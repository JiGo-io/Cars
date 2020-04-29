package com.telran.cars.di.auth;

import com.telran.cars.business.auth.AuthInteractor;
import com.telran.cars.business.auth.AuthInteractorImpl;
import com.telran.cars.data.interactor.Interactor;
import com.telran.cars.data.provider.store.StoreProvider;
import com.telran.cars.data.provider.web.ApiRx;
import com.telran.cars.data.repository.auth.AuthRepository;
import com.telran.cars.data.repository.auth.AuthRepositoryImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class AuthModule {
    @Provides
    @AuthScope
    AuthRepository provideAuthRepo(ApiRx api, StoreProvider store, Interactor interactor){
        return new AuthRepositoryImpl(api, store, interactor);
    }
    @Provides
    @AuthScope
    AuthInteractor provideAuthInteractor(AuthRepository repo){
        return new AuthInteractorImpl(repo);
    }
}
