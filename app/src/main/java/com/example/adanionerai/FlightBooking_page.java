package com.example.adanionerai;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class FlightBooking_page extends AppCompatActivity {

    // Add return
    TextView returnTitle, returnDate, returnDay;

    FrameLayout fm;

    // CLASS & TRAVELLERS
    TextView classLevel, travellersNumberText, departureDate, departureDay;

    RadioButton oneWay, roundTrip;
    RecyclerView arrivalCity;
    Button searchFlightBTN;
    ConstraintLayout TC, DepartureDate, returnTripDateContainer;
    ArrayList<city> cities = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_booking_page);

        TextView firstCityCode = findViewById(R.id.firstCityShort);
        TextView firstCityName = findViewById(R.id.firstCity);
        TextView secondCityCode = findViewById(R.id.secondCityShort);
        TextView secondCityCodeName = findViewById(R.id.secondCity);

        ImageView swapImg = findViewById(R.id.swapImage);
        searchFlightBTN = findViewById(R.id.SearchFlightBTN);
        TC = findViewById(R.id.travellersAndClassContainer);
        DepartureDate = findViewById(R.id.departureDateSelection);

        oneWay = findViewById(R.id.oneWay);
        returnTripDateContainer = findViewById(R.id.returnDateContainer);
        roundTrip = findViewById(R.id.roundWay);
        arrivalCity = findViewById(R.id.arrivalCityList);


        oneWay.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    oneWayTicket();
                }
            }
        });
        roundTrip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    roundTrip();
                }
            }
        });

        //    DEPARTURE CITY ----- SELECT
        firstCityCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = View.inflate(FlightBooking_page.this, R.layout.arrival_city, null);
                showDialog(v);
            }
        });

        //    ARRIVAL CITY ----- SELECT
        secondCityCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = View.inflate(FlightBooking_page.this, R.layout.departure_city, null);
                showDialog(v);
            }
        });

        //    TRAVELLERS AND CLASS ----- SELECT
        TC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = View.inflate(FlightBooking_page.this, R.layout.travellers_and_class_layout, null);
                showDialogTC(v);
            }
        });


        // SWAP CITIES IMAGE

        swapImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String acCode = firstCityCode.getText().toString();
                String dcCode = secondCityCode.getText().toString();
                String ac = firstCityName.getText().toString();
                String dc = secondCityCodeName.getText().toString();

                firstCityCode.setText(dcCode);
                firstCityName.setText(dc);

                secondCityCode.setText(acCode);
                secondCityCodeName.setText(ac);
            }
        });

        returnTitle = findViewById(R.id.textAddReturn);
        departureDate = findViewById(R.id.DepartureDateAndDay);
        returnDate = findViewById(R.id.returnDate);
        returnDay = findViewById(R.id.returnDay);

        returnTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = View.inflate(FlightBooking_page.this, R.layout.calendar_return, null);

                calendarArrival(v, returnDate, returnDay);
                roundTrip();
            }
        });

        // DEPARTURE DATE ------ SELECTION
        DepartureDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = View.inflate(FlightBooking_page.this, R.layout.calendar, null);

//                departureDate = findViewById(R.id.DepartureDateAndDay);
                departureDay = findViewById(R.id.DepartureDay);
                calendarDeparture(v, departureDate, departureDay);
            }
        });

        // ARRIVAL DATE ------ SELECTION
        returnTripDateContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = View.inflate(FlightBooking_page.this, R.layout.calendar_return, null);

                calendarArrival(v, returnDate, returnDay);
            }
        });



        // ARRIVAL CITY --------- RECYCLER VIEW

        cities.add(new city("New Delhi", "India", "Indira Gandhi international Airport", "DEL"));
        cities.add(new city("Mumbai", "India", "Chhatrapati Shivaji Maharaj International Airport", "BOM"));
        cities.add(new city("Banglore", "India", "Kempegowda International Airport", "BLR"));
        cities.add(new city("Kolkata", "India", "Netaji Subhash Chandra Bose international Airport", "DEL"));
        cities.add(new city("New Delhi", "India", "Indira Gandhi international Airport", "DEL"));
        cities.add(new city("Mumbai", "India", "Chhatrapati Shivaji Maharaj International Airport", "BOM"));
        cities.add(new city("Banglore", "India", "Kempegowda International Airport", "BLR"));
        cities.add(new city("Kolkata", "India", "Netaji Subhash Chandra Bose international Airport", "DEL"));
        cities.add(new city("New Delhi", "India", "Indira Gandhi international Airport", "DEL"));
        cities.add(new city("Mumbai", "India", "Chhatrapati Shivaji Maharaj International Airport", "BOM"));
        cities.add(new city("Banglore", "India", "Kempegowda International Airport", "BLR"));
        cities.add(new city("Kolkata", "India", "Netaji Subhash Chandra Bose international Airport", "DEL"));


        // SEARCH FLIGHT
        searchFlightBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SearchFlightOptions.class);
                startActivity(intent);
            }
        });

    }

    private void calendarDeparture(View v, TextView Date, TextView Day) {

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(v);

        ImageView close = dialog.findViewById(R.id.closeDialog);

        Calendar calendarInstance = Calendar.getInstance();
        CalendarView calenderView = dialog.findViewById(R.id.calendarOneWay);
        Button doneCalendar = dialog.findViewById(R.id.doneCalendar);

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);


        String week[] = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        String monthName[] = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};

        calenderView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int date) {
                int dayNum = calendarView.getFirstDayOfWeek();

                int day = (((date%8)+dayNum)%8);
//                int day = (date %8);
//                int day = calendarInstance.get(Calendar.DAY_OF_WEEK);

                if(day==0){

                }
                Day.setText(week[day]);
                Date.setText(", "+ date +" "+ monthName[month] +" "+ year%2000+" ");
                Toast.makeText(FlightBooking_page.this, ""+ date +" "+ monthName[month] +" "+ year%2000+" ",Toast.LENGTH_SHORT).show();

            }
        });

        doneCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogC(dialog);
            }
        });

    }

    private void calendarArrival(View v, TextView Date, TextView Day) {

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(v);

        ImageView close = dialog.findViewById(R.id.closeDialog);

        Calendar calendarInstance = Calendar.getInstance();
//        CalendarView calenderView = dialog.findViewById(R.id.calendarOneWay);
        Button doneCalendar = dialog.findViewById(R.id.doneCalendar);

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);


        String week[] = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        String monthName[] = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};

//        calenderView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int date) {
//                int dayNum = calendarView.getFirstDayOfWeek();
//
//                int day = (((date%8)+dayNum)%8);
////                int day = (date %8);
////                int day = calendarInstance.get(Calendar.DAY_OF_WEEK);
//
//                if(day==0){
//
//                }
//                Day.setText(week[day]);
//                Date.setText(", "+ date +" "+ monthName[month] +" "+ year%2000+" ");
//                Toast.makeText(FlightBooking_page.this, ""+ date +" "+ monthName[month] +" "+ year%2000+" ",Toast.LENGTH_SHORT).show();
//
//            }
//        });

        doneCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogC(dialog);
            }
        });

        BottomNavigationItemView arrival = dialog.findViewById(R.id.arrival);
        BottomNavigationItemView departure = dialog.findViewById(R.id.departure);

        Fragment calender = new com.example.adanionerai.Calendar();
        Fragment calendarRound = new Calendar_roundTrip();

        arrival.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* FragmentManager fm = getFragmentManager();

                // create a FragmentTransaction to begin the transaction and replace the Fragment
                FragmentTransaction fragmentTransaction = fm.beginTransaction();

                // replace the FrameLayout with new Fragment
                fragmentTransaction.replace(R.id.frame, calendarRound);
                fragmentTransaction.commit();*/
                toast("Arrival");

            }
        });
        departure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toast("Departure");
            }
        });

//        private void loadFragment(Fragment fragment) {
//            // create a FragmentManager
//            FragmentManager fm = getFragmentManager();
//
//            // create a FragmentTransaction to begin the transaction and replace the Fragment
//            FragmentTransaction fragmentTransaction = fm.beginTransaction();
//
//            // replace the FrameLayout with new Fragment
//            fm = findViewById(R.id.frame);
//            fragmentTransaction.replace(R.id.frame, fragment);
//            fragmentTransaction.commit(); // save the changes
//        }

    }

    private void oneWayTicket() {
        returnTripDateContainer = findViewById(R.id.returnDateContainer);
        returnTripDateContainer.setVisibility(View.GONE);
        returnTitle.setVisibility(View.VISIBLE);
    }

    private void roundTrip() {
        roundTrip = findViewById(R.id.roundWay);
        returnTripDateContainer = findViewById(R.id.returnDateContainer);
        roundTrip.setChecked(true);
        returnTripDateContainer.setVisibility(View.VISIBLE);
        returnTitle.setVisibility(View.GONE);
    }

    private void showDialog(View v) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(v);

        TextView arrivalTitle = dialog.findViewById(R.id.arrivalCityTitle);
        ImageView closeDialog = dialog.findViewById(R.id.closeDialog);
        RecyclerView arrivalCity = dialog.findViewById(R.id.arrivalCityList);

        arrivalTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FlightBooking_page.this, "Arrival cities", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

        arrivalCity.setLayoutManager(new LinearLayoutManager(arrivalCity.getContext()));

        ArrivalCityAdapter adapter = new ArrivalCityAdapter(FlightBooking_page.this, cities);
        arrivalCity.setAdapter(adapter);


        closeDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
    }

    private void showDialogTC(View v) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(v);

        ImageView closeDialog = dialog.findViewById(R.id.closeDialog);
        Button done = dialog.findViewById(R.id.DoneTC);

        Button AdultAdd, CAdd, IAdd, AdultReduce, CReduce, IReduce;
        TextView AdultCount, ChildrenCount, InfantCount;

        AdultAdd = dialog.findViewById(R.id.AaddBTN);
        AdultReduce = dialog.findViewById(R.id.ASubBTN);
        AdultCount = dialog.findViewById(R.id.AdultCount);
        CAdd = dialog.findViewById(R.id.CAddBTN);
        CReduce = dialog.findViewById(R.id.CSubBTN);
        ChildrenCount = dialog.findViewById(R.id.ChildrenCount);
        IAdd = dialog.findViewById(R.id.IAddBTN);
        IReduce = dialog.findViewById(R.id.ISubBTN);
        InfantCount = dialog.findViewById(R.id.InfantsCount);

        // CLASS

        RadioButton eco, priEco, Business;
        eco = dialog.findViewById(R.id.economyClass);
        priEco = dialog.findViewById(R.id.premiumEconomy);
        Business = dialog.findViewById(R.id.business);

        RadioGroup classT = dialog.findViewById(R.id.ClassRadioG);
        eco.setChecked(true);
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);


        final int[] adult = {Integer.parseInt(AdultCount.getText().toString())};
        final int[] children = {Integer.parseInt(ChildrenCount.getText().toString())};
        final int[] infant = {Integer.parseInt(InfantCount.getText().toString())};



        AdultAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adult[0] = adult[0]+1;
                int childAdultCombine = 9 - children[0];

                if(adult[0]>9 || adult[0]>childAdultCombine){
                    AdultAdd.setEnabled(false);
                    CAdd.setEnabled(false);
                } else if(infant[0]<adult[0]){
                    IAdd.setEnabled(true);
                }
                AdultReduce.setEnabled(true);
                AdultCount.setText(String.valueOf(adult[0]));
            }
        });
        CAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                children[0] = children[0]+1;
                int childAdultCombine2 = 9 - adult[0];

                if(children[0] >= childAdultCombine2){
                    CAdd.setEnabled(false);
                } else if(children[0]>0){
                    CReduce.setEnabled(true);
                } else{
                    CAdd.setEnabled(true);
                }
                ChildrenCount.setText(String.valueOf(children[0]));
            }
        });
        IAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infant[0] = infant[0]+1;
                Toast.makeText(FlightBooking_page.this, String.valueOf(adult[0]), Toast.LENGTH_SHORT).show();
                if(infant[0]==adult[0]){
                    IAdd.setEnabled(false);
                    IReduce.setEnabled(true);
                } else{
                    IReduce.setEnabled(true);
                    IAdd.setEnabled(true);
                }
                InfantCount.setText(String.valueOf(infant[0]));
            }
        });

        AdultReduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int childAdultCombine2 = 9 - children[0];
                adult[0] = adult[0] - 1;

                if (adult[0] <= infant[0]) {
                    infant[0] = adult[0];
                    if (adult[0] <= 1) {
                        AdultReduce.setEnabled(false);
                    }
                    InfantCount.setText(String.valueOf(infant[0]));
                    IAdd.setEnabled(false);
                } else if (infant[0] > 0) {
                    IReduce.setEnabled(true);
                } else if (adult[0] < childAdultCombine2) {
                    AdultAdd.setEnabled(true);
                    CAdd.setEnabled(true);
                }

                AdultCount.setText(String.valueOf(adult[0]));
            }
        });
        CReduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                children[0] = children[0]-1;
                int childAdultCombine2 = 9 - adult[0];
                if(children[0]==0){
                    CReduce.setEnabled(false);
                } else if(children[0]<childAdultCombine2){
                    CAdd.setEnabled(true);
                    AdultAdd.setEnabled(true);
                }  else{
                    CReduce.setEnabled(true);
                }
                ChildrenCount.setText(String.valueOf(children[0]));

            }
        });
        IReduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infant[0] = infant[0]-1;
                if(infant[0]<1){
                    IReduce.setEnabled(false);
                } else if(infant[0]<=adult[0]) {
                    IAdd.setEnabled(true);
                } else {
                    IReduce.setEnabled(true);
                }
                InfantCount.setText(String.valueOf(infant[0]));
            }
        });

        if(adult[0]==1){
            AdultAdd.setEnabled(true);
        } else if(children[0]==0){
            CAdd.setEnabled(true);
        } else if(infant[0]<adult[0]){
            IAdd.setEnabled(true);
        }


//        Toast.makeText(FlightBooking_page.this,""+adult[0], Toast.LENGTH_SHORT).show();


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int travellers = (Integer.parseInt(AdultCount.getText().toString()))+(Integer.parseInt(ChildrenCount.getText().toString()))+(Integer.parseInt(InfantCount.getText().toString()));
                travellers(travellers);
                selectedClass(eco, priEco, Business);
                dialogC(dialog);
            }
        });
        closeDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogC(dialog);
            }
        });
    }

    private void selectedClass(RadioButton eco, RadioButton priEco, RadioButton business) {
        classLevel = findViewById(R.id.classLevel);
        if(eco.isChecked()){
            classLevel.setText(" Economy");
        } else if(priEco.isChecked()) {
            classLevel.setText(" Premium Economy");
        } else if(business.isChecked()) {
            classLevel.setText(" Business");
        } else {
            classLevel.setText("");
            Toast.makeText(FlightBooking_page.this, "Select Class", Toast.LENGTH_SHORT).show();
        }
    }

    private void travellers(int numberOfTravellers) {
        travellersNumberText = findViewById(R.id.travellerCount);
        travellersNumberText.setText(numberOfTravellers+" Travellers");
    }

    private void dialogC(@NonNull Dialog dialog) {
        dialog.cancel();
    }

    private void toast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

}