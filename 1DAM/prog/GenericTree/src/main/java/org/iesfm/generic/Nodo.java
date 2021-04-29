package org.iesfm.generic;

import java.util.Objects;

public class Nodo<T extends Comparable<T>> {

    private T value;
    private Nodo<T> left;
    private Nodo<T> right;

    public Nodo(T value, Nodo<T> left, Nodo<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public void insert(T newValue) {
        if (value.compareTo(newValue) < 0) {
            if (right == null) {
                right = new Nodo<>(newValue, null, null);
            } else {
                right.insert(newValue);
            }
        } else if (value.compareTo(newValue) > 0)  {
            if (left == null) {
                left = new Nodo<>(newValue, null, null);
            } else {
                left.insert(newValue);
            }
        }
    }

    public boolean contains(T value) {
        boolean found = false;
        int compare = this.value.compareTo(value);
        if (compare == 0) {
            found = true;
        } else if (compare < 0) {
            if (right != null) {
                found = right.contains(value);
            }
        } else {
            if (left != null) {
                found = left.contains(value);
            }
        }
        return found;
    }


    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Nodo<T> getLeft() {
        return left;
    }

    public void setLeft(Nodo<T> left) {
        this.left = left;
    }

    public Nodo<T> getRight() {
        return right;
    }

    public void setRight(Nodo<T> right) {
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nodo<?> nodo = (Nodo<?>) o;
        return Objects.equals(value, nodo.value) &&
                Objects.equals(left, nodo.left) &&
                Objects.equals(right, nodo.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, left, right);
    }

    @Override
    public String toString() {
        return "Nodo{" +
                "valor=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
