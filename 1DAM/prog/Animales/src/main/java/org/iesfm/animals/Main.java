package org.iesfm.animals;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("red", 1, 7));
        cats.add(new Cat("red", 5, 4));

        for (Cat cat : cats) {
            cat.sayHello();
            cat.kill();
            cat.saySomething();
        }

        List<Pig> pigs = new ArrayList<>();
        pigs.add(new Pig("pink", 5, 100));
        pigs.add(new Pig("pink", 10, 120));

        for (Pig pig : pigs) {
            pig.sayHello();
            pig.saySomething();
            //pig.kill() can't compile;
        }

        List<Animal> animals = new ArrayList<>();
        animals.addAll(cats);
        animals.addAll(pigs);
        System.out.println("ANIMALES");
        for (Animal animal : animals) {
            animal.sayHello();
            animal.saySomething();
            //animal.kill() can't compile because the 'Animal' class doesn't has the 'kill' method;
        }
    }
}
