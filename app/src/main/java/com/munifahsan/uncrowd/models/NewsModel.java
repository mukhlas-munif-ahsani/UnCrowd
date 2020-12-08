package com.munifahsan.uncrowd.models;

public class NewsModel {
    int image;
    String title;
    String jumlah;

    public NewsModel(int image, String title, String jumlah) {
        this.image = image;
        this.title = title;
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

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }
}
