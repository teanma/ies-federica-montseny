package org.iesfm.animals;

import java.util.Objects;

public abstract class Animal {
    private String color;
    private int age;

    public Animal(String color, int age) {
        this.color = color;
        this.age = age;
    }

    public abstract void saySomething();

    public void sayHello() {
        System.out.println("Hello, my color is " + color + ". I am " + age + " years old");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age && Objects.equals(color, animal.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, age);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "color='" + color + '\'' +
                ", age=" + age +
                '}';
    }
}
