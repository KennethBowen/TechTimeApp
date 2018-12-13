package com.techtimeapp.techtime.view.view.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LaborRateHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "LaborRate.db";
    private static final String TABLE_NAME = "LABOR_RATE_TABLE ";
    private static final String COL1 = "ID";
    private static final String COL2 ="body";
    private static final String COL3 = "mechanical";
    private static final String COL4 = "internal";
    private static final String COL5 = "warranty";
    private static final String COL6 = "refinish";
    private static final String COL7 = "glass";
    private static final String COL8 = "frame";
    private static final String COL9 = "aluminum";
    private static final String COL10 = "other" ;

    public LaborRateHelper(Context context) {
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
               COL10 + " TEXT )");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
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

    public String getBodyData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT body FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if(result.moveToFirst()){
            returnString = result.getString(result.getColumnIndex("body"));
        }
        result.close();

        return returnString;
    }

    public boolean addBodyData(String body){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, body);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1 ){
            return false;
        } else {
            return true;
        }
    }

    public void updateBodyData(String body){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, body);
        db.update(TABLE_NAME, contentValues,null,  null);

    }


    public String getMechanicalData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT mechanical FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if(result.moveToFirst()){
            returnString = result.getString(result.getColumnIndex("mechanical"));
        }
        result.close();

        return returnString;
    }


    public boolean addMechanicalData(String mechanical){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL3, mechanical);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1 ){
            return false;
        } else {
            return true;
        }
    }

    public void updateMechanicalData(String mechanical){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL3, mechanical);
        db.update(TABLE_NAME, contentValues,null,  null);

    }

    public String getInternalData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT internal FROM " + TABLE_NAME ;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if(result.moveToFirst()){
            returnString = result.getString(result.getColumnIndex("internal"));
        }
        result.close();

        return returnString;
    }

    public boolean addInternalData(String internal){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL4, internal);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1 ){
            return false;
        } else {
            return true;
        }
    }

    public void updateInternalData(String internal){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL4, internal);
        db.update(TABLE_NAME, contentValues,null,  null);

    }

    public String getWarrantyData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT warranty FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if(result.moveToFirst()){
            returnString = result.getString(result.getColumnIndex("warranty"));
        }
        result.close();

        return returnString;
    }

    public boolean addWarrantyData(String warranty){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL5, warranty);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1 ){
            return false;
        } else {
            return true;
        }
    }


    public void updateWarrantyData(String warranty){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL5, warranty);
        db.update(TABLE_NAME, contentValues,null,  null);

    }


    public String getRefinishData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT refinish FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if(result.moveToFirst()){
            returnString = result.getString(result.getColumnIndex("refinish"));
        }
        result.close();

        return returnString;
    }


    public boolean addRefinishData(String refinish){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL6, refinish);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1 ){
            return false;
        } else {
            return true;
        }
    }


    public void updateRefinishData(String refinish){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL6, refinish);
        db.update(TABLE_NAME, contentValues,null,  null);

    }


    public String getGlassData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT glass FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if(result.moveToFirst()){
            returnString = result.getString(result.getColumnIndex("glass"));
        }
        result.close();

        return returnString;
    }


    public boolean addGlassData(String glass){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL7, glass);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1 ){
            return false;
        } else {
            return true;
        }
    }


    public void updateGlassData(String glass){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL7, glass);
        db.update(TABLE_NAME, contentValues,null,  null);

    }


    public String getFrameData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT frame FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if(result.moveToFirst()){
            returnString = result.getString(result.getColumnIndex("frame"));
        }
        result.close();

        return returnString;
    }


    public boolean addFrameData(String frame){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL8, frame);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1 ){
            return false;
        } else {
            return true;
        }
    }


    public void updateFrameData(String frame){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL8, frame);
        db.update(TABLE_NAME, contentValues,null,  null);

    }


    public String getAluminumData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT aluminum FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if(result.moveToFirst()){
            returnString = result.getString(result.getColumnIndex("aluminum"));
        }
        result.close();

        return returnString;
    }




    public boolean addAluminumData(String aluminium){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL9, aluminium);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1 ){
            return false;
        } else {
            return true;
        }
    }


    public void updateAluminumData(String aluminum){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL9, aluminum);
        db.update(TABLE_NAME, contentValues,null,  null);

    }


    public String getOtherData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT other FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);

        String returnString = "";

        if(result.moveToFirst()){
            returnString = result.getString(result.getColumnIndex("other"));
        }
        result.close();

        return returnString;
    }


    public boolean addOtherData(String other){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL10, other);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1 ){
            return false;
        } else {
            return true;
        }
    }


    public void updateOtherData(String other){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL10, other);
        db.update(TABLE_NAME, contentValues,null,  null);

    }




    public Cursor getLaborRateData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        return db.rawQuery(query, null);
    }




}
