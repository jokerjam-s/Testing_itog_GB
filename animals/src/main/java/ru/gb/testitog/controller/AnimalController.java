package ru.gb.testitog.controller;

import ru.gb.testitog.data.Cat;
import ru.gb.testitog.data.Dog;
import ru.gb.testitog.data.Hamster;
import ru.gb.testitog.services.AnimalCounter;
import ru.gb.testitog.services.AnimalList;
import ru.gb.testitog.utils.UI;

import java.util.*;
import java.util.logging.Logger;

public class AnimalController {
    private final AnimalList<Object> animalList = new AnimalList<>();
    private final UI ui = new UI();

    // главное меню
    private final Map<String, String> menuMain = new HashMap<String, String>() {{
        put("1", "Добавить животное");
        put("2", "Добавить команду");
        put("3", "Отобразить список");
        put("4", "Показать команды");
        put("5", "Показать кол-во животных");
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

    private enum ANIMALS {CAT, DOG, HAMSTER};

    public void Run() throws Exception {
        String menu;
        do {
            menu = getOperation();

            switch (menu) {
                case "11" -> addAnimal(ANIMALS.CAT);
                case "12" -> addAnimal(ANIMALS.DOG);
                case "13" -> addAnimal(ANIMALS.HAMSTER);
                case "21" -> addCommand(ANIMALS.CAT);
                case "22" -> addCommand(ANIMALS.DOG);
                case "23" -> addCommand(ANIMALS.HAMSTER);
                case "31" -> showAnimals(ANIMALS.CAT);
                case "32" -> showAnimals(ANIMALS.DOG);
                case "33" -> showAnimals(ANIMALS.HAMSTER);
                case "41" -> showCommands(ANIMALS.CAT);
                case "42" -> showCommands(ANIMALS.DOG);
                case "43" -> showCommands(ANIMALS.HAMSTER);
                case "5" -> showCountAnimals();
            }
        } while (!(menu.isEmpty() || menu.equals("0")));
    }

    private void showCountAnimals() throws Exception{
        try(AnimalCounter counter = new AnimalCounter()){
            Logger.getAnonymousLogger().info(counter.getCount().toString());
        }
    }

    /**
     * Отобразить список команд животного
     * @param animal
     */
    private void showCommands(ANIMALS animal){
        String name = ui.getString("Имя животного: ");

        Object o = null;

        switch (animal){
            case CAT -> o = animalList.findCat(name);
            case DOG -> o = animalList.findDog(name);
            case HAMSTER -> o = animalList.findHamster(name);
        }

        if(o == null){
            Logger.getAnonymousLogger().info("Животное не найдено");
            return;
        }

        List<String> commands = null;

        switch (animal){
            case CAT -> commands = ((Cat)o).getCommandList();
            case DOG -> commands = ((Dog)o).getCommandList();
            case HAMSTER -> commands = ((Hamster)o).getCommandList();
        }

        StringBuilder strCommands = new StringBuilder();
        for (String c :commands) {
            strCommands.append(c).append(", ");
        }

        Logger.getAnonymousLogger().info(strCommands.toString());
    }

    /**
     * Отображение списка животных
     * @param animal
     */
    private void showAnimals(ANIMALS animal){
        List<Object> animals = null;

        switch (animal){
            case CAT -> animals = animalList.getCats();
            case DOG -> animals = animalList.getDogs();
            case HAMSTER -> animals = animalList.getHamsters();
        }

        Logger logger = Logger.getAnonymousLogger();
        for (Object o : animals) {
            logger.info(o.toString());
        }
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
    private void addAnimal(ANIMALS animal) throws Exception {
        // Счетчик
        try(AnimalCounter counter = new AnimalCounter()){
            counter.add();
        }


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
        if (!menu.isEmpty() && !menu.equals("0") && !menu.equals("5")) {
            menu += ui.menuShow(menuAnimal);
        }

        return menu;
    }


}
