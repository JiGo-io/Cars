package com.telran.cars.data.dto;


import java.util.Arrays;

public class ResponseCarsFiltersDto {
    String current_page;
    String items_on_page;
    String items_total;
    CarsFiltersDto[] cars;

    public ResponseCarsFiltersDto(String current_page, String items_on_page, String items_total, CarsFiltersDto[] cars) {
        this.current_page = current_page;
        this.items_on_page = items_on_page;
        this.items_total = items_total;
        this.cars = cars;
    }

    public String getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(String current_page) {
        this.current_page = current_page;
    }

    public String getItems_on_page() {
        return items_on_page;
    }

    public void setItems_on_page(String items_on_page) {
        this.items_on_page = items_on_page;
    }

    public String getItems_total() {
        return items_total;
    }

    public void setItems_total(String items_total) {
        this.items_total = items_total;
    }

    public CarsFiltersDto[] getCars() {
        return cars;
    }

    public void setCars(CarsFiltersDto[] cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "ResponseCarsFiltersDto{" +
                "current_page=" + current_page +
                ", items_on_page=" + items_on_page +
                ", items_total=" + items_total +
                ", cars=" + Arrays.toString(cars) +
                '}';
    }
}
