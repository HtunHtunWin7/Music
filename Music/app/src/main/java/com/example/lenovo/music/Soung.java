package com.example.lenovo.music;

import java.util.ArrayList;

public class Soung extends ArrayList<Soung> {
    private String title,artist;
    private int price;

    public Soung(String title, String artist, int price) {
        this.title = title;
        this.artist = artist;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
