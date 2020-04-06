package com.telran.cars.data.repository.reservation;

import android.util.Log;

import com.telran.cars.data.dto.CarFullDto;
import com.telran.cars.data.dto.CarsFiltersDto;
import com.telran.cars.data.dto.OwnerCarDtoForCar;
import com.telran.cars.data.dto.PageResponseWithFilter;
import com.telran.cars.data.dto.ReservationDto;
import com.telran.cars.data.dto.ReservedPeriodDto;
import com.telran.cars.data.provider.store.StoreProvider;
import com.telran.cars.data.provider.web.ApiRx;

import java.io.IOException;

import io.reactivex.Completable;
import retrofit2.Response;

public class ReservationRepositoryImpl implements ReservationRepository {

    private static final String TAG = "ReservationRepositoryImpl";
    private ApiRx api;
    private StoreProvider storeProvider;

    public ReservationRepositoryImpl(ApiRx api, StoreProvider storeProvider) {
        this.api = api;
        this.storeProvider = storeProvider;
    }

    public ReservationRepositoryImpl(ApiRx api) {
        this.api = api;
    }

    @Override
    public Completable searchAllContains(Boolean ascending,
                                         Integer currentPage,
                                         String endDate,
                                         String engine,
                                         String fuel,
                                         String gear,
                                         Integer itemsOnPage,
                                         Number latitude,
                                         Number longitude,
                                         String make,
                                         Number maxAmount,
                                         Number minAmount,
                                         String model,
                                         Number radius,
                                         String startDate,
                                         String wheelsDrive,
                                         String year) {
        return Completable.fromSingle(
                api.searchAllContains(ascending,
                        currentPage,
                        endDate,
                        engine,
                        fuel,
                        gear,
                        itemsOnPage,
                        latitude,
                        longitude,
                        make,
                        maxAmount,
                        minAmount,
                        model,
                        radius,
                        startDate,
                        wheelsDrive,
                        year).doOnSuccess(this::onGetSearchAllContainsSuccess)
        );
    }

    private void onGetSearchAllContainsSuccess(Response<PageResponseWithFilter> response) throws IOException {
        if (response.isSuccessful()) {
//            storeProvider.saveToken(response.body().getToken());
            Log.d("TAG", "onGetCarByDateLocationPriceSuccess: " + response.body().toString());
        } else if (response.code() == 400 || response.code() == 404) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            Log.e("TAG", "onGetCarByDateLocationPriceSuccess: " + response.errorBody().string());
            throw new RuntimeException("Server error! Call to Support");
        }
    }

    @Override
    public Completable searchByFilter(Integer currentPage,
                                      String fuel,
                                      String gear,
                                      Integer itemsOnPage,
                                      String make,
                                      String model,
                                      String wheelsDrive,
                                      String year) {
        return Completable.fromSingle(
                api.getCarByFilter(currentPage,
                        fuel,
                        gear,
                        itemsOnPage,
                        make,
                        model,
                        wheelsDrive,
                        year).doOnSuccess(this::onGetSearchByFilterSuccess)
        );
    }

    private void onGetSearchByFilterSuccess(Response<CarsFiltersDto[]> response) throws IOException {
        if (response.isSuccessful()) {
//            storeProvider.saveToken(response.body().getToken());
            Log.d("TAG", "onGetCarByFilterSuccess: " + response.body().toString());
        } else if (response.code() == 400 || response.code() == 404) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            Log.e("TAG", "onGetCarByFilterSuccess: " + response.errorBody().string());
            throw new RuntimeException("Server error! Call to Support");
        }
    }

    @Override
    public Completable searchByLocation(Integer currentPage, Integer itemsOnPage, Number latitude, Number longitude, Number radius) {
        return Completable.fromSingle(
                api.getCarByLocation(currentPage,
                        itemsOnPage,
                        latitude,
                        longitude,
                        radius).doOnSuccess(this::onGetSearchByLocationSuccess)
        );
    }

    private void onGetSearchByLocationSuccess(Response<CarsFiltersDto[]> response) throws IOException {
        if (response.isSuccessful()) {
//            storeProvider.saveToken(response.body().getToken());
            Log.d("TAG", "onGetCarByLocationSuccess: " + response.body().toString());
        } else if (response.code() == 400 || response.code() == 404) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            Log.e("TAG", "onGetCarByLocationSuccess: " + response.errorBody().string());
            throw new RuntimeException("Server error! Call to Support");
        }
    }

    @Override
    public Completable paymentForReservation(String token, String bookedId) {
        return Completable.fromSingle(
                api.paymentForRegistration(token, bookedId).doOnSuccess(this::onPaymentForReservationSuccess)
        );
    }

    private void onPaymentForReservationSuccess(Response response) throws IOException {
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

    @Override
    public Completable reservationCarById(String token, ReservationDto dto, String serialNumber) {
        return Completable.fromSingle(
                api.reservationCarById(token,dto,serialNumber).doOnSuccess(this::onReservationCarByIdSuccess)
        );
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

    @Override
    public Completable reservationCancellation(String token, String serialNumber, String startDateTime) {
        return Completable.fromSingle(
                api.reservationCancellation(token,serialNumber,startDateTime).doOnSuccess(this::onReservationCancellationSuccess)
        );
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

    @Override
    public Completable unlockCarById(String token, ReservedPeriodDto[] dto, String serialNumber) {
        return Completable.fromSingle(
                api.unlockCarById(token,dto,serialNumber).doOnSuccess(this::onUnlockCarByIdSuccess)
        );
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

    @Override
    public Completable lockCarById(String token, ReservedPeriodDto[] dto, String serialNumber) {
        return Completable.fromSingle(
                api.lockCarById(token,dto,serialNumber).doOnSuccess(this::onLockCarByIdSuccess)
        );
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
