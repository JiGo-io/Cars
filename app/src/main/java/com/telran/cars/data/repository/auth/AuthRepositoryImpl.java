package com.telran.cars.data.repository.auth;

import android.util.Log;

import androidx.annotation.Nullable;

import com.telran.cars.data.dto.BookedPeriodBaseDto;
import com.telran.cars.data.dto.PersonWhoBookedDto;
import com.telran.cars.data.dto.RegistrationDto;
import com.telran.cars.data.dto.ReservationDto;
import com.telran.cars.data.dto.UserDtoForUser;
import com.telran.cars.data.interactor.Interactor;
import com.telran.cars.data.provider.store.StoreProvider;
import com.telran.cars.data.provider.web.ApiRx;

import java.io.IOException;

import io.reactivex.Completable;
import okhttp3.Credentials;
import retrofit2.Response;

public class AuthRepositoryImpl implements AuthRepository {
    private ApiRx api;
    private StoreProvider storeProvider;
    private String token;
    Interactor interactor;

    public AuthRepositoryImpl(ApiRx api, StoreProvider storeProvider, Interactor interactor) {
        this.api = api;
        this.storeProvider = storeProvider;
        this.interactor = interactor;
    }

    @Override
    public Completable onLogin(String email, String password) {
        token = Credentials.basic(email,password);
        Log.d("MA_TAG", "onLogin: " + token);
        return Completable.fromSingle(
                api.authorizationUser(token).doOnSuccess(this::onAuthorizationSuccess)
        );
    }

    @Override
    public Completable onRegistration(String email, String password, String firstName, String secondName) {
        token = Credentials.basic(email,password);
        RegistrationDto dto = new RegistrationDto(firstName, secondName);
        return Completable.fromSingle(
                api.registration(token, dto).doOnSuccess(this::onRegistrationSuccess)
        );
    }

    @Override
    public Completable remindPassword(String returnPath) {
        return api.remindPassword(returnPath);
    }


    @Override
    public Completable reserv(String serial_number, ReservationDto reservationDto) {
        token = storeProvider.getToken();
        return Completable.fromSingle(
                api.reserv(token, reservationDto, serial_number).doOnSuccess(this::onReservSuccess));
    }

    private void onReservSuccess(Response<BookedPeriodBaseDto> response) throws IOException {
        if (response.isSuccessful()) {
            Log.d("TAG", "onReservSuccess: " + response.body().toString());
            interactor.setBookedPeriodBaseDto(response.body());
        } else if (response.code() == 400 || response.code() == 401 || response.code() == 404) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            Log.e("TAG", "onReservSuccess: " + response.errorBody().string());
            throw new RuntimeException("Server error! Call to Support");
        }
    }

    private void onAuthorizationSuccess(Response<UserDtoForUser> response) throws IOException {
        if (response.isSuccessful()) {
            storeProvider.saveToken(token);
            Log.d("TAG", "onAuthorizationSuccess: " + token);
        } else if (response.code() == 400 || response.code() == 403 || response.code() == 409) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            Log.e("TAG", "onAuthorizationSuccess: " + response.errorBody().string());
            throw new RuntimeException("Server error! Call to Support");
        }
    }

    private void onRegistrationSuccess(Response<UserDtoForUser> response) throws IOException {
        if (response.isSuccessful()) {
            storeProvider.saveToken(token);
            Log.d("TAG", "onRegistrationSuccess: " + token);
        } else if (response.code() == 400 || response.code() == 403 || response.code() == 409) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            Log.e("TAG", "onRegistrationSuccess: " + response.errorBody().string());
            throw new RuntimeException("Server error! Call to Support");
        }
    }

    private void onRemindPasswordSuccess(Response response) throws IOException {
        if (response.isSuccessful()) {

            Log.d("TAG", "onRemindPasswordSuccess: " + response.body().toString());
        } else if (response.code() == 400 || response.code() == 404) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            Log.e("TAG", "onRemindPasswordSuccess: " + response.errorBody().string());
            throw new RuntimeException("Server error! Call to Support");
        }
    }

    @Override
    public boolean checkAuth() {
        if (storeProvider.getToken() != null && storeProvider.getToken() != ""){
            return true;
        }
        return false;
    }
}
