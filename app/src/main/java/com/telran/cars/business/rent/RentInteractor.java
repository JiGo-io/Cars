package com.telran.cars.business.rent;

import com.telran.cars.data.dto.CarFullUploadRequestDto;

import io.reactivex.Completable;

public interface RentInteractor {
    Completable addNewCar(String token, CarFullUploadRequestDto dto);
    Completable updateCar(String token, CarFullUploadRequestDto dto);
    Completable deleteCar(String token, String serialNumber);
    Completable getOwnerCars(String token);
    Completable getCarById(String token, String serialNumber);
    Completable getOwnerBookedPeriods(String token, String serialNumber);


}
