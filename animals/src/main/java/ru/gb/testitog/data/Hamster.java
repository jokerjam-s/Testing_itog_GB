package ru.gb.testitog.data;

import java.util.ArrayList;
import java.util.List;

public class Hamster implements Animal {
    private String name;
    private String color;
    List<String> commands;

    public Hamster() {
        this("", "", new ArrayList<>());
    }

    public Hamster(String name, String color, List<String> commands) {
        this.name = name;
        this.color = color;
        this.commands = commands;
    }

    /**
     * Получить имя животного
     *
     * @return
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Установить имя животного
     *
     * @param name - новое имя
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Пополнить список команд животного
     *
     * @param newCommand - новая команда
     */
    @Override
    public void addCommand(String newCommand) {
        if (commands.stream().filter(x -> x.equals(newCommand)).findFirst().isEmpty()) {
            return;
        }

        commands.add(newCommand);
    }

    /**
     * Удаление команды
     *
     * @param command
     */
    @Override
    public void removeCommand(String command) {
        commands.remove(command);
    }

    /**
     * Получить список команд
     *
     * @return
     */
    @Override
    public List<String> getCommandList() {
        return commands;
    }

    /**
     * Получить окрас животного
     *
     * @return
     */
    @Override
    public String getColor() {
        return this.color;
    }

    /**
     * Получить количество команд выполняемых животным
     *
     * @return
     */
    @Override
    public int getCommandCount() {
        return commands.size();
    }

    /**
     * Установить окрас животного
     *
     * @param color - новый окрас
     */
    @Override
    public void setColor(String color) {
        this.color = color;
    }
}
