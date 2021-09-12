package com.innovertech.gameon.model.PointHistoryDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlayerPoint {
    @SerializedName("player_id")
    @Expose
    private String playerId;
    @SerializedName("player_name")
    @Expose
    private String playerName;
    @SerializedName("team_name")
    @Expose
    private String teamName;
    @SerializedName("point")
    @Expose
    private String point;
    @SerializedName("flag")
    @Expose
    private String flag;
    @SerializedName("is_captain")
    @Expose
    private Boolean isCaptain;

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Boolean getCaptain() {
        return isCaptain;
    }

    public void setCaptain(Boolean captain) {
        isCaptain = captain;
    }

    @Override
    public String toString() {
        return "PlayerPoint{" +
                "playerId='" + playerId + '\'' +
                ", playerName='" + playerName + '\'' +
                ", teamName='" + teamName + '\'' +
                ", point='" + point + '\'' +
                ", flag='" + flag + '\'' +
                ", isCaptain=" + isCaptain +
                '}';
    }
}
