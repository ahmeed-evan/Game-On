package com.innovertech.gameon.model.MobileVerify;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MobilePinVerify {
    @SerializedName("pin")
    @Expose
    private String pin;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("subId")
    @Expose
    private String subId;

    public MobilePinVerify(String pin, String mobile, String subId) {
        this.pin = pin;
        this.mobile = mobile;
        this.subId = subId;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    @Override
    public String toString() {
        return "MobilePinVerify{" +
                "pin='" + pin + '\'' +
                ", mobile='" + mobile + '\'' +
                ", subId='" + subId + '\'' +
                '}';
    }
}
