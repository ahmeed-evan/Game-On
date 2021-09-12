package com.innovertech.gameon.model.CricketMatchHistory;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CricketMatchHistoryData implements Parcelable {
    @SerializedName("api_unique_id")
    @Expose
    private Integer apiUniqueId;
    @SerializedName("is_result_done")
    @Expose
    private Integer isResultDone;
    @SerializedName("team_1")
    @Expose
    private String team1;
    @SerializedName("team_1_flag")
    @Expose
    private String team1Flag;
    @SerializedName("team_2")
    @Expose
    private String team2;
    @SerializedName("team_2_flag")
    @Expose
    private String team2Flag;
    @SerializedName("match_start_time")
    @Expose
    private String matchStartTime;
    @SerializedName("board_flag_1")
    @Expose
    private String boardFlag1;
    @SerializedName("board_flag_2")
    @Expose
    private String boardFlag2;

    protected CricketMatchHistoryData(Parcel in) {
        if (in.readByte() == 0) {
            apiUniqueId = null;
        } else {
            apiUniqueId = in.readInt();
        }
        if (in.readByte() == 0) {
            isResultDone = null;
        } else {
            isResultDone = in.readInt();
        }
        team1 = in.readString();
        team1Flag = in.readString();
        team2 = in.readString();
        team2Flag = in.readString();
        matchStartTime = in.readString();
        boardFlag1 = in.readString();
        boardFlag2 = in.readString();
    }

    public static final Creator<CricketMatchHistoryData> CREATOR = new Creator<CricketMatchHistoryData>() {
        @Override
        public CricketMatchHistoryData createFromParcel(Parcel in) {
            return new CricketMatchHistoryData(in);
        }

        @Override
        public CricketMatchHistoryData[] newArray(int size) {
            return new CricketMatchHistoryData[size];
        }
    };

    public Integer getApiUniqueId() {
        return apiUniqueId;
    }

    public void setApiUniqueId(Integer apiUniqueId) {
        this.apiUniqueId = apiUniqueId;
    }

    public Integer getIsResultDone() {
        return isResultDone;
    }

    public void setIsResultDone(Integer isResultDone) {
        this.isResultDone = isResultDone;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam1Flag() {
        return team1Flag;
    }

    public void setTeam1Flag(String team1Flag) {
        this.team1Flag = team1Flag;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getTeam2Flag() {
        return team2Flag;
    }

    public void setTeam2Flag(String team2Flag) {
        this.team2Flag = team2Flag;
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

    @Override
    public String toString() {
        return "CricketMatchHistoryData{" +
                "apiUniqueId=" + apiUniqueId +
                ", isResultDone=" + isResultDone +
                ", team1='" + team1 + '\'' +
                ", team1Flag='" + team1Flag + '\'' +
                ", team2='" + team2 + '\'' +
                ", team2Flag='" + team2Flag + '\'' +
                ", matchStartTime='" + matchStartTime + '\'' +
                ", boardFlag1='" + boardFlag1 + '\'' +
                ", boardFlag2='" + boardFlag2 + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (apiUniqueId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(apiUniqueId);
        }
        if (isResultDone == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(isResultDone);
        }
        dest.writeString(team1);
        dest.writeString(team1Flag);
        dest.writeString(team2);
        dest.writeString(team2Flag);
        dest.writeString(matchStartTime);
        dest.writeString(boardFlag1);
        dest.writeString(boardFlag2);
    }

}
