package com.flighttracker.flighttracker.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.OffsetDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DepartureDTO {
    private String airport;
    private String timezone;
    private String iata;
    private String icao;
    private String terminal;
    private String gate;
    private int delay;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private OffsetDateTime scheduled;
    private OffsetDateTime estimated;
    private OffsetDateTime actual;

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
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

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public OffsetDateTime getScheduled() {
        return scheduled;
    }

    public void setScheduled(OffsetDateTime scheduled) {
        this.scheduled = scheduled;
    }

    public OffsetDateTime getEstimated() {
        return estimated;
    }

    public void setEstimated(OffsetDateTime estimated) {
        this.estimated = estimated;
    }

    public OffsetDateTime getActual() {
        return actual;
    }

    public void setActual(OffsetDateTime actual) {
        this.actual = actual;
    }

    @Override
    public String toString() {
        return "DepartureDTO{" +
                "airport='" + airport + '\'' +
                ", timezone='" + timezone + '\'' +
                ", iata='" + iata + '\'' +
                ", icao='" + icao + '\'' +
                ", terminal='" + terminal + '\'' +
                ", gate='" + gate + '\'' +
                ", delay=" + delay +
                ", scheduled=" + scheduled +
                ", estimated=" + estimated +
                ", actual=" + actual +
                '}';
    }
}
