package org.iesfm.bank.exceptions;

public class AccountAlreadyExistsException extends Exception {

    private String iban;

    public AccountAlreadyExistsException(String iban) {
        this.iban = iban;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
}
