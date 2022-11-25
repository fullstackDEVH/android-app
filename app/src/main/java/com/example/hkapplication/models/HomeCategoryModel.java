package com.example.hkapplication.models;

public class HomeCategoryModel {
    int img;
    String name;

    public HomeCategoryModel() {
    }

    public HomeCategoryModel(int img, String name) {
        this.img = img;
        this.name = name;
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
}
