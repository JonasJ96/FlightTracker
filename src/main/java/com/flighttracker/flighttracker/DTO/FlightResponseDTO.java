package com.flighttracker.flighttracker.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class FlightResponseDTO {

    private PaginationDTO pagination;
    private List<FlightDataDTO> data;

    public PaginationDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationDTO pagination) {
        this.pagination = pagination;
    }

    public List<FlightDataDTO> getData() {
        return data;
    }

    public void setData(List<FlightDataDTO> data) {
        this.data = data;
    }
}
