package com.flighttracker.flighttracker.DataObjects;

import com.flighttracker.flighttracker.DTO.DepartureDTO;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class DepartureData {


    private String airport;
    private String scheduled;
    private String actual;
    private String estimated;

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }
    public void setScheduled(OffsetDateTime scheduled) {
        this.scheduled = formatOffsetDateTime(scheduled);
    }

    public String getScheduled() {
        return scheduled;
    }

    public String getActual() {
        return actual;
    }

    public String getEstimated() {
        return estimated;
    }

    public void setActual(OffsetDateTime actual) {
            this.actual = formatOffsetDateTime(actual);
        }

        public void setEstimated(OffsetDateTime estimated) {
            this.estimated = formatOffsetDateTime(estimated);
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
            return "DepartureData{" +
                    "airport='" + airport + '\'' +
                    ", scheduled=" + scheduled +
                    ", actual=" + actual +
                    ", estimated=" + estimated +
                    '}';
        }

        public static DepartureData mapFromDTO(DepartureDTO departureDTO) {
            DepartureData departureData = new DepartureData();
            departureData.setAirport(departureDTO.getAirport());
            departureData.setScheduled(departureDTO.getScheduled());
            departureData.setActual(departureDTO.getActual());
            departureData.setEstimated(departureDTO.getEstimated());
            return departureData;
        }

}
