package com.telran.cars.data.dto;

public class UserBaseDto {
    private String first_name;
    private String photo;
    private String second_name;

    public UserBaseDto(String first_name, String photo, String second_name) {
        this.first_name = first_name;
        this.photo = photo;
        this.second_name = second_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    @Override
    public String toString() {
        return "UserBaseDto{" +
                "first_name='" + first_name + '\'' +
                ", photo='" + photo + '\'' +
                ", second_name='" + second_name + '\'' +
                '}';
    }
}
