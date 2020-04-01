package com.telran.cars.data.dto;

import java.util.Arrays;
import java.util.List;

public class CarsFiltersDto {
    private String serial_number;
    private String make;
    private String model;
    private String year;
    private String engine;
    private String fuel;
    private String gear;
    private String wheels_drive;
    private int horsepower;
    private int torque;
    private int doors;
    private int seats;
    private String car_class;
    private float fuel_consumption;
    private String[] features;
    private double price_per_day;
    private double distance_included;
    private String about;
    private PickUpPlaceDto pick_up_place;
    private String[] image_url;
    private OwnerDto owner;
    private BookedPeriodDateDto[] booked_periods; //[]??
    private ReservedPeriodDto[] reserved_periods; //[]??
    private StatisticsDto statistics;
    private CommentDtoForFilters[] comments; //[]??

    public CarsFiltersDto(String serial_number, String make, String model, String year, String engine, String fuel, String gear, String wheels_drive, int horsepower, int torque, int doors, int seats, String car_class, float fuel_consumption, String[] features, double price_per_day, double distance_included, String about, PickUpPlaceDto pick_up_place, String[] image_url, OwnerDto owner, BookedPeriodDateDto[] booked_periods, ReservedPeriodDto[] reserved_periods, StatisticsDto statistics, CommentDtoForFilters[] comments) {
        this.serial_number = serial_number;
        this.make = make;
        this.model = model;
        this.year = year;
        this.engine = engine;
        this.fuel = fuel;
        this.gear = gear;
        this.wheels_drive = wheels_drive;
        this.horsepower = horsepower;
        this.torque = torque;
        this.doors = doors;
        this.seats = seats;
        this.car_class = car_class;
        this.fuel_consumption = fuel_consumption;
        this.features = features;
        this.price_per_day = price_per_day;
        this.distance_included = distance_included;
        this.about = about;
        this.pick_up_place = pick_up_place;
        this.image_url = image_url;
        this.owner = owner;
        this.booked_periods = booked_periods;
        this.reserved_periods = reserved_periods;
        this.statistics = statistics;
        this.comments = comments;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public String getWheels_drive() {
        return wheels_drive;
    }

    public void setWheels_drive(String wheels_drive) {
        this.wheels_drive = wheels_drive;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getTorque() {
        return torque;
    }

    public void setTorque(int torque) {
        this.torque = torque;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getCar_class() {
        return car_class;
    }

    public void setCar_class(String car_class) {
        this.car_class = car_class;
    }

    public float getFuel_consumption() {
        return fuel_consumption;
    }

    public void setFuel_consumption(float fuel_consumption) {
        this.fuel_consumption = fuel_consumption;
    }

    public String[] getFeatures() {
        return features;
    }

    public void setFeatures(String[] features) {
        this.features = features;
    }

    public double getPrice_per_day() {
        return price_per_day;
    }

    public void setPrice_per_day(double price_per_day) {
        this.price_per_day = price_per_day;
    }

    public double getDistance_included() {
        return distance_included;
    }

    public void setDistance_included(double distance_included) {
        this.distance_included = distance_included;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public PickUpPlaceDto getPick_up_place() {
        return pick_up_place;
    }

    public void setPick_up_place(PickUpPlaceDto pick_up_place) {
        this.pick_up_place = pick_up_place;
    }

    public String[] getImage_url() {
        return image_url;
    }

    public void setImage_url(String[] image_url) {
        this.image_url = image_url;
    }

    public OwnerDto getOwner() {
        return owner;
    }

    public void setOwner(OwnerDto owner) {
        this.owner = owner;
    }

    public BookedPeriodDateDto[] getBooked_periods() {
        return booked_periods;
    }

    public void setBooked_periods(BookedPeriodDateDto[] booked_periods) {
        this.booked_periods = booked_periods;
    }

    public ReservedPeriodDto[] getReserved_periods() {
        return reserved_periods;
    }

    public void setReserved_periods(ReservedPeriodDto[] reserved_periods) {
        this.reserved_periods = reserved_periods;
    }

    public StatisticsDto getStatistics() {
        return statistics;
    }

    public void setStatistics(StatisticsDto statistics) {
        this.statistics = statistics;
    }

    public CommentDtoForFilters[] getComments() {
        return comments;
    }

    public void setComments(CommentDtoForFilters[] comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "CarsFiltersDto2{" +
                "serial_number='" + serial_number + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", engine='" + engine + '\'' +
                ", fuel='" + fuel + '\'' +
                ", gear='" + gear + '\'' +
                ", wheels_drive='" + wheels_drive + '\'' +
                ", horsepower=" + horsepower +
                ", torque=" + torque +
                ", doors=" + doors +
                ", seats=" + seats +
                ", car_class='" + car_class + '\'' +
                ", fuel_consumption=" + fuel_consumption +
                ", features=" + Arrays.toString(features) +
                ", price_per_day=" + price_per_day +
                ", distance_included=" + distance_included +
                ", about='" + about + '\'' +
                ", pick_up_place=" + pick_up_place +
                ", image_url=" + Arrays.toString(image_url) +
                ", owner=" + owner +
                ", booked_periods=" + Arrays.toString(booked_periods) +
                ", reserved_periods=" + Arrays.toString(reserved_periods) +
                ", statistics=" + statistics +
                ", comments=" + Arrays.toString(comments) +
                '}';
    }
}
