package com.telran.cars.di.withoutauth;

import com.telran.cars.presentation.main.presenter.MainSearchPresentor;

import dagger.Subcomponent;

@Subcomponent(modules = {WithoutAuthModule.class})
@WithoutAuthScope
public interface WithoutAuthComponent {
    void inject (MainSearchPresentor presentor);
}
