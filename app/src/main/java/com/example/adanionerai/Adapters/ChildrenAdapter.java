package com.example.adanionerai.Adapters;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adanionerai.R;

import java.util.Calendar;

public class ChildrenAdapter extends RecyclerView.Adapter<ChildrenAdapter.MyViewHolder> {

    int count;
    Context ctx;
    public ChildrenAdapter(int adultCount, Context context) {
        this.count = adultCount;
        this.ctx = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.children_item_layout, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText("Children "+(position+1));

        holder.calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();

                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        view.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // on below line we are setting date to our edit text.
                        holder.DOB.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                },
                        year, month, day);
                datePickerDialog.show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return count;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title, DOB;
        ImageView calendar;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.TravellerType);

            calendar = itemView.findViewById(R.id.calenderImageDOBChildren);
            DOB = itemView.findViewById(R.id.childrenDOB);
        }
    }
}
