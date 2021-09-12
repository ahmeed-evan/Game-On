package com.innovertech.gameon.model.FootballMatchHistory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FootballMatchHistoryRes {

    @SerializedName("total_points")
    @Expose
    private String totalPoints;
    @SerializedName("data")
    @Expose
    private List<FootballMatchHistoryData> data = null;
    @SerializedName("msisdn")
    @Expose
    private String msisdn;

    public String getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(String totalPoints) {
        this.totalPoints = totalPoints;
    }

    public List<FootballMatchHistoryData> getData() {
        return data;
    }

    public void setData(List<FootballMatchHistoryData> data) {
        this.data = data;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    @Override
    public String toString() {
        return "FootballMatchHistory{" +
                "totalPoints='" + totalPoints + '\'' +
                ", data=" + data +
                ", msisdn='" + msisdn + '\'' +
                '}';
    }

}
