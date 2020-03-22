package com.telran.cars.business.main;

import io.reactivex.Completable;

public interface MainInteractor {
    Completable onLogin(String email, String password);
    Completable onRegistration(String email, String password);
}
