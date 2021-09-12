package com.innovertech.gameon.model.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SignInReq {

    @SerializedName("msisdn")
    @Expose
    public String msisdn;
    @SerializedName("password")
    @Expose
    public String password;

}