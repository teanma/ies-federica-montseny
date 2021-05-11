package org.iesfm.bank;

import java.util.Objects;

public class Customer {

    private int customerId;
    private int nif;
    private String name;
    private String surname;
    private int cp;

    public Customer(int customerId, int nif, String name, String surname, int cp) {
        this.customerId = customerId;
        this.nif = nif;
        this.name = name;
        this.surname = surname;
        this.cp = cp;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId && nif == customer.nif && cp == customer.cp && Objects.equals(name, customer.name) && Objects.equals(surname, customer.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, nif, name, surname, cp);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", nif=" + nif +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", cp=" + cp +
                '}';
    }
}
