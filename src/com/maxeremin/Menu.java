package com.maxeremin;

import java.util.LinkedList;

/**
 * Created by Максим on 29.09.2016.
 */
public class Menu {

    private LinkedList<MenuItem> menu = new LinkedList<>();

    public Menu() {
    }

    public void addMenuItem(MenuItem NewMenuItem) {
        menu.addLast(NewMenuItem);
    }

    public LinkedList<MenuItem> getMenu() {
        return menu;
    }
}
