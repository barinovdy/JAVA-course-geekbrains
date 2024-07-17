//Напишите функцию printPrimeNums, которая выведет на экран все
//простые числа в промежутке от 1 до 1000, каждое на новой строке.
//Напишите свой код в методе printPrimeNums класса Answer.
//Пример
//2
//3
//5
//7
//11
//...

package org.geekbrains.seminar1.hw2;

class Answer {
    public void printPrimeNums(){
        // Напишите свое решение ниже
        for (int i = 2; i <= 1000; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0)  {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) System.out.println(i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Answer ans = new Answer();
        ans.printPrimeNums();
    }
}
