package com.telran.cars;

public class BookedPeriodBaseDto {
    private double amount;
    private String booking_period;
    private String order_number;

    public BookedPeriodBaseDto(double amount, String booking_period, String order_number) {
        this.amount = amount;
        this.booking_period = booking_period;
        this.order_number = order_number;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getBooking_period() {
        return booking_period;
    }

    public void setBooking_period(String booking_period) {
        this.booking_period = booking_period;
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
                ", booking_period='" + booking_period + '\'' +
                ", order_number='" + order_number + '\'' +
                '}';
    }
}
