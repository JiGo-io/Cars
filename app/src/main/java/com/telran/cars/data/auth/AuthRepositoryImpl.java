package com.telran.cars.data.auth;

import android.util.Log;

import com.telran.cars.data.dto.RegistrationDto;
import com.telran.cars.data.dto.UserDtoForUser;
import com.telran.cars.data.provider.store.StoreProvider;
import com.telran.cars.data.provider.web.ApiRx;

import java.io.IOException;

import io.reactivex.Completable;
import retrofit2.Response;

public class AuthRepositoryImpl implements AuthRepository {
    private ApiRx api;
    private StoreProvider storeProvider;

    public AuthRepositoryImpl(ApiRx api, StoreProvider storeProvider) {
        this.api = api;
        this.storeProvider = storeProvider;
    }

    @Override
    public Completable onLogin(String token) {
        return Completable.fromSingle(
                api.authorizationUser(token).doOnSuccess(this::onAuthorizationSuccess)
        );
    }

    @Override
    public Completable onRegistration(String token, String firstName, String secondName) {
        RegistrationDto dto = new RegistrationDto(firstName, secondName);
        return Completable.fromSingle(
                api.registration(token, dto).doOnSuccess(this::onRegistrationSuccess)
        );
    }

    @Override
    public Completable remindPassword(String returnPath) {
        return Completable.fromSingle(
                api.remindPassword(returnPath).doOnSuccess(this::onRemingPasswordSuccess)
        );
    }

    private void onAuthorizationSuccess(Response<UserDtoForUser> response) throws IOException {
        if (response.isSuccessful()) {
//            storeProvider.saveToken(response.body().getToken());
            Log.d("TAG", "onAuthorizationSuccess: " + response.body().toString());
        } else if (response.code() == 400 || response.code() == 403 || response.code() == 409) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            Log.e("TAG", "onAuthorizationSuccess: " + response.errorBody().string());
            throw new RuntimeException("Server error! Call to Support");
        }
    }

    private void onRegistrationSuccess(Response<UserDtoForUser> response) throws IOException {
        if (response.isSuccessful()) {
//            storeProvider.saveToken(response.body().getToken());
            Log.d("TAG", "onRegistrationSuccess: " + response.body().toString());
        } else if (response.code() == 400 || response.code() == 403 || response.code() == 409) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            Log.e("TAG", "onRegistrationSuccess: " + response.errorBody().string());
            throw new RuntimeException("Server error! Call to Support");
        }
    }

    private void onRemingPasswordSuccess(Response response) throws IOException {
        if (response.isSuccessful()) {
//            storeProvider.saveToken(response.body().getToken());
            Log.d("TAG", "onRemingPasswordSuccess: " + response.body().toString());
        } else if (response.code() == 400 || response.code() == 404) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            Log.e("TAG", "onRemingPasswordSuccess: " + response.errorBody().string());
            throw new RuntimeException("Server error! Call to Support");
        }
    }
}
