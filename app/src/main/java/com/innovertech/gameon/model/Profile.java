package com.innovertech.gameon.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Profile {
    @SerializedName("subId")
    @Expose
    private String subId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("pass")
    @Expose
    private String pass;

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Profile(String subId, String name, String mobile, String pass) {
        this.subId = subId;
        this.name = name;
        this.mobile = mobile;
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "subId='" + subId + '\'' +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
