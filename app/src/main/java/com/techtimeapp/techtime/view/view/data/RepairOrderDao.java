package com.techtimeapp.techtime.view.view.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.Date;
import java.util.List;

@Dao
public interface RepairOrderDao {
    @Query("SELECT * FROM RepairOrder")
    List<RepairOrder> getAll();

    @Query("SELECT * FROM RepairOrder WHERE mUid IN (:mUid)")
    List<RepairOrder> loadAllByIds(int[] mUid);

    @Insert
    void  insertAll(RepairOrder... repairOrders);

    @Delete
    void delete(RepairOrder repairOrder);
}
