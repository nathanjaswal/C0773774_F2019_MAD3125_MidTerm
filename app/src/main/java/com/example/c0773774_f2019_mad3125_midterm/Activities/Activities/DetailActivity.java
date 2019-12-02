package com.example.c0773774_f2019_mad3125_midterm.Activities.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.c0773774_f2019_mad3125_midterm.R;

public class DetailActivity extends AppCompatActivity {

    //Button back_btn;

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
    }
}
