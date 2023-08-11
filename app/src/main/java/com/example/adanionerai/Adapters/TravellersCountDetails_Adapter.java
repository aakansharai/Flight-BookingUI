package com.example.adanionerai.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adanionerai.R;

public class TravellersCountDetails_Adapter extends RecyclerView.Adapter<TravellersCountDetails_Adapter.MyViewHolder> {

    int adult, children, infant;
//    ArrayList<String> adult;
    Context ctx;

    public TravellersCountDetails_Adapter(int adult, int children, int infant, Context ctx) {
        this.adult = adult;
        this.children = children;
        this.infant = infant;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.traveller_details_adapter, parent, false);
        MyViewHolder view = new MyViewHolder(v);
        return view;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.adult.setLayoutManager(new LinearLayoutManager(ctx.getApplicationContext()));
        AdultAdapter adultAdapter = new AdultAdapter(adult, ctx);
        holder.adult.setAdapter(adultAdapter);

        holder.children.setLayoutManager(new LinearLayoutManager(ctx.getApplicationContext()));
        ChildrenAdapter childrenAdapter = new ChildrenAdapter(children, ctx);
        holder.children.setAdapter(childrenAdapter);

        holder.infant.setLayoutManager(new LinearLayoutManager(ctx.getApplicationContext()));
        InfantAdapter infantAdapter = new InfantAdapter(infant, ctx);
        holder.infant.setAdapter(infantAdapter);

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        RecyclerView adult, children, infant;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            adult = itemView.findViewById(R.id.AdultsRecycler);
            children = itemView.findViewById(R.id.ChildrenRecycler);
            infant = itemView.findViewById(R.id.InfantsRecycler);
        }
    }

}
