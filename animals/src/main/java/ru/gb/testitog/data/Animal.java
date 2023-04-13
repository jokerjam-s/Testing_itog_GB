package ru.gb.testitog.data;

import java.util.List;

/**
 * Интерфейс животное. Животное имеет имя (кличку),
 * может выполнять определенный набор команд.
 * Также имеет окрас. Окрас животного задается изначально,
 * изменению не подлежит
 */
public interface Animal {
    /**
     * Получить имя животного
     * @return
     */
    String getName();

    /**
     * Установить дату рождения
     * @param date
     */
    void setDateBirth(String date);

    /**
     * Получить дату рождедния
     * @return
     */
    String getDateBirth();

    /**
     * Установить имя животного
     * @param name - новое имя
     */
    void setName(String name);

    /**
     * Пополнить список команд животного
     * @param newCommand - новая команда
     */
    void addCommand(String newCommand);

    /**
     * Удаление команды
     * @param command
     */
    void removeCommand(String command);

    /**
     * Получить список команд
     * @return
     */
    List<String> getCommandList();

    /**
     * Получить окрас животного
     * @return
     */
    String getColor();

    /**
     * Получить количество команд выполняемых животным
     * @return
     */
    int getCommandCount();

    /**
     * Установить окрас животного
     * @param color - новый окрас
     */
    void setColor(String color);
}
