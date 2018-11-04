package com.techtimeapp.techtime.view.view.view;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.techtimeapp.techtime.R;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Objects;

public class EmptyPayPeriodActivity extends AppCompatActivity implements View.OnClickListener {


    //start date seen on activity
    private Button mStartDate;
    //end date seen on activity
    private Button mEndDate;

    private DatePickerDialogFragment mDatePickerDialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_pay_period);
        //allows the activity to remain in portrait only
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mStartDate = findViewById(R.id.startDateButton);
        mEndDate = findViewById(R.id.endDateButton);

        //set the current date to the startDate
        Calendar calendar = Calendar.getInstance();
        String currentDateString = DateFormat.getDateInstance(DateFormat.DEFAULT).format(calendar.getTime());
        mStartDate.setText(currentDateString);

        mDatePickerDialogFragment = new DatePickerDialogFragment();

        mStartDate.setOnClickListener(this);
        mEndDate.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.startDateButton) {
            mDatePickerDialogFragment.setFlag(EmptyPayPeriodActivity.DatePickerDialogFragment.FLAG_START_DATE);
            mDatePickerDialogFragment.show(getSupportFragmentManager(), "datePicker");
        } else if (id == R.id.endDateButton) {
            mDatePickerDialogFragment.setFlag(EmptyPayPeriodActivity.DatePickerDialogFragment.FLAG_END_DATE);
            mDatePickerDialogFragment.show(getSupportFragmentManager(), "datePicker");
        }
    }





    public static class DatePickerDialogFragment extends DialogFragment implements
            DatePickerDialog.OnDateSetListener {
        public static final int FLAG_START_DATE = 0;
        public static final int FLAG_END_DATE = 1;

        private int flag = 0;

        private EmptyPayPeriodActivity activity;

        //holds the value to mStartDate in EmptyPayPeriod
        public Button dateStart;
        //holds the value to mEndDate in EmptyPayPeriod
        public Button dateEnd;


        public DatePickerDialogFragment(){
            // Required empty public constructor
        }


        //  access the members of outer-class (Activity)
        // and still not want to make members static in Activity
        // (since fragment should be public static)
        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            activity = (EmptyPayPeriodActivity) getActivity();

            assert activity != null;
            // accessing the members of outer activity
            dateStart = activity.mStartDate;
            // accessing the members of outer activity
            dateEnd = activity.mEndDate;
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
