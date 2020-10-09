package main.java.com.Tunix70.javacore.chapter18;

import java.util.*;

class TComp implements Comparator<String>{
    @Override
    public int compare(String aStr, String bStr) {
        int i, j, k;

        //найти индекс, с которого начинается фамилия
        i = aStr.lastIndexOf(' ');
        j = bStr.lastIndexOf(' ');
        k = aStr.substring(i).compareTo(bStr.substring(j));
        if(k == 0)//фамилии совпадают, проверить имя и фамилию полностью
            return aStr.compareTo(bStr);
        else
            return k;
    }
    //переопределять метод equals() не требуется
}
class TreeMapDemo2 {
    public static void main(String[] args) {

        TreeMap<String, Double> tm = new TreeMap<>(new TComp());
        //вести элементы в древовидное отображение
        tm.put("Джон Доу", new Double(3434.34));
        tm.put("Том Смит", new Double(123.22));
        tm.put("Джейн Бейкер", new Double(1378.00));
        tm.put("Тод Холл", new Double(99.22));
        tm.put("Ральф Смит", new Double(-19.08));

        Set<Map.Entry<String, Double>> set = tm.entrySet();

        for (Map.Entry<String, Double> me : set) {
            System.out.print(me.getKey() + " ");
            System.out.println(me.getValue());
        }
        //внести сумму 1000 на счет Джона Доу
        double balance = tm.get("Джон Доу");
        tm.put("Джон Доу", balance + 1000);
        System.out.println("Новый остаток на счете Джона Доу: " + tm.get("Джон Доу"));

    }
}
