//Реализуйте простой калькулятор
//В методе calculate класса Calculator реализовать калькулятор, который будет
//выполнять математические операции (+, -, *, /) над двумя целыми числами и
//возвращать результат вещественного типа.
//В классе Printer необходимо реализовать проверку переданного оператора, при
//некорректном операторе программа должна вывести сообщение об ошибке
//"Некорректный оператор: 'оператор'".
//Аргументы, передаваемые в метод/функцию:
//        '3'
//        '+'
//        '7'
//На выходе:
//        10.0

package org.geekbrains.seminar1.hw3;

class Calculator {
    public double calculate(char op, int a, int b) {
        // Введите свое решение ниже
        double result = 0;
        switch (op) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b != 0) result = a / b;
                else System.out.println("Деление на ноль");
                break;
            default:
                System.out.println("Некорректный оператор: 'оператор'");
                break;
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        int a = 0;
        char op = ' ';
        int b = 0;

        a = 16;
        op = '/';
        b = 4;

        Calculator calculator = new Calculator();
        double result = calculator.calculate(op, a, b);
        System.out.println(result);
    }
}
