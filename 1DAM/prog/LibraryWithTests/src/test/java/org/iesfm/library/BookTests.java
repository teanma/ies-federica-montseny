package org.iesfm.library;

import org.junit.Assert;
import org.junit.Test;

public class BookTests {

    @Test
    public void hasGenreTest() {
        String[] genres = new String[2];
        genres[0] = "Terror";
        genres[1] = "Drama";
        Book book = new Book(1, "Título", "autor", genres);

        Assert.assertTrue(book.hasGenre("Terror"));
    }

    @Test
    public void notHasGenre() {
        String[] genres = new String[2];
        genres[0] = "Terror";
        genres[1] = "Drama";
        Book book = new Book(1, "Título", "autor", genres);

        Assert.assertFalse(book.hasGenre("Historia"));
    }
}
