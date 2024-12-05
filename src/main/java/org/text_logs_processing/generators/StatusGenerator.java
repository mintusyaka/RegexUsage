package org.text_logs_processing.generators;

import org.text_logs_processing.entities.Order;

import java.util.List;
import java.util.Random;

public class StatusGenerator  {
    public void generate(Order order) {
        String result = "";

        Random rand = new Random();
        switch (rand.nextInt(3)) {
            case 0:
                result = "Pending";
                break;
            case 1:
                result = "Delivering";
                break;
            case 2:
                result = "Delivered";
                break;
            default:
                result = "Cancelled";
                break;
        }

        order.setStatus(result);
    }
}
