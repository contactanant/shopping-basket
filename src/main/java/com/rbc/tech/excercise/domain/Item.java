package com.rbc.tech.excercise.domain;

import java.util.Objects;

public class Item {
    private final String code;
    private final String name;
    private final int quantity;

    private Item(String code, String name, int quantity) {
        this.code = code;
        this.name = name;
        this.quantity = quantity;
    }

    public static Item createItem(Fruit fruit) {
        return new Item(fruit.getCode(), fruit.getName(), 1);
    }

    public static Item createItem(Fruit fruit, int quantity) {
        return new Item(fruit.getCode(), fruit.getName(), quantity);
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(quantity, item.quantity) &&
                Objects.equals(code, item.code) &&
                Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, quantity);
    }
}
