package com.techtimeapp.techtime.view.view.data;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;

import java.util.ArrayList;
import java.util.Date;

@Entity
public class PayPeriod {
    @ColumnInfo(name = "repair_order_list")
    public ArrayList<RepairOrder> mRepairOrders;

    @ColumnInfo(name = "Start_Date")
    public Date mStartDate;

    @ColumnInfo(name = "End_Date")
    public Date mEndDate;

    @ColumnInfo(name = "Number_of_Repair_Orders")
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

