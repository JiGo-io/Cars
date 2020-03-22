package com.telran.cars.data.repository;

import io.reactivex.Completable;

public interface UserControllerRepository {
    Completable onLogin(String token);
    Completable onRegistration(String token, String firstName, String secondName);
    Completable onActivateUser(String code);
    Completable onUpdateUserWithPassword(String token, String newPassword, String firstName, String photo, String secondName);
    Completable onUpdateUserWithoutPassword(String token,String firstName, String photo, String secondName);
    Completable onDeleteUser(String token);
    Completable getBookedList(String token);
    Completable getInvoice(String token, String orderId);
    Completable remindPassword(String ReturnPath);

}
