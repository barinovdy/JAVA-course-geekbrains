//Реализовать консольное приложение, которое:
//1. Принимает от пользователя строку вида
//text~num
//2. Нужно рассплитить строку по ~, сохранить text в связный список на
//позицию num.
//3. Если введено print~num, выводит строку из позиции num в связном
//списке и удаляет её из списка.

package org.geekbrains.seminar4.cw2;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedList<String> li = new LinkedList<>();
        while (true) {
            System.out.println("Введите строку в формате text~num");
            System.out.println("ДЛя выхода введите exit");
            String str = scan.nextLine();
            if (str.equals("exit")) break;
            String[] inputStr = str.split("~");
            Integer num = Integer.parseInt(inputStr[1]);
            if (!("print".equals(inputStr[0]))) {
                if (li.size() >= num) {
                    li.add(num, inputStr[0]);
                } else {
                    System.out.println("Данной позиции еще нет. Элемент помещен в конец списка.");
                    li.add(inputStr[0]);
                }
            } else {
                if (li.size() >= num) {
                    System.out.println(li.get(Integer.parseInt(inputStr[1])));
                } else {
                    System.out.println("Такого элемента не существует");
                }
            }
        }
    }
}
