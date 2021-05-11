package org.iesfm.bank.exceptions;

public class AccountNotFoundException extends Exception {

    private String iban;

    public AccountNotFoundException(String iban) {
        this.iban = iban;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
}
