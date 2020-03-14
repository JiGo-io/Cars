package com.telran.cars;

public class PickUpPlaceDto {
    private double latitude;
    private double longitude;
    private String place_id;

    public PickUpPlaceDto(double latitude, double longitude, String place_id) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.place_id = place_id;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    @Override
    public String toString() {
        return "PickUpPlaceDto{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", place_id='" + place_id + '\'' +
                '}';
    }
}
