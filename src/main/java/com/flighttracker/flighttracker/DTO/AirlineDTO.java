package com.flighttracker.flighttracker.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class AirlineDTO {
    private String name;
    private String iata;
    private String icao;

    // getters and setters

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

    @Override
    public String toString() {
        return "AirlineDTO{" +
                "name='" + name + '\'' +
                ", iata='" + iata + '\'' +
                ", icao='" + icao + '\'' +
                '}';
    }
}
