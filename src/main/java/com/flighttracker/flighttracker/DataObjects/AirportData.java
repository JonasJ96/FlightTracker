package com.flighttracker.flighttracker.DataObjects;

import com.flighttracker.flighttracker.DTO.AirlineDTO;
import com.flighttracker.flighttracker.DTO.ArrivalDTO;

public class AirportData {

    private String airportName;
    private String iata;
    private String icao;
    private String timezone;

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public static AirportData mapFromDTO(ArrivalDTO arrivalDTO) {
        AirportData airportData = new AirportData();
        airportData.setIata(arrivalDTO.getIata());
        airportData.setIcao(arrivalDTO.getIcao());
        airportData.setAirportName(arrivalDTO.getAirport());
        airportData.setTimezone(arrivalDTO.getTimezone());

        return airportData;
    }
}
