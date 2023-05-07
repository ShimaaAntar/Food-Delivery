package com.example.fooddelivery.views.model;

public class Restaurants {
    private int restaurantImg;
    private String restoName;
    private String distanceInMins;

    private int menuImg;
    private String menuName;
    private int price;

    public Restaurants(int restaurantImg, String restoName, String distanceInMins) {
        this.restaurantImg = restaurantImg;
        this.restoName = restoName;
        this.distanceInMins = distanceInMins;
    }

    public Restaurants(String restoName) {
        this.restoName = restoName;
    }

    public Restaurants(String restoName, int menuImg, String menuName, int price) {
        this.restoName = restoName;
        this.menuImg = menuImg;
        this.menuName = menuName;
        this.price = price;
    }

    public int getRestaurantImg() {
        return restaurantImg;
    }

    public void setRestaurantImg(int restaurantImg) {
        this.restaurantImg = restaurantImg;
    }

    public String getRestoName() {
        return restoName;
    }

    public void setRestoName(String restoName) {
        this.restoName = restoName;
    }

    public String getDistanceInMins() {
        return distanceInMins;
    }

    public void setDistanceInMins(String distanceInMins) {
        this.distanceInMins = distanceInMins;
    }

    public int getMenuImg() {
        return menuImg;
    }

    public void setMenuImg(int menuImg) {
        this.menuImg = menuImg;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
