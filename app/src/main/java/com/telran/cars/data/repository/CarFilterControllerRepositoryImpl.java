package com.telran.cars.data.repository;

import android.util.Log;

import com.telran.cars.data.dto.CarForUsersDto;
import com.telran.cars.data.dto.CarsFiltersDto;
import com.telran.cars.data.dto.JsonNode;
import com.telran.cars.data.dto.PageResponseWithFilter;
import com.telran.cars.data.provider.store.StoreProvider;
import com.telran.cars.data.provider.web.ApiRx;

import java.io.IOException;

import io.reactivex.Completable;
import retrofit2.Response;

public class CarFilterControllerRepositoryImpl implements CarFilterControllerRepository {
    private static final String TAG = "CommentFilterImageLoggerRepository";
    private ApiRx api;
    private StoreProvider storeProvider;

    public CarFilterControllerRepositoryImpl(ApiRx api, StoreProvider storeProvider) {
        this.api = api;
        this.storeProvider = storeProvider;
    }

    @Override
    public Completable getFilters() {
        return Completable.fromSingle(
                api.getFilters().doOnSuccess(this::onGetFiltersSuccess)
        );
    }

    @Override
    public Completable getCarByDateLocationPrice(Boolean ascending,
                                                 Integer currentPage,
                                                 String endDate,
                                                 Integer itemsOnPage,
                                                 Number latitude,
                                                 Number longitude,
                                                 Number maxAmount,
                                                 Number minAmount,
                                                 String startDate) {
        return Completable.fromSingle(
                api.getCarByDateLocationPrice(ascending,
                        currentPage,
                        endDate,
                        itemsOnPage,
                        latitude,
                        longitude,
                        maxAmount,
                        minAmount,
                        startDate).doOnSuccess(this::onGetCarByDateLocationPriceSuccess)
        );
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
                        year).doOnSuccess(this::onSearchAllContainsSuccess)
        );
    }

    @Override
    public Completable getCarByFilter(Integer currentPage,
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
                        year).doOnSuccess(this::onGetCarByFilterSuccess)
        );
    }

    @Override
    public Completable getCarByLocation(Integer currentPage,
                                        Integer itemsOnPage,
                                        Number latitude,
                                        Number longitude,
                                        Number radius) {
        return Completable.fromSingle(
                api.getCarByLocation(currentPage,
                        itemsOnPage,
                        latitude,
                        longitude,
                        radius).doOnSuccess(this::onGetCarByLocationSuccess)
        );
    }

    private void onGetFiltersSuccess(Response<JsonNode> response) throws IOException {
        if (response.isSuccessful()) {
//            storeProvider.saveToken(response.body().getToken());
            Log.d("TAG", "onGetFiltersSuccess: " + response.body().toString());
        } else if (response.code() == 404) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            Log.e("TAG", "onGetFiltersSuccess: " + response.errorBody().string());
            throw new RuntimeException("Server error! Call to Support");
        }

    }

    private void onGetCarByDateLocationPriceSuccess(Response<CarForUsersDto[]> response) throws IOException {
        if (response.isSuccessful()) {
//            storeProvider.saveToken(response.body().getToken());
            Log.d("TAG", "onGetCarByDateLocationPriceSuccess: " + response.body().toString());
        } else if (response.code() == 404) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            Log.e("TAG", "onGetCarByDateLocationPriceSuccess: " + response.errorBody().string());
            throw new RuntimeException("Server error! Call to Support");
        }
    }

    private void onSearchAllContainsSuccess(Response<PageResponseWithFilter> response) throws IOException {
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

    private void onGetCarByFilterSuccess(Response<CarsFiltersDto[]> response) throws IOException {
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

    private void onGetCarByLocationSuccess(Response<CarsFiltersDto[]> response) throws IOException {
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
}
