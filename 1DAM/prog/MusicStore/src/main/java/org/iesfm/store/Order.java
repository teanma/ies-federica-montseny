package org.iesfm.store;

import java.util.Objects;

public class Order {

    private String price;
    private String date;

    public Order(String price, String date) {
        this.price = price;
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(price, order.price) &&
                Objects.equals(date, order.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, date);
    }

    @Override
    public String toString() {
        return "Order{" +
                "price='" + price + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
