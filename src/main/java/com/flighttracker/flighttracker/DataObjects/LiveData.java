package com.flighttracker.flighttracker.DataObjects;

import com.flighttracker.flighttracker.DTO.FlightDataDTO;
import com.flighttracker.flighttracker.DTO.LiveDTO;

public class LiveData {

    private double latitude;
    private double longitude;
    private double altitude;
    private double direction;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public static LiveData mapFromDTO(LiveDTO liveDTO) {
        LiveData liveData = new LiveData();
        liveData.setAltitude(liveDTO.getAltitude());
        liveData.setDirection(liveDTO.getDirection());
        liveData.setLongitude(liveDTO.getLongitude());
        liveData.setLatitude(liveDTO.getLatitude());
        return liveData;
    }


}
