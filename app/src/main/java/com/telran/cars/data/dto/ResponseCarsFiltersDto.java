package com.telran.cars.data.dto;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

public class ResponseCarsFiltersDto implements Parcelable {
    String current_page;
    String items_on_page;
    String items_total;
    CarsFiltersDto[] cars;

    public ResponseCarsFiltersDto(String current_page, String items_on_page, String items_total, CarsFiltersDto[] cars) {
        this.current_page = current_page;
        this.items_on_page = items_on_page;
        this.items_total = items_total;
        this.cars = cars;
    }

    public String getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(String current_page) {
        this.current_page = current_page;
    }

    public String getItems_on_page() {
        return items_on_page;
    }

    public void setItems_on_page(String items_on_page) {
        this.items_on_page = items_on_page;
    }

    public String getItems_total() {
        return items_total;
    }

    public void setItems_total(String items_total) {
        this.items_total = items_total;
    }

    public CarsFiltersDto[] getCars() {
        return cars;
    }

    public void setCars(CarsFiltersDto[] cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "ResponseCarsFiltersDto{" +
                "current_page=" + current_page +
                ", items_on_page=" + items_on_page +
                ", items_total=" + items_total +
                ", cars=" + Arrays.toString(cars) +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(current_page);
        dest.writeString(items_on_page);
        dest.writeString(items_total);
        dest.writeArray(cars);
    }

    public static final Parcelable.Creator<ResponseCarsFiltersDto> CREATOR = new Parcelable.Creator<ResponseCarsFiltersDto>(){

        @Override
        public ResponseCarsFiltersDto createFromParcel(Parcel source) {
            return new ResponseCarsFiltersDto(source);
        }

        @Override
        public ResponseCarsFiltersDto[] newArray(int size) {
            return new ResponseCarsFiltersDto[size];
        }
    };

    private ResponseCarsFiltersDto (Parcel p) {
        current_page = p.readString();
        items_on_page = p.readString();
        items_total = p.readString();
        cars = (CarsFiltersDto[]) p.readArray(null);
    }
}
