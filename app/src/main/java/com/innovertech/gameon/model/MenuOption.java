package com.innovertech.gameon.model;

public class MenuOption {
    private String optionTitle;
    private long optionId;
    private int optionImage;

    public MenuOption(String optionTitle, long optionId, int optionImage) {
        this.optionTitle = optionTitle;
        this.optionId = optionId;
        this.optionImage = optionImage;
    }

    public String getOptionTitle() {
        return optionTitle;
    }

    public void setOptionTitle(String optionTitle) {
        this.optionTitle = optionTitle;
    }

    public long getOptionId() {
        return optionId;
    }

    public void setOptionId(long optionId) {
        this.optionId = optionId;
    }

    public int getOptionImage() {
        return optionImage;
    }

    public void setOptionImage(int optionImage) {
        this.optionImage = optionImage;
    }
}
