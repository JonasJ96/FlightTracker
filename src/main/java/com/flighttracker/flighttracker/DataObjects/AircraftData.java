package com.flighttracker.flighttracker.DataObjects;

import com.flighttracker.flighttracker.DTO.AircraftDTO;
import com.flighttracker.flighttracker.DTO.LiveDTO;

public class AircraftData {

    private String registration;
    private String iata;
    private String icao;

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

    public static AircraftData mapFromDTO(AircraftDTO aircraftDTO) {
        AircraftData aircraftData = new AircraftData();
        aircraftData.setIata(aircraftDTO.getIata());
        aircraftData.setIcao(aircraftDTO.getIcao());
        aircraftData.setRegistration(aircraftDTO.getRegistration());
        return aircraftData;
    }
}
