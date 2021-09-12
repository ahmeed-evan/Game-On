package com.innovertech.gameon.model.PointHistoryDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PointHistoryDetailsFootball {

    @SerializedName("msisdn")
    @Expose
    private String msisdn;
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("match_id")
    @Expose
    private Integer matchId;
    @SerializedName("point")
    @Expose
    private String point;
    @SerializedName("rank")
    @Expose
    private Integer rank;
    @SerializedName("captain_id")
    @Expose
    private Integer captainId;
    @SerializedName("player_points")
    @Expose
    private List<PlayerPoint> playerPoints = null;

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getCaptainId() {
        return captainId;
    }

    public void setCaptainId(Integer captainId) {
        this.captainId = captainId;
    }

    public List<PlayerPoint> getPlayerPoints() {
        return playerPoints;
    }

    public void setPlayerPoints(List<PlayerPoint> playerPoints) {
        this.playerPoints = playerPoints;
    }

}
