package org.iesfm.socialnetwork;

import java.util.Objects;
import java.util.TreeSet;

public class User {

    private String username;
    private TreeSet<Post> wall;

    public User(String username, TreeSet<Post> wall) {
        this.username = username;
        this.wall = wall;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public TreeSet<Post> getWall() {
        return wall;
    }

    public void setWall(TreeSet<Post> wall) {
        this.wall = wall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(wall, user.wall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, wall);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", posts=" + wall +
                '}';
    }
}
