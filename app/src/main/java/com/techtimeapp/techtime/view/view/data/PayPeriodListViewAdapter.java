package com.techtimeapp.techtime.view.view.data;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.techtimeapp.techtime.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class PayPeriodListViewAdapter extends BaseAdapter {

    public Context context;
    public ArrayList<RepairOrder> arrayList;

    public PayPeriodListViewAdapter(Context context, ArrayList<RepairOrder> arrayList){

        this.context = context;
        this.arrayList = arrayList;

    }


    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //format for Hours
        DecimalFormat dot = new DecimalFormat("##.0");

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_item_pay_period, null);


        TextView roNumberTextView = (TextView) convertView.findViewById(R.id.repairOrderNumberListItem);
        TextView writerTextView = (TextView) convertView.findViewById(R.id.repairOrderWriterListItem);
        TextView dateTextView = (TextView) convertView.findViewById(R.id.repairOrderDateListItem);
        TextView grossTextView = (TextView) convertView.findViewById(R.id.repairOrderGrossListItem);
        final Button hoursTextView = (Button) convertView.findViewById(R.id.hoursButtonListItem);


        RepairOrder repairOrder = arrayList.get(position);


        roNumberTextView.setText(String.valueOf(repairOrder.getmRepairOrderNumber()));
        writerTextView.setText(repairOrder.getmWriter());
        dateTextView.setText(repairOrder.getmDate());
        grossTextView.setText(String.valueOf(NumberFormat.getCurrencyInstance().format(repairOrder.getmTotalGross())));
        hoursTextView.setText(String.valueOf(dot.format(repairOrder.getmTotalHours())));

        hoursTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Pay Roll Matches", Toast.LENGTH_SHORT).show();

            }
        });



        return convertView;
    }
}
