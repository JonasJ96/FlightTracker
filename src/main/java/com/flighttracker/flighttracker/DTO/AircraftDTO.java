package com.flighttracker.flighttracker.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AircraftDTO {
    private String registration;
    private String iata;
    private String icao;
    private String icao24;


    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
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

    public String getIcao24() {
        return icao24;
    }

    public void setIcao24(String icao24) {
        this.icao24 = icao24;
    }

    @Override
    public String toString() {
        return "AircraftDTO{" +
                "registration='" + registration + '\'' +
                ", iata='" + iata + '\'' +
                ", icao='" + icao + '\'' +
                ", icao24='" + icao24 + '\'' +
                '}';
    }
}
