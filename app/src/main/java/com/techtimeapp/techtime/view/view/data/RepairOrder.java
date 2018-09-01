package com.techtimeapp.techtime.view.view.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity
public class RepairOrder {
    @PrimaryKey
    private int mUid;

    @ColumnInfo(name = "Repair_Order_number")
    private int mRepairOrderNumber;

    @ColumnInfo(name = "Writer")
    private String mWriter;

    @ColumnInfo(name = "Customer")
    private String mCustomer;

    @ColumnInfo(name = "Date")
    private Date mDate;

    @ColumnInfo(name = "Labor_Rate")
    private LaborRate mLaborRate;

    @ColumnInfo(name = "Vehicle")
    private Vehicle mVehicle;

    @ColumnInfo(name = "Hours")
    private double mHours;

    @ColumnInfo(name = "Gross")
    private double mGross;

    public RepairOrder(int Uid, int repairOrderNumber, String writer, Date date, LaborRate laborRate) {
        mUid = Uid;
        mRepairOrderNumber = repairOrderNumber;
        mWriter = writer;
        mDate = date;
        mLaborRate = laborRate;
    }

    public RepairOrder(int Uid, int repairOrderNumber, String writer, Date date,  String customer, LaborRate laborRate, Vehicle vehicle, double hours, double gross) {
        mUid = Uid;
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
