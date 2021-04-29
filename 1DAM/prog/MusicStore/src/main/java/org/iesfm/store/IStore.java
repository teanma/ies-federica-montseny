package org.iesfm.store;

import org.iesfm.store.exceptions.MemberNotFoundException;

import java.util.*;

public interface IStore {

    TreeSet<Disk> getDisksByGenre(String genre);

    HashSet<Member> getMembersByCp(int cp);

    Disk getDisk(String title);

    Member getMember(String nif);

    TreeSet<Disk> getAuthorDisks(String author);

    LinkedList<Order> getMemberOrders (String nif) throws MemberNotFoundException;

    HashSet<Member> getMemberSpend(String nif);

    int countNumberDisks(String author);

    TreeSet<Disk> removeDisk(String title);

    TreeSet<Disk> insertDisk(Disk newDisk);

}
