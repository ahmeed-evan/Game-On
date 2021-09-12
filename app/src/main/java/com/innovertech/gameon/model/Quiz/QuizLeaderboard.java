package com.innovertech.gameon.model.Quiz;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuizLeaderboard {

    @SerializedName("rank")
    @Expose
    private Integer rank;
    @SerializedName("point")
    @Expose
    private Integer point;
    @SerializedName("name")
    @Expose
    private String name;

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "QuizLeaderboard{" +
                "rank=" + rank +
                ", point=" + point +
                ", name='" + name + '\'' +
                '}';
    }
}
