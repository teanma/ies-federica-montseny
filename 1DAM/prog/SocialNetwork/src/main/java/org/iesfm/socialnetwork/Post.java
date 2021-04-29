package org.iesfm.socialnetwork;

import java.util.HashSet;
import java.util.Objects;

public class Post implements Comparable<Post> {

    private String author;
    private String message;
    private String date;
    private HashSet<String> tags;

    public Post(String author, String message, String date, HashSet<String> tags) {
        this.author = author;
        this.message = message;
        this.date = date;
        this.tags = tags;
    }

    @Override
    public int compareTo(Post post) {
        return this.date.compareTo(post.getDate());
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public HashSet<String> getTags() {
        return tags;
    }

    public void setTags(HashSet<String> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(author, post.author) &&
                Objects.equals(message, post.message) &&
                Objects.equals(date, post.date) &&
                Objects.equals(tags, post.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, message, date, tags);
    }

    @Override
    public String toString() {
        return "Post{" +
                "authorUsername='" + author + '\'' +
                ", message='" + message + '\'' +
                ", date='" + date + '\'' +
                ", tags=" + tags +
                '}';
    }
}
