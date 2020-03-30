package com.telran.cars.di;

import android.content.Context;

import com.telran.cars.business.auth.AuthInteractor;
import com.telran.cars.business.auth.AuthInteractorImpl;
import com.telran.cars.business.withoutauth.WithoutAuthInteractor;
import com.telran.cars.business.withoutauth.WithoutAuthInteractorImpl;
import com.telran.cars.data.auth.AuthRepository;
import com.telran.cars.data.auth.AuthRepositoryImpl;
import com.telran.cars.data.provider.store.SprefStoreProvider;
import com.telran.cars.data.provider.store.StoreProvider;
import com.telran.cars.data.repository.CarFilterControllerRepository;
import com.telran.cars.data.repository.CarFilterControllerRepositoryImpl;

public class DependenceFactory {
    private static DependenceFactory instance;
    private StoreProvider storeProvider;
    private AuthRepository authRepository;
    private AuthInteractor authInteractor;


    public DependenceFactory(Context context){
        storeProvider = new SprefStoreProvider(context);
        authRepository = new AuthRepositoryImpl(ApiProvider.getInstance().getApiRx(),storeProvider);
        authInteractor = new AuthInteractorImpl(authRepository);
        instance = this;

    }

    public AuthInteractor getAuthInteractor() {
        return authInteractor;
    }

    public static DependenceFactory getInstance(){return instance;}
}
