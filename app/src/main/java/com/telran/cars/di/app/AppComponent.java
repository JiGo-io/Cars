package com.telran.cars.di.app;

import com.telran.cars.di.auth.AuthComponent;
import com.telran.cars.di.auth.AuthModule;
import com.telran.cars.di.withoutauth.WithoutAuthComponent;
import com.telran.cars.di.withoutauth.WithoutAuthModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {
    AuthComponent plus(AuthModule module);
    WithoutAuthComponent plus (WithoutAuthModule module);
}
