package com.techtimeapp.techtime.view.view.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.techtimeapp.techtime.R;
import com.techtimeapp.techtime.view.view.logic.AddEditRepairOrderActivity;


public class PayPeriodFragment extends Fragment {


    public PayPeriodFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.activity_pay_period, container, false);

        Button addRepairOrder = (Button) rootView.findViewById(R.id.add_repair_order);

        // onClick listener for add repair order button
        addRepairOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddEditRepairOrderActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }





}
