package com.javierpinya.piservice.Adapters;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.javierpinya.piservice.R;

import java.util.List;

public class CisternaAdapter extends RecyclerView.Adapter<CisternaAdapter.ViewHolder> {

    private List<String> matriculas;
    private int layout;
    private OnItemClickListener itemClickListener;

    public CisternaAdapter(List<String> matriculas, int layout, OnItemClickListener listener) {
        this.matriculas = matriculas;
        this.layout = layout;
        this.itemClickListener = listener;
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
        holder.bind(matriculas.get(position),itemClickListener);
    }

    @Override
    public int getItemCount() {
        return matriculas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvmat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvmat = itemView.findViewById(R.id.tvTractora);
        }

        public void bind(String matricula, OnItemClickListener listener) {
            tvmat.setText(matricula);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    listener.onItemClick(matricula,getAdapterPosition());
                }
            });
        }
    }

    public interface OnItemClickListener{
        void onItemClick(String mat, int position);
    }
}
