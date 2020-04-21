package com.telran.cars.business.withoutauth;

import com.telran.cars.data.dto.CarForUsersDto;


import io.reactivex.Completable;
import io.reactivex.Observable;

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
    Observable getThreeBestCar();

}
