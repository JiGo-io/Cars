package com.telran.cars.business.auth;

import io.reactivex.Completable;

public interface AuthInteractor {
    Completable onLogin(String token);
    Completable onRegistration(String token, String firstName, String secondName);
    Completable remindPassword(String returnPath);
}
