package com.techtimeapp.techtime.view.view.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Databasehelper extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseHelper";
    private SQLiteDatabase db;
    private static final String TABLE_NAME = "REPAIR_ORDER_TABLE";
    private static final String COL1 = "ID";
    private static final String COL2 = "ROnumber";
    private static final String COL3 = "Writer";
    private static final String COL4 = "Customer";
    private static final String COL5 = "Date";
    private static final String COL6 = "InsuranceCo";
    private static final String COL7 = "hours";
    private static final String COL9 = "make";
    private static final String COL10 = "model";
    private static final String COL11 = "year";
    private static final String COL12 = "mileage";
    private static final String COL13 = "vin";
    private static final String COL14 = "color";
    private static final String COL15 = "license";
    private static final String COL16 = "LaborRate1";
    private static final String COL17 = "LaborRate2";
    private static final String COL18 = "LaborRate3";
    private static final String COL19 = "LaborRate4";
    private static final String COL20 = "LaborRate5";
    private static final String COL21 = "LaborRate6";
    private static final String COL22 = "LaborRate7";
    private static final String COL23 = "LaborRate8";
    private static final String COL24 = "LaborRate9";
    private static final String COL25 = "LaborRate10";



    public Databasehelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE " + TABLE_NAME + COL1 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 + "TEXT NOT NULL, " +
                COL3 + "TEXT NOT NULL, "+
                COL4 + "TEXT, " +
                COL5 + "REAL, " +
                COL6 + "TEXT, " +
                COL7 + "REAL NOT NULL, " +
                COL9 + "TEXT, " +
                COL10 + "TEXT, " +
                COL11 + "TEXT, " +
                COL12 + "TEXT, " +
                COL13 + "TEXT, " +
                COL14 + "TEXT, " +
                COL15 + "TEXT, " +
                COL16 + "REAL, " +
                COL17 + "REAL, " +
                COL18 + "REAL, " +
                COL19 + "REAL, " +
                COL20 + "REAL, " +
                COL21 + "REAL, " +
                COL22 + "REAL, " +
                COL23 + "REAL, " +
                COL24 + "REAL, " +
                COL25 + "REAL "  +")";


        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String ROnum, String writer,String customer, String date,  String insuranceCO, String hours,  String make,
                          String model, String year, String mileage, String vin, String color, String license, String laborrate1
    , String laborrate2, String laborrate3, String laborrate4, String laborrate5, String laborrate6, String laborrate7, String laborrate8,
                           String laborrate9, String laborrate10){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, ROnum);
        contentValues.put(COL3, writer);
        contentValues.put(COL4, customer);
        contentValues.put(COL5, date);
        contentValues.put(COL6, insuranceCO);
        contentValues.put(COL7, hours);
        contentValues.put(COL9, make);
        contentValues.put(COL10, model);
        contentValues.put(COL11, year);
        contentValues.put(COL12, mileage);
        contentValues.put(COL13, vin);
        contentValues.put(COL14, color);
        contentValues.put(COL15, license);
        contentValues.put(COL16, laborrate1);
        contentValues.put(COL17, laborrate2);
        contentValues.put(COL18, laborrate3);
        contentValues.put(COL19, laborrate4);
        contentValues.put(COL20, laborrate5);
        contentValues.put(COL21, laborrate6);
        contentValues.put(COL22, laborrate7);
        contentValues.put(COL23, laborrate8);
        contentValues.put(COL24, laborrate9);
        contentValues.put(COL25, laborrate10);

        Log.d(TAG, "addDATA: adding " + ROnum + " to " + TABLE_NAME);
        //if data is inserted incorrectly it will return -1
        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1 ){
            return false;
        } else {
            return true;
        }
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }


}
