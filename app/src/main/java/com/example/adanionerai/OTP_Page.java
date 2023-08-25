package com.example.adanionerai;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
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

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.concurrent.TimeUnit;

public class OTP_Page extends AppCompatActivity {

    TextView otpNotReceive, InvalidOTP, OTP_Text, VerifyBTN, CodeSentMSG, seconds;
    EditText n1, n2, n3, n4, n5, n6;
    ProgressBar loader;
    FirebaseAuth auth;
    String otp;
    String verificationID;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_page);

        String phone = getIntent().getStringExtra("phone");
        Log.wtf("GOT THE NUMBER-OTP", phone);

        otpNotReceive = findViewById(R.id.otpNotReceived);
        InvalidOTP = findViewById(R.id.invalidOTP);
        OTP_Text = findViewById(R.id.verification_code);
        VerifyBTN = findViewById(R.id.verifyOTP_BTN);
        CodeSentMSG = findViewById(R.id.messageOfCodePhone);
        loader = findViewById(R.id.loader);
        seconds = findViewById(R.id.secondsOTP);

        InvalidOTP.setVisibility(View.GONE);
        otpNotReceive.setVisibility(View.GONE);
        loader.setVisibility(View.GONE);

        n1 = findViewById(R.id.Number1);
        n2 = findViewById(R.id.Number2);
        n3 = findViewById(R.id.Number3);
        n4 = findViewById(R.id.Number4);
        n5 = findViewById(R.id.Number5);
        n6 = findViewById(R.id.Number6);

        n1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().length()==1){
                    n2.requestFocus();
                }
            }
        });
        n2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().length()==1){
                    n3.requestFocus();
                }
            }
        });
        n3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().length()==1){
                    n4.requestFocus();
                }
            }
        });
        n4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().length()==1){
                    n5.requestFocus();
                }
            }
        });
        n5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().length()==1){
                    n6.requestFocus();
                }
            }
        });

        auth = FirebaseAuth.getInstance();
        CodeSentMSG.setText(phone);

//-----   V E R I F I C A T I O N    C O D E    S E N T  --------------
        sendVerificationCode(phone);
        timerFUN();

        otpNotReceive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendVerificationCode(phone);
                timerFUN();
                InvalidOTP.setVisibility(View.GONE);
                otpNotReceive.setVisibility(View.GONE);
            }
        });


//-----   V E R I F Y I N G  --------------
        VerifyBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                otp = n1.getText().toString()+n2.getText().toString()+n3.getText().toString()+n4.getText().toString()+n5.getText().toString()+n6.getText().toString();
                Log.wtf("OTPs", otp);
                loader.setVisibility(View.VISIBLE);

                if(otp.length()>=6){
                    Log.e("OTP", otp);
                    verifyCode(otp);
                } else {
                    InvalidOTP.setVisibility(View.VISIBLE);
                    loader.setVisibility(View.GONE);
                    toast("Invalid OTP");
                }
            }
        });
    }

//    public abstract void setAutoRetrievedSmsCodeForPhoneNumber (String phoneNumber, String smsCode);

    public void timerFUN (){
        new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long l) {
                NumberFormat f = new DecimalFormat("00");
                long min = (l / 60000) % 60;
                long sec = (l / 1000) % 60;
                seconds.setText(f.format(min) + ":" + f.format(sec)+" secs");
            }

            @Override
            public void onFinish() {
                seconds.setText("00:00 secs");
                otpNotReceive.setVisibility(View.VISIBLE);
            }
        }.start();
    }

    private void sendVerificationCode(String phone){
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(auth)
                        .setPhoneNumber(phone)
                        .setTimeout(60L, TimeUnit.SECONDS)
                        .setActivity(this)
                        .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken){
                                verificationID = s;
//                                setAutoRetrievedSmsCodeForPhoneNumber(phone, s);
                            }

                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                String OTP = OTP_Text.getText().toString();
                                verifyCode(OTP);
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                Log.e("FAILED:Reason", e.toString());
                                toast(e.toString());
                                loader.setVisibility(View.GONE);
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
                if(task.isSuccessful()) {
                    Log.d("Successful", "signInWithCredential:success");
                    FirebaseUser user = task.getResult().getUser();
                    toast("Successful");
                    loader.setVisibility(View.GONE);
                    Intent intent = new Intent(OTP_Page.this, FlightBooking_page.class);
                    startActivity(intent);
                    finish();
                } else {
                    Log.w("Failed", "signInWithCredential:failure", task.getException());
                    if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                        loader.setVisibility(View.GONE);
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
    private void toast(String s) {
        Toast.makeText(OTP_Page.this, s, Toast.LENGTH_SHORT).show();
    }
}