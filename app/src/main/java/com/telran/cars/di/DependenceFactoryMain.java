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

public class DependenceFactoryMain {
    private static DependenceFactoryMain instance;
    private StoreProvider storeProvider;
    private CarFilterControllerRepository carFilterControllerRepository;
    private WithoutAuthInteractor withoutAuthInteractor;


    public DependenceFactoryMain(Context context){
        storeProvider = new SprefStoreProvider(context);
        carFilterControllerRepository = new CarFilterControllerRepositoryImpl(ApiProvider.getInstance().getApiRx());
        withoutAuthInteractor = new WithoutAuthInteractorImpl(carFilterControllerRepository);
        instance = this;

    }


    public WithoutAuthInteractor getWithoutAuthInteractor() {
        return withoutAuthInteractor;
    }

    public static DependenceFactoryMain getInstance(){return instance;}
}
