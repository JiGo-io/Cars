package com.telran.cars.presentation.main.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.telran.cars.business.withoutauth.WithoutAuthInteractor;
import com.telran.cars.di.DependenceFactory;
import com.telran.cars.di.DependenceFactoryMain;
import com.telran.cars.presentation.main.view.MainFragment;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class MainSearchPresentor extends MvpPresenter<MainFragment> {
    private static final String TAG = "MainSearchPresentor";
    WithoutAuthInteractor interactor;
    Disposable disposable;

    public MainSearchPresentor() {
        this.interactor = DependenceFactoryMain.getInstance().getWithoutAuthInteractor();
    }

    public void getCarByDateLocationPrice(Boolean ascending,
                                          Integer currentPage,
                                          String endDate,
                                          Integer itemsOnPage,
                                          Number latitude,
                                          Number longitude,
                                          Number maxAmount,
                                          Number minAmount,
                                          String startDate) {
    disposable = interactor.getCarByDateLocationPrice(ascending, currentPage, endDate, itemsOnPage, latitude, longitude, maxAmount, minAmount, startDate)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(() -> getSuccess(),throwable -> {
                Log.e(TAG, "getCarByDateLocationPrice: ", throwable );
            });


    }

    private void getSuccess() {
        getViewState().showNextView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (disposable != null){
            disposable.dispose();
        }
    }
}