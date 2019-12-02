package com.example.c0773774_f2019_mad3125_midterm.Activities;
//
// https://stackoverflow.com/questions/8654990/how-can-i-get-current-date-in-android

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.c0773774_f2019_mad3125_midterm.Activities.Activities.DetailActivity;
import com.example.c0773774_f2019_mad3125_midterm.Activities.Helper.Helper;
import com.example.c0773774_f2019_mad3125_midterm.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

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
    TextView mrrsp_tv;
    EditText cfwd_rrsp_et;
    EditText ttl_taxin_et;
    EditText ttl_taxpyd_et;
    Button cont_btn;

    ConstraintLayout constraintLayout;

    DatePickerDialog datePickerDialog;

    int year;
    int month;
    int dayOfMonth;
    Calendar calendar;

    int ageOfUser;

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
            String strFullN = ln_et.getText().toString().toUpperCase() + " " + fn_et.getText().toString();
            fulln_tv.setText("Full Name: " + strFullN);
        }
        //edText.setFocusable(false);
        //edText.setImeOptions(EditorInfo.IME_ACTION_NEXT);
        this.hideSoftKeyboard();
    }

    void grossin_etComplete() {

        if (grossin_et.getText().toString().length() != 0){
            Helper obj = new Helper();

            String grossVal = grossin_et.getText().toString();
            Float passVal = Float.parseFloat(grossVal);

            String strCpp = obj.calCpp(passVal);
            cpp_et.setText(strCpp);
            ei_et.setText(obj.calEI(passVal));
            mrrsp_tv.setText("Max. RRSP: " + obj.calMaxRrsp(passVal));

        }

        this.hideSoftKeyboard();

    }

//    void rrsp_etStarted() {
//        if (grossin_et.getText().toString().length() == 0) {
//
////            rrsp_et.setEditableFactory(true);//setFocusable(false);
//            //
//            //Toast.makeText(MainActivity.this,"Please Enter Gross Income first... ",Toast.LENGTH_LONG).show();
//            rrsp_et.setImeOptions(EditorInfo.IME_ACTION_NEXT);
//            this.hideSoftKeyboard();
//        }else{
//            //rrsp_et.setFocusable(true);
//            Toast.makeText(MainActivity.this,"Start... ",Toast.LENGTH_LONG).show();
//        }

//    }

    //@SuppressLint("ResourceAsColor")

    void rrsp_etCompleted() {
        if (grossin_et.getText().toString().length() != 0 && rrsp_et.getText().toString().length() != 0) {
            Helper obj = new Helper();

            Float passVal = Float.parseFloat(grossin_et.getText().toString());
            Float enRsspVal = Float.parseFloat(rrsp_et.getText().toString());
            Float carryFwdRrsp = obj.calCarryFwdRrsp(passVal, enRsspVal);
            String cfwdStr = String.format("%.2f", carryFwdRrsp);
            cfwd_rrsp_et.setText(cfwdStr);
            Log.i("", cpp_et.getText().toString());
//            if(carryFwdRrsp < 0.0f){
//                String s = "<b>Bolded text</b>, <i>italic text</i>, even <u>underlined</u>!";
//                //age_tv.setTypeface(null, Typeface.BOLD);
//                //cfwd_rrsp_et.setTextColor(R.color.themeColor);
//                cfwd_rrsp_et.setText(Html.fromHtml(s));
//            }

            Log.i("", cpp_et.getText().toString());

            Float cpp = Float.parseFloat(cpp_et.getText().toString());
            Float ei = Float.parseFloat(ei_et.getText().toString());

            Float maxRrspVal = Float.parseFloat(obj.calMaxRrsp(passVal));
            Float totalTaxIn = passVal - (cpp + ei + maxRrspVal);
            ttl_taxin_et.setText(totalTaxIn.toString());

            fedTax_et.setText(obj.calFedralTax(totalTaxIn));
            provTax_et.setText(obj.calProvTax(totalTaxIn));

            Float fedTax = Float.parseFloat(obj.calFedralTax(totalTaxIn));
            Float provTax = Float.parseFloat(obj.calProvTax(totalTaxIn));
            Float totalPayed = fedTax + provTax;
            String strTtlPayed = String.format("%.2f", totalPayed);
            ttl_taxpyd_et.setText(strTtlPayed);
        }else{
            rrsp_et.setText("");
            if(rrsp_et.hasFocus() && grossin_et.getText().toString().length() == 0){

                Toast.makeText(MainActivity.this,"Please Enter Gross Income first... ",Toast.LENGTH_LONG).show();
                this.hideSoftKeyboard();
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void dobClicked() {

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        datePickerDialog = new DatePickerDialog(MainActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        LocalDate l = LocalDate.of(year, month+1, dayOfMonth);
                        Helper obj = new Helper();
                        //
                        ageOfUser = Integer.valueOf(obj.calAge(l));
                        age_tv.setText("Age: " + obj.calAge(l));
                        Log.i("Nitin>>", "inputDateStr");
                        String inputDateStr= String.valueOf(year) +"-"+ String.valueOf(month+1)+"-"+ String.valueOf(dayOfMonth) ;
                        Log.i("Nitin>>", inputDateStr);
                        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
                        DateFormat outputFormat = new SimpleDateFormat("dd-MMM-yyyy");
                        Date date = null;
                        try {
                            date = inputFormat.parse(inputDateStr);
                            String outputDateStr = outputFormat.format(date);
                            dob_et.setText(outputDateStr);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        //
                        checkValidation();

                    }
                }, year, month, dayOfMonth);

        datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
        datePickerDialog.show();

        this.hideSoftKeyboard();

    }

    void genderClicked(View v){

        this.hideSoftKeyboard();

        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.menu_gender);
        popup.show();
    }

    void contClicked() {

        // call method
        if(sin_et.getText().toString().length() == 0 ||
                fn_et.getText().toString().length() == 0 ||
                ln_et.getText().toString().length() == 0 ||
                dob_et.getText().toString().length() == 0 ||
                gender_et.getText().toString().length() == 0 ||
                grossin_et.getText().toString().length() == 0 ||
                rrsp_et.getText().toString().length() == 0 ||
                cfwd_rrsp_et.getText().toString().length() == 0 ||
                ttl_taxin_et.getText().toString().length() == 0 ||
                cpp_et.getText().toString().length() == 0 ||
                ei_et.getText().toString().length() == 0 ||
                fedTax_et.getText().toString().length() == 0 ||
                provTax_et.getText().toString().length() == 0 ||
                ttl_taxpyd_et.getText().toString().length() == 0){
            cont_btn.setAlpha(0.2f);
             Toast.makeText(MainActivity.this,"All Field are required",Toast.LENGTH_LONG).show();
        }else if (ageOfUser < 18){
            cont_btn.setAlpha(0.2f);

            // call method
            customToast("Not eligible to file tax for current year 2019");

        }else if (sin_et.getText().toString().length() < 9){
            cont_btn.setAlpha(0.2f);

            // call method
            customToast("SIN should be of 9 digits");
        }else{
            cont_btn.setAlpha(1.0f);

            // navigate
            Intent dAct = new Intent(MainActivity.this, DetailActivity.class);

            HashMap<String, String> dataMap=new HashMap<String, String>();

            dataMap.put("SinMV", sin_et.getText().toString());
            dataMap.put("FnameMV", fn_et.getText().toString());
            dataMap.put("LnameMV", ln_et.getText().toString());
            dataMap.put("FulnameMV", ln_et.getText().toString().toUpperCase() + " " + fn_et.getText().toString());
            dataMap.put("DobMV", dob_et.getText().toString());
            dataMap.put("AgeMV", String.valueOf(ageOfUser));
            dataMap.put("GenderMV", gender_et.getText().toString());
            dataMap.put("TaxDateMV", taxdate_et.getText().toString());
            dataMap.put("GrossInMV", grossin_et.getText().toString());
            dataMap.put("RrspMV", rrsp_et.getText().toString());
            dataMap.put("CarrFwdMV", cfwd_rrsp_et.getText().toString());
            dataMap.put("TtlTaxInMV", ttl_taxin_et.getText().toString());
            dataMap.put("CppMV", cpp_et.getText().toString());
            dataMap.put("EiMV", ei_et.getText().toString());
            dataMap.put("FtMV", fedTax_et.getText().toString());
            dataMap.put("PrMV", provTax_et.getText().toString());
            dataMap.put("TtPayMV", ttl_taxpyd_et.getText().toString());

            dAct.putExtra("DataCal", dataMap);

            startActivity(dAct);
        }

    }

    // Helper: -
    void customToast(String msg){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_layout));
        TextView tv = (TextView) layout.findViewById(R.id.cTostTV);
        tv.setText(msg);
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 100);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    @SuppressLint("ResourceAsColor")
    void checkValidation(){
        if(sin_et.getText().toString().length() == 0 ||
                fn_et.getText().toString().length() == 0 ||
                ln_et.getText().toString().length() == 0 ||
                dob_et.getText().toString().length() == 0 ||
                gender_et.getText().toString().length() == 0 ||
                grossin_et.getText().toString().length() == 0 ||
                rrsp_et.getText().toString().length() == 0 ||
                cfwd_rrsp_et.getText().toString().length() == 0 ||
                ttl_taxin_et.getText().toString().length() == 0 ||
                cpp_et.getText().toString().length() == 0 ||
                ei_et.getText().toString().length() == 0 ||
                fedTax_et.getText().toString().length() == 0 ||
                provTax_et.getText().toString().length() == 0 ||
                ttl_taxpyd_et.getText().toString().length() == 0){
            cont_btn.setAlpha(0.2f);
           // Toast.makeText(MainActivity.this,"All Field are required",Toast.LENGTH_LONG).show();
        }else if (ageOfUser < 18){
            cont_btn.setAlpha(0.2f);
//            Toast toast = Toast.makeText(MainActivity.this, "Not eligible to file tax for current year 2019", Toast.LENGTH_SHORT);
//            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
//            v.setTextColor(R.color.colorAccent);
//            toast.show();
            //Toast.makeText(MainActivity.this,"All Field are required",Toast.LENGTH_LONG).show();
        }else if (sin_et.getText().toString().length() < 9){
            cont_btn.setAlpha(0.2f);

        }else{
            cont_btn.setAlpha(1.0f);
        }
    }

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
        mrrsp_tv = findViewById(R.id.mRrspTV);
        cfwd_rrsp_et = findViewById(R.id.carryRRSPET);
        ttl_taxin_et = findViewById(R.id.totalTaxET);
        ttl_taxpyd_et = findViewById(R.id.totalTaxPayedET);
        cont_btn = findViewById(R.id.contBtn);


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

                    fnOrln_etComplete();
                    grossin_etComplete();

                    checkValidation();

                    //Toast.makeText(MainActivity.this,"keyboard closed",Toast.LENGTH_LONG).show();
                }
                // call method
                rrsp_etCompleted();

            }
        });

        cont_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                contClicked();
            }
        });

        registerForContextMenu(gender_et);
        gender_et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                genderClicked(v);
            }
        });

        dob_ib.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {

                dobClicked();
            }
        });

        dob_et.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {

                dobClicked();
            }
        });

        rrsp_et.setOnTouchListener(new View.OnTouchListener()
        {
            public boolean onTouch(View arg0, MotionEvent arg1)
            {
                return false;
            }
        });


        //
        fn_et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                switch (actionId){
                    case EditorInfo.IME_ACTION_DONE:
                        fnOrln_etComplete();
                        checkValidation();
                        return true;
                    case EditorInfo.IME_ACTION_NEXT:
                        fnOrln_etComplete();
                        checkValidation();
                        return true;
                    case EditorInfo.IME_ACTION_PREVIOUS:
                        fnOrln_etComplete();
                        checkValidation();
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
                        checkValidation();
                        return true;
                    case EditorInfo.IME_ACTION_NEXT:
                        fnOrln_etComplete();
                        checkValidation();
                        return true;
                    case EditorInfo.IME_ACTION_PREVIOUS:
                        fnOrln_etComplete();
                        checkValidation();
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
                        rrsp_etCompleted();
                        checkValidation();
                        return true;
                    case EditorInfo.IME_ACTION_NEXT:
                        rrsp_etCompleted();
                        checkValidation();
                        return true;
                    case EditorInfo.IME_ACTION_PREVIOUS:
                        rrsp_etCompleted();
                        checkValidation();
                        return true;
                }
                return false;
            }
        });

    }

    // Override Methods:-
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.maleItem:
                gender_et.setText("Male");
                return true;
            case R.id.femaleItem:
                gender_et.setText("Female");
                return true;
            case R.id.otherItem:
                gender_et.setText("Other");
                return true;
            default:
                return false;
        }
    }
}
