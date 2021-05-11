package org.iesfm.bank;

import org.iesfm.bank.exceptions.NotEnoughBalanceException;

import java.util.Map;
import java.util.Objects;

public class Account {

    private String iban;
    private int customerId;
    private double balance;

    public Account(String iban, int customerId, double balance) {
        this.iban = iban;
        this.customerId = customerId;
        this.balance = balance;
    }

    public void withdrawMoney(int amount) throws NotEnoughBalanceException {
        if (balance < amount) {
            throw new NotEnoughBalanceException();
        }
        balance = balance - amount;
    }

    public void depositMoney(int amount) {
        balance = balance + amount;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return customerId == account.customerId && Double.compare(account.balance, balance) == 0 && Objects.equals(iban, account.iban);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, customerId, balance);
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban='" + iban + '\'' +
                ", customerId=" + customerId +
                ", balance=" + balance +
                '}';
    }
}
