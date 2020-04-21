package com.telran.cars.presentation.main.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.telran.cars.App;
import com.telran.cars.business.withoutauth.WithoutAuthInteractor;

import com.telran.cars.data.dto.CarForUsersDto;
import com.telran.cars.data.provider.store.StoreProvider;
import com.telran.cars.di.withoutauth.WithoutAuthModule;
import com.telran.cars.presentation.main.view.MainFragment;
import com.telran.cars.presentation.main.view.MyAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class MainSearchPresentor extends MvpPresenter<MainFragment> {
    private static final String TAG = "MainSearchPresentor";
    @Inject
    WithoutAuthInteractor interactor;
    Disposable disposable;
    List<CarForUsersDto> carsList;

    public MainSearchPresentor() {
        App.get().plus(new WithoutAuthModule()).inject(this);
        carsList = new ArrayList<>();
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



    private void getThreeBestCarSuccess() {
        Log.d(TAG, "getThreeBestCarSuccess: success");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        if (disposable != null){
//            disposable.dispose();
//        }
        App.get().clearWithoutAuthComponent();
    }

    public void getThreeBestCar() {
        disposable = interactor.getThreeBestCar()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<CarForUsersDto>>) cars ->{
//                    carsList.addAll(cars);
                    getViewState().displayCars(cars);
                    Log.d(TAG, "getThreeBestCar: " + cars.toString());
                });
    }

}
