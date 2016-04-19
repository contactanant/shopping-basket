package com.rbc.tech.excercise.domain;


import com.rbc.tech.excercise.exception.ItemNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static java.lang.String.format;

public class Basket<E> {
    private final List<E> items;

    public Basket() {
        items = new ArrayList<>();
    }

    public void add(E item) {
        items.add(item);
    }

    public void removeItem(E item) throws ItemNotFoundException {
        if (!items.remove(item)) {
            throw new ItemNotFoundException(format("Item not found %s", item));
        }
    }

    public Collection<E> getItems() {
        return Collections.unmodifiableCollection(items);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "items=" + items +
                '}';
    }
}
