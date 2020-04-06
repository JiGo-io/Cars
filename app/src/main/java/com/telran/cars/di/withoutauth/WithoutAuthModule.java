package com.telran.cars.di.withoutauth;

import com.telran.cars.business.withoutauth.WithoutAuthInteractor;
import com.telran.cars.business.withoutauth.WithoutAuthInteractorImpl;
import com.telran.cars.data.provider.web.ApiRx;
import com.telran.cars.data.repository.withoutauth.WithoutAuthRepository;
import com.telran.cars.data.repository.withoutauth.WithoutAuthRepositoryImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class WithoutAuthModule {
    @Provides
    @WithoutAuthScope
    WithoutAuthRepository provideWRepo(ApiRx api){
        return new WithoutAuthRepositoryImpl(api);
    }

    @Provides
    @WithoutAuthScope
    WithoutAuthInteractor provideWInteractor(WithoutAuthRepository repo){
        return new WithoutAuthInteractorImpl(repo);
    }

}
