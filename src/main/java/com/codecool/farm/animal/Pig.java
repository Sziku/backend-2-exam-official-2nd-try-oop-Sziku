package com.codecool.farm.animal;

public class Pig extends Animal{
    @Override
    public void feed() {
        super.setSize(super.getSize() + 1);
    }
}
