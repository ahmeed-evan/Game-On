package com.innovertech.gameon.model.NumberLogin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OtpNumber {
    @SerializedName("mobile")
    @Expose
    private String mobile;


    public OtpNumber(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}
