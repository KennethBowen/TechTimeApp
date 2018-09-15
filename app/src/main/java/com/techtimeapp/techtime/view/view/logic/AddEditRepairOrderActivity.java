package com.techtimeapp.techtime.view.view.logic;


import android.content.ContentValues;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.techtimeapp.techtime.R;

import java.util.ArrayList;
import java.util.List;

public class AddEditRepairOrderActivity extends AppCompatActivity {

    /** EditText field to enter the labor Type */
    private Spinner mLaborSpinnerOne, mLaborSpinnerTwo, mLaborSpinnerThree, mLaborSpinnerFour, mLaborSpinnerFive,
            mLaborSpinnerSix, mLaborSpinnerSeven, mLaborSpinnerEight, mLaborSpinnerNine;

    //helper variable to prevent setUpSpinner() methods from calling a setUpSpinner a second time
    private int spinCount = 0;

    // declare object to hold data values
    private ArrayAdapter laborSpinnerAdapter;

    //stores labor types that will be used from already set up labor types
    private List<String> laborType;

    //labor choice for first labor type
    public String laborOneSelected ;

    //labor choice for second labor type
    public String laborTwoSelected ;

    //labor choice for third labor type
    public String laborThreeSelected ;

    //labor choice for fourth labor type
    public String laborFourSelected ;

    //labor choice for fifth labor type
    public String laborFiveSelected ;

    //labor choice for sixth labor type
    public String laborSixSelected ;

    //labor choice for seventh labor type
    public String laborSevenSelected ;

    //labor choice for eighth labor type
    public String laborEightSelected ;

    //labor choice for ninth labor type
    public String laborNineSelected ;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_repair_order);
        //allows the activity to remain in portrait only
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        laborType = new ArrayList<String>();
        laborType.add("Add Labor");
        laborType.add("Body");
        laborType.add("Mechanical");
        laborType.add("Internal");
        laborType.add("Warranty");
        laborType.add("Refinish");
        laborType.add("Glass");
        laborType.add("Frame");
        laborType.add("Aluminum");
        laborType.add("Other");


        laborSpinnerAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, laborType);
        laborSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        setupSpinnerOne();
    }




    /**
     * Setup the dropdown spinner that allows the user to select the labor type.
     */
    private void setupSpinnerOne() {

        mLaborSpinnerOne = findViewById(R.id.spinner_labor_type_one);

        // Apply the adapter to the spinner
        mLaborSpinnerOne.setAdapter(laborSpinnerAdapter);

        View mEditHoursOne = findViewById(R.id.editTextHours_one);
        final TextView mTextHoursOne = findViewById(R.id.textViewHours_one);
        View mColonOne = findViewById(R.id.textView_one);

        final View mEditHoursTwo = findViewById(R.id.editTextHours_two);
        final TextView mTextHoursTwo = findViewById(R.id.textViewHours_two);
        final View mColonTwo = findViewById(R.id.textView_two);

        mLaborSpinnerOne.setVisibility(View.VISIBLE);
        mEditHoursOne.setVisibility(View.VISIBLE);
        mTextHoursOne.setVisibility(View.VISIBLE);
        mColonOne.setVisibility(View.VISIBLE);

        mLaborSpinnerOne.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if(position > 0) {
                    if (spinCount == 0) {
                        setLaborHiddenOne(selection);
                        setupSpinnerTwo();
                        spinCount++;
                    } else {
                        setLaborHiddenOne(selection);
                    }
                } else if (laborOneSelected != null){
                    laborType.add(laborOneSelected);
                    laborOneSelected = null;
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
    private void setLaborHiddenOne(String selection){
        TextView mTextHoursOne = findViewById(R.id.textViewHours_one);
        int accentBlue = getResources().getColor(R.color.colorAccent);

        if(laborOneSelected == null){
            laborOneSelected = selection;
            laborType.remove(selection);
            mTextHoursOne.setTextColor(accentBlue);
        } if (laborOneSelected !=null){
                laborType.add(laborOneSelected);
                laborOneSelected = selection;
                laborType.remove(selection);
        }

    }




    /**
     * Setup the dropdown spinner that allows the user to select the labor type.
     */
    private void setupSpinnerTwo() {

        mLaborSpinnerTwo = findViewById(R.id.spinner_labor_type_two);

        // Apply the adapter to the spinner
        mLaborSpinnerTwo.setAdapter(laborSpinnerAdapter);

        View mEditHoursTwo = findViewById(R.id.editTextHours_two);
        final TextView mTextHoursTwo = findViewById(R.id.textViewHours_two);
        View mColonTwo = findViewById(R.id.textView_two);

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
                if(position > 0) {
                    if (spinCount == 1) {
                        setLaborHiddenTwo(selection);
                        setupSpinnerThree();
                        spinCount++;
                    } else {
                        setLaborHiddenTwo(selection);
                    }
                } else if (laborTwoSelected != null){
                    laborType.add(laborTwoSelected);
                    laborTwoSelected = null;
                    mTextHoursTwo.setTextColor(getResources().getColor(android.R.color.tab_indicator_text));
                    if(laborTwoSelected == null && laborThreeSelected == null){
                        mLaborSpinnerThree.setVisibility(View.GONE);
                        mEditHoursThree.setVisibility(View.GONE);
                        mTextHoursThree.setVisibility(View.GONE);
                        mColonThree.setVisibility(View.GONE);
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
    private void setLaborHiddenTwo(String selection){
        TextView mTextHoursTwo = findViewById(R.id.textViewHours_two);
        int accentBlue = getResources().getColor(R.color.colorAccent);

        if(laborTwoSelected == null){
            laborTwoSelected = selection;
            laborType.remove(selection);
            mTextHoursTwo.setTextColor(accentBlue);
        } if (laborTwoSelected !=null){
            laborType.add(laborTwoSelected);
            laborTwoSelected = selection;
            laborType.remove(selection);
        }

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
                        setLaborHiddenThree(selection);
                        setupSpinnerFour();
                        spinCount++;
                    } else  {
                        setLaborHiddenThree(selection);
                    }
                } else if (laborThreeSelected != null){
                    laborType.add(laborThreeSelected);
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

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    // will hide selected labor types that are in use
    private void setLaborHiddenThree(String selection){
        TextView mTextHoursThree = findViewById(R.id.textViewHours_three);
        int accentBlue = getResources().getColor(R.color.colorAccent);

        if(laborThreeSelected == null){
            laborThreeSelected = selection;
            laborType.remove(selection);
            mTextHoursThree.setTextColor(accentBlue);
        } if (laborThreeSelected !=null){
            laborType.add(laborThreeSelected);
            laborThreeSelected = selection;
            laborType.remove(selection);
        }

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
                        setLaborHiddenFour(selection);
                        setupSpinnerFive();
                        spinCount++;
                    } else  {
                        setLaborHiddenFour(selection);
                    }
                } else if (laborFourSelected != null){
                    laborType.add(laborFourSelected);
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

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    // will hide selected labor types that are in use
    private void setLaborHiddenFour(String selection){
        TextView mTextHoursFour = findViewById(R.id.textViewHours_four);
        int accentBlue = getResources().getColor(R.color.colorAccent);

        if(laborFourSelected == null){
            laborFourSelected = selection;
            laborType.remove(selection);
            mTextHoursFour.setTextColor(accentBlue);
        } if (laborFourSelected !=null){
            laborType.add(laborFourSelected);
            laborFourSelected = selection;
            laborType.remove(selection);
        }

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
                        setLaborHiddenFive(selection);
                        setupSpinnerSix();
                        spinCount++;
                    } else  {
                        setLaborHiddenFive(selection);
                    }
                } else if (laborFiveSelected != null){
                    laborType.add(laborFiveSelected);
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

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    // will hide selected labor types that are in use
    private void setLaborHiddenFive(String selection){
        TextView mTextHoursFive = findViewById(R.id.textViewHours_five);
        int accentBlue = getResources().getColor(R.color.colorAccent);

        if(laborFiveSelected == null){
            laborFiveSelected = selection;
            laborType.remove(selection);
            mTextHoursFive.setTextColor(accentBlue);
        } if (laborFiveSelected !=null){
            laborType.add(laborFiveSelected);
            laborFiveSelected = selection;
            laborType.remove(selection);
        }

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
                        setLaborHiddenSix(selection);
                        setupSpinnerSeven();
                        spinCount++;
                    } else  {
                        setLaborHiddenSix(selection);
                    }
                } else if (laborSixSelected != null){
                    laborType.add(laborSixSelected);
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

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    // will hide selected labor types that are in use
    private void setLaborHiddenSix(String selection){
        TextView mTextHoursSix = findViewById(R.id.textViewHours_six);
        int accentBlue = getResources().getColor(R.color.colorAccent);

        if(laborSixSelected == null){
            laborSixSelected = selection;
            laborType.remove(selection);
            mTextHoursSix.setTextColor(accentBlue);
        } if (laborSixSelected !=null){
            laborType.add(laborSixSelected);
            laborSixSelected = selection;
            laborType.remove(selection);
        }

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
                        setLaborHiddenSeven(selection);
                        setupSpinnerEight();
                        spinCount++;
                    } else  {
                        setLaborHiddenSeven(selection);
                    }
                } else if (laborSevenSelected != null){
                    laborType.add(laborSevenSelected);
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

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    // will hide selected labor types that are in use
    private void setLaborHiddenSeven(String selection){
        TextView mTextHoursSeven = findViewById(R.id.textViewHours_seven);
        int accentBlue = getResources().getColor(R.color.colorAccent);

        if(laborSevenSelected == null){
            laborSevenSelected = selection;
            laborType.remove(selection);
            mTextHoursSeven.setTextColor(accentBlue);
        } if (laborSevenSelected !=null){
            laborType.add(laborSevenSelected);
            laborSevenSelected = selection;
            laborType.remove(selection);
        }

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
                        setLaborHiddenEight(selection);
                        setupSpinnerNine();
                        spinCount++;
                    } else  {
                        setLaborHiddenEight(selection);
                    }
                } else if (laborEightSelected != null){
                    laborType.add(laborEightSelected);
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

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    // will hide selected labor types that are in use
    private void setLaborHiddenEight(String selection){
        TextView mTextHoursEight = findViewById(R.id.textViewHours_eight);
        int accentBlue = getResources().getColor(R.color.colorAccent);

        if(laborEightSelected == null){
            laborEightSelected = selection;
            laborType.remove(selection);
            mTextHoursEight.setTextColor(accentBlue);
        } if (laborEightSelected !=null){
            laborType.add(laborEightSelected);
            laborEightSelected = selection;
            laborType.remove(selection);
        }

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

                        setLaborHiddenNine(selection);

                } else if (laborNineSelected != null){
                    laborType.add(laborNineSelected);
                    laborNineSelected = null;
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
    private void setLaborHiddenNine(String selection){
        TextView mTextHoursNine = findViewById(R.id.textViewHours_nine);
        int accentBlue = getResources().getColor(R.color.colorAccent);

        if(laborNineSelected == null){
            laborNineSelected = selection;
            laborType.remove(selection);
            mTextHoursNine.setTextColor(accentBlue);
        } if (laborNineSelected !=null){
            laborType.add(laborNineSelected);
            laborNineSelected = selection;
            laborType.remove(selection);
        }

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
