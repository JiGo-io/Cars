package com.telran.cars;

import java.util.Arrays;
import java.util.List;

public class CarsFiltersDto {
    private String about;
    private BookedPeriodDateDto booked_periods;
    private String car_class;
    private List<CommentDtoForFilters> comments;
    private double distance_included;
    private int doors;
    private String engine;
    private String[] features;
    private String fuel;
    private float fuel_consumption;
    private String gear;
    private int horsepower;
    private String[] image_url;
    private String make;
    private String model;
    private OwnerDto owner;
    private PickUpPlaceDto pick_up_place;
    private double price_per_day;
    private int seats;
    private String serial_number;
    private StatisticsDto statistics;
    private int torque;
    private String wheels_drive;
    private String year;

    public CarsFiltersDto(String about, BookedPeriodDateDto booked_periods, String car_class, List<CommentDtoForFilters> comments, double distance_included, int doors, String engine, String[] features, String fuel, float fuel_consumption, String gear, int horsepower, String[] image_url, String make, String model, OwnerDto owner, PickUpPlaceDto pick_up_place, double price_per_day, int seats, String serial_number, StatisticsDto statistics, int torque, String wheels_drive, String year) {
        this.about = about;
        this.booked_periods = booked_periods;
        this.car_class = car_class;
        this.comments = comments;
        this.distance_included = distance_included;
        this.doors = doors;
        this.engine = engine;
        this.features = features;
        this.fuel = fuel;
        this.fuel_consumption = fuel_consumption;
        this.gear = gear;
        this.horsepower = horsepower;
        this.image_url = image_url;
        this.make = make;
        this.model = model;
        this.owner = owner;
        this.pick_up_place = pick_up_place;
        this.price_per_day = price_per_day;
        this.seats = seats;
        this.serial_number = serial_number;
        this.statistics = statistics;
        this.torque = torque;
        this.wheels_drive = wheels_drive;
        this.year = year;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public BookedPeriodDateDto getBooked_periods() {
        return booked_periods;
    }

    public void setBooked_periods(BookedPeriodDateDto booked_periods) {
        this.booked_periods = booked_periods;
    }

    public String getCar_class() {
        return car_class;
    }

    public void setCar_class(String car_class) {
        this.car_class = car_class;
    }

    public List<CommentDtoForFilters> getComments() {
        return comments;
    }

    public void setComments(List<CommentDtoForFilters> comments) {
        this.comments = comments;
    }

    public double getDistance_included() {
        return distance_included;
    }

    public void setDistance_included(double distance_included) {
        this.distance_included = distance_included;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String[] getFeatures() {
        return features;
    }

    public void setFeatures(String[] features) {
        this.features = features;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public float getFuel_consumption() {
        return fuel_consumption;
    }

    public void setFuel_consumption(float fuel_consumption) {
        this.fuel_consumption = fuel_consumption;
    }

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public String[] getImage_url() {
        return image_url;
    }

    public void setImage_url(String[] image_url) {
        this.image_url = image_url;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public OwnerDto getOwner() {
        return owner;
    }

    public void setOwner(OwnerDto owner) {
        this.owner = owner;
    }

    public PickUpPlaceDto getPick_up_place() {
        return pick_up_place;
    }

    public void setPick_up_place(PickUpPlaceDto pick_up_place) {
        this.pick_up_place = pick_up_place;
    }

    public double getPrice_per_day() {
        return price_per_day;
    }

    public void setPrice_per_day(double price_per_day) {
        this.price_per_day = price_per_day;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public StatisticsDto getStatistics() {
        return statistics;
    }

    public void setStatistics(StatisticsDto statistics) {
        this.statistics = statistics;
    }

    public int getTorque() {
        return torque;
    }

    public void setTorque(int torque) {
        this.torque = torque;
    }

    public String getWheels_drive() {
        return wheels_drive;
    }

    public void setWheels_drive(String wheels_drive) {
        this.wheels_drive = wheels_drive;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "CarsFiltersDto{" +
                "about='" + about + '\'' +
                ", booked_periods=" + booked_periods +
                ", car_class='" + car_class + '\'' +
                ", comments=" + comments +
                ", distance_included=" + distance_included +
                ", doors=" + doors +
                ", engine='" + engine + '\'' +
                ", features=" + Arrays.toString(features) +
                ", fuel='" + fuel + '\'' +
                ", fuel_consumption=" + fuel_consumption +
                ", gear='" + gear + '\'' +
                ", horsepower=" + horsepower +
                ", image_url=" + Arrays.toString(image_url) +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", owner=" + owner +
                ", pick_up_place=" + pick_up_place +
                ", price_per_day=" + price_per_day +
                ", seats=" + seats +
                ", serial_number='" + serial_number + '\'' +
                ", statistics=" + statistics +
                ", torque=" + torque +
                ", wheels_drive='" + wheels_drive + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
