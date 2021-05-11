package org.iesfm.company;

import java.util.Objects;
import java.util.TreeSet;

public class Customer {

    private String id;
    private String name;
    private String surname1;
    private String surname2;
    private TreeSet<Order> orders;

    public Customer(String id, String name, String surname1, String surname2, TreeSet<Order> orders) {
        this.id = id;
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.orders = orders;
    }

    public boolean hasBoughtProduct(String productName) {
        boolean found = false;
        for (Order order : orders) {
            if (order.getProductsName().contains(productName)) {
                found = true;
            }
        }
        return found;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname1() {
        return surname1;
    }

    public void setSurname1(String surname1) {
        this.surname1 = surname1;
    }

    public String getSurname2() {
        return surname2;
    }

    public void setSurname2(String surname2) {
        this.surname2 = surname2;
    }

    public TreeSet<Order> getOrders() {
        return orders;
    }

    public void setOrders(TreeSet<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(surname1, customer.surname1) && Objects.equals(surname2, customer.surname2) && Objects.equals(orders, customer.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname1, surname2, orders);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname1='" + surname1 + '\'' +
                ", surname2='" + surname2 + '\'' +
                ", orders=" + orders +
                '}';
    }
}
