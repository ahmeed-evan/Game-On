package com.innovertech.gameon.model;

public class SubscriptionPackage {
    private String packageId;
    private String packageTitle;
    private String packageDuration;
    private String packagePrice;
    private boolean isPackageSubscribed;

    public SubscriptionPackage(String packageId, String packageTitle, String packageDuration, String packagePrice, boolean isPackageSubscribed) {
        this.packageId = packageId;
        this.packageTitle = packageTitle;
        this.packageDuration = packageDuration;
        this.packagePrice = packagePrice;
        this.isPackageSubscribed = isPackageSubscribed;
    }

    public boolean isPackageSubscribed() {
        return isPackageSubscribed;
    }

    public void setPackageSubscribed(boolean packageSubscribed) {
        isPackageSubscribed = packageSubscribed;
    }

    public String getPackageTitle() {
        return packageTitle;
    }

    public void setPackageTitle(String packageTitle) {
        this.packageTitle = packageTitle;
    }

    public String getPackageDuration() {
        return packageDuration;
    }

    public void setPackageDuration(String packageDuration) {
        this.packageDuration = packageDuration;
    }

    public String getPackagePrice() {
        return packagePrice;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public void setPackagePrice(String packagePrice) {
        this.packagePrice = packagePrice;
    }

    @Override
    public String toString() {
        return "Package{" +
                "packageTitle='" + packageTitle + '\'' +
                ", packageSubTitle='" + packageDuration + '\'' +
                ", packagePrice='" + packagePrice + '\'' +
                '}';
    }
}
