package com.mmr.meza.flooddemo.Model;

/**
 * Created by Majedur Rahman on 11/8/2017.
 */

public class FloodData {

    private String id;
    private String data;
    private String time;


    public FloodData(){

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public FloodData(String id, String data, String time) {
        this.id = id;
        this.data = data;
        this.time = time;
    }


    @Override
    public String toString() {

        return id+ " " + data + " " + time;
    }
}
