package com.innovertech.gameon.model.OtpVerification;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Otp {
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("pin")
    @Expose
    private String pin;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Otp(String mobile, String pin) {
        this.mobile = mobile;
        this.pin = pin;
    }
}
