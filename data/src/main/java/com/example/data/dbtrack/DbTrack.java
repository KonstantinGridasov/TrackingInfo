package com.example.data.dbtrack;

import com.example.data.entity.Product;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by GHome on 19.09.2017.
 */

public class DbTrack extends RealmObject {
    @PrimaryKey
    private String track;


    public DbTrack() {
    }

    public DbTrack(Product product) {
        this.track = product.getTrack();
        this.name = product.getName();
        this.country = product.getCounrty();
    }

    private String name;

    private String country;

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
