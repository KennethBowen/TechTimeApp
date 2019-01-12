package com.techtimeapp.techtime.view.view.view;



import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Toast;

import com.techtimeapp.techtime.R;
import com.techtimeapp.techtime.view.view.data.LaborRateHelper;
import com.techtimeapp.techtime.view.view.data.RepairOrder;
import com.techtimeapp.techtime.view.view.data.RepairOrderHelper;
import com.techtimeapp.techtime.view.view.logic.AddEditRepairOrderActivity;


import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class PayPeriodFragment extends Fragment implements View.OnClickListener {


    //start date seen on activity
    public Button mStartDate;

    //end date seen on activity
    public Button mEndDate;

    //start pay period button
    public Button startPayPeriodButton;

    //add repair order button for when the pay period is active
    public Button addRepairOrder;

    // inner call for the calender dial log object
    private DateDialogFragment mDateDialogFragment;

    //holds the value to if an pay period is not active
    public boolean hasNoActivePayPeriod = true;



    public PayPeriodFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.activity_pay_period, container, false);


        //add repair order button for the pay period is active
        addRepairOrder = rootView.findViewById(R.id.add_repair_order);

        //start pay period button for the pay period is active
        startPayPeriodButton = rootView.findViewById(R.id.startPayPeriod);

        mStartDate = rootView.findViewById(R.id.startDateButton);
        mEndDate = rootView.findViewById(R.id.endDateButton);

        //set the current date to the startDate
        Calendar calendar = Calendar.getInstance();
        String currentDateString = DateFormat.getDateInstance(DateFormat.DEFAULT).format(calendar.getTime());
        mStartDate.setText(currentDateString);

        mDateDialogFragment = new DateDialogFragment();

        //enables the use of menu held in MainActivity
        setHasOptionsMenu(true);

        mStartDate.setOnClickListener(this);
        mEndDate.setOnClickListener(this);


        // onClick listener for add repair order button
        addRepairOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addRepairOrder();
            }
        });


        // onClick listener for add start pay period button
        startPayPeriodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    startPayPeriod(rootView);

                } catch (ParseException e) {
                    e.printStackTrace();

                    Toast needEndDateToast = Toast.makeText(getActivity(), "Please select an END DATE", Toast.LENGTH_LONG);
                    needEndDateToast.setGravity(Gravity.BOTTOM, 0,400);
                    needEndDateToast.show();

                }
            }
        });

        newRoObject(rootView);

        return rootView;
    }






    public void newRoObject(View rootView){
        ArrayList roArrayList = new ArrayList();

        RepairOrderHelper mRepairOrderHelper = new RepairOrderHelper(getActivity());



        String Ronum = mRepairOrderHelper.getROnumber();
        int RONumber = Integer.parseInt(Ronum);
        String writer = mRepairOrderHelper.getWriter();
        String customer = mRepairOrderHelper.getCustomer();
        String date = mRepairOrderHelper.getDate();
        String insurance = mRepairOrderHelper.getInsuranceCo();
        String spinnerCount = mRepairOrderHelper.getSpinnerCount();
        int spinnerNumber = Integer.parseInt(spinnerCount);
        String hoursOne = mRepairOrderHelper.getHoursone();
        double hours1 = Double.parseDouble(hoursOne);
        String hoursTwo = mRepairOrderHelper.getHourstwo();
        double hours2 = Double.parseDouble(hoursTwo);
        String hoursThree = mRepairOrderHelper.getHoursthree();
        double hours3 = Double.parseDouble(hoursThree);
        String hoursFour = mRepairOrderHelper.getHoursfour();
        double hours4 = Double.parseDouble(hoursFour);
        String hoursFive = mRepairOrderHelper.getHoursfive();
        double hours5 = Double.parseDouble(hoursFive);
        String hoursSix = mRepairOrderHelper.getHourssix();
        double hours6 = Double.parseDouble(hoursSix);
        String hoursSeven = mRepairOrderHelper.getHoursseven();
        double hours7 = Double.parseDouble(hoursSeven);
        String hoursEight = mRepairOrderHelper.getHourseight();
        double hours8 = Double.parseDouble(hoursEight);
        String hoursNine = mRepairOrderHelper.getHoursnine();
        double hours9 = Double.parseDouble(hoursNine);
        String grossOne = mRepairOrderHelper.getGrossone();
        double gross1 = Double.parseDouble(grossOne);
        String grossTwo = mRepairOrderHelper.getGrosstwo();
        double gross2 = Double.parseDouble(grossTwo);
        String grossThree = mRepairOrderHelper.getGrossthree();
        double gross3 = Double.parseDouble(grossThree);
        String grossFour = mRepairOrderHelper.getGrossfour();
        double gross4 = Double.parseDouble(grossFour);
        String grossFive = mRepairOrderHelper.getGrossfive();
        double gross5 = Double.parseDouble(grossFive);
        String grossSix = mRepairOrderHelper.getGrosssix();
        double gross6 = Double.parseDouble(grossSix);
        String grossSeven = mRepairOrderHelper.getGrossseven();
        double gross7 = Double.parseDouble(grossSeven);
        String grossEight = mRepairOrderHelper.getGrosseight();
        double gross8 = Double.parseDouble(grossEight);
        String grossNine = mRepairOrderHelper.getGrossnine();
        double gross9 = Double.parseDouble(grossNine);
        String laborOne = mRepairOrderHelper.getLaboroneselected();
        String laborTwo = mRepairOrderHelper.getLabortwoselected();
        String laborThree = mRepairOrderHelper.getLaborthreeselected();
        String laborFour = mRepairOrderHelper.getLaborfourselected();
        String laborFive = mRepairOrderHelper.getLaborfiveselected();
        String laborSix = mRepairOrderHelper.getLaborsixselected();
        String laborSeven = mRepairOrderHelper.getLaborsevenselected();
        String laborEight = mRepairOrderHelper.getLaboreightselected();
        String laborNine = mRepairOrderHelper.getLabornineselected();
        String payrollMatch = mRepairOrderHelper.getPayrollmatch();
        int payroll = Integer.parseInt(payrollMatch);
        String totalGross = mRepairOrderHelper.getTotalgross();
        double Gross = Double.parseDouble(totalGross);
        String make = mRepairOrderHelper.getMake();
        String model = mRepairOrderHelper.getModel();
        String year = mRepairOrderHelper.getYear();
        String mileage = mRepairOrderHelper.getMileage();
        int mileageInt = Integer.parseInt(mileage);
        String vin = mRepairOrderHelper.getVin();
        String color = mRepairOrderHelper.getColor();
        String license = mRepairOrderHelper.getLicense();
        String totalHours = mRepairOrderHelper.getTotalHours();
        double hours = Double.parseDouble(totalHours);

        RepairOrder repairOrder = new RepairOrder(RONumber, writer, customer, date, insurance, spinnerNumber, hours1, hours2, hours3, hours4, hours5, hours6, hours7, hours8, hours9,
                gross1, gross2, gross3, gross4, gross5, gross6, gross7, gross8, gross9, laborOne, laborTwo, laborThree, laborFour, laborFive, laborSix, laborSeven, laborEight, laborNine,
                payroll, Gross, make, model, year, mileageInt, vin, color, license, hours);

        roArrayList.add(writer);



        ArrayAdapter<RepairOrder> adapter = new ArrayAdapter<RepairOrder>(getActivity(), android.R.layout.simple_list_item_1, roArrayList);
        ListView listView = rootView.findViewById(R.id.listViewPayPeriod);
        listView.setAdapter(adapter);

    }


    //this is called after the add repair order button has been clicked
    //to check if the labor rates have been set.
    public void addRepairOrder(){

        double laborRatesSum = 0;

        try {

            LaborRateHelper laborRateHelper = new LaborRateHelper(getActivity());


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


            //holds the values of the labor rates from the LaborRateHelper
            double bodyRate = Double.valueOf(bodyString);
            double mechanicalRate = Double.valueOf(mechanicalString);
            double internalRate = Double.valueOf(internalString);
            double warrantyRate = Double.valueOf(warrantyString);
            double refinishRate = Double.valueOf(refinishString);
            double glassRate = Double.valueOf(glassString);
            double frameRate = Double.valueOf(frameString);
            double aluminumRate = Double.valueOf(aluminumString);
            double otherRate = Double.valueOf(otherString);

            //this variable holds the sum of all the labor rates
            laborRatesSum = bodyRate + mechanicalRate + internalRate + warrantyRate + refinishRate + glassRate + frameRate + aluminumRate + otherRate;

        } catch (Exception e) {
            e.printStackTrace();

            Toast setLabor = Toast.makeText(getActivity(), "Please set your labor rates", Toast.LENGTH_LONG);
            setLabor.setGravity(Gravity.BOTTOM, 0,400);
            setLabor.show();

        }



        if(laborRatesSum > 0) {
            Intent intent = new Intent(getActivity(), AddEditRepairOrderActivity.class);
            intent.putExtra("Source","NEW_REPAIR_ORDER");
            startActivity(intent);
        }


    }




    //this method is called after the start button is clicked
    public void startPayPeriod(View rootView) throws ParseException {
        //this block is to find all the views that will be set to GONE
        View noActive = rootView.findViewById(R.id.textViewPayPeriodEmpty);
        View whatToDo = rootView.findViewById(R.id.textViewInfo);
        View startText = rootView.findViewById(R.id.textViewStart);
        View endText = rootView.findViewById(R.id.textViewEnd);
        mStartDate = rootView.findViewById(R.id.startDateButton);
        mEndDate = rootView.findViewById(R.id.endDateButton);
        startPayPeriodButton = rootView.findViewById(R.id.startPayPeriod);


        //this block finds all the views that will be set to VISIBLE
        addRepairOrder = rootView.findViewById(R.id.add_repair_order);
        View listView = rootView.findViewById(R.id.listViewPayPeriod);

        //this variable is to grab an instance of the DateFormat and Calender
        DateFormat format = DateFormat.getDateInstance();

        //gets the string values found on the buttons for start and end dates
        String sText = mStartDate.getText().toString();
        String eText = mEndDate.getText().toString();

        // this parses the string values found on the buttons
        Date sDate = format.parse(sText);
        Date eDate = format.parse(eText);

        // this will be used to make sure the START DATE is equal to or earlier than today's date
        Calendar dateToday = Calendar.getInstance();
        Date date = dateToday.getTime();

        String endDateString = DateFormat.getDateInstance(DateFormat.DEFAULT).format(eDate.getTime());
        String currentDateString = DateFormat.getDateInstance(DateFormat.DEFAULT).format(dateToday.getTime());


        //control flow statement to check dates then set views VISIBLE to GONE and vice versa
        // and set toast messages
        if(eDate.before(sDate)){

            Toast dateEarlyToast = Toast.makeText(getActivity(), "END DATE cannot be earlier than START DATE", Toast.LENGTH_LONG);
            dateEarlyToast.setGravity(Gravity.BOTTOM, 0,400);
            dateEarlyToast.show();

        } else if(sDate.after(date)){

            Toast futureToast = Toast.makeText(getActivity(), "START DATE cannot be later than toady's date", Toast.LENGTH_LONG);
            futureToast.setGravity(Gravity.BOTTOM, 0,400);
            futureToast.show();

        } else if (eDate.before(date)) {

            if(endDateString.equals(currentDateString)){
                noActive.setVisibility(View.GONE);
                whatToDo.setVisibility(View.GONE);
                startText.setVisibility(View.GONE);
                endText.setVisibility(View.GONE);
                mStartDate.setVisibility(View.GONE);
                mEndDate.setVisibility(View.GONE);
                startPayPeriodButton.setVisibility(View.GONE);

                addRepairOrder.setVisibility(View.VISIBLE);
                listView.setVisibility(View.VISIBLE);

                //changes the status to if pay period is active
                hasNoActivePayPeriod = false;

                Toast startedToast = Toast.makeText(getActivity(), "New pay period started", Toast.LENGTH_LONG);
                startedToast.setGravity(Gravity.CENTER_HORIZONTAL, 0,0);
                startedToast.show();
            } else {
                Toast dateEarlyToast = Toast.makeText(getActivity(), "END DATE cannot be earlier than today's date", Toast.LENGTH_LONG);
                dateEarlyToast.setGravity(Gravity.BOTTOM, 0, 400);
                dateEarlyToast.show();
            }

        } else if(eDate.after(sDate) || eDate.equals(sDate)) {

                noActive.setVisibility(View.GONE);
                whatToDo.setVisibility(View.GONE);
                startText.setVisibility(View.GONE);
                endText.setVisibility(View.GONE);
                mStartDate.setVisibility(View.GONE);
                mEndDate.setVisibility(View.GONE);
                startPayPeriodButton.setVisibility(View.GONE);

                addRepairOrder.setVisibility(View.VISIBLE);
                listView.setVisibility(View.VISIBLE);

                //changes the status to if pay period is active
                hasNoActivePayPeriod = false;

                Toast startedToast = Toast.makeText(getActivity(), "New pay period started", Toast.LENGTH_LONG);
                startedToast.setGravity(Gravity.CENTER_HORIZONTAL, 0,0);
                startedToast.show();
        }

    }


    //this method is used for when the pay period has no active pay period and the state and
    // end date pickers are visible to select.
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.startDateButton) {
            mDateDialogFragment.setFlag(PayPeriodFragment.DateDialogFragment.FLAG_START_DATE);
            mDateDialogFragment.show(getChildFragmentManager(), "datePicker");
        } else if (id == R.id.endDateButton) {
            mDateDialogFragment.setFlag(PayPeriodFragment.DateDialogFragment.FLAG_END_DATE);
            mDateDialogFragment.show(getChildFragmentManager(), "datePicker");
        }
    }



    //to disable and enable menu items based on active pay period
    @Override
    public void onPrepareOptionsMenu (Menu menu) {

        if(hasNoActivePayPeriod) {
            menu.getItem(1).setEnabled(false);
            menu.getItem(3).setEnabled(false);
        } else {
            menu.getItem(1).setEnabled(true);
            menu.getItem(3).setEnabled(true);
        }


    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu options from the res/menu/menu_main.xml file.
        // This adds menu items to the app bar.

        inflater.inflate(R.menu.menu_main, menu);


    }



    //inner class
    public static class DateDialogFragment extends DialogFragment implements
            DatePickerDialog.OnDateSetListener {
        public static final int FLAG_START_DATE = 0;
        public static final int FLAG_END_DATE = 1;

        private int flag = 0;

        //holds the value to mStartDate in PayPeriodFragment
        public Button dateStart;

        //holds the value to mEndDate in PayPeriodFragment
        public Button dateEnd;


        private PayPeriodFragment fragment;

        public DateDialogFragment(){
            // Required empty public constructor
        }


        //  access the members of parentFragment
        // and still not want to make members static in fragment
        // (since fragment should be public static)
        @Override
        public void onAttach(Context context) {
            super.onAttach(context);

            fragment = (PayPeriodFragment) getParentFragment();

            assert fragment != null;
            // accessing the members of outer fragment
            dateStart = fragment.mStartDate;
            // accessing the members of outer fragment
            dateEnd = fragment.mEndDate;
        }



        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(Objects.requireNonNull(getActivity()), this, year, month, day);
        }

        public void setFlag(int i) {
            flag = i;
        }

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, monthOfYear, dayOfMonth);

            String currentDateString = DateFormat.getDateInstance(DateFormat.DEFAULT).format(calendar.getTime());

            if (flag == FLAG_START_DATE) {
                dateStart.setText(currentDateString);
            } else if (flag == FLAG_END_DATE) {
                dateEnd.setText(currentDateString);
            }
        }



    }
}
