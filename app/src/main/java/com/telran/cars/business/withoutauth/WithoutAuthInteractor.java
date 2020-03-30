package com.telran.cars.business.withoutauth;

import io.reactivex.Completable;

public interface WithoutAuthInteractor {

    Completable getCarByDateLocationPrice(Boolean ascending,
                                          Integer currentPage,
                                          String endDate,
                                          Integer itemsOnPage,
                                          Number latitude,
                                          Number longitude,
                                          Number maxAmount,
                                          Number minAmount,
                                          String startDate);
}
