//Вычислить n-ое треугольного число(сумма чисел от 1 до n).
//Внутри класса Answer напишите метод countNTriangle,
//который принимает число n и возвращает его n-ое
//треугольное число.
//Если число n < 1 (ненатуральное) метод должен вернуть -1.
//Пример
//n = 4 -> 10
//n = 5 -> 15


package org.geekbrains.seminar1.hw1;

class Answer {
    public int countNTriangle(int n){
        // Введите свое решение ниже
        int sum = 0;
        if (n >= 1) {
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            return sum;
        }
        else return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        int n = 3;
        // Вывод результата на экран
        Answer ans = new Answer();
        int itresume_res = ans.countNTriangle(n);
        System.out.println(itresume_res);
    }
}
