package com.telran.cars.business.main;

import com.telran.cars.data.repository.UserControllerRepository;

import io.reactivex.Completable;

public class MainInteractorImpl implements MainInteractor {
    UserControllerRepository repository;

    @Override
    public Completable onLogin(String email, String password) {
        return null;
    }

    @Override
    public Completable onRegistration(String email, String password) {
        return null;
    }
}
