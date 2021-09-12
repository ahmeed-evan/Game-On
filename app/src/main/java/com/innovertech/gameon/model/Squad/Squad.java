package com.innovertech.gameon.model.Squad;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Squad implements Parcelable {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("player_id")
    @Expose
    private String playerId;
    @SerializedName("flag")
    @Expose
    private String flag;

    public Squad(String name, String playerId, String flag) {
        this.name = name;
        this.playerId = playerId;
        this.flag = flag;
    }

    protected Squad(Parcel in) {
        name = in.readString();
        playerId = in.readString();
        flag = in.readString();
    }

    public static final Creator<Squad> CREATOR = new Creator<Squad>() {
        @Override
        public Squad createFromParcel(Parcel in) {
            return new Squad(in);
        }

        @Override
        public Squad[] newArray(int size) {
            return new Squad[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(playerId);
        dest.writeString(flag);
    }

    @Override
    public String toString() {
        return "Squad{" +
                "name='" + name + '\'' +
                ", playerId='" + playerId + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}