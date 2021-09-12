package com.innovertech.gameon.model;

import com.google.gson.annotations.SerializedName;

public class AuthRequest {
    @SerializedName("msisdn")
    private String userId;
    @SerializedName("password")
    private String password;

    public AuthRequest(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
