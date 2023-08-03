package com.example.adanionerai;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.kizitonwose.calendar.view.ViewContainer;

public class DayViewContainer extends ViewContainer {
    TextView textView;

    public DayViewContainer(@NonNull View view) {
        super(view);
        textView = view.findViewById(R.id.calendarDayText);
    }

    public void setOnClickListener(View.OnClickListener listener) {

        textView.setOnClickListener(listener);
    }
}
