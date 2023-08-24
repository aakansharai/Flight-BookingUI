package com.example.adanionerai;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.hbb20.CountryCodePicker;

public class RegistrationPage extends AppCompatActivity {

    TextView name, email, phoneNumber, register;
    CountryCodePicker code;
    CardView profilePicture;
    ImageView SelectedProfile;
    FirebaseAuth auth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resistration_page);

        name = findViewById(R.id.NameOfUser);
        email = findViewById(R.id.EmailId_AtRegistration);
        phoneNumber = findViewById(R.id.PhoneNumber);
        code = findViewById(R.id.country_code);
        profilePicture = findViewById(R.id.profileCard);
        register = findViewById(R.id.NextBTN_phoneNumberCheck);

        auth = FirebaseAuth.getInstance();

        String phone = getIntent().getStringExtra("phone");
        Log.wtf("GOT THE NUMBER", phone);

        String CountryCode = code.getSelectedCountryCode();

        String ValidPhoneNumber = CountryCode+phone;
        Log.wtf("valid phone ", ValidPhoneNumber);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrationPage.this, OTP_Page.class);
                intent.putExtra("phone", ValidPhoneNumber);
                startActivity(intent);
            }
        });





    }
}