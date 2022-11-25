package com.example.hkapplication.models;

public class CartModel {
    int img;
    String name;
    String price;
    String rating;

    public CartModel() {
    }

    public CartModel(int img, String name, String price, String rating) {
        this.img = img;
        this.name = name;
        this.price = price;
        this.rating = rating;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
