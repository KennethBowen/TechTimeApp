package com.techtimeapp.techtime.view.view.data;

import java.util.Date;

public class RepairOrder {
    private int mRepairOrderNumber;
    private String mWriter;
    private String mCustomer;
    private Date mDate;
    private LaborRate mLaborRate;
    private Vehicle mVehicle;
    private double mHours;
    private double mGross;

    public RepairOrder(int repairOrderNumber, String writer, Date date, LaborRate laborRate) {
        mRepairOrderNumber = repairOrderNumber;
        mWriter = writer;
        mDate = date;
        mLaborRate = laborRate;
    }

    public RepairOrder(int repairOrderNumber, String writer, Date date,  String customer, LaborRate laborRate, Vehicle vehicle, double hours, double gross) {
        mRepairOrderNumber = repairOrderNumber;
        mWriter = writer;
        mDate = date;
        mCustomer = customer;
        mLaborRate = laborRate;
        mVehicle = vehicle;
        mHours = hours;
        mGross = gross;
    }

    public int getRepairOrderNumber() {
        return mRepairOrderNumber;
    }

    public void setRepairOrderNumber(int repairOrderNumber) {
        mRepairOrderNumber = repairOrderNumber;
    }

    public String getWriter() {
        return mWriter;
    }

    public void setWriter(String writer) {
        mWriter = writer;
    }

    public String getCustomer() {
        return mCustomer;
    }

    public void setCustomer(String customer) {
        mCustomer = customer;
    }

    public LaborRate getLaborRate() {
        return mLaborRate;
    }

    public void setLaborRate(LaborRate laborRate) {
        mLaborRate = laborRate;
    }

    public Vehicle getVehicle() {
        return mVehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        mVehicle = vehicle;
    }

    public double getHours() {
        return mHours;
    }

    public void setHours(double hours) {
        mHours = hours;
    }

    public double getGross() {
        return mGross;
    }

    public void setGross(double gross) {
        mGross = gross;
    }
}
