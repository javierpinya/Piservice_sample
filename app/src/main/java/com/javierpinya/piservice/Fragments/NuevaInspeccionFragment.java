package com.javierpinya.piservice.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.javierpinya.piservice.Activities.CapturaFotoActivity;
import com.javierpinya.piservice.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NuevaInspeccionFragment extends Fragment {

    private FloatingActionButton fab;


    public NuevaInspeccionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nueva_inspeccion, container, false);

        fab = view.findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CapturaFotoActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
