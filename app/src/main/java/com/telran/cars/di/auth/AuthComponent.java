package com.telran.cars.di.auth;

import com.telran.cars.presentation.main.presenter.AuthPresenter;

import dagger.Subcomponent;

@Subcomponent(modules = {AuthModule.class})
@AuthScope
public interface AuthComponent {
    void inject(AuthPresenter presenter);
}
