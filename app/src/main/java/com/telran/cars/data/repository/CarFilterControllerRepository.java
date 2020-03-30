package com.telran.cars.data.repository;

import io.reactivex.Completable;

public interface CarFilterControllerRepository {
    Completable getFilters();

    Completable getCarByDateLocationPrice(Boolean ascending,
                                          Integer currentPage,
                                          String endDate,
                                          Integer itemsOnPage,
                                          Number latitude,
                                          Number longitude,
                                          Number maxAmount,
                                          Number minAmount,
                                          String startDate);

    Completable searchAllContains(Boolean ascending,
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
                                  String year);

    Completable getCarByFilter(Integer currentPage,
                               String fuel,
                               String gear,
                               Integer itemsOnPage,
                               String make,
                               String model,
                               String wheelsDrive,
                               String year);

    Completable getCarByLocation(Integer currentPage,
                                 Integer itemsOnPage,
                                 Number latitude,
                                 Number longitude,
                                 Number radius);
}
