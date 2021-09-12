package com.innovertech.gameon.model.Squad;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SquadRes {
    @SerializedName("msisdn")
    @Expose
    private String msisdn;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("match_id")
    @Expose
    private String matchId;
    @SerializedName("team1")
    @Expose
    private Team1 team1;
    @SerializedName("team2")
    @Expose
    private Team2 team2;

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public Team1 getTeam1() {
        return team1;
    }

    public void setTeam1(Team1 team1) {
        this.team1 = team1;
    }

    public Team2 getTeam2() {
        return team2;
    }

    public void setTeam2(Team2 team2) {
        this.team2 = team2;
    }

    @Override
    public String toString() {
        return "SquadRes{" +
                "msisdn='" + msisdn + '\'' +
                ", type='" + type + '\'' +
                ", matchId='" + matchId + '\'' +
                ", team1=" + team1 +
                ", team2=" + team2 +
                '}';
    }

    public class Team1 {
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("squad")
        @Expose
        private List<Squad> squad = null;
        @SerializedName("flag")
        @Expose
        private String flag;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Squad> getSquad() {
            return squad;
        }

        public void setSquad(List<Squad> squad) {
            this.squad = squad;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

    }

    public class Team2 {
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("squad")
        @Expose
        private List<Squad> squad = null;
        @SerializedName("flag")
        @Expose
        private String flag;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Squad> getSquad() {
            return squad;
        }

        public void setSquad(List<Squad> squad) {
            this.squad = squad;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

    }
}
