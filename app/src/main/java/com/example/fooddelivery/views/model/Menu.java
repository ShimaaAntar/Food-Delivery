package com.example.fooddelivery.views.model;

public class Menu {
    private String name;
    private int menuImg;
    private String price;
    private String restroName;

    public Menu(int menuImg, String name, String restroName, String price ) {
        this.name = name;
        this.menuImg = menuImg;
        this.price = price;
        this.restroName = restroName;
    }

    public Menu(int menuImg, String name, String price) {
        this.name = name;
        this.menuImg = menuImg;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMenuImg() {
        return menuImg;
    }

    public void setMenuImg(int menuImg) {
        this.menuImg = menuImg;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRestroName() {
        return restroName;
    }

    public void setRestroName(String restroName) {
        this.restroName = restroName;
    }
}
