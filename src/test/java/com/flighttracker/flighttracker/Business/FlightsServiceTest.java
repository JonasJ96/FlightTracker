package com.flighttracker.flighttracker.Business;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flighttracker.flighttracker.DTO.FlightDataDTO;
import com.flighttracker.flighttracker.DTO.FlightResponseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FlightsServiceTest {

    @Spy
    @InjectMocks
    private FlightsService flightsServiceMock;

    @Mock
    private HttpClient httpClientMock;

    @Mock
    private ObjectMapper objectMapperMock;

    @Mock
    private HttpRequest httpRequestMock;
    @Mock
    private HttpResponse<String> httpResponseMock;
    @Mock
    private FlightResponseDTO flightResponseDTOMock;
    @Mock
    private List<FlightDataDTO> flightDataDTOListMock;
    @Mock
    private URI uriMock;

    @Test
    void testGetFlightsData() throws URISyntaxException, IOException, InterruptedException {
        // Arrange
        String resultString = "Result";
        //String url = "http://api.aviationstack.com/v1/flights?access_key=8d6550887f07d52218a8fab4d32070c7&limit=100&offset=0";
        String url = "ResultUrl";

        System.out.println(flightsServiceMock.getHttpRequest(url));
        when(httpRequestMock.uri()).thenReturn(uriMock);
        when(httpResponseMock.headers()).thenReturn(null);
        when(flightsServiceMock.getHttpRequest(url)).thenReturn(httpRequestMock);

        when(flightsServiceMock.getHttpResponse(httpRequestMock)).thenReturn(httpResponseMock);
        when(httpResponseMock.body()).thenReturn(resultString);
        when(objectMapperMock.readValue(resultString, FlightResponseDTO.class)).thenReturn(flightResponseDTOMock);
        when(flightResponseDTOMock.getData()).thenReturn(flightDataDTOListMock);


        // Act
        List<FlightDataDTO> result = flightsServiceMock.getFlightsData(0);

        // Assert
        assertEquals(flightDataDTOListMock, result);

        // Verify
        verify(httpResponseMock, times(1)).body();
        verify(objectMapperMock, times(1)).readValue(anyString(), eq(FlightResponseDTO.class));
    }
}

