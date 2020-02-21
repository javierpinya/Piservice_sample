package com.javierpinya.piservice.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.javierpinya.piservice.Activities.BuscarCisternaActivity;
import com.javierpinya.piservice.Activities.BuscarInspeccionActivity;
import com.javierpinya.piservice.Activities.BuscarTractoraActivity;
import com.javierpinya.piservice.Activities.NuevaInspeccionActivity;
import com.javierpinya.piservice.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {

    private Button btnBuscarT, btnBuscarI, btnNuevaI, btnBuscarC;

    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        btnBuscarT = view.findViewById(R.id.btnbuscart);
        btnBuscarI = view.findViewById(R.id.btnbuscari);
        btnNuevaI = view.findViewById(R.id.btnnuevai);
        btnBuscarC = view.findViewById(R.id.btnbuscarcisterna);

        btnNuevaI.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), NuevaInspeccionActivity.class);
                startActivity(intent);
            }
        });
        btnBuscarI.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), BuscarInspeccionActivity.class);
                startActivity(intent);
            }
        });
        btnBuscarT.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), BuscarTractoraActivity.class);
                startActivity(intent);
            }
        });

        btnBuscarC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), BuscarCisternaActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }

}
