package com.telran.cars.data.repository;

import android.util.Log;

import com.telran.cars.data.dto.BookedCarsDtoForUser;
import com.telran.cars.data.dto.RegistrationDto;
import com.telran.cars.data.dto.UserBaseDto;
import com.telran.cars.data.dto.UserDtoForUser;
import com.telran.cars.data.provider.store.StoreProvider;
import com.telran.cars.data.provider.web.ApiRx;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import io.reactivex.Completable;
import retrofit2.Response;

public class UserControllerRepositoryImpl implements UserControllerRepository {
    private static final String TAG = "UserControllerRepository";
    private ApiRx api;
    private StoreProvider storeProvider;

    public UserControllerRepositoryImpl(ApiRx api, StoreProvider storeProvider) {
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
    public Completable onActivateUser(String code) {
        return Completable.fromSingle(
                api.activateUser(code).doOnSuccess(this::onActivationSuccess)
        );
    }


    @Override
    public Completable onUpdateUserWithPassword(String token, String newPassword, String firstName, String photo, String secondName) {
        UserBaseDto userBaseDto = new UserBaseDto(firstName, photo, secondName);
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", token);
        headers.put("X-New-Password", newPassword);
        return Completable.fromSingle(
                api.updateUser(headers, userBaseDto).doOnSuccess(this::onUpdateUserSuccess)
        );
    }

    @Override
    public Completable onUpdateUserWithoutPassword(String token, String firstName, String photo, String secondName) {
        UserBaseDto userBaseDto = new UserBaseDto(firstName, photo, secondName);
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", token);
        return Completable.fromSingle(
                api.updateUser(headers, userBaseDto).doOnSuccess(this::onUpdateUserSuccess)
        );
    }

    @Override
    public Completable onDeleteUser(String token) {
        return Completable.fromSingle(
                api.deleteUser(token).doOnSuccess(this::onDeleteUserSuccess)
        );
    }

    @Override
    public Completable getBookedList(String token) {
        return Completable.fromSingle(
                api.getBookedList(token).doOnSuccess(this::onBookedListSuccess)
        );
    }

    @Override
    public Completable getInvoice(String token, String orderId) {
        return Completable.fromSingle(
                api.getInvoice(token,orderId).doOnSuccess(this::onInvoiceSuccess)
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
    private void onActivationSuccess(Response<String> response) throws IOException {
        if (response.isSuccessful()) {
//            storeProvider.saveToken(response.body().getToken());
            Log.d("TAG", "onActivationSuccess: " + response.body().toString());
        } else if (response.code() == 400 || response.code() == 404) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            Log.e("TAG", "onActivationSuccess: " + response.errorBody().string());
            throw new RuntimeException("Server error! Call to Support");
        }
    }
    private void onUpdateUserSuccess(Response<UserDtoForUser> response) throws IOException {
        if (response.isSuccessful()) {
//            storeProvider.saveToken(response.body().getToken());
            Log.d("TAG", "onUpdateUserSuccess: " + response.body().toString());
        } else if (response.code() == 400 || response.code() == 401 || response.code() == 404) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            Log.e("TAG", "onUpdateUserSuccess: " + response.errorBody().string());
            throw new RuntimeException("Server error! Call to Support");
        }
    }
    private void onDeleteUserSuccess(Response response) throws IOException {
        if (response.isSuccessful()) {
//            storeProvider.saveToken(response.body().getToken());
            Log.d("TAG", "onDeleteUserSuccess: " + response.body().toString());
        } else if (response.code() == 400 || response.code() == 401 || response.code() == 404) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            Log.e("TAG", "onDeleteUserSuccess: " + response.errorBody().string());
            throw new RuntimeException("Server error! Call to Support");
        }
    }
    private void onBookedListSuccess(Response <ArrayList<BookedCarsDtoForUser>> response) throws IOException {
        if (response.isSuccessful()) {
//            storeProvider.saveToken(response.body().getToken());
            Log.d("TAG", "onBookedListSuccess: " + response.body().toString());
        } else if (response.code() == 400 || response.code() == 404) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            Log.e("TAG", "onBookedListSuccess: " + response.errorBody().string());
            throw new RuntimeException("Server error! Call to Support");
        }
    }
    private void onInvoiceSuccess(Response response) throws IOException {
        if (response.isSuccessful()) {
//            storeProvider.saveToken(response.body().getToken());
            Log.d("TAG", "onInvoiceSuccess: " + response.body().toString());
        } else if (response.code() == 400 || response.code() == 404) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            Log.e("TAG", "onInvoiceSuccess: " + response.errorBody().string());
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
