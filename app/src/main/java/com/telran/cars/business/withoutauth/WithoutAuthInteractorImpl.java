package com.telran.cars.business.withoutauth;
import com.telran.cars.data.dto.CarForUsersDto;
import com.telran.cars.data.dto.ResponseCarsFiltersDto;
import com.telran.cars.data.repository.withoutauth.WithoutAuthRepository;

import java.util.List;


import io.reactivex.Observable;

public class WithoutAuthInteractorImpl implements WithoutAuthInteractor {
    WithoutAuthRepository repository;

    public WithoutAuthInteractorImpl(WithoutAuthRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable <ResponseCarsFiltersDto> getCarByDateLocationPrice(Boolean ascending,
                                                                         Integer currentPage,
                                                                         String endDate,
                                                                         Integer itemsOnPage,
                                                                         Number latitude,
                                                                         Number longitude,
                                                                         Number maxAmount,
                                                                         Number minAmount,
                                                                         String startDate) {
        return repository.getCarByDateLocationPrice(ascending,
                currentPage,
                endDate,
                itemsOnPage,
                latitude,
                longitude,
                maxAmount,
                minAmount,
                startDate);
    }

    @Override
    public Observable<List<CarForUsersDto>> getThreeBestCar() {
        return repository.getThreeBestCar();
    }



}
