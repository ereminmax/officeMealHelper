package com.maxeremin;

public class Main {

    public static void main(String[] args) {

        // Read xml
        Parser parser = new Parser("menu.xml", "orders.xml");

        // Make reports
        Report report = new Report(parser);

        report.sendReportToKitchen();
        report.sendReportToOffice();
    }
}
