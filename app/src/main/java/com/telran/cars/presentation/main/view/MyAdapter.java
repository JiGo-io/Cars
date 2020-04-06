package com.telran.cars.presentation.main.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.telran.cars.R;
import com.telran.cars.data.dto.test.Person;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Person> list;
    private  OnRowClickListener listener;

    public MyAdapter() {
        list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            list.add(new Person("Person " + i, "Phone " + i));

        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.threebestcar_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Person p = list.get(position);
        holder.nameTxt.setText(p.getName());
        holder.phoneTxt.setText(p.getPhone());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nameTxt;
        TextView phoneTxt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTxt = itemView.findViewById(R.id.nameTxt);
            phoneTxt = itemView.findViewById(R.id.phoneTxt);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int pos = getAdapterPosition();
                        listener.onClick(pos, list.get(pos));
                    }
                }
            });
        }
    }
    interface OnRowClickListener{
        void onClick(int position, Person p);
    }
}
