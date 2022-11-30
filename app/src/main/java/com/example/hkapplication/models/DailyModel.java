package com.example.hkapplication.models;

public class DailyModel {
    int img;
    String name;
    String discount;
    String desc;
    String type;

    public DailyModel(int img, String name, String discount, String desc, String type) {
        this.img = img;
        this.name = name;
        this.discount = discount;
        this.desc = desc;
        this.type = type;
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

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
