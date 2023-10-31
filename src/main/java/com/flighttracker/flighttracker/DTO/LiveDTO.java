package com.flighttracker.flighttracker.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LiveDTO {
    private String updated;
    private double latitude;
    private double longitude;
    private double altitude;
    private double direction;
    private double speedHorizontal;
    private double speedVertical;
    private boolean isGround;



    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

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

    public double getSpeedHorizontal() {
        return speedHorizontal;
    }

    public void setSpeedHorizontal(double speedHorizontal) {
        this.speedHorizontal = speedHorizontal;
    }

    public double getSpeedVertical() {
        return speedVertical;
    }

    public void setSpeedVertical(double speedVertical) {
        this.speedVertical = speedVertical;
    }

    public boolean isGround() {
        return isGround;
    }

    public void setGround(boolean ground) {
        isGround = ground;
    }


    @Override
    public String toString() {
        return "LiveDTO{" +
                "updated='" + updated + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", altitude=" + altitude +
                ", direction=" + direction +
                ", speedHorizontal=" + speedHorizontal +
                ", speedVertical=" + speedVertical +
                ", isGround=" + isGround +
                '}';
    }
}
