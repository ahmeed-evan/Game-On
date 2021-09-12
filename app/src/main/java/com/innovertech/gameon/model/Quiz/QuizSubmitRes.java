package com.innovertech.gameon.model.Quiz;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuizSubmitRes {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("messgae")
    @Expose
    private String messgae;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessgae() {
        return messgae;
    }

    public void setMessgae(String messgae) {
        this.messgae = messgae;
    }

    @Override
    public String toString() {
        return "QuizSubmitRes{" +
                "status=" + status +
                ", messgae='" + messgae + '\'' +
                '}';
    }
}
