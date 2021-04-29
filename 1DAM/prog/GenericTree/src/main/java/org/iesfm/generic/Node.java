package org.iesfm.generic;

import java.util.Objects;

public class Node<T> {

    private T value;
    private Node<T> next;

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public Node(T value) {
        this.value = value;
    }

    public void add(T value) {
        if (next == null) {
            next = new Node<>(value);
        } else {
            next.add(value);
        }
    }

    public T get(int i) {
        if (i == 0) {
            return value;
        } else {
            return next.get(i - 1);
        }
    }

    public int count(int size) {
        if (next == null) {
            return size +1;
        } else {
            return next.count(size + 1);
        }
    }

    public void removeLast() {
        if (next.getNext() == null) {
            next = null;
        } else {
            getNext().removeLast();
        }
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(value, node.value) && Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, next);
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
