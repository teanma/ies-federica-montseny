package org.iesfm.generic;

import java.util.List;

public class ListUtils<T> {

    private List<T> values;

    public ListUtils(List<T> values) {
        this.values = values;
    }

    public T getFirstPosition() {
        return values.get(0);
    }

    public void introduceValue(T value) {
        values.add(value);
    }

    public T getLastPosition() {
        return values.get(values.size() - 1);
    }




}
