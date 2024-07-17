//Реализуйте метод, который принимает на вход целочисленный массив arr:
//        - Создаёт список ArrayList, заполненный числами из исходого массива arr.
//        - Сортирует список по возрастанию и выводит на экран.
//        - Находит минимальное значение в списке и выводит на экран - Minimum is {число} - Находит максимальное значение в списке и выводит на экран - Maximum is {число}
//        - Находит среднее арифметическое значений списка и выводит на экран - Average is =  {число}
//Напишите свой код в методе analyzeNumbers класса Answer. Метод analyzeNumbers принимает на вход один параметр:
//Integer[] arr - массив целых чисел.
//        Пример.
//Исходный массив:
//        4, 2, 7, 5, 1, 3, 8, 6, 9
//Результаты:
//        [1, 2, 3, 4, 5, 6, 7, 8, 9]
//Minimum is 1
//Maximum is 9

package org.geekbrains.seminar3.hw3;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

class Answer {
    public static void analyzeNumbers(Integer[] arr) {
        // Введите свое решение ниже
        ArrayList<Integer> arrList = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            arrList.add(arr[i]);
            sum += arr[i];
        }

        Collections.sort(arrList);
        System.out.println(arrList);

        int minValue = Collections.min(arrList);
        int maxValue = Collections.max(arrList);
        double averValue = sum / (double)arr.length;
        System.out.println("Minimum is " + minValue);
        System.out.println("Maximum is " + maxValue);
        System.out.println("Average is " + averValue);
    }
}

public class Main {
    public static void main(String[] args) {
//        Integer[] arr = {4, 2, 7, 5, 1, 3, 8, 6, 9};
        Integer[] arr = {-2, -1, 0, 1, 2, 3, 4, 5};
        Answer ans = new Answer();
        ans.analyzeNumbers(arr);
    }
}
