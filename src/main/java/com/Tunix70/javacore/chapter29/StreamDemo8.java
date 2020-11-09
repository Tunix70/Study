package main.java.com.Tunix70.javacore.chapter29;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

class StreamDemo8 {
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

        //получить итмератор для потока данных
        Iterator<String> itr = myStream.iterator();

        //перебрать элементы в потоке данных
        while(itr.hasNext())
            System.out.println(itr.next());
    }
}
