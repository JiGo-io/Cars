package com.telran.cars.data.provider.store;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.telran.cars.data.dto.CarForUsersDto;

import java.util.ArrayList;
import java.util.List;

public class SprefStoreProvider implements StoreProvider {
    private static final String SP_AUTH = "AUTH";
    private static final String TOKEN_KEY = "TOKEN";
    private Context context;

    public SprefStoreProvider(Context context) {
        this.context = context;
    }

    @Override
    public boolean saveToken(String token) {
        return context.getSharedPreferences(SP_AUTH,Context.MODE_PRIVATE)
                .edit()
                .putString(TOKEN_KEY,token)
                .commit();
    }

    @Override
    public boolean clearToken() {
        return context.getSharedPreferences(SP_AUTH,Context.MODE_PRIVATE)
                .edit()
                .clear()
                .commit();
    }

    @Override
    public String getToken() {
        return context.getSharedPreferences(SP_AUTH,Context.MODE_PRIVATE)
                .getString(TOKEN_KEY,null);
    }

}
