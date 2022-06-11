package com.finalandroid.projectnew.Models;

public class NftModel {

    private String productname;

    private int price;

    private String image;

    private String description;

    public NftModel() {}

    public String getProductname()
    {
        return productname;
    }
    public void setProductname(String firstname)
    {
        this.productname = firstname;
    }
    public int getPrice()
    {
        return price;
    }
    public void setPrice(int price)
    {
        this.price = price;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
