package com.innovertech.gameon.model.MobileVerify;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MobileVerify {

    @SerializedName("subId")
    @Expose
    private String subId;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("status")
    @Expose
    private Boolean status;

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MobileVerify{" +
                "subId='" + subId + '\'' +
                ", mobile='" + mobile + '\'' +
                ", type='" + type + '\'' +
                ", status=" + status +
                '}';
    }
}
