package com.telran.cars.data.repository.withoutauth;

import io.reactivex.Completable;

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
    Completable getThreeBestCar();
}
