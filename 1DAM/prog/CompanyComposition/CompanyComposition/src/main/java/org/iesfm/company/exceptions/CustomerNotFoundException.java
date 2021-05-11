package org.iesfm.company.exceptions;

public class CustomerNotFoundException extends Exception {

    private String id;

    public CustomerNotFoundException(String id) {
        this.id = id;
    }

    public CustomerNotFoundException(String message, String id) {
        super(message);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
