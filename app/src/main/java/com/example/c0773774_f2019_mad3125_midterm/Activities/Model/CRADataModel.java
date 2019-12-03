package com.example.c0773774_f2019_mad3125_midterm.Activities.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.logging.StreamHandler;

public class CRADataModel implements Parcelable {

    String sinV;
    String fnV;
    String lnV;
    String fullnV;
    String dobV;
    String ageV;
    String genderV;
    String taxDateV;
    String grossInV;
    String fedTaxV;
    String provTaxV;
    String cppV;
    String eiV;
    String rrspV;
    String cfwdV;
    String ttlInV;
    String ttlPyV;

    public CRADataModel() {
        this.sinV = sinV;
        this.fnV = fnV;
        this.lnV = lnV;
        this.fullnV = fullnV;
        this.dobV = dobV;
        this.ageV = ageV;
        this.genderV = genderV;
        this.taxDateV = taxDateV;
        this.grossInV = grossInV;
        this.fedTaxV = fedTaxV;
        this.provTaxV = provTaxV;
        this.cppV = cppV;
        this.eiV = eiV;
        this.rrspV = rrspV;
        this.cfwdV = cfwdV;
        this.ttlInV = ttlInV;
        this.ttlPyV = ttlPyV;
    }

    protected CRADataModel(Parcel in) {
        sinV = in.readString();
        fnV = in.readString();
        lnV = in.readString();
        fullnV = in.readString();
        dobV = in.readString();
        ageV = in.readString();
        genderV = in.readString();
        taxDateV = in.readString();
        grossInV = in.readString();
        fedTaxV = in.readString();
        provTaxV = in.readString();
        cppV = in.readString();
        eiV = in.readString();
        rrspV = in.readString();
        cfwdV = in.readString();
        ttlInV = in.readString();
        ttlPyV = in.readString();
    }

    public static final Creator<CRADataModel> CREATOR = new Creator<CRADataModel>() {
        @Override
        public CRADataModel createFromParcel(Parcel in) {
            return new CRADataModel(in);
        }

        @Override
        public CRADataModel[] newArray(int size) {
            return new CRADataModel[size];
        }
    };

    public String getSinV() {
        return sinV;
    }

    public void setSinV(String sinV) {
        this.sinV = sinV;
    }

    public String getFnV() {
        return fnV;
    }

    public void setFnV(String fnV) {
        this.fnV = fnV;
    }

    public String getLnV() {
        return lnV;
    }

    public void setLnV(String lnV) {
        this.lnV = lnV;
    }

    public String getFullnV() {
        return fullnV;
    }

    public void setFullnV(String fullnV) {
        this.fullnV = fullnV;
    }

    public String getDobV() {
        return dobV;
    }

    public void setDobV(String dobV) {
        this.dobV = dobV;
    }

    public String getAgeV() {
        return ageV;
    }

    public void setAgeV(String ageV) {
        this.ageV = ageV;
    }

    public String getGenderV() {
        return genderV;
    }

    public void setGenderV(String genderV) {
        this.genderV = genderV;
    }

    public String getTaxDateV() {
        return taxDateV;
    }

    public void setTaxDateV(String taxDateV) {
        this.taxDateV = taxDateV;
    }

    public String getGrossInV() {
        return grossInV;
    }

    public void setGrossInV(String grossInV) {
        this.grossInV = grossInV;
    }

    public String getFedTaxV() {
        return fedTaxV;
    }

    public void setFedTaxV(String fedTaxV) {
        this.fedTaxV = fedTaxV;
    }

    public String getProvTaxV() {
        return provTaxV;
    }

    public void setProvTaxV(String provTaxV) {
        this.provTaxV = provTaxV;
    }

    public String getCppV() {
        return cppV;
    }

    public void setCppV(String cppV) {
        this.cppV = cppV;
    }

    public String getEiV() {
        return eiV;
    }

    public void setEiV(String eiV) {
        this.eiV = eiV;
    }

    public String getRrspV() {
        return rrspV;
    }

    public void setRrspV(String rrspV) {
        this.rrspV = rrspV;
    }

    public String getCfwdV() {
        return cfwdV;
    }

    public void setCfwdV(String cfwdV) {
        this.cfwdV = cfwdV;
    }

    public String getTtlInV() {
        return ttlInV;
    }

    public void setTtlInV(String ttlInV) {
        this.ttlInV = ttlInV;
    }

    public String getTtlPyV() {
        return ttlPyV;
    }

    public void setTtlPyV(String ttlPyV) {
        this.ttlPyV = ttlPyV;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sinV);
        dest.writeString(fnV);
        dest.writeString(lnV);
        dest.writeString(fullnV);
        dest.writeString(dobV);
        dest.writeString(ageV);
        dest.writeString(genderV);
        dest.writeString(taxDateV);
        dest.writeString(grossInV);
        dest.writeString(fedTaxV);
        dest.writeString(provTaxV);
        dest.writeString(cppV);
        dest.writeString(eiV);
        dest.writeString(rrspV);
        dest.writeString(cfwdV);
        dest.writeString(ttlInV);
        dest.writeString(ttlPyV);
    }
}
