package com.innovertech.gameon.model.Quiz;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuestionRes {
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("question")
    @Expose
    private Question question;
    @SerializedName("isQuestionLimitFinished")
    @Expose
    private Boolean isQuestionLimitFinished;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Boolean getQuestionLimitFinished() {
        return isQuestionLimitFinished;
    }

    public void setQuestionLimitFinished(Boolean questionLimitFinished) {
        isQuestionLimitFinished = questionLimitFinished;
    }

    @Override
    public String toString() {
        return "QuestionRes{" +
                "count=" + count +
                ", question=" + question +
                ", isQuestionLimitFinished=" + isQuestionLimitFinished +
                '}';
    }

    public class Question {

        @SerializedName("question")
        @Expose
        private String question;
        @SerializedName("option1")
        @Expose
        private String option1;
        @SerializedName("option2")
        @Expose
        private String option2;
        @SerializedName("option3")
        @Expose
        private String option3;
        @SerializedName("option4")
        @Expose
        private String option4;
        @SerializedName("questionId")
        @Expose
        private Integer questionId;

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public String getOption1() {
            return option1;
        }

        public void setOption1(String option1) {
            this.option1 = option1;
        }

        public String getOption2() {
            return option2;
        }

        public void setOption2(String option2) {
            this.option2 = option2;
        }

        public String getOption3() {
            return option3;
        }

        public void setOption3(String option3) {
            this.option3 = option3;
        }

        public String getOption4() {
            return option4;
        }

        public void setOption4(String option4) {
            this.option4 = option4;
        }

        public Integer getQuestionId() {
            return questionId;
        }

        public void setQuestionId(Integer questionId) {
            this.questionId = questionId;
        }

        @Override
        public String toString() {
            return "Question{" +
                    "question='" + question + '\'' +
                    ", option1='" + option1 + '\'' +
                    ", option2='" + option2 + '\'' +
                    ", option3='" + option3 + '\'' +
                    ", option4='" + option4 + '\'' +
                    ", questionId=" + questionId +
                    '}';
        }
    }
}
