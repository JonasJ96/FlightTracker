package com.flighttracker.flighttracker.Controllers;

import com.flighttracker.flighttracker.Business.FlightsService;
import com.flighttracker.flighttracker.DTO.FlightDataDTO;
import com.flighttracker.flighttracker.DataObjects.FlightData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MapController {

    private final FlightsService flightsService;

    private List<FlightData> itemList = new ArrayList<>();

    public MapController(FlightsService flightsService) {
        this.flightsService = flightsService;
    }


    @GetMapping("/map")
    public String flights(Model model) throws Exception {


        itemList = new ArrayList<>();
        List<FlightDataDTO> list = flightsService.getFlightsData(0,"");
        if(!list.isEmpty()) {
            list.forEach(e -> itemList.add(FlightData.mapFromDTO(e)));
        }


        model.addAttribute("itemList", itemList);
        return "map";
        }
}
