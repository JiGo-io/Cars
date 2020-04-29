package com.telran.cars.presentation.main.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.telran.cars.R;
import com.telran.cars.data.dto.CarForUsersDto;
import com.telran.cars.data.dto.CarsFiltersDto;

import java.util.ArrayList;
import java.util.List;

public class MapAdapter extends RecyclerView.Adapter<MapAdapter.MyViewHolder> {
    private List<CarsFiltersDto> list = new ArrayList<>();
    private  OnRowClickListener listener;
    private Context context;

    public MapAdapter(Context context, OnRowClickListener listener) {
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.threebestcar_map_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CarsFiltersDto car = list.get(position);
        String url = car.getImage_url()[0];
        Picasso.get().load(url).into(holder.image);
        String seats = "";
        seats = String.valueOf(car.getSeats());
        String dors = "";
        dors = String.valueOf(car.getDoors());
        holder.seatTxt.setText(seats);
        holder.dorsTxt.setText(dors);
        holder.transTxt.setText(car.getWheels_drive());
        holder.modelTxt.setText(car.getMake() + " " + car.getModel());
    }

    public void setCars(@Nullable List<CarsFiltersDto> cars){
        if (cars == null){
            return;
        }
        list.clear();
        list.addAll(cars);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView seatTxt, dorsTxt, transTxt, modelTxt;
        ImageView image;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            seatTxt = itemView.findViewById(R.id.seatTxt);
            dorsTxt = itemView.findViewById(R.id.dorsTxt);
            transTxt = itemView.findViewById(R.id.transTxt);
            modelTxt = itemView.findViewById(R.id.modelTxt);
            image = itemView.findViewById(R.id.carImg);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("MY_TAG", "onClick: itemView" + listener.toString());
                    if (listener != null){
                        int pos = getAdapterPosition();
                        listener.onClickAdapter(pos, list.get(pos));
                    }
                }
            });
        }
    }
    interface OnRowClickListener{
        void onClickAdapter(int position, CarsFiltersDto car);
    }
}
