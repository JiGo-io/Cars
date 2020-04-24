package com.telran.cars.data.repository.withoutauth;

import android.util.Log;

import com.telran.cars.data.dto.CarForUsersDto;
import com.telran.cars.data.dto.ResponseCarsFiltersDto;
import com.telran.cars.data.provider.store.StoreProvider;
import com.telran.cars.data.provider.web.ApiRx;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import retrofit2.Response;

public class WithoutAuthRepositoryImpl implements WithoutAuthRepository {
    private static final String TAG = "WithoutAuthRepository";
    private ApiRx api;
    private StoreProvider storeProvider;
    List<CarForUsersDto> list = new ArrayList<>();


    public WithoutAuthRepositoryImpl(ApiRx api) {
        this.api = api;
    }


    @Override
    public Observable<ResponseCarsFiltersDto> getCarByDateLocationPrice(Boolean ascending,
                                                 Integer currentPage,
                                                 String endDate,
                                                 Integer itemsOnPage,
                                                 Number latitude,
                                                 Number longitude,
                                                 Number maxAmount,
                                                 Number minAmount,
                                                 String startDate) {
        return
                api.getCarByDateLocationPrice(ascending,
                        currentPage,
                        endDate,
                        itemsOnPage,
                        latitude,
                        longitude,
                        maxAmount,
                        minAmount,
                        startDate);
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
    public Observable<List<CarForUsersDto>> getThreeBestCar() {
        return api.getThreeBestCar();
    }

    private void onGetThreeBestCarSuccess(Response<List<CarForUsersDto>> response) throws IOException {
        if (response.isSuccessful()) {
            Log.d(TAG, "onGetThreeBestCarSuccess: " + response.body());
        } else if (response.code() == 404) {
            throw new RuntimeException(response.errorBody().string());
        } else {
            Log.e(TAG, "onGetThreeBestCarSuccess: " + response.errorBody().string());
            throw new RuntimeException("Server error! Call to Support");
        }
    }

}
