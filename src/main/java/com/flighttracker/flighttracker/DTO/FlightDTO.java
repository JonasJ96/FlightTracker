package com.flighttracker.flighttracker.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightDTO {
    private String number;
    private String iata;
    private String icao;


    // getters and setters

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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
        return "FlightDTO{" +
                "number='" + number + '\'' +
                ", iata='" + iata + '\'' +
                ", icao='" + icao + '\'' +
                '}';
    }
}
