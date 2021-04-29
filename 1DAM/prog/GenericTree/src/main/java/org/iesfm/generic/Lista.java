package org.iesfm.generic;

import java.util.Objects;

public class Lista<T> {

    private Node<T> head;

    public Lista(Node<T> head) {
        this.head = head;
    }

    public Lista() {

    }

    public void add(T value) {
        if (head == null) {
            head = new Node<>(value);
        } else {
            head.add(value);
        }
    }

    public T get(int i) {
        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException();
        } else {
            return head.get(i);
        }
    }

    public int size() {
//        if (head == null) {
//            return 0;
//        } else {
//            return head.count(0);
//        }
        Node<T> n = head;
        int size = 0;
        while (n != null) {
            size++;
            n = n.getNext();
        }
        return size;
    }

    public void removeHead() {
        if (head != null) {
            head = head.getNext();
        }
    }

    public void removeLast() {
        if (head != null) {
            if (head.getValue() == null) {
                head = null;
            } else {
                head.removeLast();
            }
        }
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lista<?> lista = (Lista<?>) o;
        return Objects.equals(head, lista.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head);
    }

    @Override
    public String toString() {
        return "Head{" +
                "head=" + head +
                '}';
    }
}
