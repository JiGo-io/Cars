package com.telran.cars.presentation.main.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.telran.cars.App;
import com.telran.cars.business.auth.AuthInteractor;
import com.telran.cars.di.auth.AuthModule;
import com.telran.cars.presentation.main.view.IAuthFragment;
import com.telran.cars.presentation.main.view.MainFragment;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Credentials;

@InjectViewState
public class AuthPresenter extends MvpPresenter<IAuthFragment>{
    private static final String TAG = "AuthPresentor";
    @Inject
    AuthInteractor interactor;
    Disposable disposable;
    String token;

    public AuthPresenter(){
        App.get().plus(new AuthModule()).inject(this);
    }

    public void onLogin(String email, String password){
        token = Credentials.basic(email,password);
        Log.d("MY_TAG", "onLogin: " + token);
        disposable = interactor.onLogin(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> onSuccess(), throwable -> {
                    Log.e(TAG, "onLogin: ", throwable );
                });
    }

    private void onSuccess() {
        Log.d(TAG, "onSuccess: ");
        getViewState().showNextView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (disposable != null){
            disposable.dispose();
        }
        App.get().clearAuthComponent();
    }
}
