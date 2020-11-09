package main.java.com.Tunix70.javacore.chapter29;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class NamePhoneEmail1 {
    String name;
    String phonenum;
    String email;

    NamePhoneEmail1(String n, String p, String e){
        name = n;
        phonenum = p;
        email = e;
    }
}

class NamePhone1 {
    String name;
    String phonenum;
    NamePhone1 (String n, String p){
        name = n;
        phonenum = p;
    }
}
class StreamDemo7 {
    public static void main(String[] args) {
        ArrayList<NamePhoneEmail1> myList = new ArrayList<>();
        myList.add(new NamePhoneEmail1("Ларри", "555-5555", "larry@ya.ru"));
        myList.add(new NamePhoneEmail1("Джеймс", "555-4444", "james@ya.ru"));
        myList.add(new NamePhoneEmail1("Мэри", "555-3333", "mary@ya.ru"));

        //отоборазить только имена и номера телефонов на новый поток данных
        Stream<NamePhone1> nameAndPhone = myList.stream().map((a) -> new NamePhone1(a.name, a.phonenum));

        //вызвать метод collect(), чтобы составить список типа List из имен и номеров телефонов
        List<NamePhone1> npList = nameAndPhone.collect(Collectors.toList());

        System.out.println("Имена и номера телефонов в списке типа List: ");
        for(NamePhone1 e : npList)
            System.out.println(e.name + " " + e.phonenum);

        //получить другое отображение имен и номеров телефонов
        nameAndPhone = myList.stream().map((a) -> new NamePhone1(a.name, a.phonenum));

        //а теперь создать множество типа Set, вызвав метод collect()
        Set<NamePhone1> npSet = nameAndPhone.collect(Collectors.toSet());

        System.out.println("Имена и номера телефонов в списке типа Set: ");
        for(NamePhone1 e : npSet)
            System.out.println(e.name + ": " + e.phonenum);
    }
}
