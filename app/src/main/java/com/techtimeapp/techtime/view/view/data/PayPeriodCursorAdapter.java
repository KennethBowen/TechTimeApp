package com.techtimeapp.techtime.view.view.data;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.techtimeapp.techtime.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class PayPeriodCursorAdapter extends CursorAdapter {

    public PayPeriodCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item_pay_period, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        DecimalFormat dot = new DecimalFormat("##.0");

        TextView roNumberTextView = (TextView) view.findViewById(R.id.repairOrderNumberListItem);
        TextView writerTextView = (TextView) view.findViewById(R.id.repairOrderWriterListItem);
        TextView dateTextView = (TextView) view.findViewById(R.id.repairOrderDateListItem);
        TextView grossTextView = (TextView) view.findViewById(R.id.repairOrderGrossListItem);
        Button hoursTextView = (Button) view.findViewById(R.id.hoursButtonListItem);

        int roColumnIndex = cursor.getColumnIndex(RepairOrderHelper.COL2);
        int writerColumnIndex = cursor.getColumnIndex(RepairOrderHelper.COL3);
        int dateColumnIndex = cursor.getColumnIndex(RepairOrderHelper.COL5);
        int grossColumnIndex = cursor.getColumnIndex(RepairOrderHelper.COL36);
        int hoursColumnIndex = cursor.getColumnIndex(RepairOrderHelper.COL44);


        String ROString = cursor.getString(roColumnIndex);
        String writer = cursor.getString(writerColumnIndex);
        String date = cursor.getString(dateColumnIndex);
        String totalGrossString = String.valueOf(NumberFormat.getCurrencyInstance().format(cursor.getString(grossColumnIndex)));
        String totalHoursString = String.valueOf(dot.format(cursor.getString(hoursColumnIndex)));



        roNumberTextView.setText(ROString);
        writerTextView.setText(writer);
        dateTextView.setText(date);
        grossTextView.setText(totalGrossString);
        hoursTextView.setText(totalHoursString);
    }
}
