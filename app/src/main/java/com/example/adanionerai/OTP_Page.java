package com.example.adanionerai;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class OTP_Page extends AppCompatActivity {

    TextView otpNotReceive, InvalidOTP, OTP_Text, VerifyBTN, CodeSentMSG;
    ImageView GoBack;
    FirebaseAuth auth;
    String verificationID;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_page);

        String phone = getIntent().getStringExtra("phone");
        Log.wtf("GOT THE NUMBER", phone);
        otpNotReceive = findViewById(R.id.otpNotReceived);
        InvalidOTP = findViewById(R.id.invalidOTP);
        OTP_Text = findViewById(R.id.verification_code);
        VerifyBTN = findViewById(R.id.verifyOTP_BTN);
        CodeSentMSG = findViewById(R.id.messageOfCodeSend);
        InvalidOTP.setVisibility(View.GONE);
        otpNotReceive.setVisibility(View.GONE);

        auth = FirebaseAuth.getInstance();

        CodeSentMSG.setText("Code sent to "+phone);

//-----   V E R I F I C A T I O N    C O D E    S E N T  --------------
        sendVerificationCode(phone);



//-----   V E R I F Y I N G  --------------
        VerifyBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(OTP_Text.getText().length()>4){
                    verifyCode(OTP_Text.getText().toString());
//                    Intent intent = new Intent(OTP_Page.this, FlightBooking_page.class);
//                    startActivity(intent);
                } else {
                    InvalidOTP.setVisibility(View.VISIBLE);
                    toast("OTP must be at least of 4 digit");
                }
            }
        });

    }

//    public abstract void setAutoRetrievedSmsCodeForPhoneNumber (String phoneNumber, String smsCode);

    private void sendVerificationCode(String phone){
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(auth)
                        .setPhoneNumber(phone)
                        .setTimeout(60L, TimeUnit.SECONDS)
                        .setActivity(this)
                        // If no activity is passed, reCAPTCHA verification can not be used.
                        .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                            @Override
                            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken){
                                verificationID = s;
//                                setAutoRetrievedSmsCodeForPhoneNumber(phone, s);
                            }

                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                String otp = OTP_Text.getText().toString();
                                verifyCode(otp);
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                toast("Verification failed!");
                            }
                        })
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        auth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.d("Successful", "signInWithCredential:success");
                    FirebaseUser user = task.getResult().getUser();
                    Intent intent = new Intent(OTP_Page.this, FlightBooking_page.class);
                    startActivity(intent);
                    finish();
                } else {
                    Log.w("Failed", "signInWithCredential:failure", task.getException());
                    if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                        // The verification code entered was invalid
                        Toast.makeText(OTP_Page.this, "Code was invalid", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void verifyCode(String codeVERIFY){
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationID, codeVERIFY);
        signInWithPhoneAuthCredential(credential);
    }

//    private fun verifyCode(codeVERIFY: String) {
//        val credential : PhoneAuthCredential = PhoneAuthProvider.getCredential(verificationId, codeVERIFY)
//        signInWithCredential(credential)
//    }

    private void toast(String s) {
        Toast.makeText(OTP_Page.this, s, Toast.LENGTH_SHORT).show();
    }
}