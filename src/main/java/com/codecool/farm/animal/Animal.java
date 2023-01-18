package com.codecool.farm.animal;

public abstract class Animal {
    private final int size;

    public Animal() {
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public abstract void feed();
}
