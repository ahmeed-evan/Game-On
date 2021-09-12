package com.innovertech.gameon.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserPointDetails extends User {

    @SerializedName("rank")
    @Expose
    private Integer rank;
    @SerializedName("point")
    @Expose
    private String point;
    @SerializedName("name")
    @Expose
    private String name;

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
