package com.telran.cars.data.dto;

public class BookedCarsDtoForUser {
    private BookedPeriodDto booked_period;
    private String serial_number;

    public BookedCarsDtoForUser(BookedPeriodDto booked_period, String serial_number) {
        this.booked_period = booked_period;
        this.serial_number = serial_number;
    }

    public BookedPeriodDto getBooked_period() {
        return booked_period;
    }

    public void setBooked_period(BookedPeriodDto booked_period) {
        this.booked_period = booked_period;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    @Override
    public String toString() {
        return "BookedCarsDtoForUser{" +
                "booked_period=" + booked_period +
                ", serial_number='" + serial_number + '\'' +
                '}';
    }
}
