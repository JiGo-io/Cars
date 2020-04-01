package com.telran.cars.data.dto;

public class PickUpPlaceDto {
    private String place_id;
    private double latitude;
    private double longitude;

    public PickUpPlaceDto(String place_id, double latitude, double longitude) {
        this.place_id = place_id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
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

    @Override
    public String toString() {
        return "PickUpPlaceDto{" +
                "place_id='" + place_id + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
