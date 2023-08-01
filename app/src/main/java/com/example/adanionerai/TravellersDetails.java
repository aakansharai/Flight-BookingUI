package com.example.adanionerai;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Objects;

public class TravellersDetails extends AppCompatActivity {

    ArrayList<String> count = new ArrayList<>();
    RecyclerView td;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travellers_details);

//        for(int i=0; i<4; i++){
//            count.add("hello");
//        }

        td = findViewById(R.id.listOfTravellers);

        td.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        TravellersCountDetails_Adapter travellersCountDetailsAdapter = new TravellersCountDetails_Adapter(5,3,1, TravellersDetails.this);

        td.setAdapter(travellersCountDetailsAdapter);

    }
}