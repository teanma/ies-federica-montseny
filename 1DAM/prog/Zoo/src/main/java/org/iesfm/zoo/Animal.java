package org.iesfm.zoo;

import java.util.Objects;

public class Animal {

    private String specie;
    private String nutrition;
    private int cage;

    public Animal(String specie, String nutrition, int cage) {
        this.specie = specie;
        this.nutrition = nutrition;
        this.cage = cage;
    }

    public void info() {
        System.out.println("La especie es un/a " + specie + ", su alimentación es " + nutrition + " y se encuentra en la jaula Nº " + cage);
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String getNutrition() {
        return nutrition;
    }

    public void setNutrition(String nutrition) {
        this.nutrition = nutrition;
    }

    public int getCage() {
        return cage;
    }

    public void setCage(int cage) {
        this.cage = cage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return cage == animal.cage &&
                Objects.equals(specie, animal.specie) &&
                Objects.equals(nutrition, animal.nutrition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specie, nutrition, cage);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "specie='" + specie + '\'' +
                ", nutrition='" + nutrition + '\'' +
                ", cage=" + cage +
                '}';
    }
}
