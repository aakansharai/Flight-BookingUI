package com.example.adanionerai.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adanionerai.R;

import java.util.ArrayList;

public class SelectBankAdapter extends RecyclerView.Adapter<SelectBankAdapter.MyViewHolder> {

    ArrayList<String> bankName;
    Context ctx;

    public SelectBankAdapter(ArrayList<String> bankName, Context ctx) {
        this.bankName = bankName;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public SelectBankAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.bank_name_item_text, parent, false);
        MyViewHolder view = new MyViewHolder(v);
        return view;
    }

    @Override
    public void onBindViewHolder(@NonNull SelectBankAdapter.MyViewHolder holder, int position) {
        holder.nameBank.setText(bankName.get(position));
    }

    @Override
    public int getItemCount() {
        return bankName.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nameBank;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nameBank = itemView.findViewById(R.id.bankNameInLayout);
        }
    }
}
