package com.innovertech.gameon.model.CricketMatchHistory;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CricketMatchHistoryRes implements Parcelable {

    @SerializedName("total_points")
    @Expose
    private String totalPoints;
    @SerializedName("data")
    @Expose
    private List<CricketMatchHistoryData> data = null;
    @SerializedName("msisdn")
    @Expose
    private String msisdn;


    protected CricketMatchHistoryRes(Parcel in) {
        totalPoints = in.readString();
        msisdn = in.readString();
    }

    public static final Creator<CricketMatchHistoryRes> CREATOR = new Creator<CricketMatchHistoryRes>() {
        @Override
        public CricketMatchHistoryRes createFromParcel(Parcel in) {
            return new CricketMatchHistoryRes(in);
        }

        @Override
        public CricketMatchHistoryRes[] newArray(int size) {
            return new CricketMatchHistoryRes[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(totalPoints);
        dest.writeString(msisdn);
    }

    public String getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(String totalPoints) {
        this.totalPoints = totalPoints;
    }

    public List<CricketMatchHistoryData> getData() {
        return data;
    }

    public void setData(List<CricketMatchHistoryData> data) {
        this.data = data;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }
}
