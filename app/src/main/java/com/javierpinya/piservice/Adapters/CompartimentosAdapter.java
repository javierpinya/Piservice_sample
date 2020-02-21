package com.javierpinya.piservice.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.javierpinya.piservice.R;

import java.util.List;

public class CompartimentosAdapter extends RecyclerView.Adapter<CompartimentosAdapter.ViewHolder> {

    private List<String> num_comp;
    private List<Integer> capacidad;
    private List<Integer> altura;
    private List<String> tag;

    private int layout;


    public CompartimentosAdapter(List<String> num_comp, List<Integer> capacidad, List<Integer> altura, List<String> tag, int layout){
        this.num_comp = num_comp;
        this.capacidad = capacidad;
        this.altura = altura;
        this.tag = tag;
        this.layout = layout;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layoutParams);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(num_comp.get(position), capacidad.get(position), altura.get(position), tag.get(position));
    }

    @Override
    public int getItemCount() {
        return num_comp.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView num_comp,capacidad,altura,tag;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            num_comp = itemView.findViewById(R.id.num_comp_dato);
            capacidad = itemView.findViewById(R.id.capacidad_dato);
            altura = itemView.findViewById(R.id.alturasonda_dato);
            tag = itemView.findViewById(R.id.tag_dato);
        }


        public void bind(String num_comp, Integer capacidad, Integer altura, String tag) {
            this.num_comp.setText(num_comp);
            this.capacidad.setText(String.valueOf(capacidad));
            this.altura.setText(String.valueOf(altura));
            this.tag.setText(tag);
        }
    }
}
