package com.telran.cars.business.auth;

import com.telran.cars.data.dto.ReservationDto;

import io.reactivex.Completable;

public interface AuthInteractor {
    Completable onLogin(String email, String password);
    Completable onRegistration(String email, String password, String firstName, String secondName);
    Completable remindPassword(String returnPath);
    boolean checkAuth();
    Completable reserv(String serial_number, ReservationDto reservationDto);

}
