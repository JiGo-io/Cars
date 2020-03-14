package com.telran.cars;

class HistoryPeriodDto {
    private double amount;
    private String booking_date;
    private String end_date_time;
    private String order_id;
    private boolean paid;
    private String start_date_time;

    public HistoryPeriodDto(double amount, String booking_date, String end_date_time, String order_id, boolean paid, String start_date_time) {
        this.amount = amount;
        this.booking_date = booking_date;
        this.end_date_time = end_date_time;
        this.order_id = order_id;
        this.paid = paid;
        this.start_date_time = start_date_time;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(String booking_date) {
        this.booking_date = booking_date;
    }

    public String getEnd_date_time() {
        return end_date_time;
    }

    public void setEnd_date_time(String end_date_time) {
        this.end_date_time = end_date_time;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String getStart_date_time() {
        return start_date_time;
    }

    public void setStart_date_time(String start_date_time) {
        this.start_date_time = start_date_time;
    }

    @Override
    public String toString() {
        return "HistoryPeriodDto{" +
                "amount=" + amount +
                ", booking_date='" + booking_date + '\'' +
                ", end_date_time='" + end_date_time + '\'' +
                ", order_id='" + order_id + '\'' +
                ", paid=" + paid +
                ", start_date_time='" + start_date_time + '\'' +
                '}';
    }
}
