package com.telran.cars;

public class StatisticsDto {
    private String rating;
    private String trips;

    public StatisticsDto(String rating, String trips) {
        this.rating = rating;
        this.trips = trips;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTrips() {
        return trips;
    }

    public void setTrips(String trips) {
        this.trips = trips;
    }

    @Override
    public String toString() {
        return "StatisticsDto{" +
                "rating='" + rating + '\'' +
                ", trips='" + trips + '\'' +
                '}';
    }
}
