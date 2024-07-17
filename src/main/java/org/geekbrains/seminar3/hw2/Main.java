//Дан произвольный массив целых чисел. Создайте список ArrayList, заполненный данными из этого массива. Необходимо удалить из списка четные числа и вернуть результирующий.
//Напишите свой код в методе removeEvenNumbers класса Answer. Метод removeEvenNumbers принимает на вход один параметр: Integer[] arr - список целых чисел, возвращает список ArrayList<Integer>
//Примеры.
//Исходный массив:
//        1, 2, 3, 4, 5, 6, 7, 8, 9
//Результат:
//        [1, 3, 5, 7, 9]
//Исходный массив:
//        2, 4, 6, 8
//Результат:
//        []

package org.geekbrains.seminar3.hw2;

import java.util.Arrays;
import java.util.ArrayList;

class Answer {
    public static ArrayList<Integer> removeEvenNumbers(Integer[] arr) {
        // Введите свое решение ниже
        ArrayList<Integer> arrList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                arrList.add(arr[i]);
            }
        }
        return arrList;
    }
}

public class Main {
    public static void main(String[] args) {
//        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] arr = {2, 4, 6, 8};
        Answer ans = new Answer();
        ArrayList<Integer> result = ans.removeEvenNumbers(arr);
        System.out.println(result);

    }
}
