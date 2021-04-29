package org.iesfm.company;

import java.util.List;
import java.util.Objects;

public final class Programmer extends Employee {

    private List<String> programmingLanguages;
    private String team;

    public Programmer(int id, String name, String surname, int hoursWorked, List<String> programmingLanguages, String team) {
        super(id, name, surname, hoursWorked);
        this.programmingLanguages = programmingLanguages;
        this.team = team;
    }

    @Override
    protected void showSpecificInfo() {
        System.out.println("Equipo: " + team);
        System.out.println("Lenguajes de programación: ");
        for (String language : programmingLanguages) {
            System.out.println(language);
        }
    }

    public List<String> getProgrammingLanguages() {
        return programmingLanguages;
    }

    public void setProgrammingLanguages(List<String> programmingLanguages) {
        this.programmingLanguages = programmingLanguages;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Programmer that = (Programmer) o;
        return Objects.equals(programmingLanguages, that.programmingLanguages) &&
                Objects.equals(team, that.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), programmingLanguages, team);
    }

    @Override
    public String toString() {
        return "org.iesfm.company.Programmer{" +
                "programmingLanguages=" + programmingLanguages +
                ", team='" + team + '\'' +
                '}';
    }
}
