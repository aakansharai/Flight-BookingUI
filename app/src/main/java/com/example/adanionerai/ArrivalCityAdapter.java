package com.example.adanionerai;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ArrivalCityAdapter extends RecyclerView.Adapter<ArrivalCityAdapter.MyViewHolder> {

    ArrayList<city> city;
    Context c;

    public ArrivalCityAdapter(FlightBooking_page flightBooking_page, ArrayList<city> city) {
        this.city = city;
        this.c = flightBooking_page;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_with_airport_item_layout, parent,false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.city.setText(city.get(position).city);
        holder.cityCode.setText(city.get(position).cityCode);
        holder.country.setText(city.get(position).country);
        holder.airport.setText(city.get(position).airport);
    }

    @Override
    public int getItemCount() {
        return city.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder  {
        TextView city;
        TextView cityCode;
        TextView country;
        TextView airport;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            city = itemView.findViewById(R.id.city);
            cityCode = itemView.findViewById(R.id.cityCode);
            country = itemView.findViewById(R.id.country);
            airport = itemView.findViewById(R.id.Airport);


        }
    }
}
