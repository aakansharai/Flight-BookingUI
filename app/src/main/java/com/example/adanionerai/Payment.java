package com.example.adanionerai;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adanionerai.Adapters.SelectBankAdapter;
import com.example.adanionerai.Adapters.TravellerNameAdapter;
import com.example.adanionerai.Adapters.ViewOtherBankAdapter;
import com.example.adanionerai.ModelClass.NameModel;

import java.util.ArrayList;

public class Payment extends AppCompatActivity {

    TextView adaniRewardBalance, selectbank, viewOtherBank, convinienceFee;
    ConstraintLayout adaniBalance, UPI, CreditDebit, NetBanking, Wallet, EMI, ticketDetail;
    ImageView dropDown1, dropUp1, dropDown2, dropUp2, dropDown3, dropUp3, dropDown4, dropUp4, dropDown5, dropUp5;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        adaniRewardBalance = findViewById(R.id.adaniRewardBalanceAmount);
        adaniBalance = findViewById(R.id.adaniRewardsCoinsContainer);
        selectbank = findViewById(R.id.selectBank);
        viewOtherBank = findViewById(R.id.viewOtherBank);
        convinienceFee = findViewById(R.id.convinienceFee);

        UPI = findViewById(R.id.UPI_options);
        CreditDebit = findViewById(R.id.CreditDebit_options);
        NetBanking = findViewById(R.id.netBanking_options);
        Wallet = findViewById(R.id.wallet_options);
        EMI = findViewById(R.id.emi_options);
        ticketDetail = findViewById(R.id.oneWayRoundTrip);

        dropDown1 = findViewById(R.id.dropDown);
        dropUp1 = findViewById(R.id.dropUp);
        dropDown2 = findViewById(R.id.dropDown2);
        dropUp2 = findViewById(R.id.dropUp2);
        dropDown3 = findViewById(R.id.dropDown3);
        dropUp3 = findViewById(R.id.dropUp3);
        dropDown4 = findViewById(R.id.dropDown4);
        dropUp4 = findViewById(R.id.dropUp4);
        dropDown5 = findViewById(R.id.dropDown5);
        dropUp5 = findViewById(R.id.dropUp5);

        if(Integer.parseInt((String) adaniRewardBalance.getText())<=0){
            adaniBalance.setClickable(false);
            adaniBalance.setBackgroundColor(Color.LTGRAY);
        }

        //----------------   UPI

        dropDown1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dropDown1.setVisibility(View.GONE);
                dropUp1.setVisibility(View.VISIBLE);
                UPI.setVisibility(View.VISIBLE);
                CreditDebit.setVisibility(View.GONE);
                NetBanking.setVisibility(View.GONE);
                Wallet.setVisibility(View.GONE);
                EMI.setVisibility(View.GONE);
            }
        });
        dropUp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dropDown1.setVisibility(View.VISIBLE);
                dropUp1.setVisibility(View.GONE);
                UPI.setVisibility(View.GONE);
                CreditDebit.setVisibility(View.GONE);
                NetBanking.setVisibility(View.GONE);
                Wallet.setVisibility(View.GONE);
                EMI.setVisibility(View.GONE);
            }
        });





        //------------------ NET BANKING
        dropDown2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dropDown2.setVisibility(View.GONE);
                dropUp2.setVisibility(View.VISIBLE);
                UPI.setVisibility(View.GONE);
                CreditDebit.setVisibility(View.VISIBLE);
                NetBanking.setVisibility(View.GONE);
                Wallet.setVisibility(View.GONE);
                EMI.setVisibility(View.GONE);
            }
        });
        dropUp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dropDown2.setVisibility(View.VISIBLE);
                dropUp2.setVisibility(View.GONE);
                UPI.setVisibility(View.GONE);
                CreditDebit.setVisibility(View.GONE);
                NetBanking.setVisibility(View.GONE);
                Wallet.setVisibility(View.GONE);
                EMI.setVisibility(View.GONE);
            }
        });

        dropDown3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dropDown3.setVisibility(View.GONE);
                dropUp3.setVisibility(View.VISIBLE);
                UPI.setVisibility(View.GONE);
                CreditDebit.setVisibility(View.GONE);
                NetBanking.setVisibility(View.VISIBLE);
                Wallet.setVisibility(View.GONE);
                EMI.setVisibility(View.GONE);
            }
        });
        dropUp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dropDown3.setVisibility(View.VISIBLE);
                dropUp3.setVisibility(View.GONE);
                UPI.setVisibility(View.GONE);
                CreditDebit.setVisibility(View.GONE);
                NetBanking.setVisibility(View.GONE);
                Wallet.setVisibility(View.GONE);
                EMI.setVisibility(View.GONE);
            }
        });

        dropDown4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dropDown4.setVisibility(View.GONE);
                dropUp4.setVisibility(View.VISIBLE);
                UPI.setVisibility(View.GONE);
                CreditDebit.setVisibility(View.GONE);
                NetBanking.setVisibility(View.GONE);
                Wallet.setVisibility(View.VISIBLE);
                EMI.setVisibility(View.GONE);
            }
        });
        dropUp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dropDown4.setVisibility(View.VISIBLE);
                dropUp4.setVisibility(View.GONE);
                UPI.setVisibility(View.GONE);
                CreditDebit.setVisibility(View.GONE);
                NetBanking.setVisibility(View.GONE);
                Wallet.setVisibility(View.GONE);
                EMI.setVisibility(View.GONE);
            }
        });

        dropDown5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dropDown5.setVisibility(View.GONE);
                dropUp5.setVisibility(View.VISIBLE);
                UPI.setVisibility(View.GONE);
                CreditDebit.setVisibility(View.GONE);
                NetBanking.setVisibility(View.GONE);
                Wallet.setVisibility(View.GONE);
                EMI.setVisibility(View.VISIBLE);
            }
        });
        dropUp5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dropDown5.setVisibility(View.VISIBLE);
                dropUp5.setVisibility(View.GONE);
                UPI.setVisibility(View.GONE);
                CreditDebit.setVisibility(View.GONE);
                NetBanking.setVisibility(View.GONE);
                Wallet.setVisibility(View.GONE);
                EMI.setVisibility(View.GONE);
            }
        });

        ticketDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = View.inflate(Payment.this, R.layout.travelling_detail_at_payment, null);
                ticketDetailShow(v);
            }
        });

        selectbank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = View.inflate(Payment.this, R.layout.bank_options_layout, null);

                selectYourBank(v);
            }
        });

        viewOtherBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = View.inflate(Payment.this, R.layout.bank_options_layout, null);

                selectBank(v);
            }
        });

        convinienceFee.setTooltipText("\bConvenience Fee Info\b\n" +
                "\n" +
                "\n" +
                "A non-refundable convenience fee for one way and roundtrip journey as per Domestic and International travel has been levied on all online payments. For payment in currencies other than INR, refer to the fare summary.");

    }

    private void selectBank(View v) {

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(v);

        RecyclerView bankList;
        TextView selectBankTitle;
        ImageView close;

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

        close = dialog.findViewById(R.id.closeDialog);
        selectBankTitle = dialog.findViewById(R.id.selectYourBankTitle);

        selectBankTitle.setText("View Other Banks");

        ArrayList<String> bankNames = new ArrayList<>();
        bankNames.add("Airtel Payments Bank");
        bankNames.add(" Andhra Bank");
        bankNames.add("Corporation Bank");
        bankNames.add("Bank of India");
        bankNames.add("Bank of Baroda - Retail Banking");
        bankNames.add("Bank of Maharashtra");
        bankNames.add("Catholic Syrian Bank");
        bankNames.add("Central Bank");
        bankNames.add("City Union Bank");
        bankNames.add("Cosmos Bank");
        bankNames.add("DCB Bank");
        bankNames.add("Deutsche Bank");
        bankNames.add("Dhanalakshmi Bank");
        bankNames.add("Federal Bank");
        bankNames.add("IDBI Bank");
        bankNames.add("IDFC FIRST Bank");
        bankNames.add("Indian Bank");
        bankNames.add("Indian Overseas Bank");
        bankNames.add("Indusind Bank");
        bankNames.add("Janata Sahakari Bank Ltd Pune");
        bankNames.add("Jammu & Kashmir Bank");

        bankList = dialog.findViewById(R.id.bankList);
        ViewOtherBankAdapter adapterBankName = new ViewOtherBankAdapter(bankNames, getApplicationContext());
        bankList.setLayoutManager(new LinearLayoutManager(bankList.getContext()));
        bankList.setAdapter(adapterBankName);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });

    }

    private void selectYourBank(View v) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(v);

        RecyclerView bankList;
        ImageView close;

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

        close = dialog.findViewById(R.id.closeDialog);

        ArrayList<String> bankNames = new ArrayList<>();
        bankNames.add("AU");
        bankNames.add("AXIS");
        bankNames.add("BOB");
        bankNames.add("CITI");
        bankNames.add("HSBC");
        bankNames.add("ICICI");
        bankNames.add("IDBI");
        bankNames.add("IDFC");
        bankNames.add("INDUSIND");
        bankNames.add("KOTAK");
        bankNames.add("ONECARD");
        bankNames.add("RBL");
        bankNames.add("SBI");
        bankNames.add("SCB");
        bankNames.add("YES");

        bankList = dialog.findViewById(R.id.bankList);
        SelectBankAdapter adapterBankName = new SelectBankAdapter(bankNames, getApplicationContext());
        bankList.setLayoutManager(new LinearLayoutManager(bankList.getContext()));
        bankList.setAdapter(adapterBankName);


        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
    }

    private void ticketDetailShow(View v) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(v);

        RecyclerView oneWay, roundTrip, travellerName;
        ImageView close;

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

        oneWay = dialog.findViewById(R.id.TravellingDetailsListOneWay);
        roundTrip = dialog.findViewById(R.id.TravellingDetailsListRound);
        travellerName = dialog.findViewById(R.id.travellersNameList);

        close = dialog.findViewById(R.id.closeDialog);

        ArrayList<NameModel> name = new ArrayList<NameModel>();

        name.add(new NameModel("Miss", "Aakansha Rai", "Adult"));
        name.add(new NameModel("Miss", "Rashmi", "Child"));
        name.add(new NameModel("Mr", "Jatin", "Infant"));

        TravellerNameAdapter adapterName = new TravellerNameAdapter(name, getApplicationContext());
        travellerName.setLayoutManager(new LinearLayoutManager(travellerName.getContext()));
        travellerName.setAdapter(adapterName);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
    }
}