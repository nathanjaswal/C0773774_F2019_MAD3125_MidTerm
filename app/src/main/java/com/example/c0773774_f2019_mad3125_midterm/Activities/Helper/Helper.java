package com.example.c0773774_f2019_mad3125_midterm.Activities.Helper;

import android.util.Log;

public class Helper {

    Float calAge() {

        return 0.0f;
    }


    public Float calFedralTax(Float total) {

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

        return fedTax;
    }


}
