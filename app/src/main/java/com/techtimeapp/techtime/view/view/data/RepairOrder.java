package com.techtimeapp.techtime.view.view.data;


import java.util.Date;


public class RepairOrder {

    private int mUid;

    private int mRepairOrderNumber;

    private String mWriter;

    private String mCustomer;

    private Date mDate;

    private LaborRate mLaborRate;

    private String mInsuranceCO;

    private double mHours;

    private double mGross;

    private String mMake;

    private String mModel;

    private String mYear;

    private int mMileage;

    private  String mVIN;

    private String color;

    private String mLicense;

    public RepairOrder(int mUid, int mRepairOrderNumber, String mWriter, String mCustomer, Date mDate, LaborRate mLaborRate, String mInsuranceCO, double mHours, double mGross, String mMake, String mModel, String mYear, int mMileage, String mVIN, String color, String mLicense) {
        this.mUid = mUid;
        this.mRepairOrderNumber = mRepairOrderNumber;
        this.mWriter = mWriter;
        this.mCustomer = mCustomer;
        this.mDate = mDate;
        this.mLaborRate = mLaborRate;
        this.mHours = mHours;
        this.mGross = mGross;
        this.mMake = mMake;
        this.mModel = mModel;
        this.mYear = mYear;
        this.mMileage = mMileage;
        this.mVIN = mVIN;
        this.color = color;
        this.mLicense = mLicense;
    }

    public RepairOrder(int mUid, int mRepairOrderNumber, String mWriter, String mCustomer, Date mDate, LaborRate mLaborRate, String mInsuranceCO, double mHours, double mGross) {
        this.mUid = mUid;
        this.mRepairOrderNumber = mRepairOrderNumber;
        this.mWriter = mWriter;
        this.mCustomer = mCustomer;
        this.mDate = mDate;
        this.mLaborRate = mLaborRate;
        this.mHours = mHours;
        this.mGross = mGross;
    }

    public RepairOrder(int mUid, int mRepairOrderNumber, String mWriter, String mCustomer, Date mDate, LaborRate mLaborRate, String mInsuranceCO, double mHours, double mGross, String mMake, String mModel) {
        this.mUid = mUid;
        this.mRepairOrderNumber = mRepairOrderNumber;
        this.mWriter = mWriter;
        this.mCustomer = mCustomer;
        this.mDate = mDate;
        this.mLaborRate = mLaborRate;
        this.mHours = mHours;
        this.mGross = mGross;
        this.mMake = mMake;
        this.mModel = mModel;
    }

    public RepairOrder(int mUid, int mRepairOrderNumber, String mWriter, String mCustomer, Date mDate, LaborRate mLaborRate, String mInsuranceCO, double mHours, double mGross, String mMake, String mModel, String mYear) {
        this.mUid = mUid;
        this.mRepairOrderNumber = mRepairOrderNumber;
        this.mWriter = mWriter;
        this.mCustomer = mCustomer;
        this.mDate = mDate;
        this.mLaborRate = mLaborRate;
        this.mHours = mHours;
        this.mGross = mGross;
        this.mMake = mMake;
        this.mModel = mModel;
        this.mYear = mYear;
    }

    public RepairOrder(int mUid, int mRepairOrderNumber, String mWriter, String mCustomer, Date mDate, LaborRate mLaborRate, String mInsuranceCO, double mHours, double mGross, String mMake, String mModel, String mYear, int mMileage) {
        this.mUid = mUid;
        this.mRepairOrderNumber = mRepairOrderNumber;
        this.mWriter = mWriter;
        this.mCustomer = mCustomer;
        this.mDate = mDate;
        this.mLaborRate = mLaborRate;
        this.mHours = mHours;
        this.mGross = mGross;
        this.mMake = mMake;
        this.mModel = mModel;
        this.mYear = mYear;
        this.mMileage = mMileage;
    }

    public RepairOrder(int mUid, int mRepairOrderNumber, String mWriter, String mCustomer, Date mDate, LaborRate mLaborRate, String mInsuranceCO, double mHours, double mGross, String mMake, String mModel, String mYear, int mMileage, String mVIN) {
        this.mUid = mUid;
        this.mRepairOrderNumber = mRepairOrderNumber;
        this.mWriter = mWriter;
        this.mCustomer = mCustomer;
        this.mDate = mDate;
        this.mLaborRate = mLaborRate;
        this.mHours = mHours;
        this.mGross = mGross;
        this.mMake = mMake;
        this.mModel = mModel;
        this.mYear = mYear;
        this.mMileage = mMileage;
        this.mVIN = mVIN;
    }

    public RepairOrder(int mUid, int mRepairOrderNumber, String mWriter, String mCustomer, Date mDate, LaborRate mLaborRate, String mInsuranceCO,  double mHours, double mGross, String mMake, String mModel, String mYear, int mMileage, String mVIN, String color) {
        this.mUid = mUid;
        this.mRepairOrderNumber = mRepairOrderNumber;
        this.mWriter = mWriter;
        this.mCustomer = mCustomer;
        this.mDate = mDate;
        this.mLaborRate = mLaborRate;
        this.mHours = mHours;
        this.mGross = mGross;
        this.mMake = mMake;
        this.mModel = mModel;
        this.mYear = mYear;
        this.mMileage = mMileage;
        this.mVIN = mVIN;
        this.color = color;
    }

    public int getmUid() {
        return mUid;
    }

    public void setmUid(int mUid) {
        this.mUid = mUid;
    }

    public String getmInsuranceCO() {
        return mInsuranceCO;
    }

    public void setmInsuranceCO(String mInsuranceCO) {
        this.mInsuranceCO = mInsuranceCO;
    }

    public int getmRepairOrderNumber() {
        return mRepairOrderNumber;
    }

    public void setmRepairOrderNumber(int mRepairOrderNumber) {
        this.mRepairOrderNumber = mRepairOrderNumber;
    }

    public String getmWriter() {
        return mWriter;
    }

    public void setmWriter(String mWriter) {
        this.mWriter = mWriter;
    }

    public String getmCustomer() {
        return mCustomer;
    }

    public void setmCustomer(String mCustomer) {
        this.mCustomer = mCustomer;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public LaborRate getmLaborRate() {
        return mLaborRate;
    }

    public void setmLaborRate(LaborRate mLaborRate) {
        this.mLaborRate = mLaborRate;
    }

    public double getmHours() {
        return mHours;
    }

    public void setmHours(double mHours) {
        this.mHours = mHours;
    }

    public double getmGross() {
        return mGross;
    }

    public void setmGross(double mGross) {
        this.mGross = mGross;
    }

    public String getmMake() {
        return mMake;
    }

    public void setmMake(String mMake) {
        this.mMake = mMake;
    }

    public String getmModel() {
        return mModel;
    }

    public void setmModel(String mModel) {
        this.mModel = mModel;
    }

    public String getmYear() {
        return mYear;
    }

    public void setmYear(String mYear) {
        this.mYear = mYear;
    }

    public int getmMileage() {
        return mMileage;
    }

    public void setmMileage(int mMileage) {
        this.mMileage = mMileage;
    }

    public String getmVIN() {
        return mVIN;
    }

    public void setmVIN(String mVIN) {
        this.mVIN = mVIN;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getmLicense() {
        return mLicense;
    }

    public void setmLicense(String mLicense) {
        this.mLicense = mLicense;
    }
}
