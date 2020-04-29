package com.telran.cars.presentation.main.presenter;

import com.arellomobile.mvp.MvpPresenter;
import com.telran.cars.App;
import com.telran.cars.business.auth.AuthInteractor;
import com.telran.cars.data.dto.BookedPeriodBaseDto;
import com.telran.cars.data.interactor.Interactor;
import com.telran.cars.di.auth.AuthModule;
import com.telran.cars.presentation.main.view.IAboutFragment;


import javax.inject.Inject;

public class AboutPresenter extends MvpPresenter<IAboutFragment> {
    @Inject
    AuthInteractor authInteractor;
    @Inject
    Interactor interactor;

    public AboutPresenter() {
        App.get().plus(new AuthModule()).inject(this);
    }

    public BookedPeriodBaseDto getPersonData() {
        return interactor.getBookedPeriodBaseDto();
    }


}
