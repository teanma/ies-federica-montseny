package org.iesfm.store;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class DiskTests {

    private Disk disk;

    @Before
    public void setUp() {
        HashSet<String> genres = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            genres.add("genre" + i);
        }

        for (String genre : genres) {
            System.out.println(genre);
        }

        disk = new Disk("titulo", "autor", genres);
    }

    @Test
    public void hasGenreTest() {
        for (int i = 0; i < 100; i++) {
            disk.hasGenre("genero");
        }
    }
}
