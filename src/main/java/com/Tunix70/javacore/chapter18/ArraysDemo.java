package main.java.com.Tunix70.javacore.chapter18;

import java.lang.reflect.Array;
import java.util.*;

class ArraysDemo {
    public static void main(String[] args) {
        int array[] = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = -3 * i;
        }

        //вывести, отсортировать и снова вывести сожержимое массива
        System.out.print("Исходный массив: ");
        display(array);
        Arrays.sort(array);
        System.out.print("Отсортированный массив: ");
        display(array);

        //заполнить массив и вывести его содрежимое
        Arrays.fill(array, 2, 6, -1);
        System.out.print("Массив после вызова метода fill(): ");
        display(array);

        //отсортировать массив и вывести содержимое массива
        Arrays.sort(array);
        System.out.print("Массив после повторной сортировки: ");
        display(array);

        //выполнить двоичный поиск значение -9
        System.out.print("Значение -9 находится на позиции: ");
        int index = Arrays.binarySearch(array, -9);
        System.out.println(index);
    }
    static void display(int array[]){
        for(int i: array)
            System.out.print(i + " ");
        System.out.println();
    }
}
