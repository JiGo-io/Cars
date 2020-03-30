package com.telran.cars.data.provider.store;

public interface StoreProvider {
    boolean saveToken(String token);
    boolean clearToken();
    String getToken();
}
