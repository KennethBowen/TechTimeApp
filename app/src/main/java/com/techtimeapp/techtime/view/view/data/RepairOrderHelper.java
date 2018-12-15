package com.techtimeapp.techtime.view.view.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RepairOrderHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "RepairOrder.db";
    public static final String TABLE_NAME = "REPAIR_ORDER_TABLE ";
    public static final String COL1 = "ID";
    public static final String COL2 = "repairordernumber";
    public static final String COL3 = "Writer";
    public static final String COL4 = "Customer";
    public static final String COL5 = "Date";
    public static final String COL6 = "InsuranceCo";
    public static final String COL7 = "SpinnerCount";
    public static final String COL8 = "hoursone";
    public static final String COL9 = "hourstwo";
    public static final String COL10 = "hoursthree";
    public static final String COL11 = "hoursfour";
    public static final String COL12 = "hoursfive";
    public static final String COL13 = "hourssix";
    public static final String COL14 = "hoursseven";
    public static final String COL15 = "hourseight";
    public static final String COL16 = "hoursnine";
    public static final String COL17 = "grossone";
    public static final String COL18 = "grosstwo";
    public static final String COL19 = "grossthree";
    public static final String COL20 = "grossfour";
    public static final String COL21 = "grossfive";
    public static final String COL22 = "grosssix";
    public static final String COL23 = "grossseven";
    public static final String COL24 = "grosseight";
    public static final String COL25 = "grossnine";

    public RepairOrderHelper(Context context) {
            super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
