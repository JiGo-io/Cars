package com.telran.cars.presentation.main.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.telran.cars.App;
import com.telran.cars.business.auth.AuthInteractor;
import com.telran.cars.data.dto.CarsFiltersDto;
import com.telran.cars.data.dto.PersonWhoBookedDto;
import com.telran.cars.data.dto.ReservationDto;
import com.telran.cars.data.interactor.Interactor;
import com.telran.cars.di.auth.AuthModule;
import com.telran.cars.presentation.main.view.ICarInfoFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class CarInfoPresenter extends MvpPresenter<ICarInfoFragment> {
    private static final String TAG = "CarInfoPresenter";
    @Inject
    Interactor interactorCars;
    @Inject
    AuthInteractor authInteractor;
    List<CarsFiltersDto> carsList;
    Disposable disposable;

    public CarInfoPresenter() {
        App.get().plus(new AuthModule()).inject(this);
        carsList = new ArrayList<>();
    }

    public CarsFiltersDto carsFilters(int pos) {
        return interactorCars.getCarsFilters().get(pos);
    }

    public List<String> images(int pos) {
        return Arrays.asList(interactorCars.getCarFilter(pos).getImage_url());
    }

    public void reserv(int pos) {
        PersonWhoBookedDto person = new PersonWhoBookedDto("VolkovAlex@mail.ru", "Alex", "0534048855", "Volkov");
        ReservationDto reservationDto = new ReservationDto("2020-05-12 12:00", person, "2020-05-10 12:00");
        disposable = authInteractor.reserv(carsFilters(pos).getSerial_number(), reservationDto)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() ->getreservSuccess(), throwable -> {
                    Log.e(TAG, "reserv: ", throwable);
                });
    }

    private void getreservSuccess() {
        getViewState().showNextView();
    }

    public void rent() {
        Log.d(TAG, "rent: checkAuth " + String.valueOf(authInteractor.checkAuth()));
        if (authInteractor.checkAuth() == true) {
            getViewState().addCalculate();
        } else {
            getViewState().showLogView();
        }
    }

}
