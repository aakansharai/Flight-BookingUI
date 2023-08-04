package com.example.adanionerai;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.adanionerai.Adapters.OneWayFlightListAdapter;
import com.example.adanionerai.Adapters.VoucherAdapter;
import com.example.adanionerai.ModelClass.FlightList;
import com.example.adanionerai.ModelClass.VoucherData;

import java.util.ArrayList;

public class FlightListRoundTrip extends AppCompatActivity {

    RecyclerView voucherList, oneWayList, ReturnList;
    ArrayList<VoucherData> voucherData = new ArrayList<>();
    ArrayList<FlightList> flightList = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_list_round_trip);

        voucherList = findViewById(R.id.vouchersListRecycler);
        oneWayList = findViewById(R.id.oneWayFlightList);
        ReturnList = findViewById(R.id.ReturnFlightList);

        voucherData.add(new VoucherData(R.drawable.img, "Earn 1% reward \n point on this\n transaction"));
        voucherData.add(new VoucherData(R.drawable.img, "Earn 1% reward \n point on this\n transaction"));
        voucherData.add(new VoucherData(R.drawable.img, "Earn 1% reward \n point on this\n transaction"));
        voucherData.add(new VoucherData(R.drawable.img, "Earn 1% reward \n point on this\n transaction"));
        voucherData.add(new VoucherData(R.drawable.img, "Earn 1% reward \n point on this\n transaction"));
        voucherData.add(new VoucherData(R.drawable.img, "Earn 1% reward \n point on this\n transaction"));

        voucherList.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        VoucherAdapter adapter = new VoucherAdapter(voucherData, FlightListRoundTrip.this);
        voucherList.setAdapter(adapter);


        flightList.add(new FlightList(R.drawable.img_1, "18:20", "20:45", "2h 20m", "Non-Stop", "₹10,000"));
        flightList.add(new FlightList(R.drawable.img_1, "15:05", "20:45", "1h 10m", "1 Stop", "₹10,000"));
        flightList.add(new FlightList(R.drawable.img_1, "18:20", "20:45", "3h 30m", "Non-Stop", "₹10,000"));
        flightList.add(new FlightList(R.drawable.img_1, "08:50", "10:45", "1h 00m", "1 Stop", "₹10,000"));
        flightList.add(new FlightList(R.drawable.img_1, "18:20", "20:45", "2h 05m", "1 Stop", "₹11,000"));
        flightList.add(new FlightList(R.drawable.img_1, "22:25", "01:45", "4h 56m", "1 Stop", "₹10,000"));
        flightList.add(new FlightList(R.drawable.img_1, "06:20", "09:45", "2h 26m", "Non-Stop", "₹10,000"));
        flightList.add(new FlightList(R.drawable.img_1, "08:50", "10:45", "1h 50m", "1 Stop", "₹10,000"));
        flightList.add(new FlightList(R.drawable.img_1, "18:20", "20:45", "1h 40m", "Non-Stop", "₹10,000"));
        flightList.add(new FlightList(R.drawable.img_1, "18:20", "20:45", "2h 20m", "Non-Stop", "₹10,000"));
        flightList.add(new FlightList(R.drawable.img_1, "15:05", "20:45", "1h 10m", "1 Stop", "₹10,000"));
        flightList.add(new FlightList(R.drawable.img_1, "18:20", "20:45", "3h 30m", "Non-Stop", "₹10,000"));
        flightList.add(new FlightList(R.drawable.img_1, "08:50", "10:45", "1h 00m", "1 Stop", "₹10,000"));
        flightList.add(new FlightList(R.drawable.img_1, "18:20", "20:45", "2h 05m", "1 Stop", "₹11,000"));
        flightList.add(new FlightList(R.drawable.img_1, "22:25", "01:45", "4h 56m", "1 Stop", "₹10,000"));
        flightList.add(new FlightList(R.drawable.img_1, "06:20", "09:45", "2h 26m", "Non-Stop", "₹10,000"));
        flightList.add(new FlightList(R.drawable.img_1, "08:50", "10:45", "1h 50m", "1 Stop", "₹10,000"));
        flightList.add(new FlightList(R.drawable.img_1, "18:20", "20:45", "1h 40m", "Non-Stop", "₹10,000"));

        OneWayFlightListAdapter oneWayFlightListAdapter = new OneWayFlightListAdapter(flightList, FlightListRoundTrip.this);
        oneWayList.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        oneWayList.setAdapter(oneWayFlightListAdapter);

        ReturnList.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        ReturnList.setAdapter(oneWayFlightListAdapter);


    }
}