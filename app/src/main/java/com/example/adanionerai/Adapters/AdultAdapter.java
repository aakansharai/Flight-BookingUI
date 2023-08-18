package com.example.adanionerai.Adapters;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adanionerai.R;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class AdultAdapter extends RecyclerView.Adapter<AdultAdapter.MyViewHolder> {

    int count;
    Context ctx;
    public AdultAdapter(int adultCount, Context context) {
        this.count = adultCount;
        this.ctx = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adult_item_layout, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText("Adults "+(position+1));

        holder.calendarChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar mCalendar = Calendar.getInstance();
                final DatePickerDialog mDialog = new DatePickerDialog(
                        view.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int mYear, int mMonth, int mDay) {
                        holder.DOB.setText(mDay + " - " + (mMonth + 1) + " - " + mYear);
                    }

                },
                mCalendar.get(Calendar.YEAR),
                mCalendar.get(Calendar.MONTH),
                mCalendar.get(Calendar.DAY_OF_MONTH));

//                Calendar minAdultAge = new GregorianCalendar();
//                minAdultAge.add(Calendar.YEAR, -21);
//                int MaxYear = minAdultAge.getWeekYear();
//                int MaxMonth = minAdultAge.getTime().getMonth();
//                int MaxDate = minAdultAge.getTime().getDate();
//                mCalendar.set(MaxYear, MaxMonth - 1, MaxDate);
//                mDialog.getDatePicker().setMaxDate(mCalendar.getTimeInMillis());

                Calendar cal = Calendar.getInstance();

                final int maxDay = cal.getTime().getDate();
                final int maxMonth = cal.getTime().getMonth();
                final int maxYear = cal.getWeekYear()-21;
                mCalendar.set(maxYear, maxMonth, maxDay);
                mDialog.getDatePicker().setMaxDate(mCalendar.getTimeInMillis());


                mDialog.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return count;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title, DOB;
        ConstraintLayout calendarChoose;
        ImageView calendar;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.TravellerType);
            calendar = itemView.findViewById(R.id.calenderImageDOBAdult);
            DOB = itemView.findViewById(R.id.adultDOB);
            calendarChoose = itemView.findViewById(R.id.AdultCalendar);

        }
    }
}
