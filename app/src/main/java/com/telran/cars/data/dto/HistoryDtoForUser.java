package com.telran.cars.data.dto;

public class HistoryDtoForUser {
    private HistoryPeriodDto booked_period;
    private String serial_number;

    public HistoryDtoForUser(HistoryPeriodDto booked_period, String serial_number) {
        this.booked_period = booked_period;
        this.serial_number = serial_number;
    }

    public HistoryPeriodDto getBooked_period() {
        return booked_period;
    }

    public void setBooked_period(HistoryPeriodDto booked_period) {
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
        return "HistoryDtoForUser{" +
                "booked_period=" + booked_period +
                ", serial_number='" + serial_number + '\'' +
                '}';
    }
}
