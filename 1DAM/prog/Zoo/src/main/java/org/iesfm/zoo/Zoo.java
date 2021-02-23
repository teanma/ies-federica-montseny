package org.iesfm.zoo;

import org.iesfm.zoo.exceptions.CageNotFoundException;
import org.iesfm.zoo.exceptions.NutritionNotFoundException;

import java.util.Arrays;
import java.util.Objects;

public class Zoo implements IZoo {

    private String name;
    private Animal[] animals;

    public Zoo(String name, Animal[] animals) {
        this.name = name;
        this.animals = animals;
    }

    public void info() {
        System.out.println("El nombre del zoo es " + name);
    }

    @Override
    public int getAnimalsOfTheCage(int cage) throws CageNotFoundException {
        int animalsOfTheCage = 0;
        try {
            for (Animal animal : animals) {
                if (animal.getCage() == cage) {
                    animalsOfTheCage++;
                }
            }
            if (animalsOfTheCage == 0) {
                throw new CageNotFoundException();
            } else {
                return animalsOfTheCage;
            }
        } catch (CageNotFoundException e) {
            System.out.println("La jaula no ha sido encontrada");
        }
        return animalsOfTheCage;
    }

    @Override
    public int getAnimalNutrition(String nutrition) throws NutritionNotFoundException {
        int animalNutrition = 0;
        try {
            for (Animal animal : animals) {
                if (animal.getNutrition() == nutrition) {
                    animalNutrition++;
                }
            }
            if (animalNutrition == 0) {
                throw new NutritionNotFoundException();
            } else {
                return animalNutrition;
            }
        } catch (NutritionNotFoundException e) {
            System.out.println("El tipo de alimentación no ha sido encontrado");
        }
        return animalNutrition;
    }

    @Override
    public int getAnimalSpeciesOfTheCage(String specie, int cage) throws CageNotFoundException {
        int animalSpeciesOfTheCage = 0;
        try {
            for (Animal animal : animals) {
                if (animal.getSpecie() == specie && animal.getCage() == cage) {
                    animalSpeciesOfTheCage++;
                }
            }
            if (animalSpeciesOfTheCage == 0) {
                throw new CageNotFoundException();
            } else {
                return animalSpeciesOfTheCage;
            }
        } catch (CageNotFoundException e) {
            System.out.println("La jaula no ha sido encontrada");
        }
        return animalSpeciesOfTheCage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public void setAnimals(Animal[] animals) {
        this.animals = animals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zoo zoo = (Zoo) o;
        return Objects.equals(name, zoo.name) &&
                Arrays.equals(animals, zoo.animals);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(animals);
        return result;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "name='" + name + '\'' +
                ", animals=" + Arrays.toString(animals) +
                '}';
    }
}
