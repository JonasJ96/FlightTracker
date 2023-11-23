package com.flighttracker.flighttracker.Controllers;

import com.flighttracker.flighttracker.DTO.FlightDataDTO;
import com.flighttracker.flighttracker.DataObjects.FlightData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
@Controller
public class MapController {


    @GetMapping("/map")
    public String flights(Model model) throws Exception {
        return "map";
        }
}
