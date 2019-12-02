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

import java.text.DecimalFormat;
import java.text.NumberFormat;
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

        Log.i("rr", dataM.get("GrossInMV"));
        Float grossInVal = Float.parseFloat(dataM.get("GrossInMV"));
        grossIn_tv.setText("$"+setFormat(grossInVal));
        Log.i("rr", dataM.get("TtlTaxInMV"));
        Float ttlVal = Float.parseFloat(dataM.get("TtlTaxInMV"));
        ttlTaxIn_tv.setText("$"+setFormat(ttlVal));
        Log.i("rr", dataM.get("RrspMV"));
        Float rrspVal = Float.parseFloat(dataM.get("RrspMV"));
        rrsp_tv.setText("$"+setFormat(rrspVal));
        Log.i("rr", dataM.get("CarrFwdMV"));
        Float crrVal = Float.parseFloat(dataM.get("CarrFwdMV"));
        crrFwdRrsp_tv.setText("$"+setFormat(crrVal));
        Log.i("rr", dataM.get("CppMV"));
        Float cppVal = Float.parseFloat(dataM.get("CppMV"));
        cpp_tv.setText("$"+setFormat(cppVal));
        Log.i("rr", dataM.get("EiMV"));
        Float eiVal = Float.parseFloat(dataM.get("EiMV"));
        ei_tv.setText("$"+setFormat(eiVal));
        Log.i("rr", dataM.get("FtMV"));
        Float ftVal = Float.parseFloat(dataM.get("FtMV"));
        fedTax_tv.setText("$"+setFormat(ftVal));
        Log.i("rr", dataM.get("PrMV"));
        Float prVal = Float.parseFloat(dataM.get("PrMV"));
        provTax_tv.setText("$"+setFormat(prVal));

        Float grossIn = Float.parseFloat(dataM.get("GrossInMV"));
        Float ttPay = Float.parseFloat(dataM.get("TtPayMV"));
        Float avg = (ttPay/grossIn)*100;
        String avgVal = String.format("%.2f", avg);
        avg_tv.setText(avgVal+"%");

        Float InAfter = grossIn - ttPay;
        inAft_tv.setText("$"+setFormat(InAfter));

    }

    // Helper:-
    String setFormat(Float val){

        NumberFormat formatter = new DecimalFormat("###,###,###.##");
        String result = String.valueOf(formatter.format(val));

        return result;
    }

}
