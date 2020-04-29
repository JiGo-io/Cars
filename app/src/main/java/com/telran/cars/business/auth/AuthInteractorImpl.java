package com.telran.cars.business.auth;

import com.telran.cars.data.dto.PersonWhoBookedDto;
import com.telran.cars.data.dto.ReservationDto;
import com.telran.cars.data.repository.auth.AuthRepository;

import io.reactivex.Completable;

public class AuthInteractorImpl implements AuthInteractor {
    AuthRepository repository;

    public AuthInteractorImpl(AuthRepository repository) {
        this.repository = repository;
    }

    @Override
    public Completable onLogin(String email, String password) {
        return repository.onLogin(email, password);

    }

    @Override
    public Completable onRegistration(String email, String password, String firstName, String secondName) {
        return repository.onRegistration(email, password, firstName, secondName);
    }

    @Override
    public Completable remindPassword(String returnPath) {
        return repository.remindPassword(returnPath);
    }

    @Override
    public boolean checkAuth() {
        return repository.checkAuth();
    }

    @Override
    public Completable reserv(String serial_number, ReservationDto reservationDto) {
        return repository.reserv(serial_number, reservationDto);
    }

}
