package com.techtimeapp.techtime.view.view.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LaborRateHelper extends SQLiteOpenHelper {
    private static final String TAG = "LaborRateHelper";
    private SQLiteDatabase db;
    private static final String TABLE_NAME = "LABOR_RATE_TABLE";
    private static final String COL1 = "ID";
    private static final String COL2 ="body";
    private static final String COL3 = "mechanical";
    private static final String COL4 = "internal";
    private static final String COL5 = "warranty";
    private static final String COL6 =  "refinish";
    private static final String COL7 = "glass";
    private static final String COL8 = "frame";
    private static final String COL9 = "aluminum";
    private static final String COL10 = "other" ;

    public LaborRateHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE " + TABLE_NAME + COL1 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                COL2 + "REAL, " +
                COL3 + "REAL, " +
                COL4 + "REAL, " +
                COL5 + "REAL, " +
                COL6 + "REAL, " +
                COL7 + "REAL, " +
                COL8 + "REAL, " +
                COL9 + "REAL, " +
                COL10 + "REAL " + ")";

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addLaborRateData(String body, String mechanical, String internal, String warranty, String refinish,
                           String glass, String frame, String aluminum, String other){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, body);
        contentValues.put(COL3, mechanical);
        contentValues.put(COL4, internal);
        contentValues.put(COL5, warranty);
        contentValues.put(COL6, refinish);
        contentValues.put(COL7, glass);
        contentValues.put(COL8, frame);
        contentValues.put(COL9, aluminum);
        contentValues.put(COL10, other);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1 ){
            return false;
        } else {
            return true;
        }
    }

    public Cursor getLaborRateData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }
}
