package com.maxeremin;

import java.util.HashMap;

/**
 * Created by Максим on 29.09.2016.
 */
public class OrderItem {

    private String clientsName;
    private HashMap<MenuItem, Integer> orderDishes = new HashMap<>();
    private double purchase;

    public OrderItem(String name) {
        this.clientsName = name;
        purchase = 0;
    }

    public void addItem(MenuItem menuItem) {
        Integer value = orderDishes.get(menuItem);

        if (value == null) {
            orderDishes.put(menuItem, 1);
            purchase += menuItem.getPrice();
        } else {
            value++;
            orderDishes.put(menuItem, value);
            purchase = menuItem.getPrice() * value;
        }
    }

    public String getName() {
        return clientsName;
    }

    public HashMap<MenuItem, Integer> getOrderDishes() {
        return orderDishes;
    }

    public double getPurchase() {
        return purchase;
    }
}
