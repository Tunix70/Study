package main.java.com.Tunix70.javacore.chapter29;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

public class StreamDemo9 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Альфа");
        myList.add("Бета");
        myList.add("Гамма");
        myList.add("Дельта");
        myList.add("Кси");
        myList.add("Омега");

        //получить поток данных для списочного массива
        Stream<String> myStream = myList.stream();

        //получить итератор-разделитель
        Spliterator<String> splitItr = myStream.spliterator();

        //перебрать элементы в потоке данных
        while (splitItr.tryAdvance((n) -> System.out.println(n)));
    }
}
