package com.telran.cars.presentation.main.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.telran.cars.App;
import com.telran.cars.business.withoutauth.WithoutAuthInteractor;
import com.telran.cars.data.dto.CarForUsersDto;
import com.telran.cars.di.withoutauth.WithoutAuthModule;
import com.telran.cars.presentation.main.view.IMapFragment;
import com.telran.cars.presentation.main.view.MapFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

@InjectViewState
public class MapPresenter extends MvpPresenter<IMapFragment> {
    @Inject
    WithoutAuthInteractor interactor;
    Disposable disposable;
    List<CarForUsersDto> carsList;

    public MapPresenter() {
        App.get().plus(new WithoutAuthModule()).inject(this);
        carsList = new ArrayList<>();
    }

}
