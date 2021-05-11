package org.iesfm.bank;

import org.iesfm.bank.exceptions.*;

import java.util.*;

public class Bank {

    private Map<String, Account> accounts;
    private Map<Integer, Customer> customers;

    public Bank(Map<String, Account> accounts, Map<Integer, Customer> customers) {
        this.accounts = accounts;
        this.customers = customers;
    }

    public int getCustomerId(int nif) throws CustomerNotFoundException {
        if (!customers.containsKey(nif)) {
            throw new CustomerNotFoundException(nif);
        }
        return customers.get(nif).getCustomerId();
    }

    public Map<String, Account> getAccounts(int nif) throws CustomerNotFoundException {
        int idClient = getCustomerId(nif);
        HashMap<String, Account> clientAccounts = new HashMap<>();
        for (Account account : accounts.values()) {
            if (account.getCustomerId() == nif) {
                clientAccounts.put(account.getIban(), account);
            }
        }
        return clientAccounts;
    }

    public void withdrawMoney(String iban, int amount) throws NotEnoughBalanceException, AccountNotFoundException {
        if (!accounts.containsKey(iban)) {
            throw new AccountNotFoundException(iban);
        }
        accounts.get(iban).withdrawMoney(amount);
//        Account myAccount = accounts.get(iban);
//        if (myAccount.getBalance() < amount) {
//            throw new NotEnoughBalanceException();
//        }
//        myAccount.setBalance(myAccount.getBalance());
    }

    public void transferMoney(String originIban, String destinationIban, int amount) throws AccountNotFoundException, NotEnoughBalanceException {
        if (!accounts.containsKey(originIban)) {
            throw new AccountNotFoundException(originIban);
        } else if (!accounts.containsKey(destinationIban)) {
            throw new AccountNotFoundException(destinationIban);
        }

        accounts.get(originIban).withdrawMoney(amount);

        accounts.get(destinationIban).depositMoney(amount);
    }

    public void createAccount(int nif, String iban) throws CustomerNotFoundException, AccountAlreadyExistsException {
        int idCustomer = getCustomerId(nif);

        if (accounts.containsKey(iban)) {
            throw new AccountAlreadyExistsException(iban);
        }

        accounts.put(iban, new Account(iban, idCustomer, 0));
    }

    public void removeAccount(String iban) throws AccountNotFoundException{
        if (!accounts.containsKey(iban)) {
            throw new AccountNotFoundException(iban);
        }
        accounts.remove(iban);
    }

    public double showAccountBalance (int nif) throws CustomerNotFoundException {
        Map<String, Account> customerAccounts = getAccounts(nif);

        double sumBalance = 0;

        for (Account account : customerAccounts.values()) {
            sumBalance = account.getBalance() + sumBalance;
        }
        return sumBalance;
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    public Map<Integer, Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Map<Integer, Customer> customers) {
        this.customers = customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(accounts, bank.accounts) && Objects.equals(customers, bank.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accounts, customers);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "accounts=" + accounts +
                ", customers=" + customers +
                '}';
    }
}
