// Дан массив целых чисел. Верно ли, что массив является симметричным.

package org.geekbrains.seminar1.cw4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введи размер массива:");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Введи значения массива:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        isSimmetr(arr);

        System.out.println("Массив выглядит так:");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(" %d , ", arr[i]);
        }
    }

    private static void isSimmetr(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) {
                System.out.println("Не симметричный");
                return;
            }
            System.out.println("Cимметричный");
        }
    }
}

/*
// Вариант с использованием флага
boolean flag = true;
for (int i = 0; i < arr.length / 2; i++) {
    if (arr[i] != arr[arr.length - 1 - i]) {
        flag = false;
    }
}
if (flag) {
    System.out.println("симметричный");
}
else{
    System.out.println("несимметричный");
}
*/