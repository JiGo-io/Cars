package com.telran.cars.data.repository;

import com.telran.cars.data.dto.CarFullUploadRequestDto;

import io.reactivex.Completable;

public interface CarControllerRepository {

    Completable getCarById(String serialNumber);

    Completable addNewCar(String token, CarFullUploadRequestDto dto);

    Completable carUpdate(String token, CarFullUploadRequestDto dto, String serialNumber);

    Completable carDelete(String token, String serialNumber);

    Completable getThreeBestCar();

    Completable getOwnerCars(String token);

    Completable getOwnerCarBySn(String token, String serialNumber);

    Completable getOwnerBookedPeriods(String token, String serialNumber);
}
