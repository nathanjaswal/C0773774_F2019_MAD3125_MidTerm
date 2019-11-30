package com.example.c0773774_f2019_mad3125_midterm;
//
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // Life Cycle: -
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // call method
        this.setUpIni();

    }

    // Helper: -
    private void setUpIni() {
        //
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    // Action: -
    void dobClicked(View view){

    }

    void dobBtnClicked(View view){

    }

    void genderClicked(View view){

    }


}
