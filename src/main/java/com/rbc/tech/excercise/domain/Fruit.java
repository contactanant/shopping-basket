package com.rbc.tech.excercise.domain;

public enum Fruit {
    APPLE ("a01", "Apple"),
    BANANA ("b01", "Banana"),
    ORANGE ("c01", "Orange"),
    LEMON ("d01", "Lemon"),
    PEACHES("e01", "Peaches");

    private final String code;
    private final String name;

    Fruit(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
