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
    boolean userRegistered;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneNumber = findViewById(R.id.MobileNumber);
        NextBTN = findViewById(R.id.NextBTN_phoneNumberCheck);
        countryCode = findViewById(R.id.country_code_PHONE);

        //-----   I N I T I AL I S A T I O N  ---------
        userRegistered = false;

        String code = countryCode.getSelectedCountryCode();
//        String phoneNum = phoneNumber.getText().toString();

        NextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(phoneNumber.length()>=6) {
                    if(!userRegistered){
                        // --------   F O R    R E G I S T R A T I O N    S C R E E N  --------------
                        Intent intent = new Intent(MainActivity.this, RegistrationPage.class);
//                        intent.putExtra("sourceCode", 0);
                        intent.putExtra("phone", phoneNumber.getText().toString());
                        intent.putExtra("countryCode", code);
                        startActivity(intent);

                    } else {
                        // --------   F O R   D I R E C T    O T P   S C R E E N  --------------

                        String phone = "+"+code+" "+phoneNumber.getText().toString();
                        Log.e("Aakansha", phone);
                        Intent intent = new Intent(MainActivity.this, OTP_Page.class);
//                        intent.putExtra("sourceCode", 1);
                        intent.putExtra("phone", phone);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Phone number not valid!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}