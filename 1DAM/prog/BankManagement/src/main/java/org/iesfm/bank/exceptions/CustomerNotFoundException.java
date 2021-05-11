package org.iesfm.bank.exceptions;

public class CustomerNotFoundException extends Exception {

    private int nif;

    public CustomerNotFoundException(int nif) {
        this.nif = nif;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }
}
