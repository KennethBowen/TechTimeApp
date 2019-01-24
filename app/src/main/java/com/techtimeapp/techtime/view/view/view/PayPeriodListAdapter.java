package com.techtimeapp.techtime.view.view.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.techtimeapp.techtime.R;
import com.techtimeapp.techtime.view.view.data.RepairOrder;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Objects;

public class PayPeriodListAdapter extends ArrayAdapter<RepairOrder> {
    private Context mContext;
    private  int mResource;

    public PayPeriodListAdapter(Context context, int resource, ArrayList<RepairOrder> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }


    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        //format for Hours
        DecimalFormat dot = new DecimalFormat("##.0");

        int RONumber = Objects.requireNonNull(getItem(position)).getmRepairOrderNumber();
        String ROString = String.valueOf(RONumber);
        String writer = Objects.requireNonNull(getItem(position)).getmWriter();
        String date = Objects.requireNonNull(getItem(position)).getmDate();
        double totalGross = Objects.requireNonNull(getItem(position)).getmTotalGross();
        String totalGrossString = String.valueOf(NumberFormat.getCurrencyInstance().format(totalGross));
        double totalHours = Objects.requireNonNull(getItem(position)).getmTotalHours();
        String totalHoursString = String.valueOf(dot.format(totalHours));


        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView roNumberTextView = (TextView) convertView.findViewById(R.id.repairOrderNumberListItem);
        TextView writerTextView = (TextView) convertView.findViewById(R.id.repairOrderWriterListItem);
        TextView dateTextView = (TextView) convertView.findViewById(R.id.repairOrderDateListItem);
        TextView grossTextView = (TextView) convertView.findViewById(R.id.repairOrderGrossListItem);
        Button hoursTextView = (Button) convertView.findViewById(R.id.hoursButtonListItem);

        roNumberTextView.setText(ROString);
        writerTextView.setText(writer);
        dateTextView.setText(date);
        grossTextView.setText(totalGrossString);
        hoursTextView.setText(totalHoursString);

        return convertView;
    }
}
