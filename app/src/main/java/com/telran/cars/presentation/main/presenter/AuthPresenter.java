package com.telran.cars.presentation.main.presenter;

import android.util.Log;

import com.arellomobile.mvp.MvpPresenter;
import com.telran.cars.business.auth.AuthInteractor;
import com.telran.cars.di.DependenceFactory;
import com.telran.cars.presentation.main.view.MainFragment;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AuthPresenter {
    private static final String TAG = "AuthPresentor";
    AuthInteractor interactor;
    Disposable disposable;


    public AuthPresenter() {
        this.interactor = DependenceFactory.getInstance().getAuthInteractor();
    }

//    public void onLogin(String email, String password){
//        disposable = interactor.onLogin(email,password)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(() -> authSuccess(), throwable -> {
//                    Log.e(TAG, "onLogin: ", throwable );
//                });
//    }

}
