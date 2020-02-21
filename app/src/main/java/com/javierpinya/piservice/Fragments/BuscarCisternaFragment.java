package com.javierpinya.piservice.Fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.javierpinya.piservice.Activities.ResultadoBuscarCisternaActivity;
import com.javierpinya.piservice.Adapters.CisternaAdapter;
import com.javierpinya.piservice.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BuscarCisternaFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button btnBuscar;
    private EditText etCis;
    private List<String> mat = new ArrayList<>();

    public BuscarCisternaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buscar_cisterna, container, false);

        btnBuscar = view.findViewById(R.id.btnbuscarcisterna);
        etCis = view.findViewById(R.id.etCisterna);

        mRecyclerView = view.findViewById(R.id.rv_resultadobuscarcisterna);
        mLayoutManager = new LinearLayoutManager(getActivity());

        mat.add("R0000AAA");
        mat.add("R0001AAB");
        mat.add("R0002AAA");
        mat.add("R0003AAB");
        mat.add("R0004AAA");
        mat.add("R0005AAB");

        btnBuscar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(etCis.getText().toString())){
                    InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(etCis.getWindowToken(), 0);
                    mAdapter = new CisternaAdapter(mat, R.layout.listview_resultado_buscar_vehiculos, new CisternaAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(String mat, int position) {
                            Intent intent = new Intent(getContext(), ResultadoBuscarCisternaActivity.class);
                            startActivity(intent);
                        }
                    });
                    mRecyclerView.setLayoutManager(mLayoutManager);
                    mRecyclerView.setAdapter(mAdapter);

                }else{
                    Toast.makeText(getActivity(), "Introduzca un valor", Toast.LENGTH_SHORT).show();
                }
            }
        });




        return view;
    }

}
