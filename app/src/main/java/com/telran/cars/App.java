package com.telran.cars;

import android.app.Application;

import com.telran.cars.di.app.AppComponent;
import com.telran.cars.di.app.AppModule;
import com.telran.cars.di.app.DaggerAppComponent;
import com.telran.cars.di.auth.AuthComponent;
import com.telran.cars.di.auth.AuthModule;
import com.telran.cars.di.withoutauth.WithoutAuthComponent;
import com.telran.cars.di.withoutauth.WithoutAuthModule;

public class App extends Application {

//    @Override
//    public void onCreate() {
//        super.onCreate();
//        new DependenceFactoryMain(this);
//    }

    private static App app;
    private AppComponent appComponent;
    private AuthComponent authComponent;
    private WithoutAuthComponent withoutAuthComponent;

    public App() {
        app = this;
    }

    public static App get(){
        return app;
    }

    @Override
    public void onCreate() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        super.onCreate();
    }

    public AuthComponent plus(AuthModule module){
        if (authComponent == null){
            authComponent = appComponent.plus(module);
        }
        return authComponent;
    }

    public void clearAuthComponent(){
        authComponent = null;
    }

    public WithoutAuthComponent plus(WithoutAuthModule module){
        if (withoutAuthComponent == null){
            withoutAuthComponent = appComponent.plus(module);
        }
        return withoutAuthComponent;
    }
    public void clearWithoutAuthComponent(){
        withoutAuthComponent = null;
    }

}
