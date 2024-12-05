package org.text_logs_processing.generators;

import org.text_logs_processing.entities.Order;

import java.util.List;
import java.util.Random;

public class OrderIdGenerator {
    private final int ID_LENGTH = 4;

    public void generate(Order order, List<Order> orders) {
        Random random = new Random();

        StringBuilder result = new StringBuilder();
        result.append("ORD-");
        for(int i = 0; i < ID_LENGTH; i++)
        {
            result.append(random.nextInt(9));
        }

        if(orders.stream().noneMatch(o -> o.getOrderId().equals(result.toString())))
        {
            order.setOrderId(result.toString());
        } else {
            generate(order, orders);
        }
    }
}
