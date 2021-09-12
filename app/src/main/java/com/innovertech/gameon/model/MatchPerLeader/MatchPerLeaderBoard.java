package com.innovertech.gameon.model.MatchPerLeader;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MatchPerLeaderBoard implements Parcelable {

    @SerializedName("rank")
    @Expose
    private Integer rank;
    @SerializedName("point")
    @Expose
    private String point;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private Integer id;

    protected MatchPerLeaderBoard(Parcel in) {
        if (in.readByte() == 0) {
            rank = null;
        } else {
            rank = in.readInt();
        }
        point = in.readString();
        name = in.readString();
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
    }

    public static final Creator<MatchPerLeaderBoard> CREATOR = new Creator<MatchPerLeaderBoard>() {
        @Override
        public MatchPerLeaderBoard createFromParcel(Parcel in) {
            return new MatchPerLeaderBoard(in);
        }

        @Override
        public MatchPerLeaderBoard[] newArray(int size) {
            return new MatchPerLeaderBoard[size];
        }
    };

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MatchPerLeaderBoard{" +
                "rank=" + rank +
                ", point='" + point + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (rank == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(rank);
        }
        dest.writeString(point);
        dest.writeString(name);
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
    }
}
