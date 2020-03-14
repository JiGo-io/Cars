package com.telran.cars;

public class UserDtoForUser {
    private BookedCarsDtoForUser booked_cars;
    private CommentDto comments;
    private String first_name;
    private HistoryDtoForUser history;
    private OwnerCarDtoForUser own_cars;
    private String photo;
    private String registration_date;
    private String second_name;

    public UserDtoForUser(BookedCarsDtoForUser booked_cars, CommentDto comments, String first_name, HistoryDtoForUser history, OwnerCarDtoForUser own_cars, String photo, String registration_date, String second_name) {
        this.booked_cars = booked_cars;
        this.comments = comments;
        this.first_name = first_name;
        this.history = history;
        this.own_cars = own_cars;
        this.photo = photo;
        this.registration_date = registration_date;
        this.second_name = second_name;
    }

    public BookedCarsDtoForUser getBooked_cars() {
        return booked_cars;
    }

    public void setBooked_cars(BookedCarsDtoForUser booked_cars) {
        this.booked_cars = booked_cars;
    }

    public CommentDto getComments() {
        return comments;
    }

    public void setComments(CommentDto comments) {
        this.comments = comments;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public HistoryDtoForUser getHistory() {
        return history;
    }

    public void setHistory(HistoryDtoForUser history) {
        this.history = history;
    }

    public OwnerCarDtoForUser getOwn_cars() {
        return own_cars;
    }

    public void setOwn_cars(OwnerCarDtoForUser own_cars) {
        this.own_cars = own_cars;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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
        return "UserDtoForUser{" +
                "booked_cars=" + booked_cars +
                ", comments=" + comments +
                ", first_name='" + first_name + '\'' +
                ", history=" + history +
                ", own_cars=" + own_cars +
                ", photo='" + photo + '\'' +
                ", registration_date='" + registration_date + '\'' +
                ", second_name='" + second_name + '\'' +
                '}';
    }
}
