//Вы работаете с приложением для учета имен пользователей. Ваша задача - разработать программу, которая принимает на вход пять имен пользователей (или использует имена по умолчанию, если аргументы не предоставлены) и подсчитывает, сколько раз каждое имя встречается.
//Программа должна использовать HashMap для хранения имен и их количества вхождений.
//По завершении, программа выводит результат в виде пар "имя - количество".
//На входе:
//        'Elena'
//        'Elena'
//        'Elena'
//        'Ivan'
//        'Ivan'
//На выходе:
//        {Ivan=2, Elena=3}

package org.geekbrains.seminar5.hw2;

import java.util.HashMap;

class NamesCounter {
    private HashMap<String, Integer> names = new HashMap<>();

    // Метод для добавления имени в HashMap
    public void addName(String name) {
        // Введите свое решение ниже
        if (!names.containsKey(name)) {
            names.put(name, 1);
        }
        else {
            int val = names.get(name);
            names.put(name, val + 1);
        }
    }

    // Метод для вывода содержимого HashMap
    public void showNamesOccurrences() {
        // Введите свое решение ниже
        System.out.println(names);
    }
}

public class Main {
    public static void main(String[] args) {
        String name1;
        String name2;
        String name3;
        String name4;
        String name5;

        name1 = "Elena";
        name2 = "Elena";
        name3 = "Elena";
        name4 = "Elena";
        name5 = "Ivan";

        NamesCounter namesCounter = new NamesCounter();

        namesCounter.addName(name1);
        namesCounter.addName(name2);
        namesCounter.addName(name3);
        namesCounter.addName(name4);
        namesCounter.addName(name5);

        namesCounter.showNamesOccurrences();
    }
}
