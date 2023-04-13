package ru.gb.testitog.controller;

import ru.gb.testitog.data.Cat;
import ru.gb.testitog.data.Dog;
import ru.gb.testitog.data.Hamster;
import ru.gb.testitog.services.AnimalList;
import ru.gb.testitog.utils.UI;

import java.util.*;
import java.util.logging.Logger;

public class AnimalController {
    private final AnimalList animalList = new AnimalList();
    private final UI ui = new UI();

    // главное меню
    private final Map<String, String> menuMain = new HashMap<String, String>() {{
        put("1", "Добавить животное");
        put("2", "Добавить команду");
        put("3", "Отобразить список");
        put("0", "Выход");
    }};
    // меню второго уровня
    private final Map<String, String> menuAnimal = new HashMap<>() {{
        put("1", "Кот");
        put("2", "Собака");
        put("3", "Хомяк");
        put("0", "Отмена");
    }};

    private final Map<String, String> menuYesNo = new HashMap<>(){{
        put("1","ДА");
        put("0", "НЕТ");
    }};

    private enum ANIMALS {CAT, DOG, HAMSTER}

    ;

    public void Run() {
        String menu;
        do {
            menu = getOperation();


            switch (menu) {
                case "11":
                    addAnimal(ANIMALS.CAT);
                    break;
                case "12":
                    addAnimal(ANIMALS.DOG);
                    break;
                case "13":
                    addAnimal(ANIMALS.HAMSTER);
                    break;
                case "21":
                    break;
                case "22":
                    break;
                case "23":
                    break;
                case "31":
                    break;
                case "32":
                    break;
                case "33":
                    break;
            }
        } while (!(menu.isEmpty() && menu.equals("0")));

    }

    /**
     * Добавление команды
     * @param animal
     */
    private void addCommand(ANIMALS animal){
        String name = ui.getString("Имя животного: ");
        Object objAnimal = null;
        switch (animal){
            case CAT -> objAnimal = animalList.findCat(name);
            case DOG -> objAnimal = animalList.findDog(name);
            case HAMSTER -> objAnimal = animalList.findHamster(name);
        }

        if(objAnimal == null){
            Logger.getAnonymousLogger().info("Такое животное не найдено");
        }
        else{
            String command = ui.getString("Новая команда: ");

            switch (animal){
                case CAT -> ((Cat)objAnimal).addCommand(command);
                case DOG -> ((Dog)objAnimal).addCommand(command);
                case HAMSTER -> ((Hamster)objAnimal).addCommand(command);
            }
        }

    }

    /**
     * Добавленеи нового животного
     * @param animal - вид добавляемого животного
     */
    private void addAnimal(ANIMALS animal) {
        String name = ui.getString("Имя животного: ");
        String color = ui.getString("Окрас: ");
        String date = ui.getString("Дата рождения: ");

        List<String> commands = new ArrayList<>();
        System.out.println("Добавить команды?");
        String menu = ui.menuShow(menuYesNo);
        while (menu.equals("1")){
            String command = ui.getString("Команда: ");
            commands.add(command);
            System.out.println("Продолжить?");
            menu = ui.menuShow(menuYesNo);
        }

        switch (animal){
            case CAT -> animalList.addAnimal(new Cat(name, color, date, commands));
            case DOG -> animalList.addAnimal(new Dog(name, color, date, commands));
            case HAMSTER -> animalList.addAnimal(new Hamster(name, color, date, commands));
        }
    }

    /**
     * Выбор операции в меню программы
     *
     * @return
     */
    private String getOperation() {
        String menu = ui.menuShow(menuMain);
        if (!menu.isEmpty()) {
            menu += ui.menuShow(menuAnimal);
        }

        return menu;
    }


}
