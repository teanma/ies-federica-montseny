package org.iesfm.company;

import java.util.List;
import java.util.Objects;

public final class ProjectManager extends Employee {

    private String team;
    private List<String> projectsList;

    public ProjectManager(int id, String name, String surname, int hoursWorked, String team, List<String> projectsList) {
        super(id, name, surname, hoursWorked);
        this.team = team;
        this.projectsList = projectsList;
    }

    @Override
    protected void showSpecificInfo() {
        System.out.println("Equipo: " + team);
        System.out.println("Proyectos: ");
        for (String project : projectsList) {
            System.out.println(project);
        }
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public List<String> getProjectsList() {
        return projectsList;
    }

    public void setProjectsList(List<String> projectsList) {
        this.projectsList = projectsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProjectManager that = (ProjectManager) o;
        return Objects.equals(team, that.team) &&
                Objects.equals(projectsList, that.projectsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), team, projectsList);
    }

    @Override
    public String toString() {
        return "org.iesfm.company.ProjectManager{" +
                "team='" + team + '\'' +
                ", projectsList=" + projectsList +
                '}';
    }
}
