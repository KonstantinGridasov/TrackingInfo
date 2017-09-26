package com.example.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by GHome on 14.08.2017.
 */

public class Product implements DataModel {

    @SerializedName("name")
    private String name;

    @SerializedName("track")
    private String track;

    @SerializedName("country")
    private String counrty;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getCounrty() {
        return counrty;
    }

    public void setCounrty(String counrty) {
        this.counrty = counrty;
    }
}
