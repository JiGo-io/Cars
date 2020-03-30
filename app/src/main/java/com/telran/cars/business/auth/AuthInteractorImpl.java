package com.telran.cars.business.auth;

import com.telran.cars.data.auth.AuthRepository;
import com.telran.cars.data.repository.UserControllerRepository;

import io.reactivex.Completable;

public class AuthInteractorImpl implements AuthInteractor {
    AuthRepository repository;

    public AuthInteractorImpl(AuthRepository repository) {
        this.repository = repository;
    }

    @Override
    public Completable onLogin(String email, String password) {
        return null;
    }

    @Override
    public Completable onRegistration(String email, String password) {
        return null;
    }

    @Override
    public Completable remindPassword(String ReturnPath) {
        return null;
    }
}
