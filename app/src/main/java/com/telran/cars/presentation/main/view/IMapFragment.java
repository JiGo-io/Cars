package com.telran.cars.presentation.main.view;

import com.arellomobile.mvp.MvpView;
import com.telran.cars.data.dto.CarsFiltersDto;

public interface IMapFragment extends MvpView {
    void showNextView(CarsFiltersDto car);

}
