package com.codecool.farm.animal;

public abstract class Animal {
    private int size;

    public Animal() {
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public abstract void feed();
}
