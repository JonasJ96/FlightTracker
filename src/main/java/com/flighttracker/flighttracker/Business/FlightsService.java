package com.flighttracker.flighttracker.Business;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flighttracker.flighttracker.DTO.FlightDataDTO;
import com.flighttracker.flighttracker.DTO.FlightResponseDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class FlightsService {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private final FlightsClient flightsClient;
    private final FlightRequestMapper flightRequestMapper;

    public FlightsService(FlightsClient flightsClient, FlightRequestMapper flightRequestMapper) {
        this.flightsClient = flightsClient;
        this.flightRequestMapper = flightRequestMapper;
    }

    @PostConstruct
    public void postConstruct() {
        objectMapper.registerModule(new JavaTimeModule());
    }


    public List<FlightDataDTO> getFlightsData(int offset, String airline) throws URISyntaxException, IOException, InterruptedException {

        String offsetURL = "&offset=" + offset;
        String FSactive = "&flight_status=active";
        String airlineURL = getAirlineURL(airline);

        String url = "http://api.aviationstack.com/v1/flights?access_key=8d6550887f07d52218a8fab4d32070c7" + FSactive + offsetURL +airlineURL;
        HttpRequest request = flightRequestMapper.getHttpRequest(url);
        HttpResponse<String> response = flightsClient.getHttpResponse(request);
        String reponseString = response.body();

        FlightResponseDTO flightResponseDTO = objectMapper.readValue(reponseString, FlightResponseDTO.class);
        logDebug(offset, flightResponseDTO, url);
        return flightResponseDTO.getData();
    }

    private static String getAirlineURL(String airline) throws UnsupportedEncodingException {
        return airline != null && !airline.isEmpty() ? "&airline_name=" + URLEncoder.encode(airline, "UTF-8") : "";
    }

    private static void logDebug(int offset, FlightResponseDTO flightResponseDTO, String url) {
        System.out.println(flightResponseDTO.getData());
        System.out.println(url);
        System.out.println(offset);
    }

}
