package com.javierpinya.piservice.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.javierpinya.piservice.Adapters.CompartimentosAdapter;
import com.javierpinya.piservice.R;

import java.util.ArrayList;
import java.util.List;

public class CompartimentosActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<String> num_comp = new ArrayList<>();
    private List<Integer> capacidad = new ArrayList<>();
    private List<Integer> altura = new ArrayList<>();
    private List<String> tag = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compartimentos);

        mRecyclerView = findViewById(R.id.rv_compartimentos);
        mLayoutManager = new LinearLayoutManager(this);

        for (int i=1;i<7;i++){
            num_comp.add(String.valueOf(i));
            tag.add("011022" + i);
        }
        capacidad.add(5000);
        capacidad.add(2000);
        capacidad.add(12000);
        capacidad.add(2000);
        capacidad.add(5000);
        capacidad.add(7000);

        altura.add(1600);
        altura.add(1610);
        altura.add(1500);
        altura.add(1630);
        altura.add(1640);
        altura.add(1640);

        mAdapter = new CompartimentosAdapter(num_comp,capacidad,altura,tag,R.layout.listview_compartimentos);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


    }
}
