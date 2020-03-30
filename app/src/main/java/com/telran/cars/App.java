package com.telran.cars;

import android.app.Application;

import com.telran.cars.di.DependenceFactoryMain;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        new DependenceFactoryMain(this);
    }
}
