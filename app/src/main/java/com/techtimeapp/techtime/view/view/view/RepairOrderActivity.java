package com.techtimeapp.techtime.view.view.view;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.techtimeapp.techtime.R;
import com.techtimeapp.techtime.view.view.data.RepairOrderHelper;
import com.techtimeapp.techtime.view.view.logic.AddEditRepairOrderActivity;

import java.text.DecimalFormat;
import java.text.NumberFormat;


public class RepairOrderActivity extends AppCompatActivity {

    public RepairOrderHelper repairOrderHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repair_order);
        //allows the activity to remain in portrait only
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        repairOrderHelper = new RepairOrderHelper(this);

        //this method will set labor type, hours, and gross from GONE to VISIBLE based on spin count
        enableVisibility();

        setRepairOrderContent();

    }


    //this method will set labor type, hours, and gross from GONE to VISIBLE based on spin count
    public void enableVisibility(){

        //this variable hold the spinner count from the database
        int spinCount = Integer.parseInt(repairOrderHelper.getSpinnerCount());

        if(spinCount == 1){

            TextView laborTypeOne = findViewById(R.id.laborTypeOne);
            TextView laborHoursOne = findViewById(R.id.laborHoursOne);
            TextView laborGrossOne = findViewById(R.id.laborGrossOne);

            laborTypeOne.setVisibility(View.VISIBLE);
            laborHoursOne.setVisibility(View.VISIBLE);
            laborGrossOne.setVisibility(View.VISIBLE);

        }else if (spinCount == 2){

            TextView laborTypeOne = findViewById(R.id.laborTypeOne);
            TextView laborHoursOne = findViewById(R.id.laborHoursOne);
            TextView laborGrossOne = findViewById(R.id.laborGrossOne);

            laborTypeOne.setVisibility(View.VISIBLE);
            laborHoursOne.setVisibility(View.VISIBLE);
            laborGrossOne.setVisibility(View.VISIBLE);


            TextView laborTypeTwo = findViewById(R.id.laborTypeTwo);
            TextView laborHoursTwo = findViewById(R.id.laborHoursTwo);
            TextView laborGrossTwo = findViewById(R.id.laborGrossTwo);

            laborTypeTwo.setVisibility(View.VISIBLE);
            laborHoursTwo.setVisibility(View.VISIBLE);
            laborGrossTwo.setVisibility(View.VISIBLE);

        }else if (spinCount == 3) {

            TextView laborTypeOne = findViewById(R.id.laborTypeOne);
            TextView laborHoursOne = findViewById(R.id.laborHoursOne);
            TextView laborGrossOne = findViewById(R.id.laborGrossOne);

            laborTypeOne.setVisibility(View.VISIBLE);
            laborHoursOne.setVisibility(View.VISIBLE);
            laborGrossOne.setVisibility(View.VISIBLE);


            TextView laborTypeTwo = findViewById(R.id.laborTypeTwo);
            TextView laborHoursTwo = findViewById(R.id.laborHoursTwo);
            TextView laborGrossTwo = findViewById(R.id.laborGrossTwo);

            laborTypeTwo.setVisibility(View.VISIBLE);
            laborHoursTwo.setVisibility(View.VISIBLE);
            laborGrossTwo.setVisibility(View.VISIBLE);


            TextView laborTypeThree = findViewById(R.id.laborTypeThree);
            TextView laborHoursThree = findViewById(R.id.laborHoursThree);
            TextView laborGrossThree = findViewById(R.id.laborGrossThree);

            laborTypeThree.setVisibility(View.VISIBLE);
            laborHoursThree.setVisibility(View.VISIBLE);
            laborGrossThree.setVisibility(View.VISIBLE);

        }else if (spinCount == 4) {

            TextView laborTypeOne = findViewById(R.id.laborTypeOne);
            TextView laborHoursOne = findViewById(R.id.laborHoursOne);
            TextView laborGrossOne = findViewById(R.id.laborGrossOne);

            laborTypeOne.setVisibility(View.VISIBLE);
            laborHoursOne.setVisibility(View.VISIBLE);
            laborGrossOne.setVisibility(View.VISIBLE);


            TextView laborTypeTwo = findViewById(R.id.laborTypeTwo);
            TextView laborHoursTwo = findViewById(R.id.laborHoursTwo);
            TextView laborGrossTwo = findViewById(R.id.laborGrossTwo);

            laborTypeTwo.setVisibility(View.VISIBLE);
            laborHoursTwo.setVisibility(View.VISIBLE);
            laborGrossTwo.setVisibility(View.VISIBLE);


            TextView laborTypeThree = findViewById(R.id.laborTypeThree);
            TextView laborHoursThree = findViewById(R.id.laborHoursThree);
            TextView laborGrossThree = findViewById(R.id.laborGrossThree);

            laborTypeThree.setVisibility(View.VISIBLE);
            laborHoursThree.setVisibility(View.VISIBLE);
            laborGrossThree.setVisibility(View.VISIBLE);


            TextView laborTypeFour = findViewById(R.id.laborTypeFour);
            TextView laborHoursFour = findViewById(R.id.laborHoursFour);
            TextView laborGrossFour = findViewById(R.id.laborGrossFour);

            laborTypeFour.setVisibility(View.VISIBLE);
            laborHoursFour.setVisibility(View.VISIBLE);
            laborGrossFour.setVisibility(View.VISIBLE);

        }else if (spinCount == 5) {

            TextView laborTypeOne = findViewById(R.id.laborTypeOne);
            TextView laborHoursOne = findViewById(R.id.laborHoursOne);
            TextView laborGrossOne = findViewById(R.id.laborGrossOne);

            laborTypeOne.setVisibility(View.VISIBLE);
            laborHoursOne.setVisibility(View.VISIBLE);
            laborGrossOne.setVisibility(View.VISIBLE);


            TextView laborTypeTwo = findViewById(R.id.laborTypeTwo);
            TextView laborHoursTwo = findViewById(R.id.laborHoursTwo);
            TextView laborGrossTwo = findViewById(R.id.laborGrossTwo);

            laborTypeTwo.setVisibility(View.VISIBLE);
            laborHoursTwo.setVisibility(View.VISIBLE);
            laborGrossTwo.setVisibility(View.VISIBLE);


            TextView laborTypeThree = findViewById(R.id.laborTypeThree);
            TextView laborHoursThree = findViewById(R.id.laborHoursThree);
            TextView laborGrossThree = findViewById(R.id.laborGrossThree);

            laborTypeThree.setVisibility(View.VISIBLE);
            laborHoursThree.setVisibility(View.VISIBLE);
            laborGrossThree.setVisibility(View.VISIBLE);


            TextView laborTypeFour = findViewById(R.id.laborTypeFour);
            TextView laborHoursFour = findViewById(R.id.laborHoursFour);
            TextView laborGrossFour = findViewById(R.id.laborGrossFour);

            laborTypeFour.setVisibility(View.VISIBLE);
            laborHoursFour.setVisibility(View.VISIBLE);
            laborGrossFour.setVisibility(View.VISIBLE);


            TextView laborTypeFive = findViewById(R.id.laborTypeFive);
            TextView laborHoursFive = findViewById(R.id.laborHoursFive);
            TextView laborGrossFive = findViewById(R.id.laborGrossFive);

            laborTypeFive.setVisibility(View.VISIBLE);
            laborHoursFive.setVisibility(View.VISIBLE);
            laborGrossFive.setVisibility(View.VISIBLE);

        }else if (spinCount == 6) {

            TextView laborTypeOne = findViewById(R.id.laborTypeOne);
            TextView laborHoursOne = findViewById(R.id.laborHoursOne);
            TextView laborGrossOne = findViewById(R.id.laborGrossOne);

            laborTypeOne.setVisibility(View.VISIBLE);
            laborHoursOne.setVisibility(View.VISIBLE);
            laborGrossOne.setVisibility(View.VISIBLE);


            TextView laborTypeTwo = findViewById(R.id.laborTypeTwo);
            TextView laborHoursTwo = findViewById(R.id.laborHoursTwo);
            TextView laborGrossTwo = findViewById(R.id.laborGrossTwo);

            laborTypeTwo.setVisibility(View.VISIBLE);
            laborHoursTwo.setVisibility(View.VISIBLE);
            laborGrossTwo.setVisibility(View.VISIBLE);


            TextView laborTypeThree = findViewById(R.id.laborTypeThree);
            TextView laborHoursThree = findViewById(R.id.laborHoursThree);
            TextView laborGrossThree = findViewById(R.id.laborGrossThree);

            laborTypeThree.setVisibility(View.VISIBLE);
            laborHoursThree.setVisibility(View.VISIBLE);
            laborGrossThree.setVisibility(View.VISIBLE);


            TextView laborTypeFour = findViewById(R.id.laborTypeFour);
            TextView laborHoursFour = findViewById(R.id.laborHoursFour);
            TextView laborGrossFour = findViewById(R.id.laborGrossFour);

            laborTypeFour.setVisibility(View.VISIBLE);
            laborHoursFour.setVisibility(View.VISIBLE);
            laborGrossFour.setVisibility(View.VISIBLE);


            TextView laborTypeFive = findViewById(R.id.laborTypeFive);
            TextView laborHoursFive = findViewById(R.id.laborHoursFive);
            TextView laborGrossFive = findViewById(R.id.laborGrossFive);

            laborTypeFive.setVisibility(View.VISIBLE);
            laborHoursFive.setVisibility(View.VISIBLE);
            laborGrossFive.setVisibility(View.VISIBLE);


            TextView laborTypeSix = findViewById(R.id.laborTypeSix);
            TextView laborHoursSix = findViewById(R.id.laborHoursSix);
            TextView laborGrossSix = findViewById(R.id.laborGrossSix);

            laborTypeSix.setVisibility(View.VISIBLE);
            laborHoursSix.setVisibility(View.VISIBLE);
            laborGrossSix.setVisibility(View.VISIBLE);

        }else if (spinCount == 7) {

            TextView laborTypeOne = findViewById(R.id.laborTypeOne);
            TextView laborHoursOne = findViewById(R.id.laborHoursOne);
            TextView laborGrossOne = findViewById(R.id.laborGrossOne);

            laborTypeOne.setVisibility(View.VISIBLE);
            laborHoursOne.setVisibility(View.VISIBLE);
            laborGrossOne.setVisibility(View.VISIBLE);


            TextView laborTypeTwo = findViewById(R.id.laborTypeTwo);
            TextView laborHoursTwo = findViewById(R.id.laborHoursTwo);
            TextView laborGrossTwo = findViewById(R.id.laborGrossTwo);

            laborTypeTwo.setVisibility(View.VISIBLE);
            laborHoursTwo.setVisibility(View.VISIBLE);
            laborGrossTwo.setVisibility(View.VISIBLE);


            TextView laborTypeThree = findViewById(R.id.laborTypeThree);
            TextView laborHoursThree = findViewById(R.id.laborHoursThree);
            TextView laborGrossThree = findViewById(R.id.laborGrossThree);

            laborTypeThree.setVisibility(View.VISIBLE);
            laborHoursThree.setVisibility(View.VISIBLE);
            laborGrossThree.setVisibility(View.VISIBLE);


            TextView laborTypeFour = findViewById(R.id.laborTypeFour);
            TextView laborHoursFour = findViewById(R.id.laborHoursFour);
            TextView laborGrossFour = findViewById(R.id.laborGrossFour);

            laborTypeFour.setVisibility(View.VISIBLE);
            laborHoursFour.setVisibility(View.VISIBLE);
            laborGrossFour.setVisibility(View.VISIBLE);


            TextView laborTypeFive = findViewById(R.id.laborTypeFive);
            TextView laborHoursFive = findViewById(R.id.laborHoursFive);
            TextView laborGrossFive = findViewById(R.id.laborGrossFive);

            laborTypeFive.setVisibility(View.VISIBLE);
            laborHoursFive.setVisibility(View.VISIBLE);
            laborGrossFive.setVisibility(View.VISIBLE);


            TextView laborTypeSix = findViewById(R.id.laborTypeSix);
            TextView laborHoursSix = findViewById(R.id.laborHoursSix);
            TextView laborGrossSix = findViewById(R.id.laborGrossSix);

            laborTypeSix.setVisibility(View.VISIBLE);
            laborHoursSix.setVisibility(View.VISIBLE);
            laborGrossSix.setVisibility(View.VISIBLE);


            TextView laborTypeSeven = findViewById(R.id.laborTypeSeven);
            TextView laborHoursSeven = findViewById(R.id.laborHoursSeven);
            TextView laborGrossSeven = findViewById(R.id.laborGrossSeven);

            laborTypeSeven.setVisibility(View.VISIBLE);
            laborHoursSeven.setVisibility(View.VISIBLE);
            laborGrossSeven.setVisibility(View.VISIBLE);

        }else if (spinCount == 8) {

            TextView laborTypeOne = findViewById(R.id.laborTypeOne);
            TextView laborHoursOne = findViewById(R.id.laborHoursOne);
            TextView laborGrossOne = findViewById(R.id.laborGrossOne);

            laborTypeOne.setVisibility(View.VISIBLE);
            laborHoursOne.setVisibility(View.VISIBLE);
            laborGrossOne.setVisibility(View.VISIBLE);


            TextView laborTypeTwo = findViewById(R.id.laborTypeTwo);
            TextView laborHoursTwo = findViewById(R.id.laborHoursTwo);
            TextView laborGrossTwo = findViewById(R.id.laborGrossTwo);

            laborTypeTwo.setVisibility(View.VISIBLE);
            laborHoursTwo.setVisibility(View.VISIBLE);
            laborGrossTwo.setVisibility(View.VISIBLE);


            TextView laborTypeThree = findViewById(R.id.laborTypeThree);
            TextView laborHoursThree = findViewById(R.id.laborHoursThree);
            TextView laborGrossThree = findViewById(R.id.laborGrossThree);

            laborTypeThree.setVisibility(View.VISIBLE);
            laborHoursThree.setVisibility(View.VISIBLE);
            laborGrossThree.setVisibility(View.VISIBLE);


            TextView laborTypeFour = findViewById(R.id.laborTypeFour);
            TextView laborHoursFour = findViewById(R.id.laborHoursFour);
            TextView laborGrossFour = findViewById(R.id.laborGrossFour);

            laborTypeFour.setVisibility(View.VISIBLE);
            laborHoursFour.setVisibility(View.VISIBLE);
            laborGrossFour.setVisibility(View.VISIBLE);


            TextView laborTypeFive = findViewById(R.id.laborTypeFive);
            TextView laborHoursFive = findViewById(R.id.laborHoursFive);
            TextView laborGrossFive = findViewById(R.id.laborGrossFive);

            laborTypeFive.setVisibility(View.VISIBLE);
            laborHoursFive.setVisibility(View.VISIBLE);
            laborGrossFive.setVisibility(View.VISIBLE);


            TextView laborTypeSix = findViewById(R.id.laborTypeSix);
            TextView laborHoursSix = findViewById(R.id.laborHoursSix);
            TextView laborGrossSix = findViewById(R.id.laborGrossSix);

            laborTypeSix.setVisibility(View.VISIBLE);
            laborHoursSix.setVisibility(View.VISIBLE);
            laborGrossSix.setVisibility(View.VISIBLE);


            TextView laborTypeSeven = findViewById(R.id.laborTypeSeven);
            TextView laborHoursSeven = findViewById(R.id.laborHoursSeven);
            TextView laborGrossSeven = findViewById(R.id.laborGrossSeven);

            laborTypeSeven.setVisibility(View.VISIBLE);
            laborHoursSeven.setVisibility(View.VISIBLE);
            laborGrossSeven.setVisibility(View.VISIBLE);


            TextView laborTypeEight = findViewById(R.id.laborTypeEight);
            TextView laborHoursEight = findViewById(R.id.laborHoursEight);
            TextView laborGrossEight = findViewById(R.id.laborGrossEight);

            laborTypeEight.setVisibility(View.VISIBLE);
            laborHoursEight.setVisibility(View.VISIBLE);
            laborGrossEight.setVisibility(View.VISIBLE);

        }else if (spinCount == 9) {

            TextView laborTypeOne = findViewById(R.id.laborTypeOne);
            TextView laborHoursOne = findViewById(R.id.laborHoursOne);
            TextView laborGrossOne = findViewById(R.id.laborGrossOne);

            laborTypeOne.setVisibility(View.VISIBLE);
            laborHoursOne.setVisibility(View.VISIBLE);
            laborGrossOne.setVisibility(View.VISIBLE);


            TextView laborTypeTwo = findViewById(R.id.laborTypeTwo);
            TextView laborHoursTwo = findViewById(R.id.laborHoursTwo);
            TextView laborGrossTwo = findViewById(R.id.laborGrossTwo);

            laborTypeTwo.setVisibility(View.VISIBLE);
            laborHoursTwo.setVisibility(View.VISIBLE);
            laborGrossTwo.setVisibility(View.VISIBLE);


            TextView laborTypeThree = findViewById(R.id.laborTypeThree);
            TextView laborHoursThree = findViewById(R.id.laborHoursThree);
            TextView laborGrossThree = findViewById(R.id.laborGrossThree);

            laborTypeThree.setVisibility(View.VISIBLE);
            laborHoursThree.setVisibility(View.VISIBLE);
            laborGrossThree.setVisibility(View.VISIBLE);


            TextView laborTypeFour = findViewById(R.id.laborTypeFour);
            TextView laborHoursFour = findViewById(R.id.laborHoursFour);
            TextView laborGrossFour = findViewById(R.id.laborGrossFour);

            laborTypeFour.setVisibility(View.VISIBLE);
            laborHoursFour.setVisibility(View.VISIBLE);
            laborGrossFour.setVisibility(View.VISIBLE);


            TextView laborTypeFive = findViewById(R.id.laborTypeFive);
            TextView laborHoursFive = findViewById(R.id.laborHoursFive);
            TextView laborGrossFive = findViewById(R.id.laborGrossFive);

            laborTypeFive.setVisibility(View.VISIBLE);
            laborHoursFive.setVisibility(View.VISIBLE);
            laborGrossFive.setVisibility(View.VISIBLE);


            TextView laborTypeSix = findViewById(R.id.laborTypeSix);
            TextView laborHoursSix = findViewById(R.id.laborHoursSix);
            TextView laborGrossSix = findViewById(R.id.laborGrossSix);

            laborTypeSix.setVisibility(View.VISIBLE);
            laborHoursSix.setVisibility(View.VISIBLE);
            laborGrossSix.setVisibility(View.VISIBLE);


            TextView laborTypeSeven = findViewById(R.id.laborTypeSeven);
            TextView laborHoursSeven = findViewById(R.id.laborHoursSeven);
            TextView laborGrossSeven = findViewById(R.id.laborGrossSeven);

            laborTypeSeven.setVisibility(View.VISIBLE);
            laborHoursSeven.setVisibility(View.VISIBLE);
            laborGrossSeven.setVisibility(View.VISIBLE);


            TextView laborTypeEight = findViewById(R.id.laborTypeEight);
            TextView laborHoursEight = findViewById(R.id.laborHoursEight);
            TextView laborGrossEight = findViewById(R.id.laborGrossEight);

            laborTypeEight.setVisibility(View.VISIBLE);
            laborHoursEight.setVisibility(View.VISIBLE);
            laborGrossEight.setVisibility(View.VISIBLE);


            TextView laborTypeNine = findViewById(R.id.laborTypeNine);
            TextView laborHoursNine = findViewById(R.id.laborHoursNine);
            TextView laborGrossNine = findViewById(R.id.laborGrossNine);

            laborTypeNine.setVisibility(View.VISIBLE);
            laborHoursNine.setVisibility(View.VISIBLE);
            laborGrossNine.setVisibility(View.VISIBLE);

        }


    }



    public void setRepairOrderContent(){

        //format for mileage
        DecimalFormat formatter = new DecimalFormat("#,###");
        //format for Hours
        DecimalFormat position = new DecimalFormat("##.0");



        TextView roNumber = findViewById(R.id.repairOrderNumber);
        String roString = repairOrderHelper.getROnumber();
        roNumber.setText(roString);

        TextView writerView = findViewById(R.id.repairOrderWriter);
        String writer = repairOrderHelper.getWriter();
        writerView.setText(writer);

        TextView dateView = findViewById(R.id.repairOrderDate);
        String date = repairOrderHelper.getDate();
        dateView.setText(date);

        TextView customerView = findViewById(R.id.repairOrderCustomer);
        String customer = repairOrderHelper.getCustomer();
        if(!customer.equals("Empty_String")) {
            customerView.setText(customer);
        }

        TextView insuranceView = findViewById(R.id.repairOrderInsurance);
        String insurance = repairOrderHelper.getInsuranceCo();
        if(!insurance.equals("Empty_String")) {
            insuranceView.setText(insurance);
        }

        TextView makeView = findViewById(R.id.repairOrderMake);
        String make = repairOrderHelper.getMake();
        if(!make.equals("Empty_String")) {
            makeView.setText(make);
        }

        TextView modelView = findViewById(R.id.repairOrderModel);
        String model = repairOrderHelper.getModel();
        if(!model.equals("Empty_String")) {
            modelView.setText(model);
        }

        TextView yearView = findViewById(R.id.repairOrderYear);
        String year = repairOrderHelper.getYear();
        if(!year.equals("Empty_String")) {
            yearView.setText(year);
        }

        TextView mileageView = findViewById(R.id.repairOrderMileage);
        String mileage = repairOrderHelper.getMileage();
        int miles = Integer.parseInt(mileage);
        if(!mileage.equals("-1")) {
            mileageView.setText(formatter.format(miles));
        }

        TextView VINView = findViewById(R.id.repairOrderVIN);
        String VIN = repairOrderHelper.getVin();
        if(!VIN.equals("Empty_String")) {
            VINView.setText(VIN);
        }

        TextView colorView = findViewById(R.id.repairOrderColor);
        String color = repairOrderHelper.getColor();
        if(!color.equals("Empty_String")) {
            colorView.setText(color);
        }

        TextView licenseView = findViewById(R.id.repairOrderLicense);
        String license = repairOrderHelper.getLicense();
        if(!license.equals("Empty_String")) {
            licenseView.setText(license);
        }



        TextView laborTypeOneView = findViewById(R.id.laborTypeOne);
        String laborOne = repairOrderHelper.getLaboroneselected();
        laborTypeOneView.setText(laborOne);

        TextView hoursOneView = findViewById(R.id.laborHoursOne);
        String hoursOne = repairOrderHelper.getHoursone();
        hoursOneView.setText(hoursOne);

        TextView grossOneView = findViewById(R.id.laborGrossOne);
        String grossOne = repairOrderHelper.getGrossone();
        double grossOneDouble = Double.parseDouble(grossOne);
        grossOneView.setText(NumberFormat.getCurrencyInstance().format(grossOneDouble));



        TextView laborTypeTwoView = findViewById(R.id.laborTypeTwo);
        String laborTwo = repairOrderHelper.getLabortwoselected();
        laborTypeTwoView.setText(laborTwo);

        TextView hoursTwoView = findViewById(R.id.laborHoursTwo);
        String hoursTwo = repairOrderHelper.getHourstwo();
        hoursTwoView.setText(hoursTwo);

        TextView grossTwoView = findViewById(R.id.laborGrossTwo);
        String grossTwo = repairOrderHelper.getGrosstwo();
        double grossTwoDouble = Double.parseDouble(grossTwo);
        grossTwoView.setText(NumberFormat.getCurrencyInstance().format(grossTwoDouble));



        TextView laborTypeThreeView = findViewById(R.id.laborTypeThree);
        String laborThree = repairOrderHelper.getLaborthreeselected();
        laborTypeThreeView.setText(laborThree);

        TextView hoursThreeView = findViewById(R.id.laborHoursThree);
        String hoursThree = repairOrderHelper.getHoursthree();
        hoursThreeView.setText(hoursThree);

        TextView grossThreeView = findViewById(R.id.laborGrossThree);
        String grossThree = repairOrderHelper.getGrossthree();
        double grossThreeDouble = Double.parseDouble(grossThree);
        grossThreeView.setText(NumberFormat.getCurrencyInstance().format(grossThreeDouble));



        TextView laborTypeFourView = findViewById(R.id.laborTypeFour);
        String laborFour = repairOrderHelper.getLaborfourselected();
        laborTypeFourView.setText(laborFour);

        TextView hoursFourView = findViewById(R.id.laborHoursFour);
        String hoursFour = repairOrderHelper.getHoursfour();
        hoursFourView.setText(hoursFour);

        TextView grossFourView = findViewById(R.id.laborGrossFour);
        String grossFour = repairOrderHelper.getGrossfour();
        double grossFourDouble = Double.parseDouble(grossFour);
        grossFourView.setText(NumberFormat.getCurrencyInstance().format(grossFourDouble));



        TextView laborTypeFiveView = findViewById(R.id.laborTypeFive);
        String laborFive = repairOrderHelper.getLaborfiveselected();
        laborTypeFiveView.setText(laborFive);

        TextView hoursFiveView = findViewById(R.id.laborHoursFive);
        String hoursFive = repairOrderHelper.getHoursfive();
        hoursFiveView.setText(hoursFive);

        TextView grossFiveView = findViewById(R.id.laborGrossFive);
        String grossFive = repairOrderHelper.getGrossfive();
        double grossFiveDouble = Double.parseDouble(grossFive);
        grossFiveView.setText(NumberFormat.getCurrencyInstance().format(grossFiveDouble));



        TextView laborTypeSixView = findViewById(R.id.laborTypeSix);
        String laborSix = repairOrderHelper.getLaborsixselected();
        laborTypeSixView.setText(laborSix);

        TextView hoursSixView = findViewById(R.id.laborHoursSix);
        String hoursSix = repairOrderHelper.getHourssix();
        hoursSixView.setText(hoursSix);

        TextView grossSixView = findViewById(R.id.laborGrossSix);
        String grossSix = repairOrderHelper.getGrosssix();
        double grossSixDouble = Double.parseDouble(grossSix);
        grossSixView.setText(NumberFormat.getCurrencyInstance().format(grossSixDouble));



        TextView laborTypeSevenView = findViewById(R.id.laborTypeSeven);
        String laborSeven = repairOrderHelper.getLaborsevenselected();
        laborTypeSevenView.setText(laborSeven);

        TextView hoursSevenView = findViewById(R.id.laborHoursSeven);
        String hoursSeven = repairOrderHelper.getHoursseven();
        hoursSevenView.setText(hoursSeven);

        TextView grossSevenView = findViewById(R.id.laborGrossSeven);
        String grossSeven = repairOrderHelper.getGrossseven();
        double grossSevenDouble = Double.parseDouble(grossSeven);
        grossSevenView.setText(NumberFormat.getCurrencyInstance().format(grossSevenDouble));



        TextView laborTypeEightView = findViewById(R.id.laborTypeEight);
        String laborEight = repairOrderHelper.getLaboreightselected();
        laborTypeEightView.setText(laborEight);

        TextView hoursEightView = findViewById(R.id.laborHoursEight);
        String hoursEight = repairOrderHelper.getHourseight();
        hoursEightView.setText(hoursEight);

        TextView grossEightView = findViewById(R.id.laborGrossEight);
        String grossEight = repairOrderHelper.getGrosseight();
        double grossEightDouble = Double.parseDouble(grossEight);
        grossEightView.setText(NumberFormat.getCurrencyInstance().format(grossEightDouble));



        TextView laborTypeNineView = findViewById(R.id.laborTypeNine);
        String laborNine = repairOrderHelper.getLabornineselected();
        laborTypeNineView.setText(laborNine);

        TextView hoursNineView = findViewById(R.id.laborHoursNine);
        String hoursNine = repairOrderHelper.getHoursnine();
        hoursNineView.setText(hoursNine);

        TextView grossNineView = findViewById(R.id.laborGrossNine);
        String grossNine = repairOrderHelper.getGrossnine();
        double grossNineDouble = Double.parseDouble(grossNine);
        grossNineView.setText(NumberFormat.getCurrencyInstance().format(grossNineDouble));



        TextView totalHoursView = findViewById(R.id.laborHoursTotal);
        String hoursTotal = repairOrderHelper.getTotalHours();
        double hoursTotalPosition = Double.parseDouble(hoursTotal);
        totalHoursView.setText(position.format(hoursTotalPosition));

        TextView totalGrossView = findViewById(R.id.laborGrossTotal);
        String grossTotal = repairOrderHelper.getTotalgross();
        double grossTotalDouble = Double.parseDouble(grossTotal);
        totalGrossView.setText(NumberFormat.getCurrencyInstance().format(grossTotalDouble));


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_main.xml file.
        // This adds menu items to the app bar.

        getMenuInflater().inflate(R.menu.menu_repair_order, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the edit option
            case R.id.action_edit:
                Intent intentEditRepairOrder = new Intent(RepairOrderActivity.this, AddEditRepairOrderActivity.class);
                intentEditRepairOrder.putExtra("Source","EDIT_REPAIR_ORDER");
                startActivity(intentEditRepairOrder);

                return true;
            // Respond to a click on the "Delete" menu option
            case R.id.action_delete:
                // Pop up confirmation dialog for deletion

                return true;



        }
        return super.onOptionsItemSelected(item);
    }
}
