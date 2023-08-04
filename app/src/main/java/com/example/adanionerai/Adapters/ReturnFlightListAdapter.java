package com.example.adanionerai.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adanionerai.ModelClass.FlightList;
import com.example.adanionerai.R;

import java.util.ArrayList;

public class ReturnFlightListAdapter extends RecyclerView.Adapter<ReturnFlightListAdapter.MyViewHolder> {

    ArrayList<FlightList> flightList;
    Context ctx;

    public ReturnFlightListAdapter(ArrayList<FlightList> flightList, Context ctx) {
        this.flightList = flightList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.retrun_flight_list_item, parent, false);
        MyViewHolder view = new MyViewHolder(v);
        return view;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.ticketRate.setText(flightList.get(position).getTicketCost());
        holder.totalTime.setText(flightList.get(position).getTotalTime());
        holder.departureTime.setText(flightList.get(position).getDepartureTime());
        holder.arrivalTime.setText(flightList.get(position).getArrivalTime());
        holder.Stops.setText(flightList.get(position).getStops());
        holder.flightImage.setImageResource(flightList.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return flightList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView flightName, departureTime, arrivalTime, totalTime, Stops, ticketRate;
        ImageView flightImage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            flightImage = itemView.findViewById(R.id.oneWayFlightIMG);
            flightName = itemView.findViewById(R.id.FlightName);
            departureTime = itemView.findViewById(R.id.timeFromOneWay);
            arrivalTime = itemView.findViewById(R.id.timeToOneWay);
            totalTime = itemView.findViewById(R.id.totalTimeTaken_OneWay);
            Stops = itemView.findViewById(R.id.StopsOneWay);
            ticketRate = itemView.findViewById(R.id.totalRate);
        }
    }
}
