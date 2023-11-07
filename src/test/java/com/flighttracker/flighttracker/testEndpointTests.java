package com.flighttracker.flighttracker;

import com.flighttracker.flighttracker.Controllers.HomeController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class testEndpointTests {

    @Mock
    private HomeController homeControllerMock;
    @Mock
    private HttpRequest requestMock;
    @Mock
    private HttpResponse<String> responseMock;

    private String url = "http://api.aviationstack.com/v1/flights?access_key=8d6550887f07d52218a8fab4d32070c7";
    private String BODY = "body";


    @BeforeEach
    public void setup() throws Exception {
//        when(homeControllerMock.test()).thenReturn(BODY);
//        when(HttpRequest.newBuilder()
//                .uri(new URI(url))
//                .GET()
//                .build()).thenReturn(requestMock);
//        when(HttpClient.newHttpClient().send(requestMock, HttpResponse.BodyHandlers.ofString())).thenReturn(responseMock);
//        when(responseMock.body()).thenReturn(BODY);
}

    @Test
    public void test_shouldReturn_body() throws Exception {
//        assertThat(homeControllerMock.test()).isEqualTo("body");
    }
}
