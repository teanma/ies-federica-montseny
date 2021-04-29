package org.iesfm.company;

import java.util.List;
import java.util.Objects;

public final class ScrumMaster extends Employee {

    private List<String> teamsList;

    public ScrumMaster(int id, String name, String surname, int hoursWorked, List<String> teamsList) {
        super(id, name, surname, hoursWorked);
        this.teamsList = teamsList;
    }

    @Override
    protected void showSpecificInfo() {
        System.out.println("Equipos: ");
        for (String team : teamsList) {
            System.out.println(team);
        }
    }

    public List<String> getTeamsList() {
        return teamsList;
    }

    public void setTeamsList(List<String> teamsList) {
        this.teamsList = teamsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ScrumMaster that = (ScrumMaster) o;
        return Objects.equals(teamsList, that.teamsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), teamsList);
    }

    @Override
    public String toString() {
        return "org.iesfm.company.ScrumMaster{" +
                "teamsList=" + teamsList +
                '}';
    }
}
