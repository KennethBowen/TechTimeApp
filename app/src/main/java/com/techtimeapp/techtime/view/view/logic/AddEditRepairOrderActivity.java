package com.techtimeapp.techtime.view.view.logic;




import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.techtimeapp.techtime.R;
import com.techtimeapp.techtime.view.view.data.LaborRateHelper;
import com.techtimeapp.techtime.view.view.data.RepairOrder;
import com.techtimeapp.techtime.view.view.data.RepairOrderHelper;
import com.techtimeapp.techtime.view.view.view.MainActivity;
import com.techtimeapp.techtime.view.view.view.RepairOrderActivity;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class AddEditRepairOrderActivity extends AppCompatActivity {

    //spinner object
    private Spinner mLaborSpinnerOne, mLaborSpinnerTwo, mLaborSpinnerThree, mLaborSpinnerFour, mLaborSpinnerFive,
            mLaborSpinnerSix, mLaborSpinnerSeven, mLaborSpinnerEight, mLaborSpinnerNine;

    // declare object to hold data values
    private ArrayAdapter<String> laborSpinnerAdapter;

    //stores labor types that will be used from already set up labor types
    private List<String> laborType;


    //EditText id
    public EditText repairOderEditText;
    public EditText writerEditText;
    public EditText customerEditText;
    public EditText insuranceEditText;
    public EditText makeEditText;
    public EditText modelEditText;
    public EditText yearEditText;
    public EditText mileageEditText;
    public EditText VINEditText;
    public EditText colorEditText;
    public EditText licenseEditText;
    public EditText laborOneEditTextHours ;
    public EditText laborTwoEditTextHours ;
    public EditText laborThreeEditTextHours ;
    public EditText laborFourEditTextHours ;
    public EditText laborFiveEditTextHours ;
    public EditText laborSixEditTextHours ;
    public EditText laborSevenEditTextHours ;
    public EditText laborEightEditTextHours ;
    public EditText laborNineEditTextHours ;

    public RepairOrder repairOrder;

    public RepairOrderHelper repairOrderHelper;

    //helper variable to tell if this is new a Repair Order
    boolean newRepairOrder;

    //helper variables to store position that is held in used spinners
    int positionOne ;
    int positionTwo ;
    int positionThree ;
    int positionFour ;
    int positionFive ;
    int positionSix ;
    int positionSeven ;
    int positionEight ;
    int positionNine ;

    //variables from here down will be used / needed in db and repair order object creation
    //helper variable to prevent setUpSpinner() methods from calling a setUpSpinner a second time
    public int spinCount = 0;

    public int mRepairOrderNumber;
    public String mWriter;
    public String mCustomer;
    public String mDate ;
    public String mInsuranceCo;
    public String mMake;
    public String mModel;
    public String mYear;
    public int mMileage;
    public String mVIN;
    public String mColor;
    public String mLicense;
    public int mMatchPayRoll;
    public double mTotalGross;
    public double mTotalHours;


    //labor choice for labor types
    public String laborOneSelected ;
    public String laborTwoSelected ;
    public String laborThreeSelected ;
    public String laborFourSelected ;
    public String laborFiveSelected ;
    public String laborSixSelected ;
    public String laborSevenSelected ;
    public String laborEightSelected ;
    public String laborNineSelected ;

    //hours for labor type preformed
    public double laborOneHours ;
    public double laborTwoHours ;
    public double laborThreeHours ;
    public double laborFourHours ;
    public double laborFiveHours ;
    public double laborSixHours ;
    public double laborSevenHours ;
    public double laborEightHours ;
    public double laborNineHours ;

    //labor type and hours preformed summed
    public double laborOneGross ;
    public double laborTwoGross ;
    public double laborThreeGross ;
    public double laborFourGross ;
    public double laborFiveGross ;
    public double laborSixGross ;
    public double laborSevenGross ;
    public double laborEightGross ;
    public double laborNineGross ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_repair_order);
        //allows the activity to remain in portrait only
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //method that will add the labor types that are active to spinners
        setLaborTypeOptionsArrayList();
        //ArrayAdapter nothing more to be said
        laborSpinnerAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, laborType);
        laborSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        gatherEditTextIds();

        //This method called to see if repair order is being created for the first time or is being edited
        intentFrom();

        //repair order object
       // repairOrder = new RepairOrder(mRepairOrderNumber, mWriter, mCustomer, mDate, mInsuranceCo, spinCount, laborOneHours, laborTwoHours, laborThreeHours, laborFourHours, laborFiveHours, laborSixHours, laborSevenHours, laborEightHours, laborNineHours, laborOneGross, laborTwoGross, laborThreeGross, laborFourGross, laborFiveGross, laborSixGross, laborSevenGross, laborEightGross, laborNineGross, laborOneSelected, laborTwoSelected, laborThreeSelected, laborFourSelected, laborFiveSelected, laborSixSelected, laborSevenSelected, laborEightSelected, laborNineSelected, mMatchPayRoll, mTotalGross, mMake, mModel, mYear, mMileage, mVIN, mColor, mLicense, mTotalHours);

    }



    //this method is used to gather the id's to all of the EditText fields
    public void gatherEditTextIds(){
        //EditText id
        repairOderEditText = findViewById(R.id.editTextRepairOrderNumber);
        writerEditText = findViewById(R.id.editTextWriter);
        customerEditText = findViewById(R.id.editTextCustomer);
        insuranceEditText = findViewById(R.id.editTextInsuranceCo);
        makeEditText = findViewById(R.id.editTextMake);
        modelEditText = findViewById(R.id.editTextModel);
        yearEditText = findViewById(R.id.editTextYear);
        mileageEditText = findViewById(R.id.editTextMileage);
        VINEditText = findViewById(R.id.editTextVIN);
        colorEditText = findViewById(R.id.editTextColor);
        licenseEditText = findViewById(R.id.editTextLicense);
        laborOneEditTextHours = findViewById(R.id.editTextHours_one);
        laborTwoEditTextHours = findViewById(R.id.editTextHours_two);
        laborThreeEditTextHours = findViewById(R.id.editTextHours_three);
        laborFourEditTextHours = findViewById(R.id.editTextHours_four);
        laborFiveEditTextHours = findViewById(R.id.editTextHours_five);
        laborSixEditTextHours = findViewById(R.id.editTextHours_six);
        laborSevenEditTextHours = findViewById(R.id.editTextHours_seven);
        laborEightEditTextHours = findViewById(R.id.editTextHours_eight);
        laborNineEditTextHours = findViewById(R.id.editTextHours_nine);
    }




    // this method is called right when the activity is created to then see if we need to query the
    //data base or if this is a new repair order
    public void intentFrom(){
        //obtain  Intent Object send  from SenderActivity
        String source = getIntent().getStringExtra("Source");

        if(source.equals("NEW_REPAIR_ORDER"))
        {
            // This is a new repair order, so change the app bar to say "Add Repair Order"
            setTitle(getString(R.string.add_repair_order));
            //this variable is used when saving
            newRepairOrder = true;
            setupSpinnerOne();
        }
        if(source.equals("EDIT_REPAIR_ORDER"))
        {
            // Otherwise this is an existing repair order, so change app bar to say "Edit Repair Order"
            setTitle(getString(R.string.edit_repair_order));
            //this variable is used when saving
            newRepairOrder = false;

            setValuesFromDataBase();

        }
    }



    //this method will set the variables with the values stored from the data base
    public void setValuesFromDataBase(){

        repairOrderHelper = new RepairOrderHelper(this);



        String spinCountString = repairOrderHelper.getSpinnerCount();
        spinCount = Integer.parseInt(spinCountString);

        String roString = repairOrderHelper.getROnumber();
        mRepairOrderNumber = Integer.parseInt(roString);

        mWriter = repairOrderHelper.getWriter();
        mCustomer = repairOrderHelper.getCustomer();
        mInsuranceCo = repairOrderHelper.getInsuranceCo();
        mMake = repairOrderHelper.getMake();
        mModel = repairOrderHelper.getModel();
        mYear = repairOrderHelper.getYear();
        String mileageString = repairOrderHelper.getMileage();
        mMileage = Integer.parseInt(mileageString);
        mVIN = repairOrderHelper.getVin();
        mColor = repairOrderHelper.getColor();
        mLicense = repairOrderHelper.getLicense();

        String laborOneHoursString = repairOrderHelper.getHoursone();
        laborOneHours = Double.valueOf(laborOneHoursString);

        String laborTwoHoursString = repairOrderHelper.getHourstwo();
        laborTwoHours = Double.valueOf(laborTwoHoursString);

        String laborThreeHoursString = repairOrderHelper.getHoursthree();
        laborThreeHours = Double.valueOf(laborThreeHoursString);

        String laborFourHoursString = repairOrderHelper.getHoursfour();
        laborFourHours = Double.valueOf(laborFourHoursString);

        String laborFiveHoursString = repairOrderHelper.getHoursfive();
        laborFiveHours = Double.valueOf(laborFiveHoursString);

        String laborSixHoursString = repairOrderHelper.getHourssix();
        laborSixHours = Double.valueOf(laborSixHoursString);

        String laborSevenHoursString = repairOrderHelper.getHoursseven();
        laborSevenHours = Double.valueOf(laborSevenHoursString);

        String laborEightHoursString = repairOrderHelper.getHourseight();
        laborEightHours = Double.valueOf(laborEightHoursString);

        String laborNineHoursString = repairOrderHelper.getHoursnine();
        laborNineHours = Double.valueOf(laborNineHoursString);


        //this method will set the edit text fields to the values stored in the variables
        setEditTextFields(roString, mileageString);

        //set up spinner and the amount of spinners to set up based on results from the data base
        setUpActiveSpinners(laborOneHoursString, laborTwoHoursString, laborThreeHoursString, laborFourHoursString, laborFiveHoursString, laborSixHoursString, laborSevenHoursString, laborEightHoursString, laborNineHoursString);

    }


    //this method will set the edit text fields to the values stored in the variables
    public void setEditTextFields(String roString, String mileageString){

        repairOderEditText.setText(roString);
        writerEditText.setText(mWriter);

        if(!mCustomer.equals("Empty_String")) {
            customerEditText.setText(mCustomer);
        }

        if(!mInsuranceCo.equals("Empty_String")) {
            insuranceEditText.setText(mInsuranceCo);
        }

        if(!mMake.equals("Empty_String")) {
            makeEditText.setText(mMake);
        }

        if(!mModel.equals("Empty_String")) {
            modelEditText.setText(mModel);
        }

        if(!mYear.equals("Empty_String")) {
            yearEditText.setText(mYear);
        }

        if(mMileage != -1) {
            mileageEditText.setText(mileageString);
        }

        if(!mVIN.equals("Empty_String")) {
            VINEditText.setText(mVIN);
        }

        if(!mColor.equals("Empty_String")) {
            colorEditText.setText(mColor);
        }

        if(!mLicense.equals("Empty_String")) {
            licenseEditText.setText(mLicense);
        }


    }


    //set up spinner and the amount of spinners to set up based on results from the data base
    public void setUpActiveSpinners(String laborOneHoursString, String laborTwoHoursString, String laborThreeHoursString, String laborFourHoursString, String laborFiveHoursString, String laborSixHoursString, String laborSevenHoursString, String laborEightHoursString, String laborNineHoursString){


        String laborTypeOne = repairOrderHelper.getLaboroneselected();
        String laborTypeTwo = repairOrderHelper.getLabortwoselected();
        String laborTypeThree = repairOrderHelper.getLaborthreeselected();
        String laborTypeFour = repairOrderHelper.getLaborfourselected();
        String laborTypeFive = repairOrderHelper.getLaborfiveselected();
        String laborTypeSix = repairOrderHelper.getLaborsixselected();
        String laborTypeSeven = repairOrderHelper.getLaborsevenselected();
        String laborTypeEight = repairOrderHelper.getLaboreightselected();
        String laborTypeNine = repairOrderHelper.getLabornineselected();




        if(!laborTypeOne.equals("Add Labor")) {



            setupSpinnerOne();

            int spinnerOnePosition = laborSpinnerAdapter.getPosition(laborTypeOne);
            mLaborSpinnerOne.setSelection(spinnerOnePosition);
            laborOneEditTextHours.setText(laborOneHoursString);

            setupSpinnerTwo();

        }

        if(!laborTypeTwo.equals("Add Labor")){

            int spinnerTwoPosition =  laborSpinnerAdapter.getPosition(laborTypeTwo);
            mLaborSpinnerTwo.setSelection(spinnerTwoPosition);
            laborTwoEditTextHours.setText(laborTwoHoursString);


            setupSpinnerThree();

        }

        if(!laborTypeThree.equals("Add Labor")){

            int spinnerThreePosition = laborSpinnerAdapter.getPosition(laborTypeThree);
            mLaborSpinnerThree.setSelection(spinnerThreePosition);
            laborThreeEditTextHours.setText(laborThreeHoursString);

            setupSpinnerFour();

        }

        if(!laborTypeFour.equals("Add Labor")){

            int spinnerFourPosition = laborSpinnerAdapter.getPosition(laborTypeFour);
            mLaborSpinnerFour.setSelection(spinnerFourPosition);
            laborFourEditTextHours.setText(laborFourHoursString);

            setupSpinnerFive();

        }

        if(!laborTypeFive.equals("Add Labor")){

            int spinnerFivePosition = laborSpinnerAdapter.getPosition(laborTypeFive);
            mLaborSpinnerFive.setSelection(spinnerFivePosition);
            laborFiveEditTextHours.setText(laborFiveHoursString);

            setupSpinnerSix();

        }

        if(!laborTypeSix.equals("Add Labor")){

            int spinnerSixPosition = laborSpinnerAdapter.getPosition(laborTypeSix);
            mLaborSpinnerSix.setSelection(spinnerSixPosition);
            laborSixEditTextHours.setText(laborSixHoursString);

            setupSpinnerSeven();

        }

        if(!laborTypeSeven.equals("Add Labor")){

            int spinnerSevenPosition = laborSpinnerAdapter.getPosition(laborTypeSeven);
            mLaborSpinnerSeven.setSelection(spinnerSevenPosition);
            laborSevenEditTextHours.setText(laborSevenHoursString);

            setupSpinnerEight();

        }

        if(!laborTypeEight.equals("Add Labor")){

            int spinnerEightPosition = laborSpinnerAdapter.getPosition(laborTypeEight);
            mLaborSpinnerEight.setSelection(spinnerEightPosition);
            laborEightEditTextHours.setText(laborEightHoursString);

            setupSpinnerNine();

        }

        if(!laborTypeNine.equals("Add Labor")){

            int spinnerNinePosition = laborSpinnerAdapter.getPosition(laborTypeNine);
            mLaborSpinnerNine.setSelection(spinnerNinePosition);
            laborNineEditTextHours.setText(laborNineHoursString);


        }


    }






    //this method is called right when the activity is created to
    //query the db to set up the options spinner with active labor types
    private void setLaborTypeOptionsArrayList(){

        LaborRateHelper laborRateHelper = new LaborRateHelper(this);


        //holds the string values from LaborRateHelper
        String bodyString = laborRateHelper.getBodyData();
        String mechanicalString = laborRateHelper.getMechanicalData();
        String internalString = laborRateHelper.getInternalData();
        String warrantyString = laborRateHelper.getWarrantyData();
        String refinishString = laborRateHelper.getRefinishData();
        String glassString = laborRateHelper.getGlassData();
        String frameString = laborRateHelper.getFrameData();
        String aluminumString = laborRateHelper.getAluminumData();
        String otherString = laborRateHelper.getOtherData();

        laborType = new ArrayList<>();
        laborType.add("Add Labor");

        if(!bodyString.equals("0.0")){
            laborType.add("Body");
        }

        if(!mechanicalString.equals("0.0")){
            laborType.add("Mechanical");
        }

        if(!internalString.equals("0.0")){
            laborType.add("Internal");
        }

        if(!warrantyString.equals("0.0")){
            laborType.add("Warranty");
        }

        if(!refinishString.equals("0.0")){
            laborType.add("Refinish");
        }

        if(!glassString.equals("0.0")){
            laborType.add("Glass");
        }

        if(!frameString.equals("0.0")){
            laborType.add("Frame");
        }

        if(!aluminumString.equals("0.0")){
            laborType.add("Aluminum");
        }

        if(!otherString.equals("0.0")){
            laborType.add("Other");
        }

    }


    //called when save button is clicked
    //this method is used to see if the required fields are not empty to then save the repair order
    public void checkVacancy(){

        //this holds the string value found in the EditText fields
        String repairOrderInput = repairOderEditText.getText().toString().trim();
        String writerInput = writerEditText.getText().toString().trim();
        String laborOneHoursInput = laborOneEditTextHours.getText().toString().trim();
        String laborTwoHoursInput = laborTwoEditTextHours.getText().toString().trim();
        String laborThreeHoursInput = laborThreeEditTextHours.getText().toString().trim();
        String laborFourHoursInput = laborFourEditTextHours.getText().toString().trim();
        String laborFiveHoursInput = laborFiveEditTextHours.getText().toString().trim();
        String laborSixHoursInput = laborSixEditTextHours.getText().toString().trim();
        String laborSevenHoursInput = laborSevenEditTextHours.getText().toString().trim();
        String laborEightHoursInput = laborEightEditTextHours.getText().toString().trim();
        String laborNineHoursInput = laborNineEditTextHours.getText().toString().trim();

        if(repairOrderInput.isEmpty()){
            Toast toast = Toast.makeText(this, "Repair Order Number Required", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM, 0,400);
            toast.show();
        }else if(writerInput.isEmpty()){
            Toast toast = Toast.makeText(this, "Writer Required", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM, 0,400);
            toast.show();
        }else if(laborOneSelected == null || laborOneSelected.equals("Add Labor")){
            Toast toast = Toast.makeText(this, "Please Add Labor Type Performed", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM, 0,400);
            toast.show();
        }else if(laborOneHoursInput.isEmpty() || Double.valueOf(laborOneHoursInput) < 0.1){
            Toast toast = Toast.makeText(this, "Labor Type '" + laborOneSelected + "' Is Missing Hours Performed", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM, 0,400);
            toast.show();
        }else if(laborTwoSelected != null && !laborTwoSelected.equals("Add Labor") && laborTwoHoursInput.isEmpty()){
            Toast toast = Toast.makeText(this, "Labor Type '" + laborTwoSelected + "' Is Missing Hours Performed", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM, 0,400);
            toast.show();
        }else if(!laborTwoHoursInput.isEmpty() && laborTwoSelected == null || Objects.equals(laborTwoSelected, "Add Labor")){
            Toast toast = Toast.makeText(this,"Please Add Labor Type Performed", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM, 0,400);
            toast.show();
        }else if(laborThreeSelected != null && !laborThreeSelected.equals("Add Labor") && laborThreeHoursInput.isEmpty()){
            Toast toast = Toast.makeText(this, "Labor Type '" + laborThreeSelected + "' Is Missing Hours Performed", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM, 0,400);
            toast.show();
        }else if(!laborThreeHoursInput.isEmpty() && laborThreeSelected == null || Objects.equals(laborThreeSelected, "Add Labor")){
            Toast toast = Toast.makeText(this,"Please Add Labor Type Performed", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM, 0,400);
            toast.show();
        }else if(laborFourSelected != null && !laborFourSelected.equals("Add Labor") && laborFourHoursInput.isEmpty()){
            Toast toast = Toast.makeText(this, "Labor Type '" + laborFourSelected + "' Is Missing Hours Performed", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM, 0,400);
            toast.show();
        }else if(!laborFourHoursInput.isEmpty() && laborFourSelected == null || Objects.equals(laborFourSelected, "Add Labor")){
            Toast toast = Toast.makeText(this,"Please Add Labor Type Performed", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM, 0,400);
            toast.show();
        }else if(laborFiveSelected != null && !laborFiveSelected.equals("Add Labor") && laborFiveHoursInput.isEmpty()){
            Toast toast = Toast.makeText(this, "Labor Type '" + laborFiveSelected + "' Is Missing Hours Performed", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM, 0,400);
            toast.show();
        }else if(!laborFiveHoursInput.isEmpty() && laborFiveSelected == null || Objects.equals(laborFiveSelected, "Add Labor")){
            Toast toast = Toast.makeText(this,"Please Add Labor Type Performed", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM, 0,400);
            toast.show();
        }else if(laborSixSelected != null && !laborSixSelected.equals("Add Labor") && laborSixHoursInput.isEmpty()){
            Toast toast = Toast.makeText(this, "Labor Type '" + laborSixSelected + "' Is Missing Hours Performed", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM, 0,400);
            toast.show();
        }else if(!laborSixHoursInput.isEmpty() && laborSixSelected == null || Objects.equals(laborSixSelected, "Add Labor")){
            Toast toast = Toast.makeText(this,"Please Add Labor Type Performed", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM, 0,400);
            toast.show();
        }else if(laborSevenSelected != null && !laborSevenSelected.equals("Add Labor") && laborSevenHoursInput.isEmpty()){
            Toast toast = Toast.makeText(this, "Labor Type '" + laborSevenSelected + "' Is Missing Hours Performed", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM, 0,400);
            toast.show();
        }else if(!laborSevenHoursInput.isEmpty() && laborSevenSelected == null || Objects.equals(laborSevenSelected, "Add Labor")){
            Toast toast = Toast.makeText(this,"Please Add Labor Type Performed", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM, 0,400);
            toast.show();
        }else if(laborEightSelected != null && !laborEightSelected.equals("Add Labor") && laborEightHoursInput.isEmpty()){
            Toast toast = Toast.makeText(this, "Labor Type '" + laborEightSelected + "' Is Missing Hours Performed", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM, 0,400);
            toast.show();
        }else if(!laborEightHoursInput.isEmpty() && laborEightSelected == null || Objects.equals(laborEightSelected, "Add Labor")){
            Toast toast = Toast.makeText(this,"Please Add Labor Type Performed", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM, 0,400);
            toast.show();
        }else if(laborNineSelected != null && !laborNineSelected.equals("Add Labor") && laborNineHoursInput.isEmpty()){
            Toast toast = Toast.makeText(this, "Labor Type '" + laborNineSelected + "' Is Missing Hours Performed", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM, 0,400);
            toast.show();
        }else if(!laborNineHoursInput.isEmpty() && laborNineSelected == null || Objects.equals(laborNineSelected, "Add Labor")){
            Toast toast = Toast.makeText(this,"Please Add Labor Type Performed", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM, 0,400);
            toast.show();
        }else {
            //this if block is used to tell if a new repair or needs to be added
            //or a repair order is being updated
            if(newRepairOrder){

                //set the current date
                Calendar calendar = Calendar.getInstance();
                mDate = DateFormat.getDateInstance(DateFormat.DEFAULT).format(calendar.getTime());

                //mMatchPayRoll is assigned 0
                mMatchPayRoll = 0;

                //if any Edit text fields are null it will assign a default value
                adjustForEmptyFields();

                //if any Edit text fields are null it will assign a default value and also for null labor selections
                prepForSum();

                //sum for all labor and hours and then multiples for total gross
                sumRepairLaborAndTotalGross();

                saveNewRepairOrder();

                // Exit activity
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }else {

                //if any Edit text fields are null it will assign a default value
                adjustForEmptyFields();

                //if any Edit text fields are null it will assign a default value and also for null labor selections
                prepForSum();

                //sum for all labor and hours and then multiples for total gross
                sumRepairLaborAndTotalGross();

                upDateRepairOrder();

                // Exit activity
                Intent intent = new Intent(this, RepairOrderActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }




        }

    }



    public void adjustForEmptyFields(){

        //this holds the string value found in the EditText fields
        String repairOrderInput = repairOderEditText.getText().toString().trim();
        String writerInput = writerEditText.getText().toString().trim();
        String customerInput = customerEditText.getText().toString().trim();
        String insuranceCoInput = insuranceEditText.getText().toString().trim();
        String makeInput = makeEditText.getText().toString().trim();
        String modelInput = modelEditText.getText().toString().trim();
        String yearInput = yearEditText.getText().toString().trim();
        String mileageInput = mileageEditText.getText().toString().trim();
        String VINinput = VINEditText.getText().toString().trim();
        String colorInput = colorEditText.getText().toString().trim();
        String licenseInput = licenseEditText.getText().toString().trim();


        //these variables are required fields and have already passed a conditional statement to get here
        // so we straight assign them now.
        mRepairOrderNumber = Integer.parseInt(repairOrderInput);
        mWriter = writerInput;

        if(customerInput.isEmpty()){
            mCustomer = "Empty_String";
        }else {
            mCustomer = customerInput;
        }

        if(insuranceCoInput.isEmpty()){
            mInsuranceCo = "Empty_String";
        }else{
            mInsuranceCo = insuranceCoInput;
        }

        if(makeInput.isEmpty()){
            mMake = "Empty_String";
        }else {
            mMake = makeInput;
        }

        if(modelInput.isEmpty()){
            mModel = "Empty_String";
        }else {
            mModel = modelInput;
        }

        if(yearInput.isEmpty()){
            mYear = "Empty_String";
        }else {
            mYear = yearInput;
        }

        if(mileageInput.isEmpty()){
            mMileage = -1;
        }else {
            mMileage = Integer.parseInt(mileageInput);
        }

        if(VINinput.isEmpty()){
            mVIN = "Empty_String";
        }else {
            mVIN = VINinput;
        }

        if(colorInput.isEmpty()){
            mColor = "Empty_String";
        }else {
            mColor = colorInput;
        }

        if(licenseInput.isEmpty()){
            mLicense = "Empty_String";
        }else {
            mLicense = licenseInput;
        }


    }


    public void prepForSum(){

        //this holds the string value found in the EditText fields
        String laborOneHoursInput = laborOneEditTextHours.getText().toString().trim();
        String laborTwoHoursInput = laborTwoEditTextHours.getText().toString().trim();
        String laborThreeHoursInput = laborThreeEditTextHours.getText().toString().trim();
        String laborFourHoursInput = laborFourEditTextHours.getText().toString().trim();
        String laborFiveHoursInput = laborFiveEditTextHours.getText().toString().trim();
        String laborSixHoursInput = laborSixEditTextHours.getText().toString().trim();
        String laborSevenHoursInput = laborSevenEditTextHours.getText().toString().trim();
        String laborEightHoursInput = laborEightEditTextHours.getText().toString().trim();
        String laborNineHoursInput = laborNineEditTextHours.getText().toString().trim();

        //laborOneSelected will never be null so no if block is needed
        //laborOneSelected is assigned in spinner object
        //so laborOneHours will never be null either so the value will be assigned without if block
        laborOneHours = Double.valueOf(laborOneHoursInput);

        if(laborTwoSelected == null){
            laborTwoSelected = "Add Labor";
        }

        if(laborTwoHoursInput.isEmpty()){
            laborTwoHours = 0.0;
        }else{
            laborTwoHours = Double.valueOf(laborTwoHoursInput);
        }

        if(laborThreeSelected == null){
            laborThreeSelected = "Add Labor";
        }

        if(laborThreeHoursInput.isEmpty()){
            laborThreeHours = 0.0;
        }else{
            laborThreeHours = Double.valueOf(laborThreeHoursInput);
        }

        if(laborFourSelected == null){
            laborFourSelected = "Add Labor";
        }

        if(laborFourHoursInput.isEmpty()){
            laborFourHours = 0.0;
        }else{
            laborFourHours = Double.valueOf(laborFourHoursInput);
        }

        if(laborFiveSelected == null){
            laborFiveSelected = "Add Labor";
        }

        if(laborFiveHoursInput.isEmpty()){
            laborFiveHours = 0.0;
        }else{
            laborFiveHours = Double.valueOf(laborFiveHoursInput);
        }

        if(laborSixSelected == null){
            laborSixSelected = "Add Labor";
        }

        if(laborSixHoursInput.isEmpty()){
            laborSixHours = 0.0;
        }else{
            laborSixHours = Double.valueOf(laborSixHoursInput);
        }

        if(laborSixSelected == null){
            laborSixSelected = "Add Labor";
        }

        if(laborSixHoursInput.isEmpty()){
            laborSixHours = 0.0;
        }else{
            laborSixHours = Double.valueOf(laborSixHoursInput);
        }

        if(laborSevenSelected == null){
            laborSevenSelected = "Add Labor";
        }

        if(laborSevenHoursInput.isEmpty()){
            laborSevenHours = 0.0;
        }else{
            laborSevenHours = Double.valueOf(laborSevenHoursInput);
        }

        if(laborEightSelected == null){
            laborEightSelected = "Add Labor";
        }

        if(laborEightHoursInput.isEmpty()){
            laborEightHours = 0.0;
        }else{
            laborEightHours = Double.valueOf(laborEightHoursInput);
        }

        if(laborNineSelected == null){
            laborNineSelected = "Add Labor";
        }

        if(laborNineHoursInput.isEmpty()){
            laborNineHours = 0.0;
        }else{
            laborNineHours = Double.valueOf(laborNineHoursInput);
        }


    }



    public void sumRepairLaborAndTotalGross(){

        //to access data from labor rates helper to perform gross multiplication
        LaborRateHelper laborRateHelper = new LaborRateHelper(this);


        if(!laborOneSelected.equals("Add Labor")) {

            switch (laborOneSelected) {
                case "Body":

                    //holds the string values from LaborRateHelper
                    String bodyString = laborRateHelper.getBodyData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double bodyRate = Double.valueOf(bodyString);
                    laborOneGross = (bodyRate * laborOneHours);

                    break;
                case "Mechanical":

                    //holds the string values from LaborRateHelper
                    String mechanicalString = laborRateHelper.getMechanicalData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double mechanicalRate = Double.valueOf(mechanicalString);
                    laborOneGross = (mechanicalRate * laborOneHours);

                    break;
                case "Internal":

                    //holds the string values from LaborRateHelper
                    String internalString = laborRateHelper.getInternalData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double internalRate = Double.valueOf(internalString);
                    laborOneGross = (internalRate * laborOneHours);

                    break;
                case "Warranty":

                    //holds the string values from LaborRateHelper
                    String warrantyString = laborRateHelper.getWarrantyData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double warrantyRate = Double.valueOf(warrantyString);
                    laborOneGross = (warrantyRate * laborOneHours);

                    break;
                case "Refinish":

                    //holds the string values from LaborRateHelper
                    String refinishString = laborRateHelper.getRefinishData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double refinishRate = Double.valueOf(refinishString);
                    laborOneGross = (refinishRate * laborOneHours);

                    break;
                case "Glass":

                    //holds the string values from LaborRateHelper
                    String glassString = laborRateHelper.getGlassData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double glassRate = Double.valueOf(glassString);
                    laborOneGross = (glassRate * laborOneHours);

                    break;
                case "Frame":

                    //holds the string values from LaborRateHelper
                    String frameString = laborRateHelper.getFrameData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double frameRate = Double.valueOf(frameString);
                    laborOneGross = (frameRate * laborOneHours);

                    break;
                case "Aluminum":

                    //holds the string values from LaborRateHelper
                    String aluminumString = laborRateHelper.getAluminumData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double aluminumRate = Double.valueOf(aluminumString);
                    laborOneGross = (aluminumRate * laborOneHours);

                    break;
                case "Other":

                    //holds the string values from LaborRateHelper
                    String otherString = laborRateHelper.getOtherData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double otherRate = Double.valueOf(otherString);
                    laborOneGross = (otherRate * laborOneHours);

                    break;
            }


        }



        if(!laborTwoSelected.equals("Add Labor")) {

            switch (laborTwoSelected) {
                case "Body":

                    //holds the string values from LaborRateHelper
                    String bodyString = laborRateHelper.getBodyData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double bodyRate = Double.valueOf(bodyString);
                    laborTwoGross = (bodyRate * laborTwoHours);

                    break;
                case "Mechanical":

                    //holds the string values from LaborRateHelper
                    String mechanicalString = laborRateHelper.getMechanicalData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double mechanicalRate = Double.valueOf(mechanicalString);
                    laborTwoGross = (mechanicalRate * laborTwoHours);

                    break;
                case "Internal":

                    //holds the string values from LaborRateHelper
                    String internalString = laborRateHelper.getInternalData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double internalRate = Double.valueOf(internalString);
                    laborTwoGross = (internalRate * laborTwoHours);

                    break;
                case "Warranty":

                    //holds the string values from LaborRateHelper
                    String warrantyString = laborRateHelper.getWarrantyData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double warrantyRate = Double.valueOf(warrantyString);
                    laborTwoGross = (warrantyRate * laborTwoHours);

                    break;
                case "Refinish":

                    //holds the string values from LaborRateHelper
                    String refinishString = laborRateHelper.getRefinishData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double refinishRate = Double.valueOf(refinishString);
                    laborTwoGross = (refinishRate * laborTwoHours);

                    break;
                case "Glass":

                    //holds the string values from LaborRateHelper
                    String glassString = laborRateHelper.getGlassData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double glassRate = Double.valueOf(glassString);
                    laborTwoGross = (glassRate * laborTwoHours);

                    break;
                case "Frame":

                    //holds the string values from LaborRateHelper
                    String frameString = laborRateHelper.getFrameData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double frameRate = Double.valueOf(frameString);
                    laborTwoGross = (frameRate * laborTwoHours);

                    break;
                case "Aluminum":

                    //holds the string values from LaborRateHelper
                    String aluminumString = laborRateHelper.getAluminumData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double aluminumRate = Double.valueOf(aluminumString);
                    laborTwoGross = (aluminumRate * laborTwoHours);

                    break;
                case "Other":

                    //holds the string values from LaborRateHelper
                    String otherString = laborRateHelper.getOtherData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double otherRate = Double.valueOf(otherString);
                    laborTwoGross = (otherRate * laborTwoHours);

                    break;
            }

        }else {
            laborTwoGross = 0.0;
        }





        if(!laborThreeSelected.equals("Add Labor")) {

            switch (laborThreeSelected) {
                case "Body":

                    //holds the string values from LaborRateHelper
                    String bodyString = laborRateHelper.getBodyData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double bodyRate = Double.valueOf(bodyString);
                    laborThreeGross = (bodyRate * laborThreeHours);

                    break;
                case "Mechanical":

                    //holds the string values from LaborRateHelper
                    String mechanicalString = laborRateHelper.getMechanicalData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double mechanicalRate = Double.valueOf(mechanicalString);
                    laborThreeGross = (mechanicalRate * laborThreeHours);

                    break;
                case "Internal":

                    //holds the string values from LaborRateHelper
                    String internalString = laborRateHelper.getInternalData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double internalRate = Double.valueOf(internalString);
                    laborThreeGross = (internalRate * laborThreeHours);

                    break;
                case "Warranty":

                    //holds the string values from LaborRateHelper
                    String warrantyString = laborRateHelper.getWarrantyData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double warrantyRate = Double.valueOf(warrantyString);
                    laborThreeGross = (warrantyRate * laborThreeHours);

                    break;
                case "Refinish":

                    //holds the string values from LaborRateHelper
                    String refinishString = laborRateHelper.getRefinishData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double refinishRate = Double.valueOf(refinishString);
                    laborThreeGross = (refinishRate * laborThreeHours);

                    break;
                case "Glass":

                    //holds the string values from LaborRateHelper
                    String glassString = laborRateHelper.getGlassData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double glassRate = Double.valueOf(glassString);
                    laborThreeGross = (glassRate * laborThreeHours);

                    break;
                case "Frame":

                    //holds the string values from LaborRateHelper
                    String frameString = laborRateHelper.getFrameData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double frameRate = Double.valueOf(frameString);
                    laborThreeGross = (frameRate * laborThreeHours);

                    break;
                case "Aluminum":

                    //holds the string values from LaborRateHelper
                    String aluminumString = laborRateHelper.getAluminumData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double aluminumRate = Double.valueOf(aluminumString);
                    laborThreeGross = (aluminumRate * laborThreeHours);

                    break;
                case "Other":

                    //holds the string values from LaborRateHelper
                    String otherString = laborRateHelper.getOtherData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double otherRate = Double.valueOf(otherString);
                    laborThreeGross = (otherRate * laborThreeHours);

                    break;
            }

        }else {
            laborThreeGross = 0.0;
        }




        if(!laborFourSelected.equals("Add Labor")) {

            switch (laborFourSelected) {
                case "Body":

                    //holds the string values from LaborRateHelper
                    String bodyString = laborRateHelper.getBodyData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double bodyRate = Double.valueOf(bodyString);
                    laborFourGross = (bodyRate * laborFourHours);

                    break;
                case "Mechanical":

                    //holds the string values from LaborRateHelper
                    String mechanicalString = laborRateHelper.getMechanicalData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double mechanicalRate = Double.valueOf(mechanicalString);
                    laborFourGross = (mechanicalRate * laborFourHours);

                    break;
                case "Internal":

                    //holds the string values from LaborRateHelper
                    String internalString = laborRateHelper.getInternalData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double internalRate = Double.valueOf(internalString);
                    laborFourGross = (internalRate * laborFourHours);

                    break;
                case "Warranty":

                    //holds the string values from LaborRateHelper
                    String warrantyString = laborRateHelper.getWarrantyData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double warrantyRate = Double.valueOf(warrantyString);
                    laborFourGross = (warrantyRate * laborFourHours);

                    break;
                case "Refinish":

                    //holds the string values from LaborRateHelper
                    String refinishString = laborRateHelper.getRefinishData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double refinishRate = Double.valueOf(refinishString);
                    laborFourGross = (refinishRate * laborFourHours);

                    break;
                case "Glass":

                    //holds the string values from LaborRateHelper
                    String glassString = laborRateHelper.getGlassData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double glassRate = Double.valueOf(glassString);
                    laborFourGross = (glassRate * laborFourHours);

                    break;
                case "Frame":

                    //holds the string values from LaborRateHelper
                    String frameString = laborRateHelper.getFrameData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double frameRate = Double.valueOf(frameString);
                    laborFourGross = (frameRate * laborFourHours);

                    break;
                case "Aluminum":

                    //holds the string values from LaborRateHelper
                    String aluminumString = laborRateHelper.getAluminumData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double aluminumRate = Double.valueOf(aluminumString);
                    laborFourGross = (aluminumRate * laborFourHours);

                    break;
                case "Other":

                    //holds the string values from LaborRateHelper
                    String otherString = laborRateHelper.getOtherData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double otherRate = Double.valueOf(otherString);
                    laborFourGross = (otherRate * laborFourHours);

                    break;
            }

        }else {
            laborFourGross = 0.0;
        }





        if(!laborFiveSelected.equals("Add Labor")) {

            switch (laborFiveSelected) {
                case "Body":

                    //holds the string values from LaborRateHelper
                    String bodyString = laborRateHelper.getBodyData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double bodyRate = Double.valueOf(bodyString);
                    laborFiveGross = (bodyRate * laborFiveHours);

                    break;
                case "Mechanical":

                    //holds the string values from LaborRateHelper
                    String mechanicalString = laborRateHelper.getMechanicalData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double mechanicalRate = Double.valueOf(mechanicalString);
                    laborFiveGross = (mechanicalRate * laborFiveHours);

                    break;
                case "Internal":

                    //holds the string values from LaborRateHelper
                    String internalString = laborRateHelper.getInternalData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double internalRate = Double.valueOf(internalString);
                    laborFiveGross = (internalRate * laborFiveHours);

                    break;
                case "Warranty":

                    //holds the string values from LaborRateHelper
                    String warrantyString = laborRateHelper.getWarrantyData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double warrantyRate = Double.valueOf(warrantyString);
                    laborFiveGross = (warrantyRate * laborFiveHours);

                    break;
                case "Refinish":

                    //holds the string values from LaborRateHelper
                    String refinishString = laborRateHelper.getRefinishData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double refinishRate = Double.valueOf(refinishString);
                    laborFiveGross = (refinishRate * laborFiveHours);

                    break;
                case "Glass":

                    //holds the string values from LaborRateHelper
                    String glassString = laborRateHelper.getGlassData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double glassRate = Double.valueOf(glassString);
                    laborFiveGross = (glassRate * laborFiveHours);

                    break;
                case "Frame":

                    //holds the string values from LaborRateHelper
                    String frameString = laborRateHelper.getFrameData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double frameRate = Double.valueOf(frameString);
                    laborFiveGross = (frameRate * laborFiveHours);

                    break;
                case "Aluminum":

                    //holds the string values from LaborRateHelper
                    String aluminumString = laborRateHelper.getAluminumData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double aluminumRate = Double.valueOf(aluminumString);
                    laborFiveGross = (aluminumRate * laborFiveHours);

                    break;
                case "Other":

                    //holds the string values from LaborRateHelper
                    String otherString = laborRateHelper.getOtherData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double otherRate = Double.valueOf(otherString);
                    laborFiveGross = (otherRate * laborFiveHours);

                    break;
            }

        }else {
            laborFiveGross = 0.0;
        }




        if(!laborSixSelected.equals("Add Labor")) {

            switch (laborSixSelected) {
                case "Body":

                    //holds the string values from LaborRateHelper
                    String bodyString = laborRateHelper.getBodyData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double bodyRate = Double.valueOf(bodyString);
                    laborSixGross = (bodyRate * laborSixHours);

                    break;
                case "Mechanical":

                    //holds the string values from LaborRateHelper
                    String mechanicalString = laborRateHelper.getMechanicalData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double mechanicalRate = Double.valueOf(mechanicalString);
                    laborSixGross = (mechanicalRate * laborSixHours);

                    break;
                case "Internal":

                    //holds the string values from LaborRateHelper
                    String internalString = laborRateHelper.getInternalData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double internalRate = Double.valueOf(internalString);
                    laborSixGross = (internalRate * laborSixHours);

                    break;
                case "Warranty":

                    //holds the string values from LaborRateHelper
                    String warrantyString = laborRateHelper.getWarrantyData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double warrantyRate = Double.valueOf(warrantyString);
                    laborSixGross = (warrantyRate * laborSixHours);

                    break;
                case "Refinish":

                    //holds the string values from LaborRateHelper
                    String refinishString = laborRateHelper.getRefinishData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double refinishRate = Double.valueOf(refinishString);
                    laborSixGross = (refinishRate * laborSixHours);

                    break;
                case "Glass":

                    //holds the string values from LaborRateHelper
                    String glassString = laborRateHelper.getGlassData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double glassRate = Double.valueOf(glassString);
                    laborSixGross = (glassRate * laborSixHours);

                    break;
                case "Frame":

                    //holds the string values from LaborRateHelper
                    String frameString = laborRateHelper.getFrameData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double frameRate = Double.valueOf(frameString);
                    laborSixGross = (frameRate * laborSixHours);

                    break;
                case "Aluminum":

                    //holds the string values from LaborRateHelper
                    String aluminumString = laborRateHelper.getAluminumData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double aluminumRate = Double.valueOf(aluminumString);
                    laborSixGross = (aluminumRate * laborSixHours);

                    break;
                case "Other":

                    //holds the string values from LaborRateHelper
                    String otherString = laborRateHelper.getOtherData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double otherRate = Double.valueOf(otherString);
                    laborSixGross = (otherRate * laborSixHours);

                    break;
            }

        }else {
            laborSixGross = 0.0;
        }





        if(!laborSevenSelected.equals("Add Labor")) {

            switch (laborSevenSelected) {
                case "Body":

                    //holds the string values from LaborRateHelper
                    String bodyString = laborRateHelper.getBodyData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double bodyRate = Double.valueOf(bodyString);
                    laborSevenGross = (bodyRate * laborSevenHours);

                    break;
                case "Mechanical":

                    //holds the string values from LaborRateHelper
                    String mechanicalString = laborRateHelper.getMechanicalData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double mechanicalRate = Double.valueOf(mechanicalString);
                    laborSevenGross = (mechanicalRate * laborSevenHours);

                    break;
                case "Internal":

                    //holds the string values from LaborRateHelper
                    String internalString = laborRateHelper.getInternalData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double internalRate = Double.valueOf(internalString);
                    laborSevenGross = (internalRate * laborSevenHours);

                    break;
                case "Warranty":

                    //holds the string values from LaborRateHelper
                    String warrantyString = laborRateHelper.getWarrantyData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double warrantyRate = Double.valueOf(warrantyString);
                    laborSevenGross = (warrantyRate * laborSevenHours);

                    break;
                case "Refinish":

                    //holds the string values from LaborRateHelper
                    String refinishString = laborRateHelper.getRefinishData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double refinishRate = Double.valueOf(refinishString);
                    laborSevenGross = (refinishRate * laborSevenHours);

                    break;
                case "Glass":

                    //holds the string values from LaborRateHelper
                    String glassString = laborRateHelper.getGlassData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double glassRate = Double.valueOf(glassString);
                    laborSevenGross = (glassRate * laborSevenHours);

                    break;
                case "Frame":

                    //holds the string values from LaborRateHelper
                    String frameString = laborRateHelper.getFrameData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double frameRate = Double.valueOf(frameString);
                    laborSevenGross = (frameRate * laborSevenHours);

                    break;
                case "Aluminum":

                    //holds the string values from LaborRateHelper
                    String aluminumString = laborRateHelper.getAluminumData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double aluminumRate = Double.valueOf(aluminumString);
                    laborSevenGross = (aluminumRate * laborSevenHours);

                    break;
                case "Other":

                    //holds the string values from LaborRateHelper
                    String otherString = laborRateHelper.getOtherData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double otherRate = Double.valueOf(otherString);
                    laborSevenGross = (otherRate * laborSevenHours);

                    break;
            }

        }else {
            laborSevenGross = 0.0;
        }




        if(!laborEightSelected.equals("Add Labor")) {

            switch (laborEightSelected) {
                case "Body":

                    //holds the string values from LaborRateHelper
                    String bodyString = laborRateHelper.getBodyData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double bodyRate = Double.valueOf(bodyString);
                    laborEightGross = (bodyRate * laborEightHours);

                    break;
                case "Mechanical":

                    //holds the string values from LaborRateHelper
                    String mechanicalString = laborRateHelper.getMechanicalData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double mechanicalRate = Double.valueOf(mechanicalString);
                    laborEightGross = (mechanicalRate * laborEightHours);

                    break;
                case "Internal":

                    //holds the string values from LaborRateHelper
                    String internalString = laborRateHelper.getInternalData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double internalRate = Double.valueOf(internalString);
                    laborEightGross = (internalRate * laborEightHours);

                    break;
                case "Warranty":

                    //holds the string values from LaborRateHelper
                    String warrantyString = laborRateHelper.getWarrantyData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double warrantyRate = Double.valueOf(warrantyString);
                    laborEightGross = (warrantyRate * laborEightHours);

                    break;
                case "Refinish":

                    //holds the string values from LaborRateHelper
                    String refinishString = laborRateHelper.getRefinishData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double refinishRate = Double.valueOf(refinishString);
                    laborEightGross = (refinishRate * laborEightHours);

                    break;
                case "Glass":

                    //holds the string values from LaborRateHelper
                    String glassString = laborRateHelper.getGlassData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double glassRate = Double.valueOf(glassString);
                    laborEightGross = (glassRate * laborEightHours);

                    break;
                case "Frame":

                    //holds the string values from LaborRateHelper
                    String frameString = laborRateHelper.getFrameData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double frameRate = Double.valueOf(frameString);
                    laborEightGross = (frameRate * laborEightHours);

                    break;
                case "Aluminum":

                    //holds the string values from LaborRateHelper
                    String aluminumString = laborRateHelper.getAluminumData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double aluminumRate = Double.valueOf(aluminumString);
                    laborEightGross = (aluminumRate * laborEightHours);

                    break;
                case "Other":

                    //holds the string values from LaborRateHelper
                    String otherString = laborRateHelper.getOtherData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double otherRate = Double.valueOf(otherString);
                    laborEightGross = (otherRate * laborEightHours);

                    break;
            }

        }else {
            laborEightGross = 0.0;
        }





        if(!laborNineSelected.equals("Add Labor")) {

            switch (laborNineSelected) {
                case "Body":

                    //holds the string values from LaborRateHelper
                    String bodyString = laborRateHelper.getBodyData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double bodyRate = Double.valueOf(bodyString);
                    laborNineGross = (bodyRate * laborNineHours);

                    break;
                case "Mechanical":

                    //holds the string values from LaborRateHelper
                    String mechanicalString = laborRateHelper.getMechanicalData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double mechanicalRate = Double.valueOf(mechanicalString);
                    laborNineGross = (mechanicalRate * laborNineHours);

                    break;
                case "Internal":

                    //holds the string values from LaborRateHelper
                    String internalString = laborRateHelper.getInternalData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double internalRate = Double.valueOf(internalString);
                    laborNineGross = (internalRate * laborNineHours);

                    break;
                case "Warranty":

                    //holds the string values from LaborRateHelper
                    String warrantyString = laborRateHelper.getWarrantyData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double warrantyRate = Double.valueOf(warrantyString);
                    laborNineGross = (warrantyRate * laborNineHours);

                    break;
                case "Refinish":

                    //holds the string values from LaborRateHelper
                    String refinishString = laborRateHelper.getRefinishData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double refinishRate = Double.valueOf(refinishString);
                    laborNineGross = (refinishRate * laborNineHours);

                    break;
                case "Glass":

                    //holds the string values from LaborRateHelper
                    String glassString = laborRateHelper.getGlassData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double glassRate = Double.valueOf(glassString);
                    laborNineGross = (glassRate * laborNineHours);

                    break;
                case "Frame":

                    //holds the string values from LaborRateHelper
                    String frameString = laborRateHelper.getFrameData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double frameRate = Double.valueOf(frameString);
                    laborNineGross = (frameRate * laborNineHours);

                    break;
                case "Aluminum":

                    //holds the string values from LaborRateHelper
                    String aluminumString = laborRateHelper.getAluminumData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double aluminumRate = Double.valueOf(aluminumString);
                    laborNineGross = (aluminumRate * laborNineHours);

                    break;
                case "Other":

                    //holds the string values from LaborRateHelper
                    String otherString = laborRateHelper.getOtherData();
                    //holds the values of the labor rates from the LaborRateHelper
                    double otherRate = Double.valueOf(otherString);
                    laborNineGross = (otherRate * laborNineHours);

                    break;
            }

        }else {
            laborNineGross = 0.0;
        }




        //mTotalGross is given the sum of all the labor gross combined
        mTotalGross = laborOneGross + laborTwoGross + laborThreeGross + laborFourGross + laborFiveGross + laborSixGross + laborSevenGross + laborEightGross + laborNineGross;

        //mTotalHours is given the sum of all the labor hours combined
        mTotalHours = (laborOneHours + laborTwoHours + laborThreeHours + laborFourHours + laborFiveHours + laborSixHours + laborSevenHours + laborEightHours + laborNineHours);


    }



    //this method is to add and save a new repair oder to the data base
    public void saveNewRepairOrder(){


        repairOrderHelper = new RepairOrderHelper(this);


        String RO = String.valueOf(mRepairOrderNumber);
        String spin = (String.valueOf(spinCount));
        String hours1 = (String.valueOf(laborOneHours));
        String hours2 = (String.valueOf(laborTwoHours));
        String hours3 = (String.valueOf(laborThreeHours));
        String hours4 = (String.valueOf(laborFourHours));
        String hours5 = (String.valueOf(laborFiveHours));
        String hours6 = (String.valueOf(laborSixHours));
        String hours7 = (String.valueOf(laborSevenHours));
        String hours8 = (String.valueOf(laborEightHours));
        String hours9 = (String.valueOf(laborNineHours));
        String gross1 = (String.valueOf(laborOneGross));
        String gross2 = (String.valueOf(laborTwoGross));
        String gross3 = (String.valueOf(laborThreeGross));
        String gross4 = (String.valueOf(laborFourGross));
        String gross5 = (String.valueOf(laborFiveGross));
        String gross6 = (String.valueOf(laborSixGross));
        String gross7 = (String.valueOf(laborSevenGross));
        String gross8 = (String.valueOf(laborEightGross));
        String gross9 = (String.valueOf(laborNineGross));
        String matchPayString = (String.valueOf(mMatchPayRoll));
        String totalGrossString = (String.valueOf(mTotalGross));
        String mileString = (String.valueOf(mMileage));
        String totalHoursString = (String.valueOf(mTotalHours));


        repairOrderHelper.addALL(RO, mWriter, mCustomer, mDate, mInsuranceCo, spin, hours1, hours2, hours3, hours4, hours5, hours6, hours7, hours8, hours9, gross1, gross2, gross3, gross4, gross5, gross6, gross7, gross8, gross9, laborOneSelected, laborTwoSelected, laborThreeSelected, laborFourSelected, laborFiveSelected, laborSixSelected, laborSevenSelected, laborEightSelected, laborNineSelected, matchPayString, totalGrossString, mMake, mModel, mYear, mileString, mVIN, mColor, mLicense, totalHoursString);


        Toast toast = Toast.makeText(this, "Repair Order " + mRepairOrderNumber + " Created", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM, 0,400);
        toast.show();

    }




    //this method is to update and save an existing repair oder to the data base
    public void upDateRepairOrder(){


        repairOrderHelper = new RepairOrderHelper(this);


        String RO = String.valueOf(mRepairOrderNumber);
        String spin = (String.valueOf(spinCount));
        String hours1 = (String.valueOf(laborOneHours));
        String hours2 = (String.valueOf(laborTwoHours));
        String hours3 = (String.valueOf(laborThreeHours));
        String hours4 = (String.valueOf(laborFourHours));
        String hours5 = (String.valueOf(laborFiveHours));
        String hours6 = (String.valueOf(laborSixHours));
        String hours7 = (String.valueOf(laborSevenHours));
        String hours8 = (String.valueOf(laborEightHours));
        String hours9 = (String.valueOf(laborNineHours));
        String gross1 = (String.valueOf(laborOneGross));
        String gross2 = (String.valueOf(laborTwoGross));
        String gross3 = (String.valueOf(laborThreeGross));
        String gross4 = (String.valueOf(laborFourGross));
        String gross5 = (String.valueOf(laborFiveGross));
        String gross6 = (String.valueOf(laborSixGross));
        String gross7 = (String.valueOf(laborSevenGross));
        String gross8 = (String.valueOf(laborEightGross));
        String gross9 = (String.valueOf(laborNineGross));
        String totalGrossString = (String.valueOf(mTotalGross));
        String mileString = (String.valueOf(mMileage));
        String totalHoursString = (String.valueOf(mTotalHours));


        repairOrderHelper.updateRepairOrder(RO, mWriter, mCustomer, mInsuranceCo, spin, hours1, hours2, hours3, hours4, hours5, hours6, hours7, hours8, hours9, gross1, gross2, gross3, gross4, gross5, gross6, gross7, gross8, gross9, laborOneSelected, laborTwoSelected, laborThreeSelected, laborFourSelected, laborFiveSelected, laborSixSelected, laborSevenSelected, laborEightSelected, laborNineSelected, totalGrossString, mMake, mModel, mYear, mileString, mVIN, mColor, mLicense, totalHoursString);


    }











    /**
     * Setup the dropdown spinner * ONE * that allows the user to select the labor type.
     */
    private void setupSpinnerOne() {

        // spinner one object
        mLaborSpinnerOne = findViewById(R.id.spinner_labor_type_one);

        // Apply the adapter to the spinner
        mLaborSpinnerOne.setAdapter(laborSpinnerAdapter);


        //the hours that would belong to the selected labor type
        View mEditHoursOne = findViewById(R.id.editTextHours_one);
        //variables to view items that belong with spinner one
        final TextView mTextHoursOne = findViewById(R.id.textViewHours_one);
        View mColonOne = findViewById(R.id.textView_one);

        // view items that belong with spinner two that can be set to GONE within this method
        final View mEditHoursTwo = findViewById(R.id.editTextHours_two);
        final TextView mTextHoursTwo = findViewById(R.id.textViewHours_two);
        final View mColonTwo = findViewById(R.id.textView_two);

        //set the view items that belong to spinner one VISIBLE
        mLaborSpinnerOne.setVisibility(View.VISIBLE);
        mEditHoursOne.setVisibility(View.VISIBLE);
        mTextHoursOne.setVisibility(View.VISIBLE);
        mColonOne.setVisibility(View.VISIBLE);

        // setOnItemSelectedListener for Spinner one for item selections
        mLaborSpinnerOne.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // holds the String value of the position selected from the spinner
                String selection = (String) parent.getItemAtPosition(position);

                if(position > 0 ) {
                    if (spinCount == 0) {
                        // passes the string values of labor type selected to setLaborHiddenOne
                        setLaborHiddenOne(selection, position);
                        setupSpinnerTwo();
                        spinCount++;
                    } else {

                        if(!selection.equals("")) {
                            // passes the string values of labor type selected to setLaborHiddenOne
                            setLaborHiddenOne(selection, position);
                        }else{
                           mLaborSpinnerOne.setSelection(positionOne);
                            laborType.remove(positionOne);
                            laborType.add(positionOne, laborOneSelected);
                            laborOneSelected = null;

                            //sets the hours text back to grey
                            mTextHoursOne.setTextColor(getResources().getColor(android.R.color.tab_indicator_text));
                            if(laborOneSelected == null && laborTwoSelected == null){
                                mLaborSpinnerTwo.setVisibility(View.GONE);
                                mEditHoursTwo.setVisibility(View.GONE);
                                mTextHoursTwo.setVisibility(View.GONE);
                                mColonTwo.setVisibility(View.GONE);
                                spinCount --;
                            }

                        }

                    }
                } else if (laborOneSelected != null){

                    if(laborType.get(positionOne).equals("")){
                        laborType.remove(positionOne);
                        laborType.add(positionOne, laborOneSelected);
                        laborOneSelected = null;
                    }else {
                        laborType.add(laborOneSelected);
                        laborOneSelected = null;
                    }


                    //sets the hours text back to grey
                    mTextHoursOne.setTextColor(getResources().getColor(android.R.color.tab_indicator_text));
                    if(laborOneSelected == null && laborTwoSelected == null){
                        mLaborSpinnerTwo.setVisibility(View.GONE);
                        mEditHoursTwo.setVisibility(View.GONE);
                        mTextHoursTwo.setVisibility(View.GONE);
                        mColonTwo.setVisibility(View.GONE);
                        spinCount --;
                    }
                }

            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }




    // will hide selected labor types that are in use
    private void setLaborHiddenOne(String selection, int position){
        //so the hours text view will be able to be set blue
        TextView mTextHoursOne = findViewById(R.id.textViewHours_one);
        int accentBlue = getResources().getColor(R.color.colorAccent);


        if (laborOneSelected !=null){
            laborType.remove(positionOne);
            laborType.add(positionOne, laborOneSelected);
            laborOneSelected = selection;
            laborType.remove(selection);
            laborType.add(position, "");
            positionOne = position;
        }else{
            // assigns the string value to the laborOneSelected
            laborOneSelected = selection;
            //removes the string value from the list of set up labor types that can be used
            laborType.remove(selection);
            laborType.add(position, "");
            positionOne = position;
            //sets the hours text to blue
            mTextHoursOne.setTextColor(accentBlue);
        }

        laborOneEditTextHours.setFocusableInTouchMode(true);
        laborOneEditTextHours.requestFocus();

    }




    /**
     * Setup the dropdown spinner that allows the user to select the labor type.
     */
    private void setupSpinnerTwo() {

        mLaborSpinnerTwo = findViewById(R.id.spinner_labor_type_two);

        // Apply the adapter to the spinner
        mLaborSpinnerTwo.setAdapter(laborSpinnerAdapter);

        final View mEditHoursTwo = findViewById(R.id.editTextHours_two);
        final TextView mTextHoursTwo = findViewById(R.id.textViewHours_two);
        final View mColonTwo = findViewById(R.id.textView_two);

        final View mEditHoursThree = findViewById(R.id.editTextHours_three);
        final TextView mTextHoursThree = findViewById(R.id.textViewHours_three);
        final View mColonThree = findViewById(R.id.textView_three);


        mLaborSpinnerTwo.setVisibility(View.VISIBLE);
        mEditHoursTwo.setVisibility(View.VISIBLE);
        mTextHoursTwo.setVisibility(View.VISIBLE);
        mColonTwo.setVisibility(View.VISIBLE);


        mLaborSpinnerTwo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if(position > 0 ) {
                    if (spinCount == 1) {
                        if(!selection.equals("")) {
                            setLaborHiddenTwo(selection, position);
                            setupSpinnerThree();
                            spinCount++;
                        }else {
                            mLaborSpinnerTwo.setSelection(0);
                        }

                    } else {
                        if(!selection.equals("")) {
                            setLaborHiddenTwo(selection, position);
                        }else{
                            mLaborSpinnerTwo.setSelection(positionTwo);
                            laborType.remove(positionTwo);
                            laborType.add(positionTwo, laborTwoSelected);
                            laborTwoSelected = null;

                            mTextHoursTwo.setTextColor(getResources().getColor(android.R.color.tab_indicator_text));
                            if(laborTwoSelected == null && laborThreeSelected == null){
                                mLaborSpinnerThree.setVisibility(View.GONE);
                                mEditHoursThree.setVisibility(View.GONE);
                                mTextHoursThree.setVisibility(View.GONE);
                                mColonThree.setVisibility(View.GONE);
                                spinCount --;
                                if(laborOneSelected == null){
                                    mLaborSpinnerTwo.setVisibility(View.GONE);
                                    mEditHoursTwo.setVisibility(View.GONE);
                                    mTextHoursTwo.setVisibility(View.GONE);
                                    mColonTwo.setVisibility(View.GONE);
                                    spinCount --;
                                }
                            }

                        }
                    }
                } else if (laborTwoSelected != null){

                    if(laborType.get(positionTwo).equals("")){
                        laborType.remove(positionTwo);
                        laborType.add(positionTwo, laborTwoSelected);
                        laborTwoSelected = null;
                    }else {
                        laborType.add(laborTwoSelected);
                        laborTwoSelected = null;
                    }


                    mTextHoursTwo.setTextColor(getResources().getColor(android.R.color.tab_indicator_text));
                    if(laborTwoSelected == null && laborThreeSelected == null){
                        mLaborSpinnerThree.setVisibility(View.GONE);
                        mEditHoursThree.setVisibility(View.GONE);
                        mTextHoursThree.setVisibility(View.GONE);
                        mColonThree.setVisibility(View.GONE);
                        spinCount --;
                        if(laborOneSelected == null){
                            mLaborSpinnerTwo.setVisibility(View.GONE);
                            mEditHoursTwo.setVisibility(View.GONE);
                            mTextHoursTwo.setVisibility(View.GONE);
                            mColonTwo.setVisibility(View.GONE);
                            spinCount --;
                        }
                    }
                }

            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    // will hide selected labor types that are in use
    private void setLaborHiddenTwo(String selection, int position){
        TextView mTextHoursTwo = findViewById(R.id.textViewHours_two);
        int accentBlue = getResources().getColor(R.color.colorAccent);

        if (laborTwoSelected !=null){
            laborType.remove(positionTwo);
            laborType.add(positionTwo, laborTwoSelected);
            laborTwoSelected = selection;
            laborType.remove(selection);
            laborType.add(position, "");
            positionTwo = position;

        }else{
            // assigns the string value to the laborOneSelected
            laborTwoSelected = selection;
            //removes the string value from the list of set up labor types that can be used
            laborType.remove(selection);
            laborType.add(position, "");
            positionTwo = position;
            //sets the hours text to blue
            mTextHoursTwo.setTextColor(accentBlue);
        }

        laborTwoEditTextHours.setFocusableInTouchMode(true);
        laborTwoEditTextHours.requestFocus();

    }




    /**
     * Setup the dropdown spinner that allows the user to select the labor type.
     */
    private void setupSpinnerThree() {

        mLaborSpinnerThree = findViewById(R.id.spinner_labor_type_three);
        // Apply the adapter to the spinner
        mLaborSpinnerThree.setAdapter(laborSpinnerAdapter);

        final View mEditHoursThree = findViewById(R.id.editTextHours_three);
        final TextView mTextHoursThree = findViewById(R.id.textViewHours_three);
        final View mColonThree = findViewById(R.id.textView_three);

        final View mEditHoursFour = findViewById(R.id.editTextHours_four);
        final TextView mTextHoursFour = findViewById(R.id.textViewHours_four);
        final View mColonFour = findViewById(R.id.textView_four);

        mLaborSpinnerThree.setVisibility(View.VISIBLE);
        mEditHoursThree.setVisibility(View.VISIBLE);
        mTextHoursThree.setVisibility(View.VISIBLE);
        mColonThree.setVisibility(View.VISIBLE);


        mLaborSpinnerThree.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if(position > 0) {
                    if (spinCount == 2) {
                        if(!selection.equals("")) {
                            setLaborHiddenThree(selection, position);
                            setupSpinnerFour();
                            spinCount++;
                        }else {
                            mLaborSpinnerThree.setSelection(0);
                        }
                    } else  {
                        if(!selection.equals("")) {
                            setLaborHiddenThree(selection, position);
                        }else{
                            mLaborSpinnerThree.setSelection(positionThree);
                            laborType.remove(positionThree);
                            laborType.add(positionThree, laborThreeSelected);
                            laborThreeSelected = null;

                            mTextHoursThree.setTextColor(getResources().getColor(android.R.color.tab_indicator_text));
                            if(laborThreeSelected == null && laborFourSelected == null){
                                mLaborSpinnerFour.setVisibility(View.GONE);
                                mEditHoursFour.setVisibility(View.GONE);
                                mTextHoursFour.setVisibility(View.GONE);
                                mColonFour.setVisibility(View.GONE);
                                spinCount --;
                                if(laborTwoSelected == null){
                                    mLaborSpinnerThree.setVisibility(View.GONE);
                                    mEditHoursThree.setVisibility(View.GONE);
                                    mTextHoursThree.setVisibility(View.GONE);
                                    mColonThree.setVisibility(View.GONE);
                                    spinCount --;
                                }
                            }

                        }
                    }

                } else if (laborThreeSelected != null){

                    if(laborType.get(positionThree).equals("")){
                        laborType.remove(positionThree);
                        laborType.add(positionThree, laborThreeSelected);
                        laborThreeSelected = null;
                    }else {
                        laborType.add(laborThreeSelected);
                        laborThreeSelected = null;
                    }

                    mTextHoursThree.setTextColor(getResources().getColor(android.R.color.tab_indicator_text));
                    if(laborThreeSelected == null && laborFourSelected == null){
                        mLaborSpinnerFour.setVisibility(View.GONE);
                        mEditHoursFour.setVisibility(View.GONE);
                        mTextHoursFour.setVisibility(View.GONE);
                        mColonFour.setVisibility(View.GONE);
                        spinCount --;
                        if(laborTwoSelected == null){
                            mLaborSpinnerThree.setVisibility(View.GONE);
                            mEditHoursThree.setVisibility(View.GONE);
                            mTextHoursThree.setVisibility(View.GONE);
                            mColonThree.setVisibility(View.GONE);
                            spinCount --;
                        }
                    }
                }

            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    // will hide selected labor types that are in use
    private void setLaborHiddenThree(String selection, int position){
        TextView mTextHoursThree = findViewById(R.id.textViewHours_three);
        int accentBlue = getResources().getColor(R.color.colorAccent);

        if (laborThreeSelected !=null){
            laborType.remove(positionThree);
            laborType.add(positionThree, laborThreeSelected);
            laborThreeSelected = selection;
            laborType.remove(selection);
            laborType.add(position, "");
            positionThree = position;
        }else{
            laborThreeSelected = selection;
            //removes the string value from the list of set up labor types that can be used
            laborType.remove(selection);
            laborType.add(position, "");
            positionThree = position;
            //sets the hours text to blue
            mTextHoursThree.setTextColor(accentBlue);
        }

        laborThreeEditTextHours.setFocusableInTouchMode(true);
        laborThreeEditTextHours.requestFocus();

    }


    /**
     * Setup the dropdown spinner that allows the user to select the labor type.
     */
    private void setupSpinnerFour() {

        mLaborSpinnerFour = findViewById(R.id.spinner_labor_type_four);
        // Apply the adapter to the spinner
        mLaborSpinnerFour.setAdapter(laborSpinnerAdapter);

        final View mEditHoursFour = findViewById(R.id.editTextHours_four);
        final TextView mTextHoursFour = findViewById(R.id.textViewHours_four);
        final View mColonFour = findViewById(R.id.textView_four);

        final View mEditHoursFive = findViewById(R.id.editTextHours_five);
        final TextView mTextHoursFive = findViewById(R.id.textViewHours_five);
        final View mColonFive = findViewById(R.id.textView_five);


        mLaborSpinnerFour.setVisibility(View.VISIBLE);
        mEditHoursFour.setVisibility(View.VISIBLE);
        mTextHoursFour.setVisibility(View.VISIBLE);
        mColonFour.setVisibility(View.VISIBLE);


        mLaborSpinnerFour.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if(position > 0) {
                    if (spinCount == 3) {
                        if(!selection.equals("")) {
                            setLaborHiddenFour(selection, position);
                            setupSpinnerFive();
                            spinCount++;
                        }else {
                            mLaborSpinnerFour.setSelection(0);
                        }
                    } else  {
                        if(!selection.equals("")) {

                            setLaborHiddenFour(selection, position);
                        }else{
                            mLaborSpinnerFour.setSelection(positionFour);
                            laborType.remove(positionFour);
                            laborType.add(positionFour, laborFourSelected);
                            laborFourSelected = null;

                            mTextHoursFour.setTextColor(getResources().getColor(android.R.color.tab_indicator_text));
                            if(laborFourSelected == null && laborFiveSelected == null){
                                mLaborSpinnerFive.setVisibility(View.GONE);
                                mEditHoursFive.setVisibility(View.GONE);
                                mTextHoursFive.setVisibility(View.GONE);
                                mColonFive.setVisibility(View.GONE);
                                spinCount --;
                                if(laborThreeSelected == null){
                                    mLaborSpinnerFour.setVisibility(View.GONE);
                                    mEditHoursFour.setVisibility(View.GONE);
                                    mTextHoursFour.setVisibility(View.GONE);
                                    mColonFour.setVisibility(View.GONE);
                                    spinCount --;
                                }
                            }

                        }
                    }

                } else if (laborFourSelected != null){

                    if(laborType.get(positionFour).equals("")){
                        laborType.remove(positionFour);
                        laborType.add(positionFour, laborFourSelected);
                        laborFourSelected = null;
                    }else {
                        laborType.add(laborFourSelected);
                        laborFourSelected = null;
                    }

                    mTextHoursFour.setTextColor(getResources().getColor(android.R.color.tab_indicator_text));
                    if(laborFourSelected == null && laborFiveSelected == null){
                        mLaborSpinnerFive.setVisibility(View.GONE);
                        mEditHoursFive.setVisibility(View.GONE);
                        mTextHoursFive.setVisibility(View.GONE);
                        mColonFive.setVisibility(View.GONE);
                        spinCount --;
                        if(laborThreeSelected == null){
                            mLaborSpinnerFour.setVisibility(View.GONE);
                            mEditHoursFour.setVisibility(View.GONE);
                            mTextHoursFour.setVisibility(View.GONE);
                            mColonFour.setVisibility(View.GONE);
                            spinCount --;
                        }
                    }
                }

            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    // will hide selected labor types that are in use
    private void setLaborHiddenFour(String selection, int position){
        TextView mTextHoursFour = findViewById(R.id.textViewHours_four);
        int accentBlue = getResources().getColor(R.color.colorAccent);

        if (laborFourSelected !=null){
            laborType.remove(positionFour);
            laborType.add(positionFour, laborFourSelected);
            laborFourSelected = selection;
            laborType.remove(selection);
            laborType.add(position, "");
            positionFour = position;
        }else{

            laborFourSelected = selection;
            //removes the string value from the list of set up labor types that can be used
            laborType.remove(selection);
            laborType.add(position, "");
            positionFour = position;
            //sets the hours text to blue
            mTextHoursFour.setTextColor(accentBlue);
        }

        laborFourEditTextHours.setFocusableInTouchMode(true);
        laborFourEditTextHours.requestFocus();

    }


    /**
     * Setup the dropdown spinner that allows the user to select the labor type.
     */
    private void setupSpinnerFive() {

        mLaborSpinnerFive = findViewById(R.id.spinner_labor_type_five);
        // Apply the adapter to the spinner
        mLaborSpinnerFive.setAdapter(laborSpinnerAdapter);


        final View mEditHoursFive = findViewById(R.id.editTextHours_five);
        final TextView mTextHoursFive = findViewById(R.id.textViewHours_five);
        final View mColonFive = findViewById(R.id.textView_five);

        final View mEditHoursSix = findViewById(R.id.editTextHours_six);
        final TextView mTextHoursSix = findViewById(R.id.textViewHours_six);
        final View mColonSix = findViewById(R.id.textView_six);


        mLaborSpinnerFive.setVisibility(View.VISIBLE);
        mEditHoursFive.setVisibility(View.VISIBLE);
        mTextHoursFive.setVisibility(View.VISIBLE);
        mColonFive.setVisibility(View.VISIBLE);


        mLaborSpinnerFive.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if(position > 0) {
                    if (spinCount == 4) {
                        if(!selection.equals("")) {
                            setLaborHiddenFive(selection, position);
                            setupSpinnerSix();
                            spinCount++;
                        }else {
                            mLaborSpinnerFive.setSelection(0);
                        }
                    } else {
                        if(!selection.equals("")) {
                            setLaborHiddenFive(selection, position);
                        }else{
                            mLaborSpinnerFive.setSelection(positionFive);
                            laborType.remove(positionFive);
                            laborType.add(positionFive, laborFiveSelected);
                            laborFiveSelected = null;

                            mTextHoursFive.setTextColor(getResources().getColor(android.R.color.tab_indicator_text));
                            if(laborFiveSelected == null && laborSixSelected == null){
                                mLaborSpinnerSix.setVisibility(View.GONE);
                                mEditHoursSix.setVisibility(View.GONE);
                                mTextHoursSix.setVisibility(View.GONE);
                                mColonSix.setVisibility(View.GONE);
                                spinCount --;
                                if(laborFourSelected == null){
                                    mLaborSpinnerFive.setVisibility(View.GONE);
                                    mEditHoursFive.setVisibility(View.GONE);
                                    mTextHoursFive.setVisibility(View.GONE);
                                    mColonFive.setVisibility(View.GONE);
                                    spinCount --;
                                }
                            }

                        }
                    }


                } else if (laborFiveSelected != null){

                    if(laborType.get(positionFive).equals("")){
                        laborType.remove(positionFive);
                        laborType.add(positionFive, laborFiveSelected);
                        laborFiveSelected = null;
                    }else {
                        laborType.add(laborFiveSelected);
                        laborFiveSelected = null;
                    }

                    mTextHoursFive.setTextColor(getResources().getColor(android.R.color.tab_indicator_text));
                    if(laborFiveSelected == null && laborSixSelected == null){
                        mLaborSpinnerSix.setVisibility(View.GONE);
                        mEditHoursSix.setVisibility(View.GONE);
                        mTextHoursSix.setVisibility(View.GONE);
                        mColonSix.setVisibility(View.GONE);
                        spinCount --;
                        if(laborFourSelected == null){
                            mLaborSpinnerFive.setVisibility(View.GONE);
                            mEditHoursFive.setVisibility(View.GONE);
                            mTextHoursFive.setVisibility(View.GONE);
                            mColonFive.setVisibility(View.GONE);
                            spinCount --;
                        }
                    }
                }

            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    // will hide selected labor types that are in use
    private void setLaborHiddenFive(String selection, int position){
        TextView mTextHoursFive = findViewById(R.id.textViewHours_five);
        int accentBlue = getResources().getColor(R.color.colorAccent);

        if (laborFiveSelected !=null){
            laborType.remove(positionFive);
            laborType.add(positionFive, laborFiveSelected);
            laborFiveSelected = selection;
            laborType.remove(selection);
            laborType.add(position, "");
            positionFive = position;
        }else{

            laborFiveSelected = selection;
            //removes the string value from the list of set up labor types that can be used
            laborType.remove(selection);
            laborType.add(position, "");
            positionFive = position;
            //sets the hours text to blue
            mTextHoursFive.setTextColor(accentBlue);
        }

        laborFiveEditTextHours.setFocusableInTouchMode(true);
        laborFiveEditTextHours.requestFocus();

    }


    /**
     * Setup the dropdown spinner that allows the user to select the labor type.
     */
    private void setupSpinnerSix() {

        mLaborSpinnerSix = findViewById(R.id.spinner_labor_type_six);
        // Apply the adapter to the spinner
        mLaborSpinnerSix.setAdapter(laborSpinnerAdapter);


        final View mEditHoursSix = findViewById(R.id.editTextHours_six);
        final TextView mTextHoursSix = findViewById(R.id.textViewHours_six);
        final View mColonSix = findViewById(R.id.textView_six);

        final View mEditHoursSeven = findViewById(R.id.editTextHours_seven);
        final TextView mTextHoursSeven = findViewById(R.id.textViewHours_seven);
        final View mColonSeven = findViewById(R.id.textView_seven);

        mLaborSpinnerSix.setVisibility(View.VISIBLE);
        mEditHoursSix.setVisibility(View.VISIBLE);
        mTextHoursSix.setVisibility(View.VISIBLE);
        mColonSix.setVisibility(View.VISIBLE);


        mLaborSpinnerSix.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if(position > 0) {
                    if (spinCount == 5) {
                        if(!selection.equals("")) {
                            setLaborHiddenSix(selection, position);
                            setupSpinnerSeven();
                            spinCount++;
                        }else {
                            mLaborSpinnerSix.setSelection(0);
                        }
                    } else  {
                        if(!selection.equals("")) {
                            setLaborHiddenSix(selection, position);
                        }else{
                            mLaborSpinnerSix.setSelection(positionSix);
                            laborType.remove(positionSix);
                            laborType.add(positionSix, laborSixSelected);
                            laborSixSelected = null;

                            mTextHoursSix.setTextColor(getResources().getColor(android.R.color.tab_indicator_text));
                            if(laborSixSelected == null && laborSevenSelected == null){
                                mLaborSpinnerSeven.setVisibility(View.GONE);
                                mEditHoursSeven.setVisibility(View.GONE);
                                mTextHoursSeven.setVisibility(View.GONE);
                                mColonSeven.setVisibility(View.GONE);
                                spinCount --;
                                if(laborFiveSelected == null){
                                    mLaborSpinnerSix.setVisibility(View.GONE);
                                    mEditHoursSix.setVisibility(View.GONE);
                                    mTextHoursSix.setVisibility(View.GONE);
                                    mColonSix.setVisibility(View.GONE);
                                    spinCount --;
                                }
                            }

                        }
                    }

                } else if (laborSixSelected != null){

                    if(laborType.get(positionSix).equals("")){
                        laborType.remove(positionSix);
                        laborType.add(positionSix, laborSixSelected);
                        laborSixSelected = null;
                    }else {
                        laborType.add(laborSixSelected);
                        laborSixSelected = null;
                    }

                    mTextHoursSix.setTextColor(getResources().getColor(android.R.color.tab_indicator_text));
                    if(laborSixSelected == null && laborSevenSelected == null){
                        mLaborSpinnerSeven.setVisibility(View.GONE);
                        mEditHoursSeven.setVisibility(View.GONE);
                        mTextHoursSeven.setVisibility(View.GONE);
                        mColonSeven.setVisibility(View.GONE);
                        spinCount --;
                        if(laborFiveSelected == null){
                            mLaborSpinnerSix.setVisibility(View.GONE);
                            mEditHoursSix.setVisibility(View.GONE);
                            mTextHoursSix.setVisibility(View.GONE);
                            mColonSix.setVisibility(View.GONE);
                            spinCount --;
                        }
                    }
                }

            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    // will hide selected labor types that are in use
    private void setLaborHiddenSix(String selection, int position){
        TextView mTextHoursSix = findViewById(R.id.textViewHours_six);
        int accentBlue = getResources().getColor(R.color.colorAccent);

        if (laborSixSelected !=null){
            laborType.remove(positionSix);
            laborType.add(positionSix, laborSixSelected);
            laborSixSelected = selection;
            laborType.remove(selection);
            laborType.add(position, "");
            positionSix = position;
        }else{

            laborSixSelected = selection;
            //removes the string value from the list of set up labor types that can be used
            laborType.remove(selection);
            laborType.add(position, "");
            positionSix = position;
            //sets the hours text to blue
            mTextHoursSix.setTextColor(accentBlue);
        }

        laborSixEditTextHours.setFocusableInTouchMode(true);
        laborSixEditTextHours.requestFocus();

    }



    /**
     * Setup the dropdown spinner that allows the user to select the labor type.
     */
    private void setupSpinnerSeven() {

        mLaborSpinnerSeven = findViewById(R.id.spinner_labor_type_seven);
        // Apply the adapter to the spinner
        mLaborSpinnerSeven.setAdapter(laborSpinnerAdapter);


        final View mEditHoursSeven = findViewById(R.id.editTextHours_seven);
        final TextView mTextHoursSeven = findViewById(R.id.textViewHours_seven);
        final View mColonSeven = findViewById(R.id.textView_seven);

        final View mEditHoursEight = findViewById(R.id.editTextHours_eight);
        final TextView mTextHoursEight = findViewById(R.id.textViewHours_eight);
        final View mColonEight = findViewById(R.id.textView_eight);

        mLaborSpinnerSeven.setVisibility(View.VISIBLE);
        mEditHoursSeven.setVisibility(View.VISIBLE);
        mTextHoursSeven.setVisibility(View.VISIBLE);
        mColonSeven.setVisibility(View.VISIBLE);


        mLaborSpinnerSeven.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if(position > 0) {
                    if (spinCount == 6) {
                        if(!selection.equals("")) {
                            setLaborHiddenSeven(selection, position);
                            setupSpinnerEight();
                            spinCount++;
                        }else {
                            mLaborSpinnerSeven.setSelection(0);
                        }
                    } else  {
                        if(!selection.equals("")) {

                            setLaborHiddenSeven(selection, position);
                        }else{
                            mLaborSpinnerSeven.setSelection(positionSeven);
                            laborType.remove(positionSeven);
                            laborType.add(positionSeven, laborSevenSelected);
                            laborSevenSelected = null;

                            mTextHoursSeven.setTextColor(getResources().getColor(android.R.color.tab_indicator_text));
                            if(laborSevenSelected == null && laborEightSelected == null){
                                mLaborSpinnerEight.setVisibility(View.GONE);
                                mEditHoursEight.setVisibility(View.GONE);
                                mTextHoursEight.setVisibility(View.GONE);
                                mColonEight.setVisibility(View.GONE);
                                spinCount --;
                                if(laborSixSelected == null){
                                    mLaborSpinnerSeven.setVisibility(View.GONE);
                                    mEditHoursSeven.setVisibility(View.GONE);
                                    mTextHoursSeven.setVisibility(View.GONE);
                                    mColonSeven.setVisibility(View.GONE);
                                    spinCount --;
                                }
                            }

                        }
                    }

                } else if (laborSevenSelected != null){

                    if(laborType.get(positionSeven).equals("")){
                        laborType.remove(positionSeven);
                        laborType.add(positionSeven, laborSevenSelected);
                        laborSevenSelected = null;
                    }else {
                        laborType.add(laborSevenSelected);
                        laborSevenSelected = null;
                    }

                    mTextHoursSeven.setTextColor(getResources().getColor(android.R.color.tab_indicator_text));
                    if(laborSevenSelected == null && laborEightSelected == null){
                        mLaborSpinnerEight.setVisibility(View.GONE);
                        mEditHoursEight.setVisibility(View.GONE);
                        mTextHoursEight.setVisibility(View.GONE);
                        mColonEight.setVisibility(View.GONE);
                        spinCount --;
                        if(laborSixSelected == null){
                            mLaborSpinnerSeven.setVisibility(View.GONE);
                            mEditHoursSeven.setVisibility(View.GONE);
                            mTextHoursSeven.setVisibility(View.GONE);
                            mColonSeven.setVisibility(View.GONE);
                            spinCount --;
                        }
                    }
                }

            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    // will hide selected labor types that are in use
    private void setLaborHiddenSeven(String selection, int position){
        TextView mTextHoursSeven = findViewById(R.id.textViewHours_seven);
        int accentBlue = getResources().getColor(R.color.colorAccent);

        if (laborSevenSelected !=null){
            laborType.remove(positionSeven);
            laborType.add(positionSeven, laborSevenSelected);
            laborSevenSelected = selection;
            laborType.remove(selection);
            laborType.add(position, "");
            positionSeven = position;
        }else{

            laborSevenSelected = selection;
            //removes the string value from the list of set up labor types that can be used
            laborType.remove(selection);
            laborType.add(position, "");
            positionSeven = position;
            //sets the hours text to blue
            mTextHoursSeven.setTextColor(accentBlue);
        }

        laborSevenEditTextHours.setFocusableInTouchMode(true);
        laborSevenEditTextHours.requestFocus();

    }



    /**
     * Setup the dropdown spinner that allows the user to select the labor type.
     */
    private void setupSpinnerEight() {

        mLaborSpinnerEight = findViewById(R.id.spinner_labor_type_eight);
        // Apply the adapter to the spinner
        mLaborSpinnerEight.setAdapter(laborSpinnerAdapter);


        final View mEditHoursEight = findViewById(R.id.editTextHours_eight);
        final TextView mTextHoursEight = findViewById(R.id.textViewHours_eight);
        final View mColonEight = findViewById(R.id.textView_eight);

        final View mEditHoursNine = findViewById(R.id.editTextHours_nine);
        final TextView mTextHoursNine = findViewById(R.id.textViewHours_nine);
        final View mColonNine = findViewById(R.id.textView_nine);

        mLaborSpinnerEight.setVisibility(View.VISIBLE);
        mEditHoursEight.setVisibility(View.VISIBLE);
        mTextHoursEight.setVisibility(View.VISIBLE);
        mColonEight.setVisibility(View.VISIBLE);


        mLaborSpinnerEight.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if(position > 0) {
                    if (spinCount == 7) {
                        if(!selection.equals("")) {
                            setLaborHiddenEight(selection, position);
                            setupSpinnerNine();
                            spinCount++;
                        }else {
                            mLaborSpinnerEight.setSelection(0);
                        }
                    } else  {
                        if(!selection.equals("")) {

                            setLaborHiddenEight(selection, position);
                        }else{
                            mLaborSpinnerEight.setSelection(positionEight);
                            laborType.remove(positionEight);
                            laborType.add(positionEight, laborEightSelected);
                            laborEightSelected = null;

                            mTextHoursEight.setTextColor(getResources().getColor(android.R.color.tab_indicator_text));
                            if(laborEightSelected == null && laborNineSelected == null){
                                mLaborSpinnerNine.setVisibility(View.GONE);
                                mEditHoursNine.setVisibility(View.GONE);
                                mTextHoursNine.setVisibility(View.GONE);
                                mColonNine.setVisibility(View.GONE);
                                spinCount --;
                                if(laborSevenSelected == null){
                                    mLaborSpinnerEight.setVisibility(View.GONE);
                                    mEditHoursEight.setVisibility(View.GONE);
                                    mTextHoursEight.setVisibility(View.GONE);
                                    mColonEight.setVisibility(View.GONE);
                                    spinCount --;
                                }
                            }

                        }
                    }

                } else if (laborEightSelected != null){

                    if(laborType.get(positionEight).equals("")){
                        laborType.remove(positionEight);
                        laborType.add(positionEight, laborEightSelected);
                        laborEightSelected = null;
                    }else {
                        laborType.add(laborEightSelected);
                        laborEightSelected = null;
                    }

                    mTextHoursEight.setTextColor(getResources().getColor(android.R.color.tab_indicator_text));
                    if(laborEightSelected == null && laborNineSelected == null){
                        mLaborSpinnerNine.setVisibility(View.GONE);
                        mEditHoursNine.setVisibility(View.GONE);
                        mTextHoursNine.setVisibility(View.GONE);
                        mColonNine.setVisibility(View.GONE);
                        spinCount --;
                        if(laborSevenSelected == null){
                            mLaborSpinnerEight.setVisibility(View.GONE);
                            mEditHoursEight.setVisibility(View.GONE);
                            mTextHoursEight.setVisibility(View.GONE);
                            mColonEight.setVisibility(View.GONE);
                            spinCount --;
                        }
                    }
                }

            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    // will hide selected labor types that are in use
    private void setLaborHiddenEight(String selection, int position){
        TextView mTextHoursEight = findViewById(R.id.textViewHours_eight);
        int accentBlue = getResources().getColor(R.color.colorAccent);

        if (laborEightSelected !=null){
            laborType.remove(positionEight);
            laborType.add(positionEight, laborEightSelected);
            laborEightSelected = selection;
            laborType.remove(selection);
            laborType.add(position, "");
            positionEight = position;
        }else{

            laborEightSelected = selection;
            //removes the string value from the list of set up labor types that can be used
            laborType.remove(selection);
            laborType.add(position, "");
            positionEight = position;
            //sets the hours text to blue
            mTextHoursEight.setTextColor(accentBlue);
        }

        laborEightEditTextHours.setFocusableInTouchMode(true);
        laborEightEditTextHours.requestFocus();

    }


    /**
     * Setup the dropdown spinner that allows the user to select the labor type.
     */
    private void setupSpinnerNine() {

        mLaborSpinnerNine = findViewById(R.id.spinner_labor_type_nine);
        // Apply the adapter to the spinner
        mLaborSpinnerNine.setAdapter(laborSpinnerAdapter);


        final View mEditHoursNine = findViewById(R.id.editTextHours_nine);
        final TextView mTextHoursNine = findViewById(R.id.textViewHours_nine);
        final View mColonNine = findViewById(R.id.textView_nine);

        mLaborSpinnerNine.setVisibility(View.VISIBLE);
        mEditHoursNine.setVisibility(View.VISIBLE);
        mTextHoursNine.setVisibility(View.VISIBLE);
        mColonNine.setVisibility(View.VISIBLE);


        mLaborSpinnerNine.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if(position > 0) {

                    if(!selection.equals("")) {

                        if(!selection.equals("")) {
                            setLaborHiddenNine(selection, position);
                            spinCount++;
                        }else {
                            mLaborSpinnerNine.setSelection(0);
                        }
                    }else  {
                            mLaborSpinnerNine.setSelection(positionNine);
                            laborType.remove(positionNine);
                            laborType.add(positionNine, laborNineSelected);
                            laborNineSelected = null;

                        mTextHoursNine.setTextColor(getResources().getColor(android.R.color.tab_indicator_text));
                        if(laborEightSelected == null && laborNineSelected == null){
                            mLaborSpinnerNine.setVisibility(View.GONE);
                            mEditHoursNine.setVisibility(View.GONE);
                            mTextHoursNine.setVisibility(View.GONE);
                            mColonNine.setVisibility(View.GONE);
                            spinCount --;
                        }


                    }

                } else if (laborNineSelected != null){

                    if(laborType.get(positionNine).equals("")){
                        laborType.remove(positionNine);
                        laborType.add(positionNine, laborNineSelected);
                        laborNineSelected = null;
                    }else {
                        laborType.add(laborNineSelected);
                        laborNineSelected = null;
                    }

                    mTextHoursNine.setTextColor(getResources().getColor(android.R.color.tab_indicator_text));
                }if(laborEightSelected == null && laborNineSelected == null){
                    mLaborSpinnerNine.setVisibility(View.GONE);
                    mEditHoursNine.setVisibility(View.GONE);
                    mTextHoursNine.setVisibility(View.GONE);
                    mColonNine.setVisibility(View.GONE);
                    spinCount --;
                }

            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    // will hide selected labor types that are in use
    private void setLaborHiddenNine(String selection, int position){
        TextView mTextHoursNine = findViewById(R.id.textViewHours_nine);
        int accentBlue = getResources().getColor(R.color.colorAccent);

        if (laborNineSelected !=null){
            laborType.remove(positionNine);
            laborType.add(positionNine, laborNineSelected);
            laborNineSelected = selection;
            laborType.remove(selection);
            laborType.add(position, "");
            positionNine = position;
        }else{

            laborNineSelected = selection;
            //removes the string value from the list of set up labor types that can be used
            laborType.remove(selection);
            laborType.add(position, "");
            positionNine = position;
            //sets the hours text to blue
            mTextHoursNine.setTextColor(accentBlue);
        }

        laborNineEditTextHours.setFocusableInTouchMode(true);
        laborNineEditTextHours.requestFocus();

    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_main.xml file.
        // This adds menu items to the app bar.

        getMenuInflater().inflate(R.menu.menu_add_edit_repair_order, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the check mark option
            case R.id.action_save:
                //check required fields and then is saved
                checkVacancy();


                return true;



        }
        return super.onOptionsItemSelected(item);
    }

}
