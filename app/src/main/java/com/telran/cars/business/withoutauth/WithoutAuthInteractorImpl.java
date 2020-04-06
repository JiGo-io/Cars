package com.telran.cars.business.withoutauth;
import com.telran.cars.data.repository.withoutauth.WithoutAuthRepository;
import io.reactivex.Completable;

public class WithoutAuthInteractorImpl implements WithoutAuthInteractor {
    WithoutAuthRepository repository;

    public WithoutAuthInteractorImpl(WithoutAuthRepository repository) {
        this.repository = repository;
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
    public Completable getThreeBestCar() {
        return repository.getThreeBestCar();
    }


}
