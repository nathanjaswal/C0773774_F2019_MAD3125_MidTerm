package com.example.c0773774_f2019_mad3125_midterm;
//
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

    // Attributes:-
    EditText sin_et;
    EditText fn_et;
    EditText ln_et;
    TextView fulln_tv;
    EditText dob_et;
    ImageButton dob_ib;
    TextView age_tv;
    EditText gender_et;
    EditText taxdate_et;
    EditText grossin_et;
    EditText fedTax_et;
    EditText provTax_et;
    EditText cpp_et;
    EditText ei_et;
    EditText rrsp_et;
    EditText cfwd_rrsp_et;
    EditText ttl_taxin_et;
    EditText ttl_taxpyd_et;

    // Life Cycle: -
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // call method
        this.iniSetUp();

    }

    // Listners: -


    // Action: -
    void fnOrln_etComplete() {

        if (fn_et.getText().toString() != "" && ln_et.getText().toString() != ""){
            fulln_tv.setAlpha(1.0f);
            String strFullN = fn_et.getText().toString() + " " + ln_et.getText().toString()
            fulln_tv.setText(strFullN);
        }else{
            fulln_tv.setAlpha(0.0f);
        }
    }

    void grossin_etComplete() {

    }

    void rrsp_etComplete() {

    }

    void dobClicked(View view){

    }

    void dobBtnClicked(View view){

    }

    void genderClicked(View view){

    }

    // Helper: -
    boolean checkValidations() {
        return true;
    }

    private void iniSetUp() {
        //
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //
        sin_et = findViewById(R.id.sinET);
        fn_et = findViewById(R.id.fNameET);
        ln_et = findViewById(R.id.lNameET);
        fulln_tv = findViewById(R.id.fullNameTV);
        dob_et = findViewById(R.id.dobET);
        dob_ib = findViewById(R.id.dobIB);
        age_tv = findViewById(R.id.ageTV);
        gender_et = findViewById(R.id.genderET);
        taxdate_et = findViewById(R.id.taxdateET);
        grossin_et = findViewById(R.id.grossIncomeET);
        fedTax_et = findViewById(R.id.fedTaxET);
        provTax_et = findViewById(R.id.provTaxET);
        cpp_et = findViewById(R.id.cppET);
        ei_et = findViewById(R.id.eiET);
        rrsp_et = findViewById(R.id.rrspET);
        cfwd_rrsp_et = findViewById(R.id.carryRRSPET);
        ttl_taxin_et = findViewById(R.id.totalTaxET);
        ttl_taxpyd_et = findViewById(R.id.totalTaxPayedET);

        //
        fulln_tv.setAlpha(0.0f);

        //
        fn_et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                switch (actionId){
                    case EditorInfo.IME_ACTION_DONE:
                    case EditorInfo.IME_ACTION_NEXT:
                    case EditorInfo.IME_ACTION_PREVIOUS:
                        fnOrln_etComplete();
                        return true;
                }
                return false;
            }
        });

        //
        ln_et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                switch (actionId){
                    case EditorInfo.IME_ACTION_DONE:
                    case EditorInfo.IME_ACTION_NEXT:
                    case EditorInfo.IME_ACTION_PREVIOUS:
                        fnOrln_etComplete();
                        return true;
                }
                return false;
            }
        });

        //
        grossin_et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                switch (actionId){
                    case EditorInfo.IME_ACTION_DONE:
                    case EditorInfo.IME_ACTION_NEXT:
                    case EditorInfo.IME_ACTION_PREVIOUS:
                        grossin_etComplete();
                        return true;
                }
                return false;
            }
        });

        //
        rrsp_et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                switch (actionId){
                    case EditorInfo.IME_ACTION_DONE:
                    case EditorInfo.IME_ACTION_NEXT:
                    case EditorInfo.IME_ACTION_PREVIOUS:
                        rrsp_etComplete();
                        return true;
                }
                return false;
            }
        });

    }


}
