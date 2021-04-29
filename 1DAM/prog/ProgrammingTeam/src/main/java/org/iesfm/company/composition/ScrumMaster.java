package org.iesfm.company.composition;

import java.util.Objects;
import java.util.Set;

public class ScrumMaster implements Position {

    public static final String SCRUMMASTER = "Scrum Master";
    Set<String> teams;

    public ScrumMaster(Set<String> teams) {
        this.teams = teams;
    }

    @Override
    public String name() {
        return SCRUMMASTER;
    }

    public Set<String> getTeams() {
        return teams;
    }

    public void setTeams(Set<String> teams) {
        this.teams = teams;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScrumMaster that = (ScrumMaster) o;
        return Objects.equals(teams, that.teams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teams);
    }

    @Override
    public String toString() {
        return "ScrumMaster{" +
                "teams=" + teams +
                '}';
    }
}
