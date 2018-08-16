package com.techtimeapp.techtime;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Provides the appropriate {@link Fragment} for a view pager.
 */
public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    public SimpleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new PayPeriodFragment();
        } else{
            return new ArchiveFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0:
                return "PAY PERIOD";
            case 1:
                return "ARCHIVE";
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
