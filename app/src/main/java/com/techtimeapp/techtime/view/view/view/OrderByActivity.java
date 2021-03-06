package com.techtimeapp.techtime.view.view.view;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.techtimeapp.techtime.R;

public class OrderByActivity extends AppCompatActivity {

    RadioGroup rg;
    RadioButton rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_by);
        //allows the activity to remain in portrait only
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        rg = (RadioGroup) findViewById(R.id.radioGroup);
    }

    public void rbClick(View v){
        int radioButtonId = rg.getCheckedRadioButtonId();
        rb = (RadioButton) findViewById(radioButtonId);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_main.xml file.
        // This adds menu items to the app bar.

        getMenuInflater().inflate(R.menu.menu_order_by, menu);

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
