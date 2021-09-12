package com.innovertech.gameon.model.Squad;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SelectedSquad {

    @SerializedName("match_id")
    @Expose
    private String matchId;
    @SerializedName("player_1_id")
    @Expose
    private String player1Id;
    @SerializedName("player_2_id")
    @Expose
    private String player2Id;
    @SerializedName("player_3_id")
    @Expose
    private String player3Id;
    @SerializedName("player_4_id")
    @Expose
    private String player4Id;
    @SerializedName("player_5_id")
    @Expose
    private String player5Id;
    @SerializedName("player_6_id")
    @Expose
    private String player6Id;
    @SerializedName("player_7_id")
    @Expose
    private String player7Id;
    @SerializedName("player_8_id")
    @Expose
    private String player8Id;
    @SerializedName("player_9_id")
    @Expose
    private String player9Id;
    @SerializedName("player_10_id")
    @Expose
    private String player10Id;
    @SerializedName("player_11_id")
    @Expose
    private String player11Id;
    @SerializedName("captain_id")
    @Expose
    private String captainId;

    public SelectedSquad(String matchId, String player1Id, String player2Id, String player3Id, String player4Id, String player5Id, String player6Id, String player7Id, String player8Id, String player9Id, String player10Id, String player11Id, String captainId) {
        this.matchId = matchId;
        this.player1Id = player1Id;
        this.player2Id = player2Id;
        this.player3Id = player3Id;
        this.player4Id = player4Id;
        this.player5Id = player5Id;
        this.player6Id = player6Id;
        this.player7Id = player7Id;
        this.player8Id = player8Id;
        this.player9Id = player9Id;
        this.player10Id = player10Id;
        this.player11Id = player11Id;
        this.captainId = captainId;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getPlayer1Id() {
        return player1Id;
    }

    public void setPlayer1Id(String player1Id) {
        this.player1Id = player1Id;
    }

    public String getPlayer2Id() {
        return player2Id;
    }

    public void setPlayer2Id(String player2Id) {
        this.player2Id = player2Id;
    }

    public String getPlayer3Id() {
        return player3Id;
    }

    public void setPlayer3Id(String player3Id) {
        this.player3Id = player3Id;
    }

    public String getPlayer4Id() {
        return player4Id;
    }

    public void setPlayer4Id(String player4Id) {
        this.player4Id = player4Id;
    }

    public String getPlayer5Id() {
        return player5Id;
    }

    public void setPlayer5Id(String player5Id) {
        this.player5Id = player5Id;
    }

    public String getPlayer6Id() {
        return player6Id;
    }

    public void setPlayer6Id(String player6Id) {
        this.player6Id = player6Id;
    }

    public String getPlayer7Id() {
        return player7Id;
    }

    public void setPlayer7Id(String player7Id) {
        this.player7Id = player7Id;
    }

    public String getPlayer8Id() {
        return player8Id;
    }

    public void setPlayer8Id(String player8Id) {
        this.player8Id = player8Id;
    }

    public String getPlayer9Id() {
        return player9Id;
    }

    public void setPlayer9Id(String player9Id) {
        this.player9Id = player9Id;
    }

    public String getPlayer10Id() {
        return player10Id;
    }

    public void setPlayer10Id(String player10Id) {
        this.player10Id = player10Id;
    }

    public String getPlayer11Id() {
        return player11Id;
    }

    public void setPlayer11Id(String player11Id) {
        this.player11Id = player11Id;
    }

    public String getCaptainId() {
        return captainId;
    }

    public void setCaptainId(String captainId) {
        this.captainId = captainId;
    }

    @Override
    public String toString() {
        return "SelectedSquad{" +
                "matchId='" + matchId + '\'' +
                ", player1Id='" + player1Id + '\'' +
                ", player2Id='" + player2Id + '\'' +
                ", player3Id='" + player3Id + '\'' +
                ", player4Id='" + player4Id + '\'' +
                ", player5Id='" + player5Id + '\'' +
                ", player6Id='" + player6Id + '\'' +
                ", player7Id='" + player7Id + '\'' +
                ", player8Id='" + player8Id + '\'' +
                ", player9Id='" + player9Id + '\'' +
                ", player10Id='" + player10Id + '\'' +
                ", player11Id='" + player11Id + '\'' +
                ", captainId='" + captainId + '\'' +
                '}';
    }
}
