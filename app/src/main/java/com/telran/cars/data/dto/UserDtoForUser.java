package com.telran.cars.data.dto;

import java.util.Arrays;

public class UserDtoForUser {
    private BookedCarsDtoForUser[] booked_cars;
    private CommentDto[] comments;
    private String first_name;
    private HistoryDtoForUser[] history;
    private OwnerCarDtoForUser[] own_cars;
    private String photo;
    private String registration_date;
    private String second_name;

    @Override
    public String toString() {
        return "UserDtoForUser{" +
                "booked_cars=" + Arrays.toString(booked_cars) +
                ", comments=" + Arrays.toString(comments) +
                ", first_name='" + first_name + '\'' +
                ", history=" + Arrays.toString(history) +
                ", own_cars=" + Arrays.toString(own_cars) +
                ", photo='" + photo + '\'' +
                ", registration_date='" + registration_date + '\'' +
                ", second_name='" + second_name + '\'' +
                '}';
    }

    public BookedCarsDtoForUser[] getBooked_cars() {
        return booked_cars;
    }

    public CommentDto[] getComments() {
        return comments;
    }

    public String getFirst_name() {
        return first_name;
    }

    public HistoryDtoForUser[] getHistory() {
        return history;
    }

    public OwnerCarDtoForUser[] getOwn_cars() {
        return own_cars;
    }

    public String getPhoto() {
        return photo;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public String getSecond_name() {
        return second_name;
    }

    public UserDtoForUser(BookedCarsDtoForUser[] booked_cars, CommentDto[] comments, String first_name, HistoryDtoForUser[] history, OwnerCarDtoForUser[] own_cars, String photo, String registration_date, String second_name) {
        this.booked_cars = booked_cars;
        this.comments = comments;
        this.first_name = first_name;
        this.history = history;
        this.own_cars = own_cars;
        this.photo = photo;
        this.registration_date = registration_date;
        this.second_name = second_name;
    }
}
