package com.telran.cars.business.auth;

import com.telran.cars.data.repository.auth.AuthRepository;

import io.reactivex.Completable;

public class AuthInteractorImpl implements AuthInteractor {
    AuthRepository repository;

    public AuthInteractorImpl(AuthRepository repository) {
        this.repository = repository;
    }

    @Override
    public Completable onLogin(String token) {

        return repository.onLogin(token);

    }

    @Override
    public Completable onRegistration(String token, String firstName, String secondName) {
        return repository.onRegistration(token, firstName, secondName);
    }

    @Override
    public Completable remindPassword(String returnPath) {
        return repository.remindPassword(returnPath);
    }
}
