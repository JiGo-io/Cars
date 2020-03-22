package com.telran.cars.data.repository;

import android.util.Log;

import com.telran.cars.data.dto.CarFullDto;
import com.telran.cars.data.dto.OwnerCarDtoForCar;
import com.telran.cars.data.dto.RegistrationDto;
import com.telran.cars.data.dto.ReservedPeriodDto;
import com.telran.cars.data.provider.store.StoreProvider;
import com.telran.cars.data.provider.web.ApiRx;

import java.io.IOException;

import io.reactivex.Completable;
import retrofit2.Response;

public class ReservationControllerRepositoryImpl implements ReservationControllerRepository {
    private static final String TAG = "ReservationControllerRepository";
    private ApiRx api;
    private StoreProvider storeProvider;

    public ReservationControllerRepositoryImpl(ApiRx api, StoreProvider storeProvider) {
        this.api = api;
        this.storeProvider = storeProvider;
    }

    @Override
    public Completable paymentForRegistration(String token, String bookedId) {
        return Completable.fromSingle(
                api.paymentForRegistration(token, bookedId).doOnSuccess(this::onPaymentForRegistrationSuccess)
        );
    }

    @Override
    public Completable reservationCarById(String token, RegistrationDto dto, String serialNumber) {
        return Completable.fromSingle(
                api.reservationCarById(token,dto,serialNumber).doOnSuccess(this::onReservationCarByIdSuccess)
        );
    }

    @Override
    public Completable reservationCancellation(String token, String serialNumber, String startDateTime) {
        return Completable.fromSingle(
                api.reservationCancellation(token,serialNumber,startDateTime).doOnSuccess(this::onReservationCancellationSuccess)
        );
    }

    @Override
    public Completable unlockCarById(String token, ReservedPeriodDto[] dto, String serialNumber) {
        return Completable.fromSingle(
                api.unlockCarById(token,dto,serialNumber).doOnSuccess(this::onUnlockCarByIdSuccess)
        );
    }

    @Override
    public Completable lockCarById(String token, ReservedPeriodDto[] dto, String serialNumber) {
        return Completable.fromSingle(
                api.lockCarById(token,dto,serialNumber).doOnSuccess(this::onLockCarByIdSuccess)
        );
    }

    private void onPaymentForRegistrationSuccess(Response response) throws IOException {
        if (response.isSuccessful()) {
//            storeProvider.saveToken(response.body().getToken());
            Log.d("TAG", "onPaymentForRegistrationSuccess: " + response.body().toString());
        } else if (response.code() == 400 || response.code() == 401 || response.code() == 403 || response.code() == 404) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            Log.e("TAG", "onPaymentForRegistrationSuccess: " + response.errorBody().string());
            throw new RuntimeException("Server error! Call to Support");
        }
    }

    private void onReservationCarByIdSuccess(Response<CarFullDto> response) throws IOException {
        if (response.isSuccessful()) {
//            storeProvider.saveToken(response.body().getToken());
            Log.d("TAG", "onReservationCarByIdSuccess: " + response.body().toString());
        } else if (response.code() == 400 || response.code() == 401 || response.code() == 404) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            Log.e("TAG", "onReservationCarByIdSuccess: " + response.errorBody().string());
            throw new RuntimeException("Server error! Call to Support");
        }
    }

    private void onReservationCancellationSuccess(Response<CarFullDto> response) throws IOException {
        if (response.isSuccessful()) {
//            storeProvider.saveToken(response.body().getToken());
            Log.d("TAG", "onReservationCancellationSuccess: " + response.body().toString());
        } else if (response.code() == 400 || response.code() == 401 || response.code() == 404) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            Log.e("TAG", "onReservationCancellationSuccess: " + response.errorBody().string());
            throw new RuntimeException("Server error! Call to Support");
        }
    }

    private void onUnlockCarByIdSuccess(Response<OwnerCarDtoForCar> response) throws IOException {
        if (response.isSuccessful()) {
//            storeProvider.saveToken(response.body().getToken());
            Log.d("TAG", "onUnlockCarByIdSuccess: " + response.body().toString());
        } else if (response.code() == 400 || response.code() == 401 || response.code() == 403 || response.code() == 404) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            Log.e("TAG", "onUnlockCarByIdSuccess: " + response.errorBody().string());
            throw new RuntimeException("Server error! Call to Support");
        }
    }

    private void onLockCarByIdSuccess(Response<OwnerCarDtoForCar> response) throws IOException {
        if (response.isSuccessful()) {
//            storeProvider.saveToken(response.body().getToken());
            Log.d("TAG", "onLockCarByIdSuccess: " + response.body().toString());
        } else if (response.code() == 400 || response.code() == 401 || response.code() == 403 || response.code() == 404) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            Log.e("TAG", "onLockCarByIdSuccess: " + response.errorBody().string());
            throw new RuntimeException("Server error! Call to Support");
        }
    }
}
