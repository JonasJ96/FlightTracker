package com.flighttracker.flighttracker.Controllers;

import com.flighttracker.flighttracker.Business.FlightDataGenerator;
import com.flighttracker.flighttracker.Business.FlightsService;
import com.flighttracker.flighttracker.DTO.FlightDataDTO;
import com.flighttracker.flighttracker.DataObjects.FlightData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class FlightController {
    private final FlightsService flightsService;
    private List<FlightData> itemList = new ArrayList<>();


    public FlightController(FlightsService flightsService) {
        this.flightsService = flightsService;
    }

    @GetMapping("/flights")
    public String flights(@RequestParam(defaultValue = "0") int offset,@RequestParam(defaultValue = "") String airline, Model model) throws Exception {
        //Rigtig kode hvis API virker
        List<FlightDataDTO> list = flightsService.getFlightsData(offset,airline);
        if(!list.isEmpty()) {
            list.forEach(e -> itemList.add(FlightData.mapFromDTO(e)));
        }


        model.addAttribute("itemList", itemList);

        return "flights";


        //Kode med tilfældigt genereret data
//        List<FlightData> list = FlightDataGenerator.generateRandomFlightDataList();
//        if(!list.isEmpty()) {
//            itemList.addAll(list);
//        }
//
//
//        model.addAttribute("itemList", itemList);
//
//        return "flights";
    }
}
