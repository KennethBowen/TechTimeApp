package com.techtimeapp.techtime.view.view.data;

public class LaborRate {
    private double mBody = 0;
    private double mMechanical = 0;
    private double mInternal = 0;
    private double mWarranty = 0;
    private double mRefinish = 0;
    private double mGlass = 0;
    private double mFrame = 0;
    private double mAluminum = 0;
    private double mOther = 0;

    public LaborRate(double body, double mechanical, double internal, double warranty, double refinish, double glass, double frame, double aluminum, double other) {

        mBody = body;
        mMechanical = mechanical;
        mInternal = internal;
        mWarranty = warranty;
        mRefinish = refinish;
        mGlass = glass;
        mFrame = frame;
        mAluminum = aluminum;
        mOther = other;
    }

    public double getBody() {
        return mBody;
    }

    public void setBody(double body) {
        mBody = body;
    }

    public double getMechanical() {
        return mMechanical;
    }

    public void setMechanical(double mechanical) {
        mMechanical = mechanical;
    }

    public double getInternal() {
        return mInternal;
    }

    public void setInternal(double internal) {
        mInternal = internal;
    }

    public double getWarranty() {
        return mWarranty;
    }

    public void setWarranty(double warranty) {
        mWarranty = warranty;
    }

    public double getRefinish() {
        return mRefinish;
    }

    public void setRefinish(double refinish) {
        mRefinish = refinish;
    }

    public double getGlass() {
        return mGlass;
    }

    public void setGlass(double glass) {
        mGlass = glass;
    }

    public double getFrame() {
        return mFrame;
    }

    public void setFrame(double frame) {
        mFrame = frame;
    }

    public double getmAluminum(){
        return mAluminum;
    }

    public void setmAluminum(double aluminum){
        mAluminum = aluminum;
    }

    public double getOther() {
        return mOther;
    }

    public void setOther(double other) {
        mOther = other;
    }
}
