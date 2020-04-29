package com.telran.cars.presentation.main.view;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.telran.cars.R;

import java.util.ArrayList;
import java.util.List;

public class CarInfoAdapter extends RecyclerView.Adapter<CarInfoAdapter.MyViewHolder> {
    private List<String> list = new ArrayList<>();

    public CarInfoAdapter(List<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.carinfo_row,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String image = list.get(position);
        Picasso.get().load(image).into(holder.image);
        holder.seatTxt.setText("5");
        holder.dorsTxt.setText("4");
        holder.transTxt.setText("Manual");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView seatTxt, dorsTxt, transTxt;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.carImg);
            seatTxt = itemView.findViewById(R.id.seatTxt);
            dorsTxt = itemView.findViewById(R.id.dorsTxt);
            transTxt = itemView.findViewById(R.id.transTxt);
        }

        public void onItemClick(int id) {
            Log.d("MY_TAG", "onItemClick: " + id);
        }
    }
}
