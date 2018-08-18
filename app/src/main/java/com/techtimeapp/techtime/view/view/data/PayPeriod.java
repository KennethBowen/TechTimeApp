package com.techtimeapp.techtime.view.view.data;

import java.util.ArrayList;
import java.util.Date;

public class PayPeriod {
    private ArrayList<RepairOrder> mRepairOrders;
    private Date mStartDate;
    private Date mEndDate;
    private int mNumberOfRepairOrders;

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

