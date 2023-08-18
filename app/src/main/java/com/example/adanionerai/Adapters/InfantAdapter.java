package com.example.adanionerai.Adapters;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adanionerai.R;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class InfantAdapter extends RecyclerView.Adapter<InfantAdapter.MyViewHolder> {

    int count;
    Context ctx;
    public InfantAdapter(int adultCount, Context context) {
        this.count = adultCount;
        this.ctx = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.infant_item_layout, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText("Infant "+(position+1));

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
//                Calendar minAdultAge = Calendar.getInstance();
////                Calendar maxAdultAge = minAdultAge;
//                minAdultAge.add(Calendar.YEAR, - 2);
//
//                int MinYear = minAdultAge.getWeekYear();
//                int MinMonth = minAdultAge.getTime().getMonth();
//                int MinDate = minAdultAge.getTime().getDate();
//
//                mCalendar.set(MinYear, MinMonth - 1, MinDate);
//                mDialog.getDatePicker().setMinDate(mCalendar.getTimeInMillis());
//
////                final int minDay = 15;
////                final int minMonth = 8;
////                final int minYear = 2021;
////                mCalendar.set(minYear, minMonth - 1, minDay);
////                mDialog.getDatePicker().setMinDate(mCalendar.getTimeInMillis());
//
////                maxAdultAge.add(Calendar.YEAR, 1);
//                int maxDay = Calendar.DAY_OF_MONTH;
//                int maxMonth = Calendar.MONTH;
//                int maxYear = Calendar.YEAR - 2;
////                mCalendar.set(maxYear, maxMonth - 1, maxDay);
////                mDialog.getDatePicker().setMaxDate(mCalendar.getTimeInMillis());

                Calendar cal = Calendar.getInstance();
                Log.e("CALENDAR DATE", cal.getTime().getDate()+" "+cal.getTime().getMonth()+" "+(cal.getWeekYear()-2));
                Log.e("CALENDAR DATE", cal.getTime().getDate()+" "+cal.getTime().getMonth()+" "+(cal.getWeekYear()));

                final int minDay = cal.getTime().getDate();
                final int minMonth = cal.getTime().getMonth();
                final int minYear = cal.getWeekYear()-2;
                mCalendar.set(minYear, minMonth, minDay);
                mDialog.getDatePicker().setMinDate(mCalendar.getTimeInMillis());


                final int maxDay = cal.getTime().getDate();
                final int maxMonth = cal.getTime().getMonth();
                final int maxYear = cal.getWeekYear();
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
            calendar = itemView.findViewById(R.id.calenderImageDOBInfant);
            DOB = itemView.findViewById(R.id.infantDOB);
            calendarChoose = itemView.findViewById(R.id.InfantCalendar);
        }
    }
}
