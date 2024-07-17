//Дан LinkedList с несколькими элементами разного типа.
//В методе revert класса LLTasks реализуйте разворот этого
//списка без использования встроенного функционала.
//Пример
//// Дан
//[1, One, 2, Two]
//// Вывод
//[1, One, 2, Two]
//[Two, 2, One, 1]

package org.geekbrains.seminar4.hw1;

import java.util.LinkedList;

class LLTasks {
    public static void revertLL(LinkedList<Object> ll) {
        // Напишите свое решение ниже
        Object temp;
        for (int i = 0; i < ll.size() / 2; i++) {
            temp = ll.get(i);
            ll.set(i, ll.get(ll.size() - 1 - i));
            ll.set(ll.size() - 1 - i, temp);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList<Object> ll = new LinkedList<>();
        ll.add(1);
        ll.add("One");
        ll.add(2);
        ll.add("Two");
        LLTasks answer = new LLTasks();
        System.out.println(ll);
        answer.revertLL(ll);
        System.out.println(ll);
    }
}

