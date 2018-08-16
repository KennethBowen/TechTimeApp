package com.techtimeapp.techtime;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class PayPeriodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_category);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new PayPeriodFragment())
                .commit();

    }
}
