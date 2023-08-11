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
                final Calendar c = Calendar.getInstance();

                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                final Calendar mCalendar = Calendar.getInstance();

                // Creating a simple calendar dialog.
                // It was 9 Aug 2021 when this program was
                // developed.
                final DatePickerDialog mDialog = new DatePickerDialog(
                        view.getContext(), new DatePickerDialog.OnDateSetListener() {

                    int MaxYear, MaxMonth, MaxDate;
                    @Override
                    public void onDateSet(
                        android.widget.DatePicker view, int mYear, int mMonth, int mDay) {

                            mCalendar.set(Calendar.YEAR, MaxYear);
                            mCalendar.set(Calendar.MONTH, MaxMonth);
                            mCalendar.set(Calendar.DAY_OF_MONTH, MaxDate);
                        }

                },
                mCalendar.get(Calendar.YEAR),
                mCalendar.get(Calendar.MONTH),
                mCalendar.get(Calendar.DAY_OF_MONTH));

                Calendar minAdultAge = new GregorianCalendar();
                minAdultAge.add(Calendar.YEAR, -18);
                int MaxYear = minAdultAge.getWeekYear();
                int MaxMonth = minAdultAge.getTime().getMonth();
                int MaxDate = minAdultAge.getTime().getDate();
                mCalendar.set(MaxYear, MaxMonth - 1, MaxDate);
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
