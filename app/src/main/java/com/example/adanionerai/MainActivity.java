package com.example.adanionerai;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hbb20.CountryCodePicker;

public class MainActivity extends AppCompatActivity {

    EditText phoneNumber;
    TextView NextBTN;
    CountryCodePicker countryCode;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneNumber = findViewById(R.id.MobileNumber);
        NextBTN = findViewById(R.id.NextBTN_phoneNumberCheck);
        countryCode = findViewById(R.id.country_code_PHONE);

        String code = countryCode.getSelectedCountryCode();

        NextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(phoneNumber.length()>=6) {

                    // --------   F O R    R E G I S T R A T I O N    S C R E E N  --------------

                    String phone = "+"+code+" "+phoneNumber.getText().toString();
                    Log.e("Aakansha", phone);
                    Intent intent = new Intent(MainActivity.this, OTP_Page.class);
                    intent.putExtra("phone", phone);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Phone number not valid!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}