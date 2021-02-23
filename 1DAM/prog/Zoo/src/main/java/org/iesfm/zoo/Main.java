package org.iesfm.zoo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);

    static Zoo readZoo() {
        Zoo zoo = null;
        while (zoo == null) {
            System.out.println("Introduce el nombre del zoo");
            String name = scan.nextLine();
            Animal[] animals = getAnimal();
            zoo = new Zoo(name, animals);
        }
        return zoo;
    }

    private static int getPositiveNumber() {
        int cantidad = getNumber();
        while (cantidad < 1) {
            System.out.println("La cantidad debe ser mayor que 0");
            cantidad = getNumber();
        }
        return cantidad;
    }

    private static int getNumber() {
        Integer num = null;
        while (num == null) {
            try {
                num = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error, no es un número");
                scan.nextLine();
            }
        }
        return num;
    }

    private static Animal[] getAnimal() {
        Animal[] animals = null;
        while (animals == null) {
            System.out.println("¿Cuántos animales vas a introducir?");
            int cantidad = getPositiveNumber();
            animals = new Animal[cantidad];
            for (int i = 0; i < animals.length; i++) {
                animals[i] = readAnimal();
            }
        }
        return animals;
    }

    static Animal readAnimal() {
        Animal animal = null;
        while (animal == null) {
            System.out.println("Introduce la especie");
            String specie = scan.nextLine();
            System.out.println("Introduce la alimentación");
            String nutrition = scan.nextLine();
            System.out.println("Introduce el número de jaula");
            int cage = scan.nextInt();
            scan.nextLine();
            animal = new Animal(specie, nutrition, cage);
        }
        return animal;
    }

    public static void main(String[] args) {
        Zoo zoo = readZoo();
        zoo.info();
    }
}
