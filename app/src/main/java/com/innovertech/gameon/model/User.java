package com.innovertech.gameon.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("isVerified")
    @Expose
    private Boolean isVerified;
    @SerializedName("isSubscribed")
    @Expose
    private Boolean isSubscribed;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("subId")
    @Expose
    private String subId;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getVerified() {
        return isVerified;
    }

    public void setVerified(Boolean verified) {
        isVerified = verified;
    }

    public Boolean getSubscribed() {
        return isSubscribed;
    }

    public void setSubscribed(Boolean subscribed) {
        isSubscribed = subscribed;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    @Override
    public String toString() {
        return "User{" +
                "status=" + status +
                ", isVerified=" + isVerified +
                ", isSubscribed=" + isSubscribed +
                ", msg='" + msg + '\'' +
                ", subId='" + subId + '\'' +
                '}';
    }
}
