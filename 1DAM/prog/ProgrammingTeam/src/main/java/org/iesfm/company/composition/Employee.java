package org.iesfm.company.composition;

import java.util.Objects;

public class Employee {

    public static final String PROGRAMMER = "Programer";
    public static final String PROJECTMANAGER = "ProjectManager";
    public static final String SCRUMMASTER = "ScrumMaster";

    private String rol;
    private String name;
    private String surname;
    private int id;
    private int workedHours;
    private Position position;

    public Employee(String rol, String name, String surname, int id, int workedHours, Position position) {
        this.rol = rol;
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.workedHours = workedHours;
        this.position = position;
    }

    public void showInfo() {
        if (rol.equals(PROGRAMMER)) {
            System.out.println("Hola, me llamo " + name + surname);
            System.out.println("Mi codigo de empleado es " + id);
            System.out.println("He trabajado " + workedHours + " horas");
            System.out.println("Y mi rol es " + rol);
        } else if (rol.equals(PROJECTMANAGER)) {
            System.out.println("Hola, me llamo " + name + surname);
            System.out.println("Mi código de empleado es " + id);
            System.out.println("He trabajado " + workedHours + " horas");
            System.out.println("Y mi rol es " + rol);
        } else if (rol.equals(SCRUMMASTER)) {
            System.out.println("Hola, me llamo " + name + surname);
            System.out.println("Mi código de empleado es " + id);
            System.out.println("He trabajado " + workedHours + " horas");
            System.out.println("Y mi rol es " + rol);
        }
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(int workedHours) {
        this.workedHours = workedHours;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && workedHours == employee.workedHours && Objects.equals(rol, employee.rol) && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname) && Objects.equals(position, employee.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rol, name, surname, id, workedHours, position);
    }
}
