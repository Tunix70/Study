package main.java.com.Tunix70.javacore.chapter29;

import java.util.ArrayList;
import java.util.stream.Stream;

class NamePhoneEmail {
    String name;
    String phonenum;
    String email;

    NamePhoneEmail(String n, String p, String e){
        name = n;
        phonenum = p;
        email = e;
    }
}

class NamePhone {
    String name;
    String phonenum;
    NamePhone (String n, String p){
        name = n;
        phonenum = p;
    }
}

class StreamDemo5 {
    public static void main(String[] args) {
        //список имен, номеров телефонов и адресов электронной почты
        ArrayList<NamePhoneEmail> myList = new ArrayList<>();
        myList.add(new NamePhoneEmail("Ларри", "555-5555", "larry@ya.ru"));
        myList.add(new NamePhoneEmail("Джеймс", "555-4444", "james@ya.ru"));
        myList.add(new NamePhoneEmail("Мэри", "555-3333", "mary@ya.ru"));

        System.out.println("Исходные элементы из списка myList: ");
        myList.stream().forEach((a) -> {
            System.out.println(a.name + " " + a.phonenum + " " + a.email);
        });
        System.out.println();

        //отобразить на новый поток данных
        //только имена и номера телефонов
        Stream<NamePhone> nameAndPhone = myList.stream().map(a -> new NamePhone(a.name, a.phonenum));
        System.out.println("Список имен и номеров телефонов: ");
        nameAndPhone.forEach(a -> {
            System.out.println(a.name + " " + a.phonenum);
        });
    }
}
