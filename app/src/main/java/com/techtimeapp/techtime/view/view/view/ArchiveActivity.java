package com.techtimeapp.techtime.view.view.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.techtimeapp.techtime.R;

public class ArchiveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_category);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new ArchiveFragment())
                .commit();

    }
}
