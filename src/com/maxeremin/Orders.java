package com.maxeremin;

import java.util.LinkedList;

/**
 * Created by Максим on 29.09.2016.
 */
public class Orders {

    private LinkedList<OrderItem> orders = new LinkedList<>();

    public Orders() {
    }

    public void addOrderItem(OrderItem newOrderItem) {
        orders.addLast(newOrderItem);
    }

    public LinkedList<OrderItem> getOrders() {
        return orders;
    }
}
