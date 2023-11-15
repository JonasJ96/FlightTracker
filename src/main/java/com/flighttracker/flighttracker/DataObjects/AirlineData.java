package com.flighttracker.flighttracker.DataObjects;


import com.flighttracker.flighttracker.DTO.AirlineDTO;

public class AirlineData {
    private String name;
    private String iata;
    private String icao;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public static AirlineData mapFromDTO(AirlineDTO airlineDTO) {
        AirlineData airlineData = new AirlineData();
        airlineData.setIata(airlineDTO.getIata());
        airlineData.setIcao(airlineDTO.getIcao());
        airlineData.setName(airlineDTO.getName());
        return airlineData;
    }
}

