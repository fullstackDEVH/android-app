package com.example.hkapplication.models;

public class DetailDailyModel {
    int img ;
    String name;
    String desc;
    String rating;
    String price;
    String time;

    public DetailDailyModel(int img, String name, String desc, String rating, String price, String time) {
        this.img = img;
        this.name = name;
        this.desc = desc;
        this.rating = rating;
        this.price = price;
        this.time = time;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
