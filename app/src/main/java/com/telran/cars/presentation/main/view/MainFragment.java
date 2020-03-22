package com.telran.cars.presentation.main.view;

import com.arellomobile.mvp.MvpView;

public interface MainFragment extends MvpView {
    void showProgress();
    void hideProgress();
    void showError(String error);
    void showNextView();
    void hideErrorDialog();
}
