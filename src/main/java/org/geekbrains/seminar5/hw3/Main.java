//Необходимо разработать программу для сортировки массива целых чисел с использованием сортировки кучей (Heap Sort). Программа должна работать следующим образом:
//Принимать на вход массив целых чисел для сортировки. Если массив не предоставлен, программа использует массив по умолчанию.
//Сначала выводить исходный массив на экран.
//Затем применять сортировку кучей (Heap Sort) для сортировки элементов массива в порядке возрастания.
//Выводить отсортированный массив на экран.
//Ваше решение должно содержать два основных метода: buildTree, который строит сортирующее дерево на основе массива, и heapSort, который выполняет собственно сортировку кучей.
//Программа должна быть способной сортировать массив, даже если он состоит из отрицательных чисел и имеет дубликаты.
//На входе:
//        '5 8 12 3 6 9'
//На выходе:
//Initial array:
//        [5, 8, 12, 3, 6, 9]
//Sorted array:
//        [3, 5, 6, 8, 9, 12]

package org.geekbrains.seminar5.hw3;

import java.util.Arrays;

class HeapSort {
    public static void buildTree(int[] tree, int sortLength) {
        // Введите свое решение ниже
        //Построение max-кучи
        for (int i = sortLength / 2 - 1; i >= 0; i--) {
            heapify(tree, sortLength, i);
        }
    }

    public static void heapify(int[] tree, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && tree[left] > tree[largest]) {
            largest = left;
        }

        if (right < n && tree[right] > tree[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = tree[i];
            tree[i] = tree[largest];
            tree[largest] = swap;

            heapify(tree, n, largest);
        }
    }

    public static void heapSort(int[] sortArray, int sortLength) {
        // Введите свое решение ниже
        buildTree(sortArray, sortLength);

        //Извлекаем элемениты кучи один за другим
        for (int i = sortLength - 1; i > 0 ; i--) {
            //Перемещаем текущий корень в конец
            int temp = sortArray[0];
            sortArray[0] = sortArray[i];
            sortArray[i] = temp;

            //Вызываем heapify на уменьшенной куче
            heapify(sortArray, i, 0);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] initArray;

        initArray = new int[]{17, 32, 1, 4, 25, 17, 0, 3, 10, 7, 64, 1};

        System.out.println("Initial array:");
        System.out.println(Arrays.toString(initArray));
        HeapSort.heapSort(initArray, initArray.length);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(initArray));
    }
}
