package com.example.adanionerai;

import static android.app.PendingIntent.getActivity;
import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.datepicker.CalendarConstraints;
import com.kizitonwose.calendar.view.ViewContainer;

public class DayViewContainer extends ViewContainer {
    TextView textView;
    int clickedIndex, nextIndex;
    DayViewContainer nextContainer;
    Context context;

    public DayViewContainer(@NonNull View view, final Context context) {
        super(view);
        textView = view.findViewById(R.id.calendarDayText);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("ViewGroup_Log", "ENTERED");

                ViewGroup parentView = (ViewGroup) v.getParent();

                clickedIndex = parentView.indexOfChild(v);
                nextIndex = clickedIndex + 1;

                SharedPreferences sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("nextIndex", nextIndex);
                editor.apply();

            }
        });
    }

//    public void setOnClickListener(View.OnClickListener listener) {
//        textView.setOnClickListener(listener);
//    }


}

