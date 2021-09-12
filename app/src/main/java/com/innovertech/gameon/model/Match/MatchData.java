package com.innovertech.gameon.model.Match;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MatchData implements Parcelable {
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("match_id")
        @Expose
        private Integer matchId;
        @SerializedName("team_1")
        @Expose
        private String team1;
        @SerializedName("team_2")
        @Expose
        private String team2;
        @SerializedName("match_start_time")
        @Expose
        private String matchStartTime;
        @SerializedName("board_flag_1")
        @Expose
        private String boardFlag1;
        @SerializedName("board_flag_2")
        @Expose
        private String boardFlag2;
        @SerializedName("team_1_flag")
        @Expose
        private String team1Flag;
        @SerializedName("team_2_flag")
        @Expose
        private String team2Flag;
        @SerializedName("played")
        @Expose
        private String played;

    protected MatchData(Parcel in) {
        type = in.readString();
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        if (in.readByte() == 0) {
            matchId = null;
        } else {
            matchId = in.readInt();
        }
        team1 = in.readString();
        team2 = in.readString();
        matchStartTime = in.readString();
        boardFlag1 = in.readString();
        boardFlag2 = in.readString();
        team1Flag = in.readString();
        team2Flag = in.readString();
        played = in.readString();
    }

    public static final Creator<MatchData> CREATOR = new Creator<MatchData>() {
        @Override
        public MatchData createFromParcel(Parcel in) {
            return new MatchData(in);
        }

        @Override
        public MatchData[] newArray(int size) {
            return new MatchData[size];
        }
    };

    public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getMatchId() {
            return matchId;
        }

        public void setMatchId(Integer matchId) {
            this.matchId = matchId;
        }

        public String getTeam1() {
            return team1;
        }

        public void setTeam1(String team1) {
            this.team1 = team1;
        }

        public String getTeam2() {
            return team2;
        }

        public void setTeam2(String team2) {
            this.team2 = team2;
        }

        public String getMatchStartTime() {
            return matchStartTime;
        }

        public void setMatchStartTime(String matchStartTime) {
            this.matchStartTime = matchStartTime;
        }

        public String getBoardFlag1() {
            return boardFlag1;
        }

        public void setBoardFlag1(String boardFlag1) {
            this.boardFlag1 = boardFlag1;
        }

        public String getBoardFlag2() {
            return boardFlag2;
        }

        public void setBoardFlag2(String boardFlag2) {
            this.boardFlag2 = boardFlag2;
        }

        public String getTeam1Flag() {
            return team1Flag;
        }

        public void setTeam1Flag(String team1Flag) {
            this.team1Flag = team1Flag;
        }

        public String getTeam2Flag() {
            return team2Flag;
        }

        public void setTeam2Flag(String team2Flag) {
            this.team2Flag = team2Flag;
        }

        public String getPlayed() {
            return played;
        }

        public void setPlayed(String played) {
            this.played = played;
        }

        @Override
        public String toString() {
            return "MatchData{" +
                    "type='" + type + '\'' +
                    ", id=" + id +
                    ", matchId=" + matchId +
                    ", team1='" + team1 + '\'' +
                    ", team2='" + team2 + '\'' +
                    ", matchStartTime='" + matchStartTime + '\'' +
                    ", boardFlag1='" + boardFlag1 + '\'' +
                    ", boardFlag2='" + boardFlag2 + '\'' +
                    ", team1Flag='" + team1Flag + '\'' +
                    ", team2Flag='" + team2Flag + '\'' +
                    ", played='" + played + '\'' +
                    '}';
        }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        if (matchId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(matchId);
        }
        dest.writeString(team1);
        dest.writeString(team2);
        dest.writeString(matchStartTime);
        dest.writeString(boardFlag1);
        dest.writeString(boardFlag2);
        dest.writeString(team1Flag);
        dest.writeString(team2Flag);
        dest.writeString(played);
    }
}
