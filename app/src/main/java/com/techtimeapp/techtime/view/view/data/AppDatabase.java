package com.techtimeapp.techtime.view.view.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * HEY YOU! YEAAAA YOU! DON'T TOUCH!
 * Database using room abstraction for later use with RXJava and Dagger2
 * for using dependency injection classes.
 */

@Database(entities = {RepairOrder.class, PayPeriod.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract RepairOrderDao mRepairOrderDao();
    public abstract PayPeriodDao mPayPeriodDao();
}
