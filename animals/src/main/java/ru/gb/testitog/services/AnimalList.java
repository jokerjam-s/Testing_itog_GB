package ru.gb.testitog.services;

import ru.gb.testitog.data.Animal;
import ru.gb.testitog.data.Cat;
import ru.gb.testitog.data.Dog;
import ru.gb.testitog.data.Hamster;

import java.util.ArrayList;
import java.util.List;


/**
 * список животных
 */
public class AnimalList <Animal> {
    private List<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public boolean removeAnimal(Animal animal){
        return animals.remove(animal);
    }

    public List<Animal> getAnimals(){
        return animals;
    }

    public List<Animal> getCats(){
        return animals.stream().filter(x -> x instanceof Cat).toList();
    }

    public List<Animal> getDogs(){
        return animals.stream().filter(x -> x instanceof Dog).toList();
    }

    public List<Animal> getHamsters(){
        return animals.stream().filter(x -> x instanceof Hamster).toList();
    }

}
