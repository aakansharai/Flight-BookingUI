package com.example.adanionerai;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.hbb20.CountryCodePicker;

public class RegistrationPage extends AppCompatActivity {

    TextView name, email, phoneNumber, register, profileText;
    CountryCodePicker code;
    CardView profilePictureContainer;
    ImageView SelectedProfile, previewIMG;
    FirebaseAuth auth;
    int REQUEST_CODE = 200;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resistration_page);

        name = findViewById(R.id.NameOfUser);
        email = findViewById(R.id.EmailId_AtRegistration);
        phoneNumber = findViewById(R.id.PhoneNumber);
        code = findViewById(R.id.country_code);
        profilePictureContainer = findViewById(R.id.profileCard);
        register = findViewById(R.id.NextBTN_phoneNumberCheck);
        profileText = findViewById(R.id.cardText_Profile);
        SelectedProfile = findViewById(R.id.ProfileImageSelected);
        previewIMG = findViewById(R.id.PreviewIMG);

        SelectedProfile.setVisibility(View.GONE);
        previewIMG.setVisibility(View.VISIBLE);
        profileText.setVisibility(View.VISIBLE);

        String phone = getIntent().getStringExtra("phone");
        String codeC = getIntent().getStringExtra("countryCode");
        int getCode = Integer.parseInt(codeC);

        Log.wtf("GOT THE NUMBER", phone);

        auth = FirebaseAuth.getInstance();
        phoneNumber.setText(phone);
        code.setDefaultCountryUsingPhoneCode(getCode);
        Log.e("COUNTRY Code", code.getSelectedCountryCode());

        String CountryCode = code.getSelectedCountryCode();

        String ValidPhoneNumber = "+"+CountryCode+" "+phoneNumber.getText().toString();
        Log.wtf("valid phone ", ValidPhoneNumber);

        profilePictureContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageChooser();

            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrationPage.this, OTP_Page.class);
                intent.putExtra("phone", ValidPhoneNumber);
                startActivity(intent);
            }
        });
    }

    private void imageChooser() {
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i, "Select Picture"), REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

            if(resultCode == RESULT_OK) {
                if(requestCode == REQUEST_CODE) {
                    Uri selectedImage = data.getData();

                    if(null != selectedImage) {
                        SelectedProfile.setImageURI(selectedImage);
                        SelectedProfile.setVisibility(View.VISIBLE);
                        previewIMG.setVisibility(View.GONE);
                        profileText.setVisibility(View.GONE);
                    }
                }
            }

    }
}