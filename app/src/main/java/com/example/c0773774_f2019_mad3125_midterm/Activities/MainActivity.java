package com.example.c0773774_f2019_mad3125_midterm.Activities;
//
// https://stackoverflow.com/questions/8654990/how-can-i-get-current-date-in-android

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.c0773774_f2019_mad3125_midterm.Activities.Helper.Helper;
import com.example.c0773774_f2019_mad3125_midterm.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

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

    ConstraintLayout constraintLayout;

    // Life Cycle: -
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // call method
        this.iniSetUp();

        this.setupUI();

    }

    // Action: -
    void fnOrln_etComplete() {

        if (fn_et.getText().toString().length() != 0 && ln_et.getText().toString().length() != 0){
            fulln_tv.setAlpha(1.0f);
            String strFullN = fn_et.getText().toString() + " " + ln_et.getText().toString();
            fulln_tv.setText(strFullN);
        }else{
            fulln_tv.setAlpha(0.0f);
        }

        //edText.setFocusable(false);
        //edText.setImeOptions(EditorInfo.IME_ACTION_NEXT);
        this.hideSoftKeyboard();
    }

    void grossin_etComplete() {

        if (grossin_et.getText().toString().length() != 0){
            Helper obj = new Helper();

            Float passVal = Float.parseFloat(grossin_et.getText().toString());
            Log.i("Nitin", String.valueOf(obj.calFedralTax(passVal)));

        }

        this.hideSoftKeyboard();

    }

    void rrsp_etComplete() {

    }

    public void dobClicked(View view){
        this.hideSoftKeyboard();
    }

    void dobBtnClicked(View view){
        this.hideSoftKeyboard();
    }

    void genderClicked(){
        this.hideSoftKeyboard();
    }

    // Helper: -
    String currentDate() {
        Date c = Calendar.getInstance().getTime();
        //System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c);

        return formattedDate;
    }

    void setupUI() {
        taxdate_et.setText(currentDate());//
    }

    /**
     * Hides the soft keyboard
     */
    public void hideSoftKeyboard() {
        if(getCurrentFocus()!=null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    /**
     * Shows the soft keyboard
     */
    public void showSoftKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        view.requestFocus();
        inputMethodManager.showSoftInput(view, 0);
    }

    boolean checkValidations() {

        return true;
    }

//    void dismissKeyboard(EditText edText) {
//        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.hideSoftInputFromWindow(edText.getWindowToken(), 0);
//    }

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

        //https://www.tutorialspoint.com/how-to-check-visibility-of-virtual-keyboard-on-android
        constraintLayout=findViewById(R.id.rootView);
        constraintLayout.getViewTreeObserver().addOnGlobalLayoutListener(new             ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Rect r = new Rect();
                constraintLayout.getWindowVisibleDisplayFrame(r);
                int screenHeight = constraintLayout.getRootView().getHeight();
                int keypadHeight = screenHeight - r.bottom;
                if (keypadHeight > screenHeight * 0.15) {
                    //Toast.makeText(MainActivity.this,"Keyboard is showing",Toast.LENGTH_LONG).show();
                } else {
                    // call method
                    fnOrln_etComplete();
                    grossin_etComplete();
                    //Toast.makeText(MainActivity.this,"keyboard closed",Toast.LENGTH_LONG).show();
                }
            }
        });

        gender_et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                genderClicked();
            }
        });

        //
        fn_et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                switch (actionId){
                    case EditorInfo.IME_ACTION_DONE:
                        fnOrln_etComplete();
                        return true;
                    case EditorInfo.IME_ACTION_NEXT:
                        fnOrln_etComplete();
                        return true;
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
                        fnOrln_etComplete();
                        return true;
                    case EditorInfo.IME_ACTION_NEXT:
                        fnOrln_etComplete();
                        return true;
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
                        grossin_etComplete();
                        return true;
                    case EditorInfo.IME_ACTION_NEXT:
                        grossin_etComplete();
                        return true;
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
