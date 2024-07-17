//В классе MyQueueInt реализуйте очередь для типа данных Integer с помощью LinkedList со следующими методами:
//enqueue() - помещает элемент в конец очереди
//dequeue() - возвращает первый элемент из очереди и удаляет его
//first() - возвращает первый элемент из очереди, не удаляя
//getElements() - возвращает все элементы в очереди
//Пример
//queue.enqueue(1);
//queue.enqueue(10);
//queue.enqueue(15);
//queue.enqueue(5);
//System.out.println(queue.getElements());
//Результат:
//[1, 10, 15, 5]
//queue.dequeue();
//queue.dequeue();
//System.out.println(queue.getElements());
//Результат:
//[15, 5]
//System.out.println(queue.first());
//Результат:
//15

package org.geekbrains.seminar4.hw2;

import java.util.LinkedList;

class MyQueueInt {
    // Напишите свое решение ниже
    private LinkedList<Integer> ll = new LinkedList<>();

    public void enqueue(int element){
        // Напишите свое решение ниже
        ll.add(element);
    }

    public int dequeue(){
        // Напишите свое решение ниже
        if (ll.isEmpty()) {
            System.out.println("Список пуст");
            return 0;
        } else {
            return (Integer)ll.removeFirst();
        }
    }

    public int first(){
        // Напишите свое решение ниже
        if (ll.isEmpty()) {
            System.out.println("Список пуст");
            return 0;
        } else {
            return (Integer)ll.getFirst();
        }
    }

    public LinkedList<Integer> getElements() {
        // Напишите свое решение ниже
        return ll;
    }
}

public class Main {
    public static void main(String[] args) {
        MyQueueInt queue;
        queue = new MyQueueInt();

        queue.enqueue(1);
        queue.enqueue(10);
        queue.enqueue(15);
        queue.enqueue(5);

        System.out.println(queue.getElements());

        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.getElements());

        System.out.println(queue.first());

    }
}
