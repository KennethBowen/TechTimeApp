package com.techtimeapp.techtime.view.view.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
    public static final String COL26 = "laboroneselected";
    public static final String COL27 = "labortwoselected";
    public static final String COL28 = "laborthreeselected";
    public static final String COL29 = "laborfourselected";
    public static final String COL30 = "laborfiveselected";
    public static final String COL31 = "laborsixselected";
    public static final String COL32 = "laborsevenselected";
    public static final String COL33 = "laboreightselected";
    public static final String COL34 = "labornineselected";
    public static final String COL35 = "payrollmatch";
    public static final String COL36 = "totalgross";
    public static final String COL37 = "make";
    public static final String COL38 = "model";
    public static final String COL39 = "year";
    public static final String COL40 = "mileage";
    public static final String COL41 = "vin";
    public static final String COL42 = "color";
    public static final String COL43 = "license";
    public static final String COL44 = "totalhours";

    public RepairOrderHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                COL2 + " TEXT, " +
                COL3 + " TEXT, " +
                COL4 + " TEXT, " +
                COL5 + " TEXT, " +
                COL6 + " TEXT, " +
                COL7 + " TEXT, " +
                COL8 + " TEXT, " +
                COL9 + " TEXT, " +
                COL10 + " TEXT, " +
                COL11 + " TEXT, " +
                COL12 + " TEXT, " +
                COL13 + " TEXT, " +
                COL14 + " TEXT, " +
                COL15 + " TEXT, " +
                COL16 + " TEXT, " +
                COL17 + " TEXT, " +
                COL18 + " TEXT, " +
                COL19 + " TEXT, " +
                COL20 + " TEXT, " +
                COL21 + " TEXT, " +
                COL22 + " TEXT, " +
                COL23 + " TEXT, " +
                COL24 + " TEXT, " +
                COL25 + " TEXT, " +
                COL26 + " TEXT, " +
                COL27 + " TEXT, " +
                COL28 + " TEXT, " +
                COL29 + " TEXT, " +
                COL30 + " TEXT, " +
                COL31 + " TEXT, " +
                COL32 + " TEXT, " +
                COL33 + " TEXT, " +
                COL34 + " TEXT, " +
                COL35 + " TEXT, " +
                COL36 + " TEXT, " +
                COL37 + " TEXT, " +
                COL38 + " TEXT, " +
                COL39 + " TEXT, " +
                COL40 + " TEXT, " +
                COL41 + " TEXT, " +
                COL42 + " TEXT, " +
                COL43 + " TEXT, " +
                COL44 + " TEXT )");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public String getROnumber() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT repairordernumber FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("repairordernumber"));
        }
        result.close();

        return returnString;
    }

    public boolean addROnumber(String repairordernumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, repairordernumber);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateROnumber(String repairordernumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, repairordernumber);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getWriter() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT Writer FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("Writer"));
        }
        result.close();

        return returnString;
    }

    public boolean addWriter(String writer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL3, writer);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1 ){
            return false;
        } else {
            return true;
        }
    }

    public void updateWriter(String writer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL3, writer);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getCustomer() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT Customer FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("Customer"));
        }
        result.close();

        return returnString;
    }

    public boolean addCustomer(String customer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL4, customer);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateCustomer(String customer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL4, customer);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getDate() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT Date FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("Date"));
        }
        result.close();

        return returnString;
    }

    public boolean addDate(String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL5, date);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateDate(String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL5, date);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getInsuranceCo() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT InsuranceCo FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("InsuranceCo"));
        }
        result.close();

        return returnString;
    }

    public boolean addInsuranceCo(String InsuranceCo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL6, InsuranceCo);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateInsuranceCo(String InsuranceCo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL6, InsuranceCo);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getSpinnerCount() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT SpinnerCount FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("SpinnerCount"));
        }
        result.close();

        return returnString;
    }

    public boolean addSpinnerCount(String SpinnerCount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL7, SpinnerCount);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateSpinnerCount(String SpinnerCount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL7, SpinnerCount);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getHoursone() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT hoursone FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("hoursone"));
        }
        result.close();

        return returnString;
    }

    public boolean addHoursone(String hoursone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL8, hoursone);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateHoursone(String hoursone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL8, hoursone);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getHourstwo() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT hourstwo FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("hourstwo"));
        }
        result.close();

        return returnString;
    }

    public boolean addHourstwo(String hourstwo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL9, hourstwo);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateHourstwo(String hourstwo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL9, hourstwo);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getHoursthree() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT hoursthree FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("hoursthree"));
        }
        result.close();

        return returnString;
    }

    public boolean addHoursthree(String hoursthree) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL10, hoursthree);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateHoursthree(String hoursthree) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL10, hoursthree);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getHoursfour() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT hoursfour FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("hoursfour"));
        }
        result.close();

        return returnString;
    }

    public boolean addHoursfour(String hoursfour) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL11, hoursfour);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateHoursfour(String hoursfour) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL11, hoursfour);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getHoursfive() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT hoursfive FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("hoursfive"));
        }
        result.close();

        return returnString;
    }

    public boolean addHoursfive(String hoursfive) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL12, hoursfive);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateHoursfive(String hoursfive) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL12, hoursfive);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getHourssix() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT hourssix FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("hourssix"));
        }
        result.close();

        return returnString;
    }

    public boolean addHourssix(String hourssix) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL13, hourssix);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateHourssix(String hourssix) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL14, hourssix);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getHoursseven() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT hoursseven FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("hoursseven"));
        }
        result.close();

        return returnString;
    }

    public boolean addHoursseven(String hoursseven) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL14, hoursseven);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateHoursseven(String hoursseven) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL14, hoursseven);
        db.update(TABLE_NAME, contentValues, null, null);

    }

    public String getHourseight() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT hourseight FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("hourseight"));
        }
        result.close();

        return returnString;
    }

    public boolean addHourseight(String hourseight) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL15, hourseight);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateHourseight(String hourseight) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL15, hourseight);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getHoursnine() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT hoursnine FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("hoursnine"));
        }
        result.close();

        return returnString;
    }

    public boolean addHoursnine(String hoursnine) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL16, hoursnine);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateHoursnine(String hoursnine) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL16, hoursnine);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getGrossone() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT grossone FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("grossone"));
        }
        result.close();

        return returnString;
    }

    public boolean addGrossone(String grossone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL17, grossone);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateGrossone(String grossone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL17, grossone);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getGrosstwo() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT grosstwo FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("grosstwo"));
        }
        result.close();

        return returnString;
    }

    public boolean addGrosstwo(String grosstwo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL17, grosstwo);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateGrosstwo(String body) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, body);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getGrossthree() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT grossthree FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("grossthree"));
        }
        result.close();

        return returnString;
    }

    public boolean addGrossthree(String grossthree) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL19, grossthree);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateGrossthree(String grossthree) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL19, grossthree);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getGrossfour() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT grossfour FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("grossfour"));
        }
        result.close();

        return returnString;
    }

    public boolean addGrossfour(String grossfour) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL20, grossfour);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateGrossfour(String grossfour) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL20, grossfour);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getGrossfive() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT grossfive FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("grossfive"));
        }
        result.close();

        return returnString;
    }

    public boolean addGrossfive(String grossfive) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL21, grossfive);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateGrossfive(String grossfive) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL21, grossfive);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getGrosssix() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT grosssix FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("grosssix"));
        }
        result.close();

        return returnString;
    }

    public boolean addGrosssix(String grosssix) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL22, grosssix);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateGrosssix(String grosssix) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL22, grosssix);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getGrossseven() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT grossseven FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("grossseven"));
        }
        result.close();

        return returnString;
    }

    public boolean addGrossseven(String grossseven) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL23, grossseven);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateGrossseven(String grossseven) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL23, grossseven);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getGrosseight() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT grosseight FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("grosseight"));
        }
        result.close();

        return returnString;
    }

    public boolean addGrosseight(String grosseight) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL24, grosseight);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateGrosseight(String grosseight) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL24, grosseight);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getGrossnine() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT grossnine FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("grossnine"));
        }
        result.close();

        return returnString;
    }

    public boolean addGrossnine(String grossnine) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL25, grossnine);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateGrossnine(String grossnine) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL25, grossnine);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getLaboroneselected() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT laboroneselected FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("laboroneselected"));
        }
        result.close();

        return returnString;
    }

    public boolean addLaboroneselected(String laboroneselected) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL26, laboroneselected);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateLaboroneselected(String laboroneselected) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL26, laboroneselected);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getLabortwoselected() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT labortwoselected FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("labortwoselected"));
        }
        result.close();

        return returnString;
    }

    public boolean addLabortwoselected(String labortwoselected) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL27, labortwoselected);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateLabortwoselected(String labortwoselected) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL27, labortwoselected);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getLaborthreeselected() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT laborthreeselected FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("laborthreeselected"));
        }
        result.close();

        return returnString;
    }

    public boolean addLaborthreeselected(String laborthreeselected) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL28, laborthreeselected);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateLaborthreeselected(String laborthreeselected) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL28, laborthreeselected);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getLaborfourselected() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT laborfourselected FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("laborfourselected"));
        }
        result.close();

        return returnString;
    }

    public boolean addLaborfourselected(String laborfourselected) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL29, laborfourselected);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateLaborfourselected(String laborfourselected) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL29, laborfourselected);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getLaborfiveselected() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT laborfiveselected FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("laborfiveselected"));
        }
        result.close();

        return returnString;
    }

    public boolean addLaborfiveselected(String laborfiveselected) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL30, laborfiveselected);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateLaborfiveselected(String laborfiveselected) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL30, laborfiveselected);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getLaborsixselected() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT laborsixselected FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("laborsixselected"));
        }
        result.close();

        return returnString;
    }

    public boolean addLaborsixselected(String laborsixselected) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL31, laborsixselected);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateLaborsixselected(String laborsixselected) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL31, laborsixselected);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getLaborsevenselected() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT laborsevenselected FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("laborsevenselected"));
        }
        result.close();

        return returnString;
    }

    public boolean addLaborsevenselected(String laborsevenselected) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL32, laborsevenselected);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateLaborsevenselected(String laborsevenselected) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL32, laborsevenselected);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getLaboreightselected() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT laboreightselected FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("laboreightselected"));
        }
        result.close();

        return returnString;
    }

    public boolean addLaboreightselected(String laboreightselected) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL33, laboreightselected);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateLaboreightselected(String laboreightselected) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL33, laboreightselected);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getLabornineselected() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT labornineselected FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("labornineselected"));
        }
        result.close();

        return returnString;
    }

    public boolean addLabornineselected(String labornineselected) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL34, labornineselected);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateLabornineselected(String labornineselected) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL34, labornineselected);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getPayrollmatch() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT payrollmatch FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("payrollmatch"));
        }
        result.close();

        return returnString;
    }

    public boolean addPayrollmatch(String payrollmatch) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL35, payrollmatch);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updatePayrollmatch(String payrollmatch) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL35, payrollmatch);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getTotalgross() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT totalgross FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("totalgross"));
        }
        result.close();

        return returnString;
    }

    public boolean addTotalgross(String totalgross) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL36, totalgross);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateTotalgross(String totalgross) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL36, totalgross);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getMake() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT make FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("make"));
        }
        result.close();

        return returnString;
    }

    public boolean addMake(String make) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL37, make);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateMake(String make) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL37, make);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getModel() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT model FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("model"));
        }
        result.close();

        return returnString;
    }

    public boolean addModel(String model) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL38, model);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateModel(String model) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL38, model);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getYear() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT year FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("year"));
        }
        result.close();

        return returnString;
    }

    public boolean addYear(String year) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL39, year);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateYear(String year) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL39, year);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getMileage() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT mileage FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("mileage"));
        }
        result.close();

        return returnString;
    }

    public boolean addMileage(String mileage) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL40, mileage);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateMileage(String mileage) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL40, mileage);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getVin() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT vin FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("vin"));
        }
        result.close();

        return returnString;
    }

    public boolean addVin(String vin) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL41, vin);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateVin(String vin) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL41, vin);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getColor() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT color FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("color"));
        }
        result.close();

        return returnString;
    }

    public boolean addColor(String color) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL42, color);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateColor(String color) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL42, color);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getLicense() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT license FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("license"));
        }
        result.close();

        return returnString;
    }

    public boolean addLicense(String license) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL43, license);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateLicense(String license) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL43, license);
        db.update(TABLE_NAME, contentValues, null, null);

    }


    public String getTotalHours() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT totalhours FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if (result.moveToFirst()) {
            returnString = result.getString(result.getColumnIndex("totalhours"));
        }
        result.close();

        return returnString;
    }

    public boolean addTotalHours(String totalHours) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL44, totalHours);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateTotalHours(String totalHours) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL44, totalHours);
        db.update(TABLE_NAME, contentValues, null, null);

    }

    public Integer deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, null, new String[]{id});
    }

    public boolean addALL(String RoNumber, String writer, String customer, String date, String insuranceCo, String spinnerCount, String hoursone, String hourstwo, String hoursthree,
                            String hoursfour, String hoursfive, String hourssix, String hoursseven, String hourseight, String hoursnine, String grossone, String grosstwo
            , String grossthree, String grossfour, String grossfive, String grosssix, String grossseven, String grosseight, String grossnine, String laboroneselected,
                            String labortwoselected, String laborthreeselected, String laborfourselected, String laborfiveselected, String laborsixselected, String laborsevenselected, String laboreightselected, String labornineselected,
                            String payrollmatch, String totalgross, String make, String model, String year, String mileage, String vin, String color, String license, String totalHours) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, RoNumber);
        contentValues.put(COL3, writer);
        contentValues.put(COL4, customer);
        contentValues.put(COL5, date);
        contentValues.put(COL6, insuranceCo);
        contentValues.put(COL7, spinnerCount);
        contentValues.put(COL8, hoursone);
        contentValues.put(COL9, hourstwo);
        contentValues.put(COL10, hoursthree);
        contentValues.put(COL11, hoursfour);
        contentValues.put(COL12, hoursfive);
        contentValues.put(COL13, hourssix);
        contentValues.put(COL14, hoursseven);
        contentValues.put(COL15, hourseight);
        contentValues.put(COL16, hoursnine);
        contentValues.put(COL17, grossone);
        contentValues.put(COL18, grosstwo);
        contentValues.put(COL19, grossthree);
        contentValues.put(COL20, grossfour);
        contentValues.put(COL21, grossfive);
        contentValues.put(COL22, grosssix);
        contentValues.put(COL23, grossseven);
        contentValues.put(COL24, grosseight);
        contentValues.put(COL25, grossnine);
        contentValues.put(COL26, laboroneselected);
        contentValues.put(COL27, labortwoselected);
        contentValues.put(COL28, laborthreeselected);
        contentValues.put(COL29, laborfourselected);
        contentValues.put(COL30, laborfiveselected);
        contentValues.put(COL31, laborsixselected);
        contentValues.put(COL32, laborsevenselected);
        contentValues.put(COL33, laboreightselected);
        contentValues.put(COL34, labornineselected);
        contentValues.put(COL35, payrollmatch);
        contentValues.put(COL36, totalgross);
        contentValues.put(COL37, make);
        contentValues.put(COL38, model);
        contentValues.put(COL39, year);
        contentValues.put(COL40, mileage);
        contentValues.put(COL41, vin);
        contentValues.put(COL42, color);
        contentValues.put(COL43, license);
        contentValues.put(COL44, totalHours);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }


    }
}
