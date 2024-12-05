package org.text_logs_processing.generators;

import org.text_logs_processing.entities.Order;

import java.util.ArrayList;
import java.util.List;

public class OrdersGenerator {
    UsernameGenerator usernameGenerator = new UsernameGenerator();
    OrderIdGenerator orderIdGenerator = new OrderIdGenerator();
    StatusGenerator statusGenerator = new StatusGenerator();

    List<Order> orders = new ArrayList<Order>();

    public List<Order> generate(int count) {
        for (int i = 0; i < count; i++) {
            Order order = new Order();

            usernameGenerator.generate(order, orders);
            orderIdGenerator.generate(order, orders);
            statusGenerator.generate(order);

            orders.add(order);
        }

        return orders;
    }
}
