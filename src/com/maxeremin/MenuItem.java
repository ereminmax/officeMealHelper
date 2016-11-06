package com.maxeremin;

/**
 * Created by Максим on 29.09.2016.
 */
public class MenuItem {

    private String name;
    private Double weight;
    private Double price;

    public MenuItem(String name, Double weight, Double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getPrice() {
        return price;
    }
}
