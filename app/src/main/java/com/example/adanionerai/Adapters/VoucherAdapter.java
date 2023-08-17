package com.example.adanionerai.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adanionerai.ModelClass.VoucherData;
import com.example.adanionerai.R;

import java.util.ArrayList;


public class VoucherAdapter extends RecyclerView.Adapter<VoucherAdapter.MyViewHolder>{

    ArrayList<VoucherData> data;
    Context ctx;

    public VoucherAdapter(ArrayList<VoucherData> data, Context ctx) {
        this.data = data;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.voucher_item_layout, parent, false);
        MyViewHolder view = new MyViewHolder(v);
        return view;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageView.setImageResource(data.get(position).getImage());
        holder.textView.setText(data.get(position).getRewards());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView= itemView.findViewById(R.id.voucherImage);
            textView = itemView.findViewById(R.id.earnReward);
        }
    }
}
