package com.telran.cars.business.rent;

import com.telran.cars.data.dto.CarFullUploadRequestDto;

import io.reactivex.Completable;

public interface RentInteractor {
    Completable addCar(String token, CarFullUploadRequestDto dto);
    Completable updateCar(String token, CarFullUploadRequestDto dto);
    Completable deleteCar(String token, String serialNumber);
    Completable getCars(String token);
    Completable getCarById(String token, String serialNumber);
    Completable gerBookedPeriodsById(String token, String serialNumber);


    Completable getBookedList(String token);

}
