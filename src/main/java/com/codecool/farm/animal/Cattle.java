package com.codecool.farm.animal;

public class Cattle extends Animal{

    @Override
    public void feed() {
        super.setSize(super.getSize() + 2);
    }
}
