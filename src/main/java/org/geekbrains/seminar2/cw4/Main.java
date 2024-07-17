//Напишите метод, который принимает на вход строку (String) и
//определяет является ли строка палиндромом (возвращает
//boolean значение)

package org.geekbrains.seminar2.cw4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stroka = new Scanner(System.in);
        String result = stroka.nextLine();
        boolean flag = true;
        for (int i = 0; i < result.length() / 2; i++) {
            if (result.charAt(i) != result.charAt(result.length() - 1 - i)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Палиндром");
        }
        else {
            System.out.println("Не палиндром");
        }

//Метод препода
//        String stroka = "qwe eWQ".replaceAll("\\s", "");
//        //если строка эквивалента перевернутой строке
//        if (stroka.equals(new StringBuilder(stroka).reverse().toString())) {
//            System.out.println("Палиндром");
//        }
//        else {
//            System.out.println("не палиндром");
//        }
    }
}
