package org.iesfm.store;

import org.iesfm.store.exceptions.MemberNotFoundException;

import java.util.*;

public class Store implements IStore {

    private String name;
    private String address;
    private HashMap<String, Disk> disks;
    private HashMap<String, Member> members;

    public Store(String name, String address, HashMap<String, Disk> disks, HashMap<String, Member> members) {
        this.name = name;
        this.address = address;
        this.disks = disks;
        this.members = members;
    }

    @Override
    public TreeSet<Disk> getDisksByGenre(String genre) {
        TreeSet<Disk> genreDisks = new TreeSet<>();
        for (Disk disk : disks.values()) {
            if (disk.hasGenre(genre)) {
                genreDisks.add(disk);
            }
        }
        return genreDisks;
    }

    @Override
    public HashSet<Member> getMembersByCp(int cp) {
        HashSet<Member> cpMembers = new HashSet<>();
        for (Member member : members.values()) {
            if (member.getCp() == cp) {
                cpMembers.add(member);
            }
        }
        return cpMembers;
    }

    @Override
    public Disk getDisk(String title) {
        return disks.get(title);
    }

    @Override
    public Member getMember(String nif) {
        return members.get(nif);
    }

    @Override
    public TreeSet<Disk> getAuthorDisks(String author) {
        TreeSet<Disk> authorDisks = new TreeSet<>();
        for (Disk disk : disks.values()) {
            if (disk.getAuthor().equals(author)) {
                authorDisks.add(disk);
            }
        }
        return authorDisks;
    }

    @Override
    public LinkedList<Order> getMemberOrders(String nif) throws MemberNotFoundException {
        //LinkedList<Order> memberOrders = new LinkedList<>();
        Member member = members.get(nif);
        if (member == null) {
            throw new MemberNotFoundException();
        }
        return member.getOrders();
    }

    @Override
    public HashSet<Member> getMemberSpend(String nif) {
        HashSet<Member> spend = new HashSet<>();
        Order orderPrices = null;
        for (Member member : members.values()) {
            if (member.getNif().equals(nif)) {
                orderPrices.getPrice();
            }
        }
        return spend;
    }

    @Override
    public int countNumberDisks(String author) {
        int numbersDisk = 0;
        for (Disk disk : disks.values()) {
            if (disk.getAuthor().equals(author)) {
                numbersDisk++;
            }
        }
        return numbersDisk;
    }

    @Override
    public TreeSet<Disk> removeDisk(String title) {
        TreeSet<Disk> removedDisk = new TreeSet<>();
        for (Disk disk : disks.values()) {
            if (disk.getTitle().equals(title)) {
                removedDisk.remove(disk);
            }
        }
        return removedDisk;
    }

    @Override
    public TreeSet<Disk> insertDisk(Disk newDisk) {
        TreeSet<Disk> addedDisk = new TreeSet<>();

        addedDisk.add(newDisk);

        return addedDisk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public HashMap<String, Disk> getDisks() {
        return disks;
    }

    public void setDisks(HashMap<String, Disk> disks) {
        this.disks = disks;
    }

    public HashMap<String, Member> getMembers() {
        return members;
    }

    public void setMembers(HashMap<String, Member> members) {
        this.members = members;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return Objects.equals(name, store.name) && Objects.equals(address, store.address) && Objects.equals(disks, store.disks) && Objects.equals(members, store.members);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, disks, members);
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", disks=" + disks +
                ", members=" + members +
                '}';
    }
}
