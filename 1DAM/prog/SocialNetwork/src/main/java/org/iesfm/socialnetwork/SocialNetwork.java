package org.iesfm.socialnetwork;

import java.util.*;

public class SocialNetwork implements ISocialNetwork {

    private String name;
    private HashMap<String, User> users;
    private List<String> trendingTopics;

    public SocialNetwork(String name, HashMap<String, User> users, List<String> trendingTopics) {
        this.name = name;
        this.users = users;
        this.trendingTopics = trendingTopics;
    }

    @Override
    public TreeSet<Post> getWallPostsByUsername(String username) {
        User user = users.get(username);
        return user.getWall();
    }

    @Override
    public TreeSet<Post> getWallPostsByTag(String username, String tag) {
        User user = users.get(tag);
        return user.getWall();
    }

    @Override
    public TreeSet<Post> addWallPosts(String username, String message, String date, HashSet<String> tags) {
        TreeSet<Post> addedWallPosts = new TreeSet<>();
        for (Post post : addedWallPosts) {
            if (post.getAuthor().equals(username) && post.getMessage().equals(message) && post.getDate().equals(date) && post.getTags().equals(tags)) {
                addedWallPosts.add(post);
            }
        }
        return addedWallPosts;
    }

    @Override
    public LinkedList<Post> findAuthorWallPosts(String username) {
        LinkedList<Post> authorWallPosts = new LinkedList<>();
        for (Post post : authorWallPosts) {
            if (post.getAuthor().equals(username)) {
                authorWallPosts.add(post);
            }
        }
        return authorWallPosts;
    }

    @Override
    public User createUser(String username) {
        TreeSet<Post> wall = new TreeSet<>();
        User user = new User(username, wall);

        users.put(username, user);
        return user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, User> getUsers() {
        return users;
    }

    public void setUsers(HashMap<String, User> users) {
        this.users = users;
    }

    public List<String> getTrendingTopics() {
        return trendingTopics;
    }

    public void setTrendingTopics(LinkedList<String> trendingTopics) {
        this.trendingTopics = trendingTopics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocialNetwork that = (SocialNetwork) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(users, that.users) &&
                Objects.equals(trendingTopics, that.trendingTopics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, users, trendingTopics);
    }

    @Override
    public String toString() {
        return "SocialMedia{" +
                "name='" + name + '\'' +
                ", users=" + users +
                ", trendingTopics=" + trendingTopics +
                '}';
    }
}
