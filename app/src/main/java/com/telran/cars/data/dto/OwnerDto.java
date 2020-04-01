package com.telran.cars.data.dto;

class OwnerDto {
    private String first_name;
    private String second_name;
    private String registration_date;

    public OwnerDto(String first_name, String second_name, String registration_date) {
        this.first_name = first_name;
        this.second_name = second_name;
        this.registration_date = registration_date;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }

    @Override
    public String toString() {
        return "OwnerDto{" +
                "first_name='" + first_name + '\'' +
                ", second_name='" + second_name + '\'' +
                ", registration_date='" + registration_date + '\'' +
                '}';
    }
}
