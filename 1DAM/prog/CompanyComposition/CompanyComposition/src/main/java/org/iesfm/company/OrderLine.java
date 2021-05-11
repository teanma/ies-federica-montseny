package org.iesfm.company;

import java.util.Objects;

public class OrderLine {

    private int amount;
    private String productName;
    private int price;

    public OrderLine(int amount, String productName, int price) {
        this.amount = amount;
        this.productName = productName;
        this.price = price;
    }

    public int calculatePrice() {
        return price * amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLine orderLine = (OrderLine) o;
        return amount == orderLine.amount && price == orderLine.price && Objects.equals(productName, orderLine.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, productName, price);
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "amount=" + amount +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}
