package com.techtimeapp.techtime.view.view.view;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.techtimeapp.techtime.R;
import com.techtimeapp.techtime.view.view.logic.LaborRatesActivity;

import static com.techtimeapp.techtime.R.id.sliding_tabs;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        //allows the activity to remain in portrait only
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //action bar techtime name logic
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.drawable.techtime_name);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);


        TabLayout tabLayout = (TabLayout) findViewById(sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_main.xml file.
        // This adds menu items to the app bar.

            getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Labor Rates" menu option
            case R.id.labor_rates:
                Intent intentLabor = new Intent(MainActivity.this, LaborRatesActivity.class);
                startActivity(intentLabor);
                return true;

            // Respond to a click on the "Edit Pay Period Dates" menu option
            case R.id.edit_pay_period_dates:
                Intent intentEditPayPeriod = new Intent(MainActivity.this, EditPayPeriodActivity.class);
                startActivity(intentEditPayPeriod);
                return true;

            // Respond to a click on the "Order By" menu option
            case R.id.order_by:
                Intent intentOrderBy = new Intent(MainActivity.this, OrderByActivity.class);
                startActivity(intentOrderBy);
                return true;

            // Respond to a click on the "End Pay Period" menu option
            case R.id.end_pay_period:

                //!!!!!THIS IS JUST A TEMPORARY INTENT TO SEE THE REPAIR ORDER ACTIVITY!!!!
                //Intent intentRepairOrder = new Intent(MainActivity.this, RepairOrderActivity.class);
                //startActivity(intentRepairOrder);

                //!!!!!THIS IS JUST A TEMPORARY INTENT TO SEE THE EMPTY PAY PERIOD ACTIVITY!!!!
                //Intent intentRepairOrder = new Intent(MainActivity.this, EmptyPayPeriodActivity.class);
                //startActivity(intentRepairOrder);

                //!!!!!THIS IS JUST A TEMPORARY INTENT TO SEE THE EMPTY ARCHIVE ACTIVITY!!!!
                //Intent intentEmptyArchive = new Intent(MainActivity.this, EmptyArchiveActivity.class);
                //startActivity(intentEmptyArchive);

                //!!!!!THIS IS JUST A TEMPORARY INTENT TO SEE THE ARCHIVED PAY PERIOD ACTIVITY!!!!
                Intent intentArchivedPayPeriod = new Intent(MainActivity.this, ArchivedPayPeriodActivity.class);
                startActivity(intentArchivedPayPeriod);

                return true;

        }
        return super.onOptionsItemSelected(item);
    }


}
