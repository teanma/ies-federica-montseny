package org.iesfm.company;

import java.util.*;

public class Company {

    private String name;
    private List<Employee> employees;

    public Company(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public List<Programmer> getProgrammers() {
        List<Programmer> programmerList = new LinkedList<>();
        for (Employee employee : employees) {
            if (employee instanceof Programmer) {
                programmerList.add((Programmer) employee);
            }
        }
        return programmerList;
    }

    public List<ProjectManager> getProjectManagers() {
        List<ProjectManager> projectManagerList = new LinkedList<>();
        for (Employee employee : employees) {
            if (employee instanceof ProjectManager) {
                projectManagerList.add((ProjectManager) employee);
            }
        }
        return projectManagerList;
    }

    public List<ScrumMaster> getScrumMasters() {
        List<ScrumMaster> scrumMasterList = new LinkedList<>();
        for (Employee employee : employees) {
            if (employee instanceof ScrumMaster) {
                scrumMasterList.add((ScrumMaster) employee);
            }
        }
        return scrumMasterList;
    }

    public List<String> getAllProjects() {
        List<ProjectManager> projectManagers = getProjectManagers();
        List<String> projects = new LinkedList<>();
        for (ProjectManager projectManager : projectManagers) {
            projects.addAll(projectManager.getProjectsList());
        }
        return projects;
    }

    public Set<String> getAllTeams() {
        Set<String> teams = new HashSet<>();
        List<ScrumMaster> scrumMasters = getScrumMasters();
        for (ScrumMaster scrumMaster : scrumMasters) {
            teams.addAll(scrumMaster.getTeamsList());
        }
        List<Programmer> programmers = getProgrammers();
        for (Programmer programmer : programmers) {
            teams.add(programmer.getTeam());
        }
        return teams;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name) && Objects.equals(employees, company.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, employees);
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}
