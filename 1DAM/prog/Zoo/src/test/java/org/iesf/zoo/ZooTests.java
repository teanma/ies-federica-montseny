package org.iesf.zoo;

import org.iesfm.zoo.Animal;
import org.iesfm.zoo.Zoo;
import org.iesfm.zoo.exceptions.CageNotFoundException;
import org.iesfm.zoo.exceptions.NutritionNotFoundException;
import org.junit.Assert;
import org.junit.Test;

public class ZooTests {


    @Test
    public void getAnimalsOfTheCageTest() throws CageNotFoundException {
        Animal[] animals = new Animal[3];
        Animal firstAnimal = new Animal("León", "Carnívoro", 15);
        Animal secondAnimal = new Animal("Jirafa", "Herbívoro", 32);
        Animal thirdAnimal = new Animal("Oso", "Omnívoro", 7);

        animals[0] = firstAnimal;
        animals[1] = secondAnimal;
        animals[2] = thirdAnimal;

        Zoo zoo = new Zoo("Guadalajara", animals);

        try {
            int res = zoo.getAnimalsOfTheCage(96);
            Assert.fail("La jaula no existe");
        } catch (CageNotFoundException e) {
            System.out.println("La jaula debe ser un número");
        }
    }

    @Test
    public void getAnimalNutritionTest() throws NutritionNotFoundException {
        Animal[] animals = new Animal[3];
        Animal firstAnimal = new Animal("León", "Carnívoro", 15);
        Animal secondAnimal = new Animal("Jirafa", "Herbívoro", 32);
        Animal thirdAnimal = new Animal("Elefante", "Herbívoro", 43);

        animals[0] = firstAnimal;
        animals[1] = secondAnimal;
        animals[2] = thirdAnimal;

        Zoo zoo = new Zoo("Guadalajara", animals);

        try {
            int res = zoo.getAnimalNutrition("Omnívoro");
            Assert.fail("El tipo de alimentación no existe");
        } catch (NutritionNotFoundException e) {
            System.out.println("La alimentación no puede ser un número");
        }
    }

    @Test
    public void getAnimalSpeciesOfTheCageTest() throws CageNotFoundException {
        Animal[] animals = new Animal[3];
        Animal firstAnimal = new Animal("León", "Carnívoro", 15);
        Animal secondAnimal = new Animal("Jirafa", "Herbívoro", 32);
        Animal thirdAnimal = new Animal("Oso", "Omnívoro", 7);

        animals[0] = firstAnimal;
        animals[1] = secondAnimal;
        animals[2] = thirdAnimal;

        Zoo zoo = new Zoo("Guadalajara", animals);

        try {
            int res = zoo.getAnimalSpeciesOfTheCage("Cerdo", 112);
            Assert.fail("La jaula no existe");
        } catch (CageNotFoundException e) {
            System.out.println("La jaula debe ser un número");
        }
    }
}
