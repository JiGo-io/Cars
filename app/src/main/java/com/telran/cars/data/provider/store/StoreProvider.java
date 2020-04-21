package com.telran.cars.data.provider.store;

import com.telran.cars.data.dto.CarForUsersDto;

import java.util.List;

public interface StoreProvider {
    boolean saveToken(String token);
    boolean clearToken();
    String getToken();

   }
