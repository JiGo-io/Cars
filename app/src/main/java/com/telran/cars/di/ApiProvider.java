package com.telran.cars.di;

import com.telran.cars.data.provider.web.ApiRx;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiProvider {
    private static final ApiProvider instance = new ApiProvider();
    private ApiRx apiRx;

    public static ApiProvider getInstance() {
        return instance;
    }
    private ApiProvider() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://java-3-ilcarro-team-b.herokuapp.com/")
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        apiRx = retrofit.create(ApiRx.class);
    }

    public ApiRx getApiRx() {
        return apiRx;
    }
}
