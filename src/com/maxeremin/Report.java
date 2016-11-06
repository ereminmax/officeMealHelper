package com.maxeremin;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Максим on 29.09.2016.
 */
public class Report {

    private Parser parser;
    private HashMap<MenuItem, Integer> foundMenuItems = new HashMap<>();
    private Double total;

    public Report(Parser parser) {
        this.parser = parser;
        total = 0.;
    }

    public void sendReportToKitchen() {
        System.out.println("Отчет на кухню");

        makeMenuList();

        for ( Map.Entry entry : foundMenuItems.entrySet() ) {
            MenuItem mi = (MenuItem) entry.getKey();
            Integer countOfMI = (Integer) entry.getValue();
            Double valueOfMI = mi.getPrice() * countOfMI;
            total += valueOfMI;

            System.out.println("Блюдо: " + mi.getName() + "\n\tСтоимость: " + valueOfMI + "\n\t\tКол-во: " + countOfMI);
        }

        System.out.println("Общая сумма: " + total);
    }

    private void makeMenuList() {
        for ( OrderItem oi : parser.orders.getOrders() ) {
            for ( Map.Entry entry : oi.getOrderDishes().entrySet() ) {
                MenuItem mi = (MenuItem) entry.getKey();
                Integer countOfDish = (Integer) entry.getValue();
                Integer value = foundMenuItems.get(mi);

                if (value == null) {
                    foundMenuItems.put(mi, countOfDish);
                } else {
                    value += countOfDish;
                    foundMenuItems.put(mi, value);
                }
            }
        }
    }

    public void sendReportToOffice() {
        System.out.println("Отчет в офис");

        for ( OrderItem oi : parser.orders.getOrders() ) {
            System.out.println("Клиент: " + oi.getName());

            for ( Map.Entry entry : oi.getOrderDishes().entrySet() ) {
                MenuItem mi = (MenuItem) entry.getKey();

                System.out.println("\tБлюдо: " + mi.getName());
            }

            System.out.println("\t\tСумма заказа: " + oi.getPurchase());
        }
    }
}
