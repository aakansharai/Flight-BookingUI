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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Objects;

public class TravellersDetails extends AppCompatActivity {

    Button proceedToPayment;
    EditText emailId;
    ConstraintLayout billingAddress;
    RecyclerView td;
    JSONObject obj;
    int adultSet=1, childrenSet=0, infantSet=0, adultGet = 1, childrenGet = 0, infantGet = 0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travellers_details);

        proceedToPayment = findViewById(R.id.proceedToPayment);
        billingAddress = findViewById(R.id.billingAddressContainer);
        emailId = findViewById(R.id.EmailId_TravellerDetails);

        int arr = getIntent().getExtras().getInt("TC");
        int i=1;
        while(arr>0)
        {
            if(i==1){
                infantSet = arr%10;
            } else if(i==2){
                childrenSet = arr%10;
            } else if(i==3){
                adultSet = arr%10;
            }
            arr=arr/10;
            i++;
        }

        try {
            obj = new JSONObject(loadJSON());
            obj.getJSONObject("travellerCount").put("adult", adultSet);
            obj.getJSONObject("travellerCount").put("child", childrenSet);
            obj.getJSONObject("travellerCount").put("infant", infantSet);

            adultGet = obj.getJSONObject("travellerCount").getInt("adult");
            childrenGet = obj.getJSONObject("travellerCount").getInt("child");
            infantGet = obj.getJSONObject("travellerCount").getInt("infant");
            Log.e("TESTING", obj+"");
        } catch (JSONException e) {
            Log.e("TESTING", "GOT AN ERROR");
            throw new RuntimeException(e);
        }


        Toast.makeText(this, arr+""+" "+adultSet+" "+childrenSet+" "+childrenSet, Toast.LENGTH_SHORT).show();
        Log.e("LES_SEE"," "+adultSet+" "+childrenSet+" "+infantSet);
        td = findViewById(R.id.listOfTravellers);

        td.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        TravellersCountDetails_Adapter travellersCountDetailsAdapter = new TravellersCountDetails_Adapter(adultSet, childrenSet, infantSet, TravellersDetails.this);

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

    private String loadJSON() {
        String json = null;
        try {
            InputStream is = getApplicationContext().getAssets().open("travellers.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }
}