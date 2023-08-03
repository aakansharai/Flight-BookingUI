package com.example.adanionerai.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adanionerai.ModelClass.NameModel;
import com.example.adanionerai.R;

import java.util.ArrayList;

public class TravellerNameAdapter extends RecyclerView.Adapter<TravellerNameAdapter.MyViewHolder> {

    ArrayList<NameModel> name;
    Context ctx;

    public TravellerNameAdapter(ArrayList<NameModel> name, Context ctx) {
        this.name = name;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.traveller_names_itemlayout, parent, false);
        MyViewHolder view = new MyViewHolder(v);
        return view;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.title.setText(name.get(position).getTitle());
        holder.name.setText(name.get(position).getName());
        holder.type.setText(name.get(position).getTravellerType());
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title, name, type;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.TitleName);
            name = itemView.findViewById(R.id.Name);
            type = itemView.findViewById(R.id.TravellerType);
        }
    }
}
