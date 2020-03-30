package com.telran.cars.data.repository;


import com.telran.cars.data.dto.ReservationDto;
import com.telran.cars.data.dto.ReservedPeriodDto;

import io.reactivex.Completable;

public interface ReservationControllerRepository {
    Completable paymentForRegistration(String token, String bookedId);
    Completable reservationCarById(String token, ReservationDto dto, String serialNumber);
    Completable reservationCancellation(String token, String serialNumber, String startDateTime);
    Completable unlockCarById(String token, ReservedPeriodDto[] dto, String serialNumber);
    Completable lockCarById(String token, ReservedPeriodDto[] dto, String serialNumber);
}
