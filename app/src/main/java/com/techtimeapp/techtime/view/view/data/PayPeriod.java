package com.techtimeapp.techtime.view.view.data;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;

import java.util.ArrayList;
import java.util.Date;

public class PayPeriod {

    public ArrayList<RepairOrder> mRepairOrders;


    public Date mStartDate;


    public Date mEndDate;


    public int mNumberOfRepairOrders;

    public PayPeriod(ArrayList<RepairOrder> repairOrders, Date startDate, Date endDate, int numberOfRepairOrders) {
        mRepairOrders = repairOrders;
        mStartDate = startDate;
        mEndDate = endDate;
        mNumberOfRepairOrders = numberOfRepairOrders;
    }

    public Date getStartDate() {
        return mStartDate;
    }

    public Date getEndDate() {
        return mEndDate;
    }

    public int getNumberOfRepairOrders() {
        return mRepairOrders.size();
    }
}

