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

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FlightsServiceTest {

    @Spy
    @InjectMocks
    private FlightsService testobj;

    @Mock
    FlightsClient flightsClientMock;
    @Mock
    FlightRequestMapper flightRequestMapperMock;

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


    @Test
    void testGetFlightsData() throws URISyntaxException, IOException, InterruptedException {
        // Arrange
        String resultString = "someJsonLol";
     when(flightRequestMapperMock.getHttpRequest(any())).thenReturn(httpRequestMock);
     when(flightsClientMock.getHttpResponse(httpRequestMock)).thenReturn(httpResponseMock);
     when(httpResponseMock.body()).thenReturn(resultString);
     when(objectMapperMock.readValue(resultString, FlightResponseDTO.class)).thenReturn(flightResponseDTOMock);
     when(flightResponseDTOMock.getData()).thenReturn(flightDataDTOListMock);

        // Act
        List<FlightDataDTO> result = testobj.getFlightsData(0,"");

        // Assert
        assertEquals(flightDataDTOListMock, result);

        // Verify
        verify(httpResponseMock, times(1)).body();
        verify(objectMapperMock, times(1)).readValue(anyString(), eq(FlightResponseDTO.class));
    }
}

