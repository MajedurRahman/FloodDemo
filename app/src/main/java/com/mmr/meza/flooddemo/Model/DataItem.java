package com.mmr.meza.flooddemo.Model;

/**
 * Created by Majedur Rahman on 10/18/2017.
 */

public class DataItem {

    private String title;
    private String time;
    private String date;

    public DataItem(String title, String time, String date) {
        this.title = title;
        this.time = time;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
