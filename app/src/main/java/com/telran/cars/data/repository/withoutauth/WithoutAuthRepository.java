package com.telran.cars.data.repository.withoutauth;

import com.telran.cars.data.dto.CarForUsersDto;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

public interface WithoutAuthRepository {
    Completable getCarByDateLocationPrice(Boolean ascending,
                                          Integer currentPage,
                                          String endDate,
                                          Integer itemsOnPage,
                                          Number latitude,
                                          Number longitude,
                                          Number maxAmount,
                                          Number minAmount,
                                          String startDate);
    Observable<List<CarForUsersDto>> getThreeBestCar();
}
