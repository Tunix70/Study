package main.java.com.Tunix70.javacore.chapter18;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class HashMapDemo {
    public static void main(String[] args) {
        //создать хеш-отображение
        HashMap<String, Double> hm = new HashMap<>();

        //ввести элементы в хеш-отображение
        hm.put("Джон Доу", new Double(3434.34));
        hm.put("Том Смит", new Double(123.22));
        hm.put("Джейн Бейкер", new Double(1378.00));
        hm.put("Тод Холл", new Double(99.22));
        hm.put("Ральф Сит", new Double(-19.08));

        //получить множество записей
        Set<Map.Entry<String, Double>> set = hm.entrySet();

        //вывести множество записей
        for(Map.Entry<String, Double> me: set){
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
        System.out.println();

        //внести сумму 1000 на счет Джона Доу
        double balance = hm.get("Джон Доу");
        hm.put("Джон Доу", balance + 1000);
        System.out.println("Новый остаток на счете Джона Доу: " + hm.get("Джон Доу"));

    }
}
