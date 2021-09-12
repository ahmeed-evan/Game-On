package com.innovertech.gameon.model.MatchPerLeader;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.innovertech.gameon.model.PointHistoryDetails.PlayerPoint;


import java.util.List;

public class MatchPerLeaderPoint {
    @SerializedName("msisdn")
    @Expose
    private String msisdn;
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("match_id")
    @Expose
    private String matchId;
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
    @SerializedName("points")
    @Expose
    private Points points;

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

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
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

    public Points getPoints() {
        return points;
    }

    public void setPoints(Points points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "MatchPerLeaderPoint{" +
                "msisdn='" + msisdn + '\'' +
                ", success=" + success +
                ", matchId='" + matchId + '\'' +
                ", point='" + point + '\'' +
                ", rank=" + rank +
                ", captainId=" + captainId +
                ", playerPoints=" + playerPoints +
                ", points=" + points +
                '}';
    }

    private class Points {
        @SerializedName("msisdn")
        @Expose
        private String msisdn;
        @SerializedName("success")
        @Expose
        private Boolean success;
        @SerializedName("match_id")
        @Expose
        private String matchId;
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

        public String getMatchId() {
            return matchId;
        }

        public void setMatchId(String matchId) {
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
}
