package com.techtimeapp.techtime.view.view.view;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.techtimeapp.techtime.R;


public class PayPeriodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_category);
        //allows the activity to remain in portrait only
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new PayPeriodFragment())
                .commit();

    }
}
