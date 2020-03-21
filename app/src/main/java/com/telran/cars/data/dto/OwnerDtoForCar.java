package com.telran.cars.data.dto;

public class OwnerDtoForCar {
    private String first_name;
    private String registration_date;
    private String second_name;

    public OwnerDtoForCar(String first_name, String registration_date, String second_name) {
        this.first_name = first_name;
        this.registration_date = registration_date;
        this.second_name = second_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    @Override
    public String toString() {
        return "OwnerDtoForCar{" +
                "first_name='" + first_name + '\'' +
                ", registration_date='" + registration_date + '\'' +
                ", second_name='" + second_name + '\'' +
                '}';
    }
}
