package com.telran.cars.presentation.main.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.telran.cars.App;
import com.telran.cars.business.withoutauth.WithoutAuthInteractor;

import com.telran.cars.data.dto.CarForUsersDto;
import com.telran.cars.data.dto.CarsFiltersDto;
import com.telran.cars.data.dto.ResponseCarsFiltersDto;
import com.telran.cars.data.interactor.Interactor;
import com.telran.cars.di.withoutauth.WithoutAuthModule;
import com.telran.cars.presentation.main.view.MainFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class MainSearchPresenter extends MvpPresenter<MainFragment> {
    private static final String TAG = "MainSearchPresenter";
    @Inject
    WithoutAuthInteractor interactor;
    @Inject
    Interactor interactorCars;
    Disposable disposable;
    ArrayList<CarsFiltersDto> carsList;

    public MainSearchPresenter() {
        App.get().plus(new WithoutAuthModule()).inject(this);
        carsList = new ArrayList<>();
    }

    public void getCarByDateLocationPrice(Boolean ascending,
                                          Integer currentPage,
                                          String endDate,
                                          Integer itemsOnPage,
                                          Number latitude,
                                          Number longitude,
                                          Number maxAmount,
                                          Number minAmount,
                                          String startDate) {
        getViewState().showProgress();
        disposable = interactor.getCarByDateLocationPrice(ascending, currentPage, endDate, itemsOnPage, latitude, longitude, maxAmount, minAmount, startDate)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe((Consumer<ResponseCarsFiltersDto>)responseCars ->{
                getViewState().hideProgress();
                List<CarsFiltersDto> cars = Arrays.asList(responseCars.getCars());
                interactorCars.setCarsFilters(cars);
                getViewState().showNextView();

            Log.d(TAG, "getCarByDateLocationPrice: " + cars.toString());
        });
    }

    public void getThreeBestCar() {
        disposable = interactor.getThreeBestCar()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<CarForUsersDto>>) cars ->{
                    getViewState().displayCars(cars);
                    Log.d(TAG, "getThreeBestCar: " + cars.toString());
                });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (disposable != null){
            disposable.dispose();
        }
        App.get().clearWithoutAuthComponent();
    }

}
