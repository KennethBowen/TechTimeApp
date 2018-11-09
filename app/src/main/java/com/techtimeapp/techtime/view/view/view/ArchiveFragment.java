package com.techtimeapp.techtime.view.view.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.techtimeapp.techtime.R;

import java.util.Objects;


public class ArchiveFragment extends Fragment {


    public ArchiveFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.activity_archive, container, false);

        View listView = rootView.findViewById(R.id.listViewArchive);





        return rootView;
    }


}
