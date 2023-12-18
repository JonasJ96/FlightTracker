package com.flighttracker.flighttracker.Controllers;

import com.flighttracker.flighttracker.Business.FlightsService;
import com.flighttracker.flighttracker.DTO.FlightDataDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;

@Controller
public class HomeController {


    public HomeController() {

    }

    @GetMapping("/")
    public String home(){
        return "home";
    }


}
