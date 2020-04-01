package com.telran.cars.data.dto;

public class StatisticsDto {
    private String trips;
    private String rating;

    public StatisticsDto(String trips, String rating) {
        this.trips = trips;
        this.rating = rating;
    }

    public String getTrips() {
        return trips;
    }

    public void setTrips(String trips) {
        this.trips = trips;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "StatisticsDto{" +
                "trips='" + trips + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
