package com.techtimeapp.techtime.view.view.data;

import java.time.Year;

public class Vehicle {
    private String mMake;
    private String mModel;
    private Year mYear;
    private int mMileage;
    private  String mVIN;
    private String color;
    private String mLicense;

    public Vehicle(String make, String model, Year year, int mileage, String VIN, String color, String license) {
        mMake = make;
        mModel = model;
        mYear = year;
        mMileage = mileage;
        mVIN = VIN;
        this.color = color;
        mLicense = license;
    }

    public String getMake() {
        return mMake;
    }

    public void setMake(String make) {
        mMake = make;
    }

    public String getModel() {
        return mModel;
    }

    public void setModel(String model) {
        mModel = model;
    }

    public Year getYear() {
        return mYear;
    }

    public void setYear(Year year) {
        mYear = year;
    }

    public int getMileage() {
        return mMileage;
    }

    public void setMileage(int mileage) {
        mMileage = mileage;
    }

    public String getVIN() {
        return mVIN;
    }

    public void setVIN(String VIN) {
        mVIN = VIN;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLicense() {
        return mLicense;
    }

    public void setLicense(String license) {
        mLicense = license;
    }
}
