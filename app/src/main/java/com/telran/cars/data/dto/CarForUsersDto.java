package com.telran.cars.data.dto;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;
import java.util.List;

public class CarForUsersDto implements Parcelable {
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
    private OwnerDtoForCar owner;
    private BookedPeriodDateDto[] booked_periods;
    private ReservedPeriodDto[] reserved_periods;
    private StatisticsDto statistics;
    private CommentDto[] comments;

    public CarForUsersDto(String serial_number, String make, String model, String year, String engine, String fuel, String gear, String wheels_drive, int horsepower, int torque, int doors, int seats, String car_class, float fuel_consumption, String[] features, double price_per_day, double distance_included, String about, PickUpPlaceDto pick_up_place, String[] image_url, OwnerDtoForCar owner, BookedPeriodDateDto[] booked_periods, ReservedPeriodDto[] reserved_periods, StatisticsDto statistics, CommentDto[] comments) {

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

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public String getEngine() {
        return engine;
    }

    public String getFuel() {
        return fuel;
    }

    public String getGear() {
        return gear;
    }

    public String getWheels_drive() {
        return wheels_drive;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public int getTorque() {
        return torque;
    }

    public int getDoors() {
        return doors;
    }

    public int getSeats() {
        return seats;
    }

    public String getCar_class() {
        return car_class;
    }

    public float getFuel_consumption() {
        return fuel_consumption;
    }

    public String[] getFeatures() {
        return features;
    }

    public double getPrice_per_day() {
        return price_per_day;
    }

    public double getDistance_included() {
        return distance_included;
    }

    public String getAbout() {
        return about;
    }

    public PickUpPlaceDto getPick_up_place() {
        return pick_up_place;
    }

    public String[] getImage_url() {
        return image_url;
    }

    public OwnerDtoForCar getOwner() {
        return owner;
    }

    public BookedPeriodDateDto[] getBooked_periods() {
        return booked_periods;
    }

    public ReservedPeriodDto[] getReserved_periods() {
        return reserved_periods;
    }

    public StatisticsDto getStatistics() {
        return statistics;
    }

    public CommentDto[] getComments() {
        return comments;
    }

    public String getSerial_number() {
        return serial_number;
    }

    @Override
    public String toString() {
        return "CarForUsersDto{" +
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(serial_number);
        dest.writeString(make);
        dest.writeString(model);
        dest.writeString(year);
        dest.writeString(engine);
        dest.writeString(fuel);
        dest.writeString(gear);
        dest.writeString(wheels_drive);
        dest.writeInt(horsepower);
        dest.writeInt(torque);
        dest.writeInt(doors);
        dest.writeInt(seats);
        dest.writeString(car_class);
        dest.writeFloat(fuel_consumption);
        dest.writeStringArray(features);
        dest.writeDouble(price_per_day);
        dest.writeDouble(distance_included);
        dest.writeString(about);
        dest.writeValue(pick_up_place);
        dest.writeStringArray(image_url);
        dest.writeValue(owner);
        dest.writeArray(booked_periods);
        dest.writeArray(reserved_periods);
        dest.writeValue(statistics);
        dest.writeArray(comments);
    }
    public static final Parcelable.Creator<CarForUsersDto> CREATOR = new Parcelable.Creator<CarForUsersDto>(){

        @Override
        public CarForUsersDto createFromParcel(Parcel source) {
            return new CarForUsersDto(source);
        }

        @Override
        public CarForUsersDto[] newArray(int size) {
            return new CarForUsersDto[size];
        }
    };

    private CarForUsersDto(Parcel p) {
        serial_number = p.readString();
        make = p.readString();
        model = p.readString();
        year = p.readString();
        engine = p.readString();
        fuel = p.readString();
        gear = p.readString();
        wheels_drive = p.readString();
        horsepower = p.readInt();
        torque = p.readInt();
        doors = p.readInt();
        seats = p.readInt();
        car_class = p.readString();
        fuel_consumption = p.readFloat();
        features = p.createStringArray();
        price_per_day = p.readDouble();
        distance_included = p.readDouble();
        about = p.readString();
        pick_up_place = (PickUpPlaceDto) p.readValue(null);
        owner = (OwnerDtoForCar) p.readValue(null);
        booked_periods = (BookedPeriodDateDto[]) p.readArray(null);
        reserved_periods = (ReservedPeriodDto[]) p.readArray(null);
        statistics = (StatisticsDto) p.readValue(null);
        comments = (CommentDto[]) p.readArray(null);
    }
}
