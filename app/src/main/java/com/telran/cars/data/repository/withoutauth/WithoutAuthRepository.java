package com.telran.cars.data.repository.withoutauth;

import com.telran.cars.data.dto.CarForUsersDto;
import com.telran.cars.data.dto.ResponseCarsFiltersDto;

import java.util.List;

import io.reactivex.Observable;

public interface WithoutAuthRepository {
    Observable<ResponseCarsFiltersDto> getCarByDateLocationPrice(Boolean ascending,
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
