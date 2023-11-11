package com.flighttracker.flighttracker.Business;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class FlightRequestMapper {

    public HttpRequest getHttpRequest(String url) throws URISyntaxException {
        if (url == null) {
            throw new IllegalArgumentException("URL cannot be null");
        }
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                .build();
        return request;
    }
}
