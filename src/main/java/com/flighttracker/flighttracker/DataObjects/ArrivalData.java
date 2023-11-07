package com.flighttracker.flighttracker.DataObjects;

import com.flighttracker.flighttracker.DTO.ArrivalDTO;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class ArrivalData {
    private String airport;
    private String scheduled;
    private String actual;
    private String estimated;
    private String estimatedRunway;
    private String actualRunway;

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public String getScheduled() {
        return scheduled;
    }

    public void setScheduled(OffsetDateTime scheduled) {
        this.scheduled = formatOffsetDateTime(scheduled);
    }

    public String getActual() {
        return actual;
    }

    public void setActual(OffsetDateTime actual) {
        this.actual = formatOffsetDateTime(actual);
    }

    public String getEstimated() {
        return estimated;
    }

    public void setEstimated(OffsetDateTime estimated) {
        this.estimated = formatOffsetDateTime(estimated);
    }

    public String getEstimatedRunway() {
        return estimatedRunway;
    }

    public void setEstimatedRunway(OffsetDateTime estimatedRunway) {
        this.estimatedRunway = formatOffsetDateTime(estimatedRunway);
    }

    public String getActualRunway() {
        return actualRunway;
    }

    public void setActualRunway(OffsetDateTime actualRunway) {
        this.actualRunway = formatOffsetDateTime(actualRunway);
    }

    private String formatOffsetDateTime(OffsetDateTime offsetDateTime) {
        if (offsetDateTime != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return offsetDateTime.format(formatter);
        } else {
            return "N/A";
        }
    }

    @Override
    public String toString() {
        return "ArrivalData{" +
                "airport='" + airport + '\'' +
                ", scheduled=" + scheduled +
                ", actual=" + actual +
                ", estimated=" + estimated +
                ", estimatedRunway=" + estimatedRunway +
                ", actualRunway=" + actualRunway +
                '}';
    }

    public static ArrivalData mapFromDTO(ArrivalDTO arrivalDTO) {
        ArrivalData arrivalData = new ArrivalData();
        arrivalData.setAirport(arrivalDTO.getAirport());
        arrivalData.setScheduled(arrivalDTO.getScheduled());
        arrivalData.setActual(arrivalDTO.getActual());
        arrivalData.setEstimated(arrivalDTO.getEstimated());
        arrivalData.setEstimatedRunway(arrivalDTO.getEstimatedRunway());
        arrivalData.setActualRunway(arrivalDTO.getActualRunway());
        return arrivalData;
    }
}
