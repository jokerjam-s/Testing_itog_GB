package ru.gb.testitog.services;

//import ru.gb.testitog.data.Animal;
import ru.gb.testitog.data.Animal;
import ru.gb.testitog.data.Cat;
import ru.gb.testitog.data.Dog;
import ru.gb.testitog.data.Hamster;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


/**
 * список животных
 */
public class AnimalList <Animal> {
    private List<Animal> animals = new ArrayList<>();

    /**
     * добавить животное в список
     * @param animal
     */
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    /**
     * удалить животное из списка
     * @param animal
     * @return
     */
    public boolean removeAnimal(Animal animal){
        return animals.remove(animal);
    }

    /**
     * Получить список животных
     * @return
     */
    public List<Animal> getAnimals(){
        return animals;
    }

    /**
     * Получить только кошек
     * @return
     */
    public List<Animal> getCats(){
        return animals.stream().filter(x -> x instanceof Cat).toList();
    }

    /**
     * Получить только собак
     * @return
     */
    public List<Animal> getDogs(){
        return animals.stream().filter(x -> x instanceof Dog).toList();
    }

    /**
     * Получить только хомяков
     * @return
     */
    public List<Animal> getHamsters(){
        return animals.stream().filter(x -> x instanceof Hamster).toList();
    }

    public Cat findCat(String name){
        List<Cat> cats = (List<Cat>) this.getCats();
        Cat cat = null;

        try {
            cat = cats.stream().filter(c -> c.getName().equals(name)).findFirst().get();
        }
        catch (NoSuchElementException ex){
            cat = null;
        }
        return cat;
    }

    public Dog findDog(String name){
        List<Dog> dogs = (List<Dog>) this.getDogs();
        Dog dog = null;

        try {
            dog = dogs.stream().filter(c -> c.getName().equals(name)).findFirst().get();
        }
        catch (NoSuchElementException ex){
            dog = null;
        }
        return dog;
    }

    public Hamster findHamster(String name){
        List<Hamster> hamsters = (List<Hamster>) this.getDogs();
        Hamster hamster = null;

        try {
            hamster = hamsters.stream().filter(c -> c.getName().equals(name)).findFirst().get();
        }
        catch (NoSuchElementException ex){
            hamster = null;
        }
        return hamster;
    }

}
