package com.telran.cars.di.auth;

import com.telran.cars.presentation.main.presenter.AboutPresenter;
import com.telran.cars.presentation.main.presenter.AuthPresenter;
import com.telran.cars.presentation.main.presenter.CarInfoPresenter;

import dagger.Subcomponent;

@Subcomponent(modules = {AuthModule.class})
@AuthScope
public interface AuthComponent {
    void inject(AuthPresenter presenter);
    void inject (CarInfoPresenter presenter);
    void inject (AboutPresenter presenter);
}
