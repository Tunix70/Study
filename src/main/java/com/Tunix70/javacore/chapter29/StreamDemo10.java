package main.java.com.Tunix70.javacore.chapter29;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

class StreamDemo10 {
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

        //а теперь разделить первый итератор
        Spliterator<String> splitItr2 = splitItr.trySplit();

        //использовать сначала итератор splitItr2, если нельзя разделить
        //итератор splitItr
        if(splitItr2 != null){
            System.out.println("Результат выводимый иметарором splitItr2: ");
            splitItr2.forEachRemaining((n) -> System.out.println(n));
        }
        //а вот теперь воспользоваться итератором splitItr
        System.out.println("\nРезультат, выводимый итератором spliter: ");
            splitItr.forEachRemaining((n) -> System.out.println(n));
    }
}
