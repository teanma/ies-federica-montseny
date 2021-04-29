package org.iesfm.animals;

import java.util.Objects;

public class Cat implements Specie {
    private int lives;

    public Cat(int lives) {
        this.lives = lives;
    }

    @Override
    public void saySomething() {
        System.out.println("miau");
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return lives == cat.lives;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lives);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "lives=" + lives +
                '}';
    }
}
