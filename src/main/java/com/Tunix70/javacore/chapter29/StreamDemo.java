package main.java.com.Tunix70.javacore.chapter29;

import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

class StreamDemo {
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(7);
        myList.add(18);
        myList.add(10);
        myList.add(24);
        myList.add(17);
        myList.add(5);

        System.out.println("Исходный список: " + myList);

        //получить поток элементов списочного массива
        Stream<Integer> myStream = myList.stream();

        //получить минимальное и максимальное значение
        Optional<Integer> minVal = myStream.min(Integer :: compare);
        if(minVal.isPresent()) System.out.println("Минимальное значение: " + minVal.get());

        //непременно получить новый поток данных, поскольку предыдущий вызов метода min() стал
        //оконченной операцией, употребившей поток данных
        myStream = myList.stream();
        Optional<Integer> maxVal = myStream.max(Integer :: compare);
        if(maxVal.isPresent()) System.out.println("Максимальное значение: " + maxVal.get());

        //отсортировать поток данных
        Stream<Integer> sortedStream = myList.stream().sorted();

        //отобразить отсортированный поток данных
        System.out.print("Отсортированный потом данных: ");
        sortedStream.forEach((n) -> System.out.print(n + " "));
        System.out.println();

        //вывести только нечетные целочисленные значения
        Stream<Integer> oddVals = myList.stream().sorted().filter((n) -> (n % 2) == 1);

        //вывести только те нечетные целочисленные значения, которые больше 5. Обратите внимание на
        //конвейеризацию обеих операций фильтраций
        oddVals = myList.stream().filter((n) -> (n % 2) == 1).filter((n) -> n > 5);
        System.out.print("Нечетные значения болье 5: ");
        oddVals.forEach((n) -> System.out.print(n + " "));
        System.out.println();
    }
}
