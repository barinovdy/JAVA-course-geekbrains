//4*. К калькулятору из предыдущего дз добавить логирование.

package org.geekbrains.seminar2.hw4;

import org.geekbrains.seminar2.hw4.Calculator;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;

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

    private static final Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        int a = 16;
        char op = '/';
        int b = 4;

//        ConsoleHandler ch = new ConsoleHandler();
        FileHandler fh = null;
        try {
            fh = new FileHandler("s2_hw4.log");
        } catch (IOException ex) {
            throw new RuntimeException();
        }
        log.addHandler(fh);
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String date = dateFormat.format(new Date());

        log.log(Level.INFO, "Start");
        log.log(Level.INFO, date);

        Calculator calculator = new Calculator();
        log.log(Level.INFO, "Calc method: a=" + a + " op=" + op + " b=" + b);
        double result = calculator.calculate(op, a, b);
        log.log(Level.INFO, "Result: " + result);
        System.out.println(result);
    }
}
