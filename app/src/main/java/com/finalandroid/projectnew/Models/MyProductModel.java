package com.finalandroid.projectnew.Models;

public class MyProductModel {

    private String Name, desc;
    private int imgId, Price;

    public MyProductModel(String name, int imgId, int price, String desc) {
        Name = name;
        this.imgId = imgId;
        Price = price;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }
}
