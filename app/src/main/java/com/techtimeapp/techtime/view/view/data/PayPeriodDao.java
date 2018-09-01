package com.techtimeapp.techtime.view.view.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface PayPeriodDao {
    @Query("SELECT * FROM payperiod")
    List<PayPeriod> getAllPay();

    @Insert
    void insertPayPeriod(PayPeriod... payPeriods);

    @Delete
    void delete(PayPeriod payPeriod);
}
