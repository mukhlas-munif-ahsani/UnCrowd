package com.munifahsan.uncrowd.models;

import android.util.Log;

public class MallModel {
    int image;
    String title;
    String desc;
    String jumlah;

    public MallModel(int image, String title, String desc, String jumlah) {
        this.image = image;
        this.title = title;
        this.desc = desc;
        this.jumlah = jumlah;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }
}
