package com.flighttracker.flighttracker.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class FlightDataDTO {

    private String flight_date;
    private String flight_status;
    private DepartureDTO departure;
    private ArrivalDTO arrival;
    private AirlineDTO airline;
    private FlightDTO flight;
    private AircraftDTO aircraft;
    private LiveDTO live;

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

    public DepartureDTO getDeparture() {
        return departure;
    }

    public void setDeparture(DepartureDTO departure) {
        this.departure = departure;
    }

    public ArrivalDTO getArrival() {
        return arrival;
    }

    public void setArrival(ArrivalDTO arrival) {
        this.arrival = arrival;
    }

    public AirlineDTO getAirline() {
        return airline;
    }

    public void setAirline(AirlineDTO airline) {
        this.airline = airline;
    }

    public FlightDTO getFlight() {
        return flight;
    }

    public void setFlight(FlightDTO flight) {
        this.flight = flight;
    }

    public AircraftDTO getAircraft() {
        return aircraft;
    }

    public void setAircraft(AircraftDTO aircraft) {
        this.aircraft = aircraft;
    }

    public LiveDTO getLive() {
        return live;
    }

    public void setLive(LiveDTO live) {
        this.live = live;
    }

    @Override
    public String toString() {
        return "FlightDataDTO{" +
                "flight_date='" + flight_date + '\'' +
                ", flight_status='" + flight_status + '\'' +
                ", departure=" + departure +
                ", arrival=" + arrival +
                ", airline=" + airline +
                ", flight=" + flight +
                ", aircraft=" + aircraft +
                ", live=" + live +
                '}';
    }
}
