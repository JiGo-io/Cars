package com.telran.cars.data.dto;

public class BookedPeriodBaseDto {
    private double amount;
    private String booking_date;
    private String order_number;

    public BookedPeriodBaseDto(double amount, String booking_date, String order_number) {
        this.amount = amount;
        this.booking_date = booking_date;
        this.order_number = order_number;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getBooking_period() {
        return booking_date;
    }

    public void setBooking_period(String booking_date) {
        this.booking_date = booking_date;
    }

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    @Override
    public String toString() {
        return "BookedPeriodBaseDto{" +
                "amount=" + amount +
                ", booking_date='" + booking_date + '\'' +
                ", order_number='" + order_number + '\'' +
                '}';
    }
}
