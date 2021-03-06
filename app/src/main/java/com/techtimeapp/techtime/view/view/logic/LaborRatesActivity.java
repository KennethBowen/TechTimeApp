package com.techtimeapp.techtime.view.view.logic;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.techtimeapp.techtime.R;
import com.techtimeapp.techtime.view.view.data.LaborRate;
import com.techtimeapp.techtime.view.view.data.LaborRateHelper;
import com.techtimeapp.techtime.view.view.view.MainActivity;

import java.text.DecimalFormat;


public class LaborRatesActivity extends AppCompatActivity {

    //LaborRate object
    private LaborRate laborRates;

    LaborRateHelper laborRateHelper;

    //list of labor types found by id
    private EditText body ;
    private EditText mechanical ;
    private EditText internal ;
    private EditText warranty ;
    private EditText refinish ;
    private EditText glass ;
    private EditText frame ;
    private EditText aluminum ;
    private EditText other ;

    //this list holds double value for labor rate
    public double bodyRate ;
    public double mechanicalRate ;
    public double internalRate ;
    public double warrantyRate ;
    public double refinishRate ;
    public double glassRate ;
    public double frameRate ;
    public double aluminumRate ;
    public double otherRate ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labor_rates);
        //allows the activity to remain in portrait only
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setFromData();

        //LaborRate
        laborRates = new LaborRate(bodyRate, mechanicalRate, internalRate, warrantyRate, refinishRate, glassRate, frameRate, aluminumRate, otherRate);

        //calls stored laborRates values to display
        displayLaborRates();

    }


    public void setFromData(){

        laborRateHelper = new LaborRateHelper(this);

        String bodyString = laborRateHelper.getBodyData();
        if (bodyString.isEmpty()){
            bodyRate = Double.valueOf("0.0");

            //add body to data base
            String body = String.valueOf(bodyRate);
            laborRateHelper.addBodyData(body);

        }else {
            bodyRate = Double.valueOf(bodyString);
        }


        String mechanicalString = laborRateHelper.getMechanicalData();
        if (mechanicalString == null){
            mechanicalRate = Double.valueOf("0.0");

            //add mechanical to data base
            String mechanical = String.valueOf(mechanicalRate);
            laborRateHelper.addMechanicalData(mechanical);

        }else {
            mechanicalRate = Double.valueOf(mechanicalString);
        }


        String internalString = laborRateHelper.getInternalData();
        if (internalString == null){
            internalRate = Double.valueOf("0.0");

            //add internal to data base
            String internal = String.valueOf(internalRate);
            laborRateHelper.addInternalData(internal);

        }else {
            internalRate = Double.valueOf(internalString);
        }


        String warrantyString = laborRateHelper.getWarrantyData();
        if (warrantyString == null){
            warrantyRate = Double.valueOf("0.0");

            //add warranty to data base
            String warranty = String.valueOf(warrantyRate);
            laborRateHelper.addWarrantyData(warranty);

        }else {
            warrantyRate = Double.valueOf(warrantyString);
        }


        String refinishString = laborRateHelper.getRefinishData();
        if (refinishString == null){
            refinishRate = Double.valueOf("0.0");

            //add refinish to data base
            String refinish = String.valueOf(refinishRate);
            laborRateHelper.addRefinishData(refinish);

        }else {
            refinishRate = Double.valueOf(refinishString);
        }

        String glassString = laborRateHelper.getGlassData();
        if (glassString == null){
            glassRate = Double.valueOf("0.0");

            //add glass to data base
            String glass = String.valueOf(glassRate);
            laborRateHelper.addGlassData(glass);

        }else {
            glassRate = Double.valueOf(glassString);
        }


        String frameString = laborRateHelper.getFrameData();
        if (frameString == null){
            frameRate = Double.valueOf("0.0");

            //add frame to data base
            String frame = String.valueOf(frameRate);
            laborRateHelper.addFrameData(frame);

        }else {
            frameRate = Double.valueOf(frameString);
        }


        String aluminumString = laborRateHelper.getAluminumData();
        if (aluminumString == null){
            aluminumRate = Double.valueOf("0.0");

            //add aluminum to data base
            String aluminum = String.valueOf(aluminumRate);
            laborRateHelper.addAluminumData(aluminum);

        }else {
            aluminumRate = Double.valueOf(aluminumString);
        }


        String otherString = laborRateHelper.getOtherData();
        if (otherString == null){
            otherRate = Double.valueOf("0.0");

            //add other to data base
            String other = String.valueOf(otherRate);
            laborRateHelper.addOtherData(other);

        }else {
            otherRate = Double.valueOf(otherString);
        }


    }



    //places labor rate values for display
    public void displayLaborRates(){

        //needed to format the labor rate values for display
        DecimalFormat precision = new DecimalFormat("0.00");

        //list of labor types found by id
        body = findViewById(R.id.editBodyRate);
        mechanical = findViewById(R.id.editMechanicalRate);
        internal = findViewById(R.id.editInternalRate);
        warranty = findViewById(R.id.editWarrantyRate);
        refinish = findViewById(R.id.editRefinishRate);
        glass = findViewById(R.id.editGlassRate);
        frame = findViewById(R.id.editFrameRate);
        aluminum = findViewById(R.id.editAluminumRate);
        other = findViewById(R.id.editOtherRate);

        //color for textView "rates" and bold font resources
        int rateBlue = getResources().getColor(R.color.colorAccent);
        Typeface boldTypeface = Typeface.defaultFromStyle(Typeface.BOLD);

        //this list holds resource IDs for all the "rate" textViews to later change its color and font
        TextView rateTextViewBody = findViewById(R.id.rateBody);
        TextView rateTextViewMechanical = findViewById(R.id.rateMechanical);
        TextView rateTextViewInternal = findViewById(R.id.rateInternal);
        TextView rateTextViewWarranty = findViewById(R.id.rateWarranty);
        TextView rateTextViewRefinish = findViewById(R.id.rateRefinish);
        TextView rateTextViewGlass = findViewById(R.id.rateGlass);
        TextView rateTextViewFrame = findViewById(R.id.rateFrame);
        TextView rateTextViewAluminum = findViewById(R.id.rateAluminum);
        TextView rateTextViewOther = findViewById(R.id.rateOther);


        //if body has a stored value it will display
        if(laborRates.getBody() != 0) {
            double bodyRateDisplay = laborRates.getBody();
            body.setText(String.valueOf(precision.format(bodyRateDisplay)));

            //set the Rate for body blue and bolds the text
            rateTextViewBody.setTextColor(rateBlue);
            rateTextViewBody.setTypeface(boldTypeface);
        }

        //if mechanical has a stored value it will display
        if(laborRates.getMechanical() != 0) {
            double mechanicalRateDisplay = laborRates.getMechanical();
            mechanical.setText(String.valueOf(precision.format(mechanicalRateDisplay)));

            //set the Rate for mechanical blue and bolds the text
            rateTextViewMechanical.setTextColor(rateBlue);
            rateTextViewMechanical.setTypeface(boldTypeface);
        }

        //if internal has a stored value it will display
        if(laborRates.getInternal() != 0) {
            double internalRateDisplay = laborRates.getInternal();
            internal.setText(String.valueOf(precision.format(internalRateDisplay)));

            //set the Rate for internal blue and bolds the text
            rateTextViewInternal.setTextColor(rateBlue);
            rateTextViewInternal.setTypeface(boldTypeface);
        }

        //if warranty has a stored value it will display
        if(laborRates.getWarranty() != 0) {
            double warrantyRateDisplay = laborRates.getWarranty();
            warranty.setText(String.valueOf(precision.format(warrantyRateDisplay)));

            //set the Rate for warranty blue and bolds the text
            rateTextViewWarranty.setTextColor(rateBlue);
            rateTextViewWarranty.setTypeface(boldTypeface);
        }

        //if refinish has a stored value it will display
        if(laborRates.getRefinish() != 0) {
            double refinishRateDisplay = laborRates.getRefinish();
            refinish.setText(String.valueOf(precision.format(refinishRateDisplay)));

            //set the Rate for refinish blue and bolds the text
            rateTextViewRefinish.setTextColor(rateBlue);
            rateTextViewRefinish.setTypeface(boldTypeface);
        }

        //if glass has a stored value it will display
        if(laborRates.getGlass() != 0) {
            double glassRateDisplay = laborRates.getGlass();
            glass.setText(String.valueOf(precision.format(glassRateDisplay)));

            //set the Rate for glass blue and bolds the text
            rateTextViewGlass.setTextColor(rateBlue);
            rateTextViewGlass.setTypeface(boldTypeface);
        }

        //if frame has a stored value it will display
        if(laborRates.getFrame() != 0) {
            double frameRateDisplay = laborRates.getFrame();
            frame.setText(String.valueOf(precision.format(frameRateDisplay)));

            //set the Rate for frame blue and bolds the text
            rateTextViewFrame.setTextColor(rateBlue);
            rateTextViewFrame.setTypeface(boldTypeface);
        }

        //if aluminum has a stored value it will display
        if(laborRates.getAluminum() != 0) {
            double aluminumRateDisplay = laborRates.getAluminum();
            aluminum.setText(String.valueOf(precision.format(aluminumRateDisplay)));

            //set the Rate for aluminum blue and bolds the text
            rateTextViewAluminum.setTextColor(rateBlue);
            rateTextViewAluminum.setTypeface(boldTypeface);
        }

        //if other has a stored value it will display
        if(laborRates.getOther() != 0) {
            double otherRateDisplay = laborRates.getOther();
            other.setText(String.valueOf(precision.format(otherRateDisplay)));

            //set the Rate for other blue and bolds the text
            rateTextViewOther.setTextColor(rateBlue);
            rateTextViewOther.setTypeface(boldTypeface);
        }

    }



    //this method is called when the check mark is clicked
    //  sets the given values to laborRates object
    public void saveLaborRates() {

        //this list holds the String value from the user input to then be parsed to double
        String bodyInput = body.getText().toString().trim();
        String mechanicalInput = mechanical.getText().toString().trim();
        String internalInput = internal.getText().toString().trim();
        String warrantyInput = warranty.getText().toString().trim();
        String refinishInput = refinish.getText().toString().trim();
        String glassInput = glass.getText().toString().trim();
        String frameInput = frame.getText().toString().trim();
        String aluminumInput = aluminum.getText().toString().trim();
        String otherInput = other.getText().toString().trim();

        //colors block to gather the colors need for rates
        int rateBlue = getResources().getColor(R.color.colorAccent);
        int rateGray = getResources().getColor(R.color.greyRates);

        //text style for rates based on if it contains a value
        Typeface boldTypeface = Typeface.defaultFromStyle(Typeface.BOLD);
        Typeface normalTypeface = Typeface.defaultFromStyle(Typeface.NORMAL);

        //this list holds resource IDs for all the "rate" textViews to later change its color and font
        TextView rateTextViewBody = findViewById(R.id.rateBody);
        TextView rateTextViewMechanical = findViewById(R.id.rateMechanical);
        TextView rateTextViewInternal = findViewById(R.id.rateInternal);
        TextView rateTextViewWarranty = findViewById(R.id.rateWarranty);
        TextView rateTextViewRefinish = findViewById(R.id.rateRefinish);
        TextView rateTextViewGlass = findViewById(R.id.rateGlass);
        TextView rateTextViewFrame = findViewById(R.id.rateFrame);
        TextView rateTextViewAluminum = findViewById(R.id.rateAluminum);
        TextView rateTextViewOther = findViewById(R.id.rateOther);


        //if block for body labor rate
        if (bodyInput.isEmpty()){
            bodyRate = 0.0;
            laborRates.setBody(bodyRate);

            //update body to data base
            String bodyString = String.valueOf(bodyRate);
            laborRateHelper.updateBodyData(bodyString);

            //set the Rate for body grey
            rateTextViewBody.setTextColor(rateGray);
            rateTextViewBody.setTypeface(normalTypeface);

        } else {
            bodyRate = Double.parseDouble(bodyInput);
            laborRates.setBody(bodyRate);

            //update body to data base
            String bodyString = String.valueOf(bodyRate);
            laborRateHelper.updateBodyData(bodyString);

            //set the Rate for body blue
            rateTextViewBody.setTextColor(rateBlue);
            rateTextViewBody.setTypeface(boldTypeface);
        }

        //if block for mechanical labor rate
        if (mechanicalInput.isEmpty()){
            mechanicalRate = 0.0;
            laborRates.setMechanical(mechanicalRate);

            //update mechanical to data base
            String mechanicalString = String.valueOf(mechanicalRate);
            laborRateHelper.updateMechanicalData(mechanicalString);

            //set the Rate for Mechanical grey
            rateTextViewMechanical.setTextColor(rateGray);
            rateTextViewMechanical.setTypeface(normalTypeface);
        } else {
            mechanicalRate = Double.parseDouble(mechanicalInput);
            laborRates.setMechanical(mechanicalRate);

            //update mechanical to data base
            String mechanicalString = String.valueOf(mechanicalRate);
            laborRateHelper.updateMechanicalData(mechanicalString);

            //set the Rate for Mechanical blue
            rateTextViewMechanical.setTextColor(rateBlue);
            rateTextViewMechanical.setTypeface(boldTypeface);
        }

        //if block for internal labor rate
        if (internalInput.isEmpty()){
            internalRate = 0.0;
            laborRates.setInternal(internalRate);

            //update internal to data base
            String internalString = String.valueOf(internalRate);
            laborRateHelper.updateInternalData(internalString);

            //set the Rate for Internal grey
            rateTextViewInternal.setTextColor(rateGray);
            rateTextViewInternal.setTypeface(normalTypeface);
        } else {
            internalRate = Double.parseDouble(internalInput);
            laborRates.setInternal(internalRate);

            //update internal to data base
            String internalString = String.valueOf(internalRate);
            laborRateHelper.updateInternalData(internalString);

            //set the Rate for Internal blue
            rateTextViewInternal.setTextColor(rateBlue);
            rateTextViewInternal.setTypeface(boldTypeface);
        }

        //if block for warranty labor rate
        if (warrantyInput.isEmpty()){
            warrantyRate = 0.0;
            laborRates.setWarranty(warrantyRate);

            //update warranty to data base
            String warrantyString = String.valueOf(warrantyRate);
            laborRateHelper.updateWarrantyData(warrantyString);

            //set the Rate for Warranty grey
            rateTextViewWarranty.setTextColor(rateGray);
            rateTextViewWarranty.setTypeface(normalTypeface);
        } else {
            warrantyRate = Double.parseDouble(warrantyInput);
            laborRates.setWarranty(warrantyRate);

            //update warranty to data base
            String warrantyString = String.valueOf(warrantyRate);
            laborRateHelper.updateWarrantyData(warrantyString);

            //set the Rate for Warranty blue
            rateTextViewWarranty.setTextColor(rateBlue);
            rateTextViewWarranty.setTypeface(boldTypeface);
        }

        //if block for refinish labor rate
        if (refinishInput.isEmpty()){
            refinishRate = 0.0;
            laborRates.setRefinish(refinishRate);

            //update refinish to data base
            String refinishString = String.valueOf(refinishRate);
            laborRateHelper.updateRefinishData(refinishString);

            //set the Rate for Refinish grey
            rateTextViewRefinish.setTextColor(rateGray);
            rateTextViewRefinish.setTypeface(normalTypeface);
        } else {
            refinishRate = Double.parseDouble(refinishInput);
            laborRates.setRefinish(refinishRate);

            //update refinish to data base
            String refinishString = String.valueOf(refinishRate);
            laborRateHelper.updateRefinishData(refinishString);

            //set the Rate for Refinish blue
            rateTextViewRefinish.setTextColor(rateBlue);
            rateTextViewRefinish.setTypeface(boldTypeface);
        }

        //if block for glass labor rate
        if (glassInput.isEmpty()){
            glassRate = 0.0;
            laborRates.setGlass(glassRate);

            //update glass to data base
            String glassString = String.valueOf(glassRate);
            laborRateHelper.updateGlassData(glassString);

            //set the Rate for Glass grey
            rateTextViewGlass.setTextColor(rateGray);
            rateTextViewGlass.setTypeface(normalTypeface);
        } else {
            glassRate = Double.parseDouble(glassInput);
            laborRates.setGlass(glassRate);

            //update glass to data base
            String glassString = String.valueOf(glassRate);
            laborRateHelper.updateGlassData(glassString);

            //set the Rate for Glass blue
            rateTextViewGlass.setTextColor(rateBlue);
            rateTextViewGlass.setTypeface(boldTypeface);
        }

        //if block for frame labor rate
        if (frameInput.isEmpty()){
            frameRate = 0.0;
            laborRates.setFrame(frameRate);

            //update frame to data base
            String frameString = String.valueOf(frameRate);
            laborRateHelper.updateFrameData(frameString);

            //set the Rate for Frame grey
            rateTextViewFrame.setTextColor(rateGray);
            rateTextViewFrame.setTypeface(normalTypeface);
        } else {
            frameRate = Double.parseDouble(frameInput);
            laborRates.setFrame(frameRate);

            //update frame to data base
            String frameString = String.valueOf(frameRate);
            laborRateHelper.updateFrameData(frameString);

            //set the Rate for Frame blue
            rateTextViewFrame.setTextColor(rateBlue);
            rateTextViewFrame.setTypeface(boldTypeface);
        }

        //if block for aluminum labor rate
        if (aluminumInput.isEmpty()){
            aluminumRate = 0.0;
            laborRates.setAluminum(aluminumRate);

            //update aluminum to data base
            String aluminumString = String.valueOf(aluminumRate);
            laborRateHelper.updateAluminumData(aluminumString);

            //set the Rate for Aluminum grey
            rateTextViewAluminum.setTextColor(rateGray);
            rateTextViewAluminum.setTypeface(normalTypeface);
        } else {
            aluminumRate = Double.parseDouble(aluminumInput);
            laborRates.setAluminum(aluminumRate);

            //update aluminum to data base
            String aluminumString = String.valueOf(aluminumRate);
            laborRateHelper.updateAluminumData(aluminumString);

            //set the Rate for Aluminum blue
            rateTextViewAluminum.setTextColor(rateBlue);
            rateTextViewAluminum.setTypeface(boldTypeface);
        }

        //if block for other labor rate
        if (otherInput.isEmpty()){
            otherRate = 0.0;
            laborRates.setOther(otherRate);

            //update other to data base
            String otherString = String.valueOf(otherRate);
            laborRateHelper.updateOtherData(otherString);

            //set the Rate for Other grey
            rateTextViewOther.setTextColor(rateGray);
            rateTextViewOther.setTypeface(normalTypeface);
        } else {
            otherRate = Double.parseDouble(otherInput);
            laborRates.setOther(otherRate);

            //update other to data base
            String otherString = String.valueOf(otherRate);
            laborRateHelper.updateOtherData(otherString);

            //set the Rate for Other blue
            rateTextViewOther.setTextColor(rateBlue);
            rateTextViewOther.setTypeface(boldTypeface);
        }


    }


    //if none of the labor rate contain a value
    public void checkVacancy(String from){

        if(0 == bodyRate + mechanicalRate + internalRate + warrantyRate + refinishRate + glassRate + frameRate + aluminumRate + otherRate){

            Toast setLaborToast = Toast.makeText(this, "Please set your labor rates", Toast.LENGTH_LONG);
            setLaborToast.setGravity(Gravity.BOTTOM, 0,400);
            setLaborToast.show();

        } else if (from.contains("save")) {

            // Exit activity
            finish();

            Toast savedToast = Toast.makeText(this, "Saved", Toast.LENGTH_LONG);
            savedToast.setGravity(Gravity.BOTTOM, 0,400);
            savedToast.show();
        }
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();

        //checks to make sure at lease one of the labor rates has a value
         checkVacancy("onBackPressed");
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_main.xml file.
        // This adds menu items to the app bar.

        getMenuInflater().inflate(R.menu.menu_labor_rates, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu

        switch (item.getItemId()) {
            // Respond to a click on the check mark option
            case R.id.action_save:

                //calls method that will insert given user inputs and values to the laborRates object
                saveLaborRates();

                //checks to make sure at lease one of the labor rates has a value
                checkVacancy("save");

                return true;

            //Respond to home button
            case android.R.id.home :

                //checks to make sure at lease one of the labor rates has a value
                checkVacancy("homeButton");

                //home button intent back to MainActivity and then clears top so the back button
                // will not intent back to LaborRatesActivity
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
