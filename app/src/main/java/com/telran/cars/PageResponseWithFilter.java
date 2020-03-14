package com.telran.cars;

import java.util.List;

public class PageResponseWithFilter {
    private List<CarsFiltersDto> cars;
    private String current_page;
    private JsonNode filter;
    private String items_on_page;
    private String items_total;

    public PageResponseWithFilter(List<CarsFiltersDto> cars, String current_page, JsonNode filter, String items_on_page, String items_total) {
        this.cars = cars;
        this.current_page = current_page;
        this.filter = filter;
        this.items_on_page = items_on_page;
        this.items_total = items_total;
    }

    public List<CarsFiltersDto> getCars() {
        return cars;
    }

    public void setCars(List<CarsFiltersDto> cars) {
        this.cars = cars;
    }

    public String getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(String current_page) {
        this.current_page = current_page;
    }

    public JsonNode getFilter() {
        return filter;
    }

    public void setFilter(JsonNode filter) {
        this.filter = filter;
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

    @Override
    public String toString() {
        return "PageResponseWithFilter{" +
                "cars=" + cars +
                ", current_page='" + current_page + '\'' +
                ", filter=" + filter +
                ", items_on_page='" + items_on_page + '\'' +
                ", items_total='" + items_total + '\'' +
                '}';
    }
}

