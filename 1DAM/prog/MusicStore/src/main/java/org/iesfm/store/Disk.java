package org.iesfm.store;

import java.util.HashSet;
import java.util.Objects;

public class Disk implements Comparable<Disk> {

    private String title;
    private String author;
    private HashSet<String> genres;

    public Disk(String title, String author, HashSet<String> genres) {
        this.title = title;
        this.author = author;
        this.genres = genres;
    }

    public boolean hasGenre(String genre) {
        return genres.contains(genre);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public HashSet<String> getGenres() {
        return genres;
    }

    public void setGenres(HashSet<String> genres) {
        this.genres = genres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disk disk = (Disk) o;
        return Objects.equals(title, disk.title) &&
                Objects.equals(author, disk.author) &&
                Objects.equals(genres, disk.genres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, genres);
    }

    @Override
    public String toString() {
        return "Disk{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genres=" + genres +
                '}';
    }

    @Override
    public int compareTo(Disk o) {
        return this.title.compareTo(o.title);
    }
}
