package com.innovertech.gameon.model.Squad;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class SendAbleList implements Parcelable {
    List<Squad> squadList;

    public SendAbleList(List<Squad> squadList) {
        this.squadList = squadList;
    }

    protected SendAbleList(Parcel in) {
        squadList = in.createTypedArrayList(Squad.CREATOR);
    }

    public static final Creator<SendAbleList> CREATOR = new Creator<SendAbleList>() {
        @Override
        public SendAbleList createFromParcel(Parcel in) {
            return new SendAbleList(in);
        }

        @Override
        public SendAbleList[] newArray(int size) {
            return new SendAbleList[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(squadList);
    }

    @Override
    public String toString() {
        return "SendAbleList{" +
                "squadList=" + squadList +
                '}';
    }

    public List<Squad> getSquadList() {
        return squadList;
    }

    public void setSquadList(List<Squad> squadList) {
        this.squadList = squadList;
    }
}
