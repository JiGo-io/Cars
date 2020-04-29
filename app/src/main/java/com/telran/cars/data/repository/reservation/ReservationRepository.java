package com.telran.cars.data.repository.reservation;

import com.telran.cars.data.dto.ReservationDto;
import com.telran.cars.data.dto.ReservedPeriodDto;

import io.reactivex.Completable;

public interface ReservationRepository {

    Completable searchAllContains(Boolean ascending,
                                  Integer currentPage,
                                  String endDate,
                                  String engine,
                                  String fuel,
                                  String gear,
                                  Integer itemsOnPage,
                                  Number latitude,
                                  Number longitude,
                                  String make,
                                  Number maxAmount,
                                  Number minAmount,
                                  String model,
                                  Number radius,
                                  String startDate,
                                  String wheelsDrive,
                                  String year);

    Completable searchByFilter(Integer currentPage,
                               String fuel,
                               String gear,
                               Integer itemsOnPage,
                               String make,
                               String model,
                               String wheelsDrive,
                               String year);

    Completable searchByLocation(Integer currentPage,
                                 Integer itemsOnPage,
                                 Number latitude,
                                 Number longitude,
                                 Number radius);

    // Reservation_Controller

    Completable paymentForReservation(String token, String bookedId);
//    Completable reservationCarById(String token, ReservationDto dto, String serialNumber);
    Completable reservationCancellation(String token, String serialNumber, String startDateTime);
    Completable unlockCarById(String token, ReservedPeriodDto[] dto, String serialNumber);
    Completable lockCarById(String token, ReservedPeriodDto[] dto, String serialNumber);
}
