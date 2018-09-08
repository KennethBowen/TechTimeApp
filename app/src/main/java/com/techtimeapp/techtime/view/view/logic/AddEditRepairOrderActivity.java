package com.techtimeapp.techtime.view.view.logic;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.techtimeapp.techtime.R;

public class AddEditRepairOrderActivity extends AppCompatActivity {

    /** EditText field to enter the labor Type */
    private Spinner mLaborSpinnerOne, mLaborSpinnerTwo, mLaborSpinnerThree, mLaborSpinnerFour, mLaborSpinnerFive, mLaborSpinnerSix, mLaborSpinnerSeven, mLaborSpinnerEight, mLaborSpinnerNine;

    int spinCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_repair_order);
        //allows the activity to remain in portrait only
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mLaborSpinnerOne = findViewById(R.id.spinner_labor_type_one);
        mLaborSpinnerTwo = findViewById(R.id.spinner_labor_type_two);
        mLaborSpinnerThree = findViewById(R.id.spinner_labor_type_three);
        mLaborSpinnerFour = findViewById(R.id.spinner_labor_type_four);
        mLaborSpinnerFive = findViewById(R.id.spinner_labor_type_five);
        mLaborSpinnerSix = findViewById(R.id.spinner_labor_type_six);
        mLaborSpinnerSeven = findViewById(R.id.spinner_labor_type_seven);
        mLaborSpinnerEight = findViewById(R.id.spinner_labor_type_eight);
        mLaborSpinnerNine = findViewById(R.id.spinner_labor_type_nine);
        setupSpinnerOne();
    }


    /**
     * Setup the dropdown spinner that allows the user to select the labor type.
     */
    private void setupSpinnerOne() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter laborSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_Labor_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        laborSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        mLaborSpinnerOne.setAdapter(laborSpinnerAdapter);

        View mEditHoursOne = findViewById(R.id.editTextHours_one);
        View mTextHoursOne = findViewById(R.id.textViewHours_one);
        View mColonOne = findViewById(R.id.textView_one);

        mLaborSpinnerOne.setVisibility(View.VISIBLE);
        mEditHoursOne.setVisibility(View.VISIBLE);
        mTextHoursOne.setVisibility(View.VISIBLE);
        mColonOne.setVisibility(View.VISIBLE);

        mLaborSpinnerOne.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position > 0 && spinCount == 0){
                    setupSpinnerTwo();
                    spinCount++;
                }

            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    /**
     * Setup the dropdown spinner that allows the user to select the labor type.
     */
    private void setupSpinnerTwo() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter laborSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_Labor_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        laborSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        mLaborSpinnerTwo.setAdapter(laborSpinnerAdapter);

        View mEditHoursTwo = findViewById(R.id.editTextHours_two);
        View mTextHoursTwo = findViewById(R.id.textViewHours_two);
        View mColonTwo = findViewById(R.id.textView_two);

        mLaborSpinnerTwo.setVisibility(View.VISIBLE);
        mEditHoursTwo.setVisibility(View.VISIBLE);
        mTextHoursTwo.setVisibility(View.VISIBLE);
        mColonTwo.setVisibility(View.VISIBLE);


        mLaborSpinnerTwo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position > 0 && spinCount == 1){
                    setupSpinnerThree();
                    spinCount++;
                }

            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    /**
     * Setup the dropdown spinner that allows the user to select the labor type.
     */
    private void setupSpinnerThree() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter laborSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_Labor_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        laborSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        mLaborSpinnerThree.setAdapter(laborSpinnerAdapter);

        View mEditHoursThree = findViewById(R.id.editTextHours_three);
        View mTextHoursThree = findViewById(R.id.textViewHours_three);
        View mColonThree = findViewById(R.id.textView_three);

        mLaborSpinnerThree.setVisibility(View.VISIBLE);
        mEditHoursThree.setVisibility(View.VISIBLE);
        mTextHoursThree.setVisibility(View.VISIBLE);
        mColonThree.setVisibility(View.VISIBLE);


        mLaborSpinnerThree.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position > 0 && spinCount == 2){
                    setupSpinnerFour();
                    spinCount++;
                }

            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    /**
     * Setup the dropdown spinner that allows the user to select the labor type.
     */
    private void setupSpinnerFour() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter laborSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_Labor_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        laborSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        mLaborSpinnerFour.setAdapter(laborSpinnerAdapter);

        View mEditHoursFour = findViewById(R.id.editTextHours_four);
        View mTextHoursFour = findViewById(R.id.textViewHours_four);
        View mColonFour = findViewById(R.id.textView_four);

        mLaborSpinnerFour.setVisibility(View.VISIBLE);
        mEditHoursFour.setVisibility(View.VISIBLE);
        mTextHoursFour.setVisibility(View.VISIBLE);
        mColonFour.setVisibility(View.VISIBLE);


        mLaborSpinnerFour.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position > 0 && spinCount == 3){
                    setupSpinnerFive();
                    spinCount++;
                }

            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    /**
     * Setup the dropdown spinner that allows the user to select the labor type.
     */
    private void setupSpinnerFive() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter laborSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_Labor_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        laborSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        mLaborSpinnerFive.setAdapter(laborSpinnerAdapter);

        View mEditHoursFive = findViewById(R.id.editTextHours_five);
        View mTextHoursFive = findViewById(R.id.textViewHours_five);
        View mColonFive = findViewById(R.id.textView_five);

        mLaborSpinnerFive.setVisibility(View.VISIBLE);
        mEditHoursFive.setVisibility(View.VISIBLE);
        mTextHoursFive.setVisibility(View.VISIBLE);
        mColonFive.setVisibility(View.VISIBLE);


        mLaborSpinnerFive.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position > 0 && spinCount == 4){
                    setupSpinnerSix();
                    spinCount++;
                }

            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    /**
     * Setup the dropdown spinner that allows the user to select the labor type.
     */
    private void setupSpinnerSix() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter laborSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_Labor_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        laborSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        mLaborSpinnerSix.setAdapter(laborSpinnerAdapter);

        View mEditHoursSix = findViewById(R.id.editTextHours_six);
        View mTextHoursSix = findViewById(R.id.textViewHours_six);
        View mColonSix = findViewById(R.id.textView_six);

        mLaborSpinnerSix.setVisibility(View.VISIBLE);
        mEditHoursSix.setVisibility(View.VISIBLE);
        mTextHoursSix.setVisibility(View.VISIBLE);
        mColonSix.setVisibility(View.VISIBLE);


        mLaborSpinnerSix.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position > 0 && spinCount == 5){
                    setupSpinnerSeven();
                    spinCount++;
                }

            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    /**
     * Setup the dropdown spinner that allows the user to select the labor type.
     */
    private void setupSpinnerSeven() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter laborSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_Labor_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        laborSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        mLaborSpinnerSeven.setAdapter(laborSpinnerAdapter);

        View mEditHoursSeven = findViewById(R.id.editTextHours_seven);
        View mTextHoursSeven = findViewById(R.id.textViewHours_seven);
        View mColonSeven = findViewById(R.id.textView_seven);

        mLaborSpinnerSeven.setVisibility(View.VISIBLE);
        mEditHoursSeven.setVisibility(View.VISIBLE);
        mTextHoursSeven.setVisibility(View.VISIBLE);
        mColonSeven.setVisibility(View.VISIBLE);


        mLaborSpinnerSeven.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position > 0 && spinCount == 6){
                    setupSpinnerEight();
                    spinCount++;
                }

            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    /**
     * Setup the dropdown spinner that allows the user to select the labor type.
     */
    private void setupSpinnerEight() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter laborSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_Labor_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        laborSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        mLaborSpinnerEight.setAdapter(laborSpinnerAdapter);

        View mEditHoursEight = findViewById(R.id.editTextHours_eight);
        View mTextHoursEight = findViewById(R.id.textViewHours_eight);
        View mColonEight = findViewById(R.id.textView_eight);

        mLaborSpinnerEight.setVisibility(View.VISIBLE);
        mEditHoursEight.setVisibility(View.VISIBLE);
        mTextHoursEight.setVisibility(View.VISIBLE);
        mColonEight.setVisibility(View.VISIBLE);


        mLaborSpinnerEight.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position > 0 && spinCount == 7){
                    setupSpinnerNine();
                    spinCount++;
                }

            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    /**
     * Setup the dropdown spinner that allows the user to select the labor type.
     */
    private void setupSpinnerNine() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter laborSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_Labor_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        laborSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        mLaborSpinnerNine.setAdapter(laborSpinnerAdapter);

        View mEditHoursNine = findViewById(R.id.editTextHours_nine);
        View mTextHoursNine = findViewById(R.id.textViewHours_nine);
        View mColonNine = findViewById(R.id.textView_nine);

        mLaborSpinnerNine.setVisibility(View.VISIBLE);
        mEditHoursNine.setVisibility(View.VISIBLE);
        mTextHoursNine.setVisibility(View.VISIBLE);
        mColonNine.setVisibility(View.VISIBLE);


        mLaborSpinnerNine.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position > 0 ){

                }

            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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

                // Exit activity
                finish();
                return true;



        }
        return super.onOptionsItemSelected(item);
    }

}
