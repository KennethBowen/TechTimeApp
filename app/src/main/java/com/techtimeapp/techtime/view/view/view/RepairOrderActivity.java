package com.techtimeapp.techtime.view.view.view;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.techtimeapp.techtime.R;
import com.techtimeapp.techtime.view.view.data.RepairOrderHelper;
import com.techtimeapp.techtime.view.view.logic.AddEditRepairOrderActivity;


public class RepairOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repair_order);
        //allows the activity to remain in portrait only
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setRepairOrderContent();

    }



    public void setRepairOrderContent(){

        //DecimalFormat formatter = new DecimalFormat("#,###");
        //Hours
        //DecimalFormat position = new DecimalFormat("##.0");

        RepairOrderHelper repairOrderHelper = new RepairOrderHelper(this);

        TextView roNumber = findViewById(R.id.repairOrderNumber);
        String roString = repairOrderHelper.getROnumber();
        roNumber.setText(roString);

        TextView writerView = findViewById(R.id.repairOrderWriter);
        String writer = repairOrderHelper.getWriter();
        writerView.setText(writer);

        TextView dateView = findViewById(R.id.repairOrderDate);
        String date = repairOrderHelper.getDate();
        dateView.setText(date);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_main.xml file.
        // This adds menu items to the app bar.

        getMenuInflater().inflate(R.menu.menu_repair_order, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the edit option
            case R.id.action_edit:
                Intent intentEditRepairOrder = new Intent(RepairOrderActivity.this, AddEditRepairOrderActivity.class);
                intentEditRepairOrder.putExtra("Source","EDIT_REPAIR_ORDER");
                startActivity(intentEditRepairOrder);

                return true;
            // Respond to a click on the "Delete" menu option
            case R.id.action_delete:
                // Pop up confirmation dialog for deletion

                return true;



        }
        return super.onOptionsItemSelected(item);
    }
}
