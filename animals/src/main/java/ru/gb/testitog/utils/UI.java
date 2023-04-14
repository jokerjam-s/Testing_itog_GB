package ru.gb.testitog.utils;

import java.util.Map;
import java.util.Scanner;

public class UI {
    /**
     * вывод и запрос действия меню, если пользователь вводит не существующий ключ - вернет пустое значение
     * @param menu - словарь для отображения меню, key - ожидаемый ввод от пользователя, value - пункт меню
     * @return
     */
    public String menuShow(Map<String, String> menu) {
        Scanner scanner = new Scanner(System.in);
        String answear;

        for (String s : menu.keySet()) {
            System.out.println(s + " - " + menu.get(s));
        }
        System.out.print("> ");

        answear = scanner.next();

        if(!menu.containsKey(answear)){
            answear = "";
        }

        return answear;
    }

    /**
     * Запрос числового значения у пользователя
     * @param message - сообщение пользователю
     * @return
     */
    public int getInteger(String message){
        Scanner scanner = new Scanner(System.in);

        System.out.print(message);
        return scanner.nextInt();
    }

    /**
     * Запрос строковаого значения у пользователя
     * @param message - сообщение пользователю
     * @return
     */
    public String getString(String message){
        Scanner scanner = new Scanner(System.in);

        System.out.print(message);
        return scanner.next();
    }

}
