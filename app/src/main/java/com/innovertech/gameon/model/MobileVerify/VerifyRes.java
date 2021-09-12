package com.innovertech.gameon.model.MobileVerify;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VerifyRes {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("msg")
    @Expose
    private String msg;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "MobilePinVerifyRes{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                '}';
    }
}
