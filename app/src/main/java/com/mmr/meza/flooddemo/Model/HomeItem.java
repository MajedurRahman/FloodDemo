package com.mmr.meza.flooddemo.Model;

/**
 * Created by Majedur Rahman on 10/18/2017.
 */

public class HomeItem {

    private String title;
    private int image;
    private String cloudImage;

    public HomeItem(String title, int image) {
        this.title = title;
        this.image = image;
    }

    public HomeItem(String title, String cloudImage) {
        this.title = title;
        this.cloudImage = cloudImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCloudImage() {
        return cloudImage;
    }

    public void setCloudImage(String cloudImage) {
        this.cloudImage = cloudImage;
    }
}
