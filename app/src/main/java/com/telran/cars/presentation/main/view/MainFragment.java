package com.telran.cars.presentation.main.view;

import com.arellomobile.mvp.MvpView;
import com.telran.cars.data.dto.CarForUsersDto;
import com.telran.cars.data.dto.CarsFiltersDto;
import com.telran.cars.data.dto.ResponseCarsFiltersDto;

import java.util.ArrayList;
import java.util.List;

public interface MainFragment extends MvpView {
    void showProgress();
    void hideProgress();
    void showError(String error);
    void showNextView(ResponseCarsFiltersDto responseCars);
    void hideErrorDialog();
    void displayCars(List<CarForUsersDto> listCars);
}
