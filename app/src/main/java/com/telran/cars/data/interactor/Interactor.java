package com.telran.cars.data.interactor;

import com.telran.cars.data.dto.CarsFiltersDto;

import java.util.ArrayList;
import java.util.List;

public class Interactor {
    private List<CarsFiltersDto> carsFilters;

    public Interactor() {
        carsFilters = new ArrayList<>();
    }

    public List<CarsFiltersDto> getCarsFilters() {
        return carsFilters;
    }

    public void setCarsFilters(List<CarsFiltersDto> carsFilters) {
        this.carsFilters = carsFilters;
    }
}
