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
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.techtimeapp.techtime.R;
import com.techtimeapp.techtime.view.view.logic.AddEditRepairOrderActivity;


import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class PayPeriodFragment extends Fragment implements View.OnClickListener {


    //start date seen on activity
    public Button mStartDate;

    //end date seen on activity
    public Button mEndDate;

    //start pay period button for the pay period is active
    Button startPayPeriodButton;

    //add repair order button for the pay period is active
    Button addRepairOrder;

    // inner call for the calender dial log object
    private DateDialogFragment mDateDialogFragment;



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

        mStartDate.setOnClickListener(this);
        mEndDate.setOnClickListener(this);


        // onClick listener for add repair order button
        addRepairOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddEditRepairOrderActivity.class);
                startActivity(intent);
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


        return rootView;
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

        //these variables are to grab an instance of the DateFormat and Calender
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




        //control flow statement to check dates then set views VISIBLE to GONE and vice versa
        // and set toast messages
        if(eDate.before(sDate)){

            Toast dateEarlyToast = Toast.makeText(getActivity(), "END DATE cannot be earlier than START DATE", Toast.LENGTH_LONG);
            dateEarlyToast.setGravity(Gravity.BOTTOM, 0,400);
            dateEarlyToast.show();

        }else if(eDate.after(sDate) || eDate.equals(sDate)) {

            if(sDate.after(date)){
                Toast futureToast = Toast.makeText(getActivity(), "START DATE can only be today's date or earlier", Toast.LENGTH_LONG);
                futureToast.setGravity(Gravity.BOTTOM, 0,400);
                futureToast.show();
            } else {
                noActive.setVisibility(View.GONE);
                whatToDo.setVisibility(View.GONE);
                startText.setVisibility(View.GONE);
                endText.setVisibility(View.GONE);
                mStartDate.setVisibility(View.GONE);
                mEndDate.setVisibility(View.GONE);
                startPayPeriodButton.setVisibility(View.GONE);

                addRepairOrder.setVisibility(View.VISIBLE);
                listView.setVisibility(View.VISIBLE);

                Toast startedToast = Toast.makeText(getActivity(), "New pay period started", Toast.LENGTH_LONG);
                startedToast.setGravity(Gravity.CENTER_HORIZONTAL, 0,0);
                startedToast.show();
            }



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
