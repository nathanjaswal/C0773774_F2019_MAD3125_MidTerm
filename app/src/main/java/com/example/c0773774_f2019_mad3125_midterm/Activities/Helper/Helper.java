package com.example.c0773774_f2019_mad3125_midterm.Activities.Helper;

import android.os.Build;
import android.util.Log;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

import androidx.annotation.RequiresApi;

public class Helper {

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String calAge(LocalDate l) {

        //direct age calculation
       // LocalDate l = LocalDate.of(1998, 04, 23); //specify year, month, date directly
        LocalDate now = LocalDate.now(); //gets localDate
        Period diff = Period.between(l, now); //difference between the dates is calculated
        System.out.println(diff.getYears() + "years" + diff.getMonths() + "months" + diff.getDays() + "days");

        return String.valueOf(diff.getYears());
    }

    public String calCpp(Float total) {
        Float cpp = 0.0f;
        if(total >= 57400.0f) {
            cpp = 57400.0f * 0.051f;

        }
        //Log.i("Nitin W ", cpp.toString());
        String result = String.format("%.2f", cpp);
        return result;
    }

    public String calMaxRrsp(Float total) {
        Float rrsp = 0.0f;

        rrsp = total * 0.18f;

        String result = String.format("%.2f", rrsp);
        return result;
    }

    public String calEI(Float total) {
        Float ei = 0.0f;

        if(total >= 53100.0f) {
            ei = 53100.0f * 0.0162f;

        }

        String result = String.format("%.2f", ei);
        return result;
    }

    public Float calCarryFwdRrsp(Float total, Float enRrsp) {
        Float mRrsp = 0.0f;
        mRrsp = total * 0.18f;

//        if(mRrsp > enRrsp) {
//
//        }
        Float crrFwd = 0.0f;
        crrFwd = mRrsp - enRrsp;

        return crrFwd;
    }

    public String calFedralTax(Float total) {

        Float fedTax = 0.0f;

        Float grossAmnt = total;
        grossAmnt = grossAmnt - 12069.0f;

        // check bracket 2
        if (grossAmnt > 0.0f ) {
            fedTax = grossAmnt > 35561.0f ? fedTax + (35561.0f * 0.15f) : fedTax + (grossAmnt * 0.15f) ;
            grossAmnt = grossAmnt > 35561.0f ? (grossAmnt - 35561.0f) : 0.0f;

        }
        // check bracket 3
        if (grossAmnt > 0.0f){
            fedTax = grossAmnt > 47628.99f ? fedTax + (47628.99f * 0.205f) : fedTax + (grossAmnt * 0.205f);
            grossAmnt = grossAmnt > 47628.99f ? (grossAmnt - 47628.99f):0.0f;

        }
        // check bracket 4
        if (grossAmnt > 0.0f){
            fedTax = grossAmnt > 147667.0f ? fedTax + (147667.0f * 0.26f) : fedTax + (grossAmnt * 0.26f);
            grossAmnt = grossAmnt > 147667.0f ? (grossAmnt - 147667.0f):0.0f;

        }
        // check bracket 5
        if (grossAmnt > 0.0f){
            fedTax = grossAmnt > 62703.99f ? fedTax + (62703.99f * 0.29f) : fedTax + (grossAmnt * 0.29f);
            grossAmnt = grossAmnt > 62703.99f ? (grossAmnt - 62703.99f):0.0f;

        }
        // check bracket 6
        if (grossAmnt > 0.0f){
            fedTax = fedTax + (grossAmnt * 0.33f);

        }

        Log.i("RRRRNi>", fedTax.toString());
        String result = String.format("%.2f", fedTax);
        return result;
    }

    public String calProvTax(Float total) {

        Float provTax = 0.0f;

        Float grossAmnt = total;
        grossAmnt = grossAmnt - 10582.0f;

        // check bracket 2
        if (grossAmnt > 0.0f ) {
            provTax = grossAmnt > 33323.99f ? provTax + (33323.99f * 0.0505f) : provTax + (grossAmnt * 0.0505f) ;
            grossAmnt = grossAmnt > 33323.99f ? (grossAmnt - 33323.99f) : 0.0f;

        }
        // check bracket 3
        if (grossAmnt > 0.0f){
            provTax = grossAmnt > 43906.99f ? provTax + (43906.99f * 0.0915f) : provTax + (grossAmnt * 0.0915f);
            grossAmnt = grossAmnt > 43906.99f ? (grossAmnt - 43906.99f):0.0f;

        }
        // check bracket 4
        if (grossAmnt > 0.0f){
            provTax = grossAmnt > 62186.99f ? provTax + (62186.99f * 0.1116f) : provTax + (grossAmnt * 0.1116f);
            grossAmnt = grossAmnt > 62186.99f ? (grossAmnt - 62186.99f):0.0f;

        }
        // check bracket 5
        if (grossAmnt > 0.0f){
            provTax = grossAmnt > 69999.99f ? provTax + (69999.99f * 0.29f) : provTax + (grossAmnt * 0.1216f);
            grossAmnt = grossAmnt > 69999.99f ? (grossAmnt - 69999.99f):0.0f;

        }
        // check bracket 6
        if (grossAmnt > 0.0f){
            provTax = provTax + (grossAmnt * 0.1316f);

        }

        Log.i("RRRRNi>", provTax.toString());
        String result = String.format("%.2f", provTax);
        return result;
    }


}
