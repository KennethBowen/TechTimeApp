package com.techtimeapp.techtime.view.view.logic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.techtimeapp.techtime.R;
import com.techtimeapp.techtime.view.view.data.RepairOrder;

import java.util.List;

public class RepairOrderAdapter extends ArrayAdapter<RepairOrder> {


    public RepairOrderAdapter(Context context, List<RepairOrder> repairorder) {
        super(context, 0, repairorder);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_pay_period, parent, false);
        }


        return listItemView;
    }
}
