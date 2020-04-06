package com.telran.cars.data.repository.rent;

import android.util.Log;

import com.telran.cars.data.dto.CarFullDto;
import com.telran.cars.data.dto.CarFullUploadRequestDto;
import com.telran.cars.data.provider.store.StoreProvider;
import com.telran.cars.data.provider.web.ApiRx;

import java.io.IOException;

import io.reactivex.Completable;
import retrofit2.Response;

public class RentRepositoryImpl implements RentRepository {
    private static final String TAG = "RentRepository";
    private ApiRx api;
    private StoreProvider storeProvider;

    public RentRepositoryImpl(ApiRx api, StoreProvider storeProvider) {
        this.api = api;
        this.storeProvider = storeProvider;
    }


    @Override
    public Completable addNewCar(String token, CarFullUploadRequestDto dto) {
        return Completable.fromSingle(
                api.addNewCar(token, dto).doOnSuccess(this::onAddNewCarSuccess)
        );
    }

    private void onAddNewCarSuccess(Response<CarFullDto> response) throws IOException {
        if (response.isSuccessful()) {
//            storeProvider.saveToken(response.body().getToken());
            Log.d("TAG", "onGetCarByIdSuccess: " + response.body().toString());
        } else if (response.code() == 400 || response.code() == 404) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            Log.e("TAG", "onGetCarByIdSuccess: " + response.errorBody().string());
            throw new RuntimeException("Server error! Call to Support");
        }
    }

    @Override
    public Completable updateCar(String token, CarFullUploadRequestDto dto, String serialNumber) {
        return Completable.fromSingle(
                api.carUpdate(token, dto, serialNumber).doOnSuccess(this::onUpdateCarSuccess)
        );
    }

    private void onUpdateCarSuccess(Response<CarFullDto> response) throws IOException {
        if (response.isSuccessful()) {
//            storeProvider.saveToken(response.body().getToken());
            Log.d("TAG", "onCarUpdateSuccess: " + response.body().toString());
        } else if (response.code() == 400 || response.code() == 401) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            Log.e("TAG", "onCarUpdateSuccess: " + response.errorBody().string());
            throw new RuntimeException("Server error! Call to Support");
        }
    }

    @Override
    public Completable deleteCar(String token, String serialNumber) {
        return Completable.fromSingle(
                api.carDelete(token, serialNumber).doOnSuccess(this::onDeleteCarSuccess)
        );
    }

    private void onDeleteCarSuccess(Response response) throws IOException {
        if (response.isSuccessful()) {
//            storeProvider.saveToken(response.body().getToken());
            Log.d("TAG", "onCarDeleteSuccess: " + response.body().toString());
        } else if (response.code() == 400 || response.code() == 401 || response.code() == 404) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            Log.e("TAG", "onCarDeleteSuccess: " + response.errorBody().string());
            throw new RuntimeException("Server error! Call to Support");
        }
    }

    @Override
    public Completable getOwnerCars(String token) {
        return Completable.fromSingle(
                api.getOwnerCars(token).doOnSuccess(this::onGetOwnerCarsSuccess)
        );
    }

    private void onGetOwnerCarsSuccess(Response<CarFullDto> response) throws IOException {
        if (response.isSuccessful()) {
//            storeProvider.saveToken(response.body().getToken());
            Log.d("TAG", "onGetOwnerCarsSuccess: " + response.body().toString());
        } else if (response.code() == 404) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            Log.e("TAG", "onGetOwnerCarsSuccess: " + response.errorBody().string());
            throw new RuntimeException("Server error! Call to Support");
        }
    }

    @Override
    public Completable getCarById(String token, String serialNumber) {
        return Completable.fromSingle(
                api.getCarById(serialNumber).doOnSuccess(this::onGetCarByIdSuccess)
        );
    }

    private void onGetCarByIdSuccess(Response<CarFullDto> response) throws IOException {
        if (response.isSuccessful()) {
//            storeProvider.saveToken(response.body().getToken());
            Log.d("TAG", "onGetCarByIdSuccess: " + response.body().toString());
        } else if (response.code() == 400 || response.code() == 404) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            Log.e("TAG", "onGetCarByIdSuccess: " + response.errorBody().string());
            throw new RuntimeException("Server error! Call to Support");
        }
    }

    @Override
    public Completable getOwnerBookedPeriods(String token, String serialNumber) {
        return Completable.fromSingle(
                api.getOwnerBookedPeriods(token, serialNumber).doOnSuccess(this::onGetOwnerBookedPeriodsSuccess)
        );
    }

    private void onGetOwnerBookedPeriodsSuccess(Response<CarFullDto> response) throws IOException {
        if (response.isSuccessful()) {
//            storeProvider.saveToken(response.body().getToken());
            Log.d("TAG", "onGetOwnerBookedPeriodsSuccess: " + response.body().toString());
        } else if (response.code() == 400 || response.code() == 401 || response.code() == 404) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            Log.e("TAG", "onGetOwnerBookedPeriodsSuccess: " + response.errorBody().string());
            throw new RuntimeException("Server error! Call to Support");
        }
    }

}
