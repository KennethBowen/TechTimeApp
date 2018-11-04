package com.techtimeapp.techtime.view.view.view;



import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

import com.techtimeapp.techtime.R;
import com.techtimeapp.techtime.view.view.logic.AddEditRepairOrderActivity;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Objects;

public class PayPeriodFragment extends Fragment implements View.OnClickListener {


    //start date seen on activity
    public Button mStartDate;
    //end date seen on activity
    public Button mEndDate;

    private DateDialogFragment mDateDialogFragment;


    public PayPeriodFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.activity_pay_period, container, false);


        //add repair order button for when the pay period is active
        Button addRepairOrder = rootView.findViewById(R.id.add_repair_order);


        // onClick listener for add repair order button
        addRepairOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddEditRepairOrderActivity.class);
                startActivity(intent);
            }
        });



        mStartDate = rootView.findViewById(R.id.startDateButton);
        mEndDate = rootView.findViewById(R.id.endDateButton);

        //set the current date to the startDate
        Calendar calendar = Calendar.getInstance();
        String currentDateString = DateFormat.getDateInstance(DateFormat.DEFAULT).format(calendar.getTime());
        mStartDate.setText(currentDateString);

        mDateDialogFragment = new DateDialogFragment();

        mStartDate.setOnClickListener(this);
        mEndDate.setOnClickListener(this);

        return rootView;
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.startDateButton) {
            mDateDialogFragment.setFlag(PayPeriodFragment.DateDialogFragment.FLAG_START_DATE);
            assert getFragmentManager() != null;
            mDateDialogFragment.show(getFragmentManager(), "datePicker");
        } else if (id == R.id.endDateButton) {
            mDateDialogFragment.setFlag(PayPeriodFragment.DateDialogFragment.FLAG_END_DATE);
            assert getFragmentManager() != null;
            mDateDialogFragment.show(getFragmentManager(), "datePicker");
        }
    }

    public static class DateDialogFragment extends DialogFragment implements
            DatePickerDialog.OnDateSetListener {
        public static final int FLAG_START_DATE = 0;
        public static final int FLAG_END_DATE = 1;

        private int flag = 0;

        //holds the value to mStartDate in PayPeriodFragment
        public Button dateStart;
        //holds the value to mEndDate in PayPeriodFragment
        public Button dateEnd;


        public DateDialogFragment(){
            // Required empty public constructor
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
                //dateStart.setText(currentDateString);
            } else if (flag == FLAG_END_DATE) {
                //dateEnd.setText(currentDateString);
            }
        }
    }
}
