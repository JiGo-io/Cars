package com.telran.cars.di.withoutauth;

import com.telran.cars.presentation.main.presenter.MainSearchPresenter;
import com.telran.cars.presentation.main.presenter.MapPresenter;

import dagger.Subcomponent;

@Subcomponent(modules = {WithoutAuthModule.class})
@WithoutAuthScope
public interface WithoutAuthComponent {
    void inject (MainSearchPresenter presentor);
    void inject (MapPresenter presentor);

}
