package com.telran.cars.di.withoutauth;

import com.telran.cars.presentation.main.presenter.CarInfoPresenter;
import com.telran.cars.presentation.main.presenter.MainSearchPresenter;
import com.telran.cars.presentation.main.presenter.MapPresenter;

import dagger.Subcomponent;

@Subcomponent(modules = {WithoutAuthModule.class})
@WithoutAuthScope
public interface WithoutAuthComponent {
    void inject (MainSearchPresenter presenter);
    void inject (MapPresenter presenter);


}
