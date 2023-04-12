package ru.gb.testitog.utils;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    /**
     * вывод и запрос действия меню
     * @param menu
     * @return
     */

    public int showMenu(List<String> menu) {
        Scanner scanner = new Scanner(System.in);
        int mm = 0;

        for (String s : menu) {
            System.out.println(s);
        }

        mm = scanner.nextInt();

        mm = (mm < 0 || mm > menu.size() - 1) ? 0 : mm;

        return mm;
    }

    /**
     * Запрос числового значения у пользователя
     * @param message - сообщение пользователю
     * @return
     */
    public int getInteger(String message){
        Scanner scanner = new Scanner(System.in);

        System.out.println(message);
        return scanner.nextInt();
    }

    /**
     * Запрос строковаого значения у пользователя
     * @param message - сообщение пользователю
     * @return
     */
    public String getString(String message){
        Scanner scanner = new Scanner(System.in);

        System.out.println(message);
        return scanner.next();
    }

}
