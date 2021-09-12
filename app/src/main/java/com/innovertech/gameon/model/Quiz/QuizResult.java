package com.innovertech.gameon.model.Quiz;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuizResult {

    @SerializedName("point")
    @Expose
    private Point point;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("isQuestionLimitFinished")
    @Expose
    private Boolean isQuestionLimitFinished;

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getQuestionLimitFinished() {
        return isQuestionLimitFinished;
    }

    public void setQuestionLimitFinished(Boolean questionLimitFinished) {
        isQuestionLimitFinished = questionLimitFinished;
    }

    @Override
    public String toString() {
        return "QuizResult{" +
                "point=" + point +
                ", name='" + name + '\'' +
                ", isQuestionLimitFinished=" + isQuestionLimitFinished +
                '}';
    }

    public class Point {
        @SerializedName("totalAnswered")
        @Expose
        private Integer totalAnswered;
        @SerializedName("totalCorrect")
        @Expose
        private Integer totalCorrect;
        @SerializedName("totalWrong")
        @Expose
        private Integer totalWrong;
        @SerializedName("totalPoint")
        @Expose
        private Integer totalPoint;
        @SerializedName("correctPoint")
        @Expose
        private Integer correctPoint;
        @SerializedName("negativePoint")
        @Expose
        private Integer negativePoint;
        @SerializedName("totalQuestion")
        @Expose
        private Integer totalQuestion;

        public Integer getTotalAnswered() {
            return totalAnswered;
        }

        public void setTotalAnswered(Integer totalAnswered) {
            this.totalAnswered = totalAnswered;
        }

        public Integer getTotalCorrect() {
            return totalCorrect;
        }

        public void setTotalCorrect(Integer totalCorrect) {
            this.totalCorrect = totalCorrect;
        }

        public Integer getTotalWrong() {
            return totalWrong;
        }

        public void setTotalWrong(Integer totalWrong) {
            this.totalWrong = totalWrong;
        }

        public Integer getTotalPoint() {
            return totalPoint;
        }

        public void setTotalPoint(Integer totalPoint) {
            this.totalPoint = totalPoint;
        }

        public Integer getCorrectPoint() {
            return correctPoint;
        }

        public void setCorrectPoint(Integer correctPoint) {
            this.correctPoint = correctPoint;
        }

        public Integer getNegativePoint() {
            return negativePoint;
        }

        public void setNegativePoint(Integer negativePoint) {
            this.negativePoint = negativePoint;
        }

        public Integer getTotalQuestion() {
            return totalQuestion;
        }

        public void setTotalQuestion(Integer totalQuestion) {
            this.totalQuestion = totalQuestion;
        }

        @Override
        public String toString() {
            return "QuizResult{" +
                    "totalAnswered=" + totalAnswered +
                    ", totalCorrect=" + totalCorrect +
                    ", totalWrong=" + totalWrong +
                    ", totalPoint=" + totalPoint +
                    ", correctPoint=" + correctPoint +
                    ", negativePoint=" + negativePoint +
                    ", totalQuestion=" + totalQuestion +
                    '}';
        }
    }
}