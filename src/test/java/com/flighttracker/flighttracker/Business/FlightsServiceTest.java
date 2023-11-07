package com.flighttracker.flighttracker.Business;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flighttracker.flighttracker.DTO.FlightDataDTO;
import com.flighttracker.flighttracker.DTO.FlightResponseDTO;
import com.flighttracker.flighttracker.DTO.FlightDataDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class FlightsServiceTest {
    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private HttpClient httpClient;

    @InjectMocks
    private FlightsService flightsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getFlightsData_shouldReturnListOfFlights() throws URISyntaxException, IOException, InterruptedException {
        // Arrange
        int offset = 0;
        String dummyResponse = "dummyResponse"; // Replace this with your expected JSON response
        FlightResponseDTO dummyFlightResponseDTO = new FlightResponseDTO(); // Replace this with your expected FlightResponseDTO

        when(httpClient.send(any(HttpRequest.class), eq(HttpResponse.BodyHandlers.ofString())))
                .thenReturn(HttpResponse.BodyHandlers.ofString().handle(new URI("dummy"), new HttpRequest.Builder().build(), new byte[]{'d', 'u', 'm', 'm', 'y'}));
        when(httpClient.send(any(HttpRequest.class), eq(HttpResponse.BodyHandlers.ofString())))
                .thenReturn(new HttpResponse<>(dummyResponse, 200));

        // Mock the behavior of objectMapper
        when(objectMapper.readValue(dummyResponse, FlightResponseDTO.class))
                .thenReturn(dummyFlightResponseDTO);

        // Act
        List<FlightDataDTO> result = flightsService.getFlightsData(offset);

        // Assert
        // Replace the expectedList with the expected list of FlightDataDTO
        List<FlightDataDTO> expectedList = dummyFlightResponseDTO.getData();
        assertEquals(expectedList, result);

        // Optionally, you can verify that the HttpClient was called with the expected URI
        verify(httpClient).send(argThat(request -> {
            // Replace the expected URI with the URI you expect the HttpClient to be called with
            String expectedUri = "http://api.aviationstack.com/v1/flights?access_key=8d6550887f07d52218a8fab4d32070c7&limit=100&offset=0";
            return request.uri().toString().equals(expectedUri);
        }), eq(HttpResponse.BodyHandlers.ofString()));
    }
}