package org.iesfm.company.exceptions;

public class OrderNotFoundException extends Exception {

    private int orderNumber;

    public OrderNotFoundException(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public OrderNotFoundException(String message, int orderNumber) {
        super(message);
        this.orderNumber = orderNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
}
