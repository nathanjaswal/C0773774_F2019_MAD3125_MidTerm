package com.example.c0773774_f2019_mad3125_midterm.Activities.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.c0773774_f2019_mad3125_midterm.R;

import java.util.HashMap;

public class DetailActivity extends AppCompatActivity {

    //Button back_btn;eferf
    HashMap<String, String> dataMap;
    TextView ttTax_tv;
    TextView avg_tv;
    TextView inAft_tv;
    TextView sin_tv;
    TextView fn_tv;
    TextView dob_tv;
    TextView age_tv;
    TextView gender_tv;
    TextView taxFilDate_tv;
    TextView grossIn_tv;
    TextView ttlTaxIn_tv;
    TextView rrsp_tv;
    TextView crrFwdRrsp_tv;
    TextView cpp_tv;
    TextView ei_tv;
    TextView fedTax_tv;
    TextView provTax_tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //back_btn = findViewById(R.id.backBtn);

        //
//        back_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                finish();
//            }
//        });

        Intent intent = getIntent();
        dataMap = (HashMap<String, String>)intent.getSerializableExtra("DataCal");

        iniSetup(dataMap);
    }

    // Helper:-
    void iniSetup(HashMap<String, String> dataM) {
        // initializing
        ttTax_tv = findViewById(R.id.ttlTaxPayTV);
        avg_tv = findViewById(R.id.avgTaxTV);
        inAft_tv = findViewById(R.id.inAftTax);
        sin_tv = findViewById(R.id.sinTV);
        fn_tv = findViewById(R.id.fullNameTV);
        dob_tv = findViewById(R.id.dobTV);
        age_tv = findViewById(R.id.ageTV);
        gender_tv = findViewById(R.id.genderTV);
        taxFilDate_tv = findViewById(R.id.taxFilDatTV);
        grossIn_tv = findViewById(R.id.grosIncTV);
        ttlTaxIn_tv = findViewById(R.id.ttlTaxIn);
        rrsp_tv = findViewById(R.id.rrspTV);
        crrFwdRrsp_tv = findViewById(R.id.crrFwdRrspTV);
        cpp_tv = findViewById(R.id.cppTV);
        ei_tv = findViewById(R.id.eiTV);
        fedTax_tv = findViewById(R.id.fedTV);
        provTax_tv = findViewById(R.id.provTV);

        // parsing values
        ttTax_tv.setText("$"+dataM.get("TtPayMV"));
        age_tv.setText(dataM.get("AgeMV"));
        sin_tv.setText(dataM.get("SinMV"));
        fn_tv.setText(dataM.get("FulnameMV"));
        dob_tv.setText(dataM.get("DobMV"));
        gender_tv.setText(dataM.get("GenderMV"));
        taxFilDate_tv.setText(dataM.get("TaxDateMV"));
        grossIn_tv.setText("$"+dataM.get("GrossInMV"));
        ttlTaxIn_tv.setText("$"+dataM.get("TtlTaxInMV"));
        rrsp_tv.setText("$"+dataM.get("RrspMV"));
        crrFwdRrsp_tv.setText("$"+dataM.get("CarrFwdMV"));
        cpp_tv.setText("$"+dataM.get("CppMV"));
        ei_tv.setText("$"+dataM.get("EiMV"));
        fedTax_tv.setText("$"+dataM.get("FtMV"));
        provTax_tv.setText("$"+dataM.get("PrMV"));

        Float grossIn = Float.parseFloat(dataM.get("GrossInMV"));
        Float ttPay = Float.parseFloat(dataM.get("TtPayMV"));
        Float avg = (ttPay/grossIn)*100;
        String avgVal = String.format("%.2f", avg);
        avg_tv.setText(avgVal+"%");

        Float InAfter = grossIn - ttPay;
        inAft_tv.setText("$"+String.valueOf(InAfter));

    }

}
