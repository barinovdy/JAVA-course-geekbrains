//Дано четное число N (>0) и символы c1 и c2.
//Написать метод, который вернет строку длины N, которая
//состоит из чередующихся символов c1 и c2, начиная с c1.

package org.geekbrains.seminar2.cw1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        shuffleLine(n);
    }

    private static void shuffleLine(int n) {
        String line1 = "c1";
        String line2 = "c2";
        String result = "";

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                result += line1;
            }
            else {
                result += line2;
            }
        }
        System.out.println(result);
    }
}
