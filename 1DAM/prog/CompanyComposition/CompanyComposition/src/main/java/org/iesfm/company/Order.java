package org.iesfm.company;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.time.LocalDateTime;
import java.util.Set;

public class Order implements Comparable<Order> {

    private int orderNumber;
    private LocalDateTime date;
    private List<OrderLine> orderLines;

    public Order(int orderNumber, LocalDateTime date, List<OrderLine> orderLines) {
        this.orderNumber = orderNumber;
        this.date = date;
        this.orderLines = orderLines;
    }

    public int price() {
        int finalPrice = 0;

        for (OrderLine orderLine : orderLines) {
            finalPrice = finalPrice + orderLine.calculatePrice();
        }
        return finalPrice;
    }

    public Set<String> getProductsName() {
        Set<String> products = new HashSet<>();
        for (OrderLine orderLine : orderLines) {
            products.add(orderLine.getProductName());
        }
        return products;
    }

    public int getAmount(String productName) {
        int amount = 0;
        for (OrderLine orderLine : orderLines) {
            if (orderLine.getProductName().equals(productName)) {
                amount = amount + orderLine.getAmount();
            }
        }
        return amount;
    }

    @Override
    public int compareTo(Order o) {
        return date.compareTo(o.date);
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderNumber == order.orderNumber && Objects.equals(date, order.date) && Objects.equals(orderLines, order.orderLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, date, orderLines);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", date=" + date +
                ", orderLines=" + orderLines +
                '}';
    }
}
