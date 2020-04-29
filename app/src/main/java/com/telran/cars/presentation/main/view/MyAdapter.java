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

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<CarForUsersDto> list = new ArrayList<>();
    private OnRowClickListener listener;
    private Context context;

    public MyAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.threebestcar_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CarForUsersDto car = list.get(position);
        String url = car.getImage_url()[0];
        if (url == null) {
            url = car.getImage_url()[1];
        }
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

    public void setCars(@Nullable List<CarForUsersDto> cars) {
        if (cars == null) {
            return;
        }
        list.clear();
        list.addAll(cars);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
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
                    if (listener != null) {
                        int pos = getAdapterPosition();
                        listener.onClickAdapter(pos, list.get(pos));
                    }
                }
            });
        }
    }

    interface OnRowClickListener {
        void onClickAdapter(int position, CarForUsersDto car);
    }
}
