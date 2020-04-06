package com.telran.cars.data.repository.withoutauth;

import android.util.Log;

import com.telran.cars.data.dto.CarForUsersDto;
import com.telran.cars.data.dto.ResponseCarsFiltersDto;
import com.telran.cars.data.provider.store.StoreProvider;
import com.telran.cars.data.provider.web.ApiRx;

import java.io.IOException;

import io.reactivex.Completable;
import retrofit2.Response;

public class WithoutAuthRepositoryImpl implements WithoutAuthRepository {
    private static final String TAG = "WithoutAuthRepository";
    private ApiRx api;
    private StoreProvider storeProvider;

    public WithoutAuthRepositoryImpl(ApiRx api) {
        this.api = api;
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
                        startDate).doOnSuccess(response -> onGetCarByDateLocationPriceSuccess(response))
        );
    }
    private void onGetCarByDateLocationPriceSuccess(Response<ResponseCarsFiltersDto> response) throws IOException {
        if (response.isSuccessful()) {
            Log.d(TAG, "onGetCarByDateLocationPriceSuccess: " + response.body().toString());
        } else if (response.code() == 404) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            Log.e(TAG, "onGetCarByDateLocationPriceSuccess: " + response.errorBody().string());
            throw new RuntimeException("Server error! Call to Support");
        }
    }

    @Override
    public Completable getThreeBestCar() {
        return Completable.fromSingle(
                api.getThreeBestCar().doOnSuccess(this::onGetThreeBestCarSuccess)
        );
    }

    private void onGetThreeBestCarSuccess(Response<CarForUsersDto[]> response) throws IOException {
        if (response.isSuccessful()) {
            Log.d(TAG, "onGetThreeBestCarSuccess: " + response.body().toString());
        } else if (response.code() == 404) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            Log.e(TAG, "onGetThreeBestCarSuccess: " + response.errorBody().string());
            throw new RuntimeException("Server error! Call to Support");
        }
    }
}
