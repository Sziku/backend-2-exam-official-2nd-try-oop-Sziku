package com.codecool.farm;

import com.codecool.farm.animal.Animal;
import com.codecool.farm.animal.Pig;

import java.util.ArrayList;
import java.util.List;

class Farm {

    private List<Animal> animals;

    public Farm(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void feedAnimals(){
        for (Animal animal : animals){
            animal.feed();
        }
    }

    public void butcher(Butcher butcher){
        for (Animal animal : animals){
            butcher.canButcher(animal);
        }

    }

    public boolean isEmpty(){
        return animals.isEmpty();
    }

    public List<String> getStatus(){
        List<String> animalStatusList =  new ArrayList<>();

        for(Animal animal : animals){
            StringBuilder animalStatus = new StringBuilder();
            animalStatus.append("There is a ")
                    .append(animal.getSize())
                    .append(" sized ")
                    .append(animal.getClass().getSimpleName().toLowerCase())
                    .append(" in the farm.");

            animalStatusList.add(animalStatus.toString());
        }

        return animalStatusList;
    }

}
