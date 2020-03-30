package com.telran.cars.business.auth;

import io.reactivex.Completable;

public interface AuthInteractor {
    Completable onLogin(String email, String password);
    Completable onRegistration(String email, String password);
    Completable remindPassword(String ReturnPath);
}
