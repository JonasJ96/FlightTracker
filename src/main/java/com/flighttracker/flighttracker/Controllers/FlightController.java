package com.flighttracker.flighttracker.Controllers;

import com.flighttracker.flighttracker.Business.FlightsService;
import com.flighttracker.flighttracker.DTO.FlightDataDTO;
import com.flighttracker.flighttracker.DataObjects.FlightData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class FlightController {
    private final FlightsService flightsService;
    private List<FlightData> itemList = new ArrayList<>();

    private int offset = 0;

    public FlightController(FlightsService flightsService) {
        this.flightsService = flightsService;
    }

    @GetMapping("/flights")
    public String flights(Model model) throws Exception {
        if(itemList.isEmpty()) {
            flightsService.getFlightsData(offset).forEach(e -> itemList.add(FlightData.mapFromDTO(e)));
        }
        /*
        itemList = new ArrayList<>();
        flightsService.getFlightsData(offset).forEach(e -> itemList.add(FlightData.mapFromDTO(e)));
        */


        model.addAttribute("itemList", itemList);

        //offset = offset+100;
        return "flights";
    }
}
