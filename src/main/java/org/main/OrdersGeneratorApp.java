package org.main;

import org.text_logs_processing.entities.Order;
import org.text_logs_processing.generators.OrdersGenerator;
import org.text_logs_processing.serializers.OrdersTextWriter;

import java.io.IOException;
import java.util.List;

public class OrdersGeneratorApp {
    public static void main(String[] args) {
        List<Order> orders = new OrdersGenerator().generate(1000);

        try {
            OrdersTextWriter.write(orders, "orders.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> readResult;
        try {
            readResult = OrdersTextWriter.read("orders.txt");
            for(String row: readResult) {
                System.out.println(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
