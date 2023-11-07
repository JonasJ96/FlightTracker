package com.flighttracker.flighttracker.Business;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flighttracker.flighttracker.DTO.FlightDataDTO;
import com.flighttracker.flighttracker.DTO.FlightResponseDTO;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class FlightsService {
    private static final ObjectMapper objectMapper = new ObjectMapper();


    public List<FlightDataDTO> getFlightsData(int offset) throws URISyntaxException, IOException, InterruptedException {
        objectMapper.registerModule(new JavaTimeModule());
        String url = "http://api.aviationstack.com/v1/flights?access_key=8d6550887f07d52218a8fab4d32070c7" + "&limit=100" + "&offset=" + offset;
        //String url = "https://api.aviationstack.com/v1/flights?access_key=8d6550887f07d52218a8fab4d32070c7&limit=100&offset=500";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        String reponseString = response.body();

        FlightResponseDTO flightResponseDTO = objectMapper.readValue(reponseString, FlightResponseDTO.class);
        System.out.println(flightResponseDTO.getData());
        System.out.println(url);
        System.out.println(offset);
        return flightResponseDTO.getData();
    }
}
