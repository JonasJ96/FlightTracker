package com.flighttracker.flighttracker.DataObjects;

import com.flighttracker.flighttracker.DTO.ArrivalDTO;
import com.flighttracker.flighttracker.DTO.DepartureDTO;
import com.flighttracker.flighttracker.DTO.FlightDTO;
import com.flighttracker.flighttracker.DTO.FlightDataDTO;

public class FlightData {

    private String flight_date;
    private String flight_status;

    private String number;
    private AirlineData airline;
    private DepartureData departure;
    private ArrivalData arrival;

    public String getFlight_date() {
        return flight_date;
    }

    public void setFlight_date(String flight_date) {
        this.flight_date = flight_date;
    }

    public String getFlight_status() {
        return flight_status;
    }

    public void setFlight_status(String flight_status) {
        this.flight_status = flight_status;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public AirlineData getAirline() {
        return airline;
    }

    public void setAirline(AirlineData airline) {
        this.airline = airline;
    }

    public DepartureData getDeparture() {
        return departure;
    }

    public void setDeparture(DepartureData departure) {
        this.departure = departure;
    }

    public ArrivalData getArrival() {
        return arrival;
    }

    public void setArrival(ArrivalData arrival) {
        this.arrival = arrival;
    }

    public static FlightData mapFromDTO(FlightDataDTO flightDataDTO) {
        FlightData flightData = new FlightData();
        flightData.setAirline(AirlineData.mapFromDTO(flightDataDTO.getAirline()));
        flightData.setArrival(ArrivalData.mapFromDTO(flightDataDTO.getArrival()));
        flightData.setDeparture(DepartureData.mapFromDTO(flightDataDTO.getDeparture()));
        flightData.setFlight_date(flightDataDTO.getFlight_date());
        flightData.setFlight_status(flightDataDTO.getFlight_status());
        flightData.setNumber(flightDataDTO.getFlight().getNumber());
        return flightData;
    }

}
