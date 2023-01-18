package com.codecool.farm;

import com.codecool.farm.animal.Animal;

class Butcher {

    public boolean canButcher(Animal animal){
        return animal.getSize() > 3;
    }
}
