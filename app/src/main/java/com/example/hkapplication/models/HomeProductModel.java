package com.example.hkapplication.models;

public class HomeProductModel {
    int img;
    String name;
    String time;
    String rating;
    String price;

    public HomeProductModel() {
    }

    public HomeProductModel(int img, String name, String time, String rating, String price) {
        this.img = img;
        this.name = name;
        this.time = time;
        this.rating = rating;
        this.price = price;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
