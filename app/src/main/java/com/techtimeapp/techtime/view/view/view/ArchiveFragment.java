package com.techtimeapp.techtime.view.view.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.techtimeapp.techtime.R;


public class ArchiveFragment extends Fragment{


    public ArchiveFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.activity_archive, container, false);

        //disables the use of menu held in MainActivity
        setHasOptionsMenu(false);

        View listView = rootView.findViewById(R.id.listViewArchive);


        return rootView;
    }


}
