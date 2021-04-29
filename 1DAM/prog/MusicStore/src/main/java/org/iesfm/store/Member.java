package org.iesfm.store;

import java.util.LinkedList;
import java.util.Objects;

public class Member {

    private String name;
    private String surname1;
    private String surname2;
    private String nif;
    private int cp;
    private LinkedList<Order> orders;

    public Member(String name, String surname1, String surname2, String nif, int cp, LinkedList<Order> orders) {
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.nif = nif;
        this.cp = cp;
        this.orders = orders;
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

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public LinkedList<Order> getOrders() {
        return orders;
    }

    public void setOrders(LinkedList<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return cp == member.cp &&
                Objects.equals(name, member.name) &&
                Objects.equals(surname1, member.surname1) &&
                Objects.equals(surname2, member.surname2) &&
                Objects.equals(nif, member.nif) &&
                Objects.equals(orders, member.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname1, surname2, nif, cp, orders);
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", surname1='" + surname1 + '\'' +
                ", surname2='" + surname2 + '\'' +
                ", nif='" + nif + '\'' +
                ", cp=" + cp +
                ", orders=" + orders +
                '}';
    }
}
