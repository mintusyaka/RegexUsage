package org.text_logs_processing.generators;

import org.text_logs_processing.entities.Order;

import java.util.List;
import java.util.Random;

public class UsernameGenerator {
    public void generate(Order order, List<Order> orders) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder nickname = new StringBuilder();

        Random random = new Random();
        int length = random.nextInt(6) + 5;

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            nickname.append(characters.charAt(index));
        }

        if(orders.stream().noneMatch(o -> o.getUsername().equals(nickname))) {
            order.setUsername(nickname.toString());
        } else {
            generate(order, orders);
        }
    }
}
