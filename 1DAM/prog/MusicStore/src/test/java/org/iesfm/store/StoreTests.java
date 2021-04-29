package org.iesfm.store;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class StoreTests {

    private Store store;
    private TreeSet<Disk> disks;
    private HashMap<String, Member> members;

    @Test
    public void getDisksByGenreTest() {
        disks = new TreeSet<>();
        TreeSet<Disk> disks = new TreeSet<>();
        HashSet<String> genres = new HashSet<>();
        genres.add("Rock");
        disks.add(new Disk("titulo1", "autor1", genres));
        disks.add(new Disk("titulo2", "autor2", genres));
        disks.add(new Disk("titulo3", "autor3", genres));
        disks.add(new Disk("titulo4", "autor4", new HashSet<>()));
        store = new Store("Mi lib", "Calle1", new HashMap<>(), new HashMap<>());

        TreeSet<Disk> rockDisks = store.getDisksByGenre("Rock");

        Set<Disk> expectedRockDisks = new HashSet<>();
        disks.add(new Disk("titulo1", "autor1", genres));
        disks.add(new Disk("titulo2", "autor2", genres));
        disks.add(new Disk("titulo3", "autor3", genres));

        Assert.assertEquals(expectedRockDisks, rockDisks);
    }

    @Test
    public void getMembersByCpTest() {

        HashMap<String, Member> members = new HashMap<>();

        members.put("nombre1", new Member("nombre1", "apellido1.1", "apellido1.2", "1", 40212, new LinkedList<>()));
        members.put("nombre2", new Member("nombre2", "apellido2.1", "apellido2.2", "2", 40212, new LinkedList<>()));
        members.put("nombre3", new Member("nombre3", "apellido3.1", "apellido3.2", "3", 92372, new LinkedList<>()));

        Store store = new Store("Mi lib", "Calle1", new HashMap<>(), members);

        HashSet<Member> membersCp = store.getMembersByCp(40212);

        HashSet<Member> expectedMembersCp = new HashSet<>();

        expectedMembersCp.add(new Member("nombre1", "apellido1.1", "apellido1.2", "1", 40212, new LinkedList<>()));
        expectedMembersCp.add(new Member("nombre2", "apellido2.1", "apellido2.2", "2", 40212, new LinkedList<>()));

        Assert.assertEquals(expectedMembersCp, membersCp);
    }

    @Test
    public void hasGenreTest() {
        TreeSet<Disk> rockDisks = store.getDisksByGenre("Rock");

        Assert.assertEquals(disks, rockDisks);
    }

    @Test
    public void getMembersByCpTests() {
        HashSet<Member> cp = store.getMembersByCp(5000);
        Assert.assertEquals(members, cp);
    }

    @Test
    public void authorDisksTest() {

        HashMap<String, Disk> disks = new HashMap<>();

        disks.put("name1", new Disk("name1", "artista1", new HashSet<>()));
        disks.put("name2", new Disk("name2", "artista1", new HashSet<>()));
        disks.put("name3", new Disk("name3", "artista2", new HashSet<>()));

        Store store = new Store("name1","address1", disks, new HashMap<>());

        TreeSet<Disk> author1Disks = store.getAuthorDisks("artista1");

        TreeSet<Disk> expectedDisks = new TreeSet<>();

        expectedDisks.add(new Disk("name1", "artista1", new HashSet<>()));
        expectedDisks.add(new Disk("name2", "artista1", new HashSet<>()));

        Assert.assertEquals(expectedDisks, author1Disks);
    }
}
