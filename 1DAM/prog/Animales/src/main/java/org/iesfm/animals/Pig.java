package org.iesfm.animals;

import java.util.Objects;

public class Pig extends Animal {
    private int weight;

    public Pig(String color, int age, int weight) {
        super(color, age);
        this.weight = weight;
    }

    @Override
    public void saySomething() {
        System.out.println("Oink");
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pig pig = (Pig) o;
        return weight == pig.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weight);
    }

    @Override
    public String toString() {
        return "Pig{" +
                "weight=" + weight +
                '}';
    }
}
