package com.telran.cars.data.repository.auth;

import io.reactivex.Completable;

public interface AuthRepository {
    Completable onLogin(String token);

    Completable onRegistration(String token, String firstName, String secondName);

    Completable remindPassword(String ReturnPath);
}