package org.text_logs_processing.serializers;

import org.text_logs_processing.entities.Order;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OrdersTextWriter {
    public static void write(List<Order> orders, String filename) throws Exception {
        try(FileWriter ordersWriter = new FileWriter(filename, false))
        {
            for(Order order : orders)
            {
                ordersWriter.write(order.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> read(String filename) throws Exception {
        return Files.readAllLines(Paths.get(filename));
    }
}
