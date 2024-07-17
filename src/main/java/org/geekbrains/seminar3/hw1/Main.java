//Реализовать алгоритм сортировки слиянием
//Внутри класса MergeSort напишите метод mergeSort,
//который принимает массив целых чисел, реализует алгоритм
//сортировки слиянием. Метод должен возвращать отсортированный массив.
//Пример
//a = {5, 1, 6, 2, 3, 4} -> [1, 2, 3, 4, 5, 6]

package org.geekbrains.seminar3.hw1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[]{5, 1, 6, 2, 3, 4};
        System.out.println(Arrays.toString(a));
        MergeSort answer = new MergeSort();
        String itresume_res = Arrays.toString(answer.mergeSort(a));
        System.out.println(itresume_res);
    }
}
class MergeSort {
    public static int[] mergeSort(int[] a) {
        // Напишите свое решение ниже
        if (a.length <= 1) return a;

        int middleIndex = a.length / 2;
        int[] arrayLeft = new int[middleIndex];
        int[] arrayRight = new int[a.length - middleIndex];
        for (int i = 0; i < a.length; i++) {
            if (i < middleIndex) arrayLeft[i] = a[i];
            else arrayRight[i - middleIndex] = a[i];
        }

        System.out.println("L " + Arrays.toString(arrayLeft));
        System.out.println("R " + Arrays.toString(arrayRight));

        arrayLeft = mergeSort(arrayLeft);
        arrayRight = mergeSort(arrayRight);

        int[] result = new int[a.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arrayLeft.length && j < arrayRight.length) {
            if (arrayLeft[i] < arrayRight[j]) {
                result[k] = arrayLeft[i];
                i++;
            }
            else {
                result[k] = arrayRight[j];
                j++;
            }
            k++;
        }
        while (i < arrayLeft.length) {
            result[k] = arrayLeft[i];
            i++;
            k++;
        }
        while (j < arrayRight.length) {
            result[k] = arrayRight[j];
            j++;
            k++;
        }

        System.out.println(Arrays.toString(result));

        return result;
    }
}

