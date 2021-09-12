package com.innovertech.gameon.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubscriptionRes {
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("aoc_url")
    @Expose
    private String aocUrl;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getAocUrl() {
        return aocUrl;
    }

    public void setAocUrl(String aocUrl) {
        this.aocUrl = aocUrl;
    }

    @Override
    public String toString() {
        return "SubscriptionRes{" +
                "status=" + status +
                ", aocUrl='" + aocUrl + '\'' +
                '}';
    }
}
