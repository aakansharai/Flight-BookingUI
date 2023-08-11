package com.example.adanionerai;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.adanionerai.Adapters.TravellersCountDetails_Adapter;

import java.util.ArrayList;

public class TravellersDetails extends AppCompatActivity {

    ArrayList<String> count = new ArrayList<>();
    Button proceedToPayment;
    EditText emailId;
    ConstraintLayout billingAddress;
    RecyclerView td;
//    @SuppressLint("MissingInflatedId")
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travellers_details);

        proceedToPayment = findViewById(R.id.proceedToPayment);
        billingAddress = findViewById(R.id.billingAddressContainer);
        emailId = findViewById(R.id.EmailId_TravellerDetails);

        int arr = getIntent().getExtras().getInt("TC");

        int adult=1 ;
        int children=0 ;
        int infant=0 ;

        int i=1;
        while(arr>0)
        {
            if(i==1){
                infant = arr%10;
            } else if(i==2){
                children = arr%10;
            } else if(i==3){
                adult = arr%10;
            }
            arr=arr/10;
            i++;
        }

        Toast.makeText(this, arr+""+" "+adult+" "+children+" "+infant, Toast.LENGTH_SHORT).show();
        Log.e("LES_SEE"," "+adult+" "+children+" "+infant);
        td = findViewById(R.id.listOfTravellers);

        td.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        TravellersCountDetails_Adapter travellersCountDetailsAdapter = new TravellersCountDetails_Adapter(adult, children, infant, TravellersDetails.this);

        td.setAdapter(travellersCountDetailsAdapter);

        proceedToPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Payment.class);
                startActivity(i);
            }
        });

        billingAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TravellersDetails.this, BillingDetails.class);
                startActivity(i);
            }
        });

        emailId.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String email = emailId.getText().toString();
                if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    Toast.makeText(getApplicationContext(), "Emails Valid!", Toast.LENGTH_SHORT).show();
                } else if(!email.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Email is not Valid", Toast.LENGTH_SHORT).show();
                    emailId.setError("Email is not Valid");
                } else {
                    Toast.makeText(getApplicationContext(), "Email cannot be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}