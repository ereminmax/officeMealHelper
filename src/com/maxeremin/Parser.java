package com.maxeremin;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.sun.xml.internal.bind.v2.TODO;
import org.w3c.dom.*;

import java.io.File;

/**
 * Created by Максим on 29.09.2016.
 */
public class Parser {

    private String menuFileName;
    private String ordersFileName;
    private Menu menu = new Menu();
    Orders orders = new Orders();
    private OrderItem oi;

    public Parser(String menuFileName, String ordersFileName) {
        this.menuFileName = menuFileName;
        this.ordersFileName = ordersFileName;

        readMenu();
        readOrders();
    }

    private void readMenu() {
        try {
            File file = new File(menuFileName);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);

            NodeList nList = doc.getElementsByTagName("menu_item");
            for (int i = 0; i < nList.getLength(); i++) {

                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element el = (Element) nNode;
                    String name = el.getElementsByTagName("name").item(0).getTextContent().trim();
                    Double weight = Double.parseDouble( el.getElementsByTagName("weight").item(0).getTextContent().trim() );
                    Double price = Double.parseDouble( el.getElementsByTagName("price").item(0).getTextContent().trim() );

                    menu.addMenuItem( new MenuItem(name, weight, price) );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readOrders() {
        try {
            File file = new File(ordersFileName);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);

            NodeList nList = doc.getElementsByTagName("order_item");
            for (int i = 0; i < nList.getLength(); i++) {

                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element el = (Element) nNode;
                    String name = el.getElementsByTagName("clientsName").item(0).getTextContent().trim();
                    oi = new OrderItem(name);

                    for (int j = 0; j < el.getElementsByTagName("dish").getLength(); j++) {
                        String dish = el.getElementsByTagName("dish").item(j).getTextContent().trim();
                        for (MenuItem mi : menu.getMenu()) {
                            if (mi.getName().equals(dish)) {
                                oi.addItem(mi);
                            }
                        }
                    }
                }
                orders.addOrderItem(oi);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
