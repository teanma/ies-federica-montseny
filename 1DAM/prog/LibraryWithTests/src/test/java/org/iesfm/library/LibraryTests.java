package org.iesfm.library;

import org.junit.Assert;
import org.junit.Test;

public class LibraryTests {

    @Test
    public void getBookTests() {
        String[] genres = new String[0];
        Book book1 = new Book(1, "titulo1", "autor1", genres);
        Book book2 = new Book(2, "titulo2", "autor2", genres);
        Book[] books = {book1, book2};
        Library library = new Library("lib", books, new Member[0], new BookLend[0]);

        Book res = library.getBook(1);

        Assert.assertEquals(book2, res);
    }
}
