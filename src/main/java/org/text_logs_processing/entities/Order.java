package org.text_logs_processing.entities;

import java.io.Serializable;

public class Order {
    private String orderId;
    private String username;
    private String status;

    public Order() {}

    public Order(String orderId, String username, String status) {
        this.orderId = orderId;
        this.username = username;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Username: " + username + ", Order ID: " + orderId + ", Status: " + status + ";\n";
    }
}
