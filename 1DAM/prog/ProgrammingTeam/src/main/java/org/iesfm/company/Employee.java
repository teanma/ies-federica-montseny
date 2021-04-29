package org.iesfm.company;

import java.util.Objects;

public abstract class Employee {

    private int id;
    private String name;
    private String surname;
    private int workedHours;

    public Employee(int id, String name, String surname, int workedHours) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.workedHours = workedHours;
    }

    public void logWork(int hours) {
        workedHours = workedHours + hours;
        System.out.println("You have worked: " + workedHours);
    }

    public void basicInfo() {
        System.out.println("Hola, me llamo " + getName());
        System.out.println(" con apellido " + getSurname());
        System.out.println(" con el id " + getId());
        System.out.println(" y he trabajado " + getWorkedHours() + " horas");
    }

    protected abstract void showSpecificInfo();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(int workedHours) {
        this.workedHours = workedHours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                workedHours == employee.workedHours &&
                Objects.equals(name, employee.name) &&
                Objects.equals(surname, employee.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, workedHours);
    }

    @Override
    public String toString() {
        return "org.iesfm.company.Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", hoursWorked=" + workedHours +
                '}';
    }
}
