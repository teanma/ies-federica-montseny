package org.iesfm.animals;

import java.util.Objects;

public class Dog implements Specie {
    private String kind;

    public Dog(String kind) {
        this.kind = kind;
    }

    @Override
    public void saySomething() {
        System.out.println("guau");
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(kind, dog.kind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kind);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "kind='" + kind + '\'' +
                '}';
    }
}
