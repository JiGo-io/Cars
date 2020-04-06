package com.telran.cars.data.dto;

public class BookedPeriodDateDto {
    private String start_date_time;
    private String end_date_time;

    public BookedPeriodDateDto(String start_date_time, String end_date_time) {
        this.start_date_time = start_date_time;
        this.end_date_time = end_date_time;
    }

    public String getStart_date_time() {
        return start_date_time;
    }

    public String getEnd_date_time() {
        return end_date_time;
    }

    @Override
    public String toString() {
        return "BookedPeriodDateDto{" +
                "start_date_time='" + start_date_time + '\'' +
                ", end_date_time='" + end_date_time + '\'' +
                '}';
    }
}
