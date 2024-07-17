//Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации
//запишите в лог-файл.

package org.geekbrains.seminar2.hw2;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Main {
    public static void main(String[] args) {
//        int[] arr = new int[]{9, 4, 8, 3, 1};
        int[] arr = new int[]{9, 3, 4, 8, 2, 5, 7, 1, 6, 10};

        BubbleSort ans = new BubbleSort();
        ans.sort(arr);

//        try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}

class BubbleSort {
    private static File log;
    private static FileWriter fileWriter;

    public static void sort(int[] mas) {
        try {
            log = new File("log.txt");
            fileWriter = new FileWriter(log);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String dateTime = dateFormat.format(new Date());
            String arrayToLog = Arrays.toString(mas);
//            printArray(mas);
//            fileWriter.write(dateTime + " " + arrayToLog + "\n");
            int temp = 0;
            boolean swapped = false;
            for (int i = 0; i < mas.length; i++) {
                for (int j = 0; j < mas.length - 1; j++) {
                    if (mas[j] > mas[j + 1]) {
                        temp = mas[j];
                        mas[j] = mas[j + 1];
                        mas[j + 1] = temp;
                    }
                }
                if (arrayToLog.equals(Arrays.toString(mas))) swapped = true;
//                printArray(mas);
                dateTime = dateFormat.format(new Date());
                arrayToLog = Arrays.toString(mas);
                fileWriter.write(dateTime + " " + arrayToLog + "\n");
                if (swapped) break;

            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println("");
    }
}