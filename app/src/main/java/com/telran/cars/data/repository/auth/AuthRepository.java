package com.telran.cars.data.repository.auth;

import com.telran.cars.data.dto.ReservationDto;

import io.reactivex.Completable;

public interface AuthRepository {
    Completable onLogin(String email, String password);

    Completable onRegistration(String email, String password, String firstName, String secondName);

    Completable remindPassword(String ReturnPath);

    boolean checkAuth();

    Completable reserv(String serial_number, ReservationDto reservationDto);
}
