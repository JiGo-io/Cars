package com.telran.cars.data.dto;

public class PriceDto {
    private double amount;
    private String currency;

    public PriceDto(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "PriceDto{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
