package com.telran.cars.data.interactor;

import com.telran.cars.data.dto.BookedPeriodBaseDto;
import com.telran.cars.data.dto.CarsFiltersDto;
import com.telran.cars.data.dto.UserDtoForUser;

import java.util.ArrayList;
import java.util.List;

public class Interactor {
    private List<CarsFiltersDto> carsFilters;
    private UserDtoForUser user;
    private BookedPeriodBaseDto bookedPeriodBaseDto;

    public Interactor() {
        carsFilters = new ArrayList<>();
    }

    public List<CarsFiltersDto> getCarsFilters() {
        return carsFilters;
    }

    public void setCarsFilters(List<CarsFiltersDto> carsFilters) {
        this.carsFilters = carsFilters;
    }

    public CarsFiltersDto getCarFilter(int pos) {
        return carsFilters.get(pos);
    }

    public UserDtoForUser getUser() {
        return user;
    }

    public void setUser(UserDtoForUser user) {
        this.user = user;
    }

    public BookedPeriodBaseDto getBookedPeriodBaseDto() {
        return bookedPeriodBaseDto;
    }

    public void setBookedPeriodBaseDto(BookedPeriodBaseDto bookedPeriodBaseDto) {
        this.bookedPeriodBaseDto = bookedPeriodBaseDto;
    }
}
