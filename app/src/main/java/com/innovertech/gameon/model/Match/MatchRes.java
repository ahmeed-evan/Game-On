package com.innovertech.gameon.model.Match;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MatchRes {
    @SerializedName("isLoggedIn")
    @Expose
    private Boolean isLoggedIn;
    @SerializedName("isSubscribed")
    @Expose
    private Boolean isSubscribed;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("msisdn")
    @Expose
    private String msisdn;
    @SerializedName("data")
    @Expose
    private List<MatchData> data = null;


    public Boolean getLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public Boolean getSubscribed() {
        return isSubscribed;
    }

    public void setSubscribed(Boolean subscribed) {
        isSubscribed = subscribed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public List<MatchData> getData() {
        return data;
    }

    public void setData(List<MatchData> data) {
        this.data = data;
    }

}
