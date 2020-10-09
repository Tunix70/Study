package main.java.com.Tunix70.javacore.chapter18;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class CompLastNames implements Comparator<String>{
    @Override
    public int compare(String aStr, String bStr) {
        int i, j;

        //найти индекс, с которого начинается фамилия
        i = aStr.lastIndexOf(' ');
        j = bStr.lastIndexOf(' ');

        return aStr.substring(i).compareToIgnoreCase(bStr.substring(j));
    }
}
//отсортировать счета вкладчиков по ФИО, если фамилии одинаковы
class CompThenByFirstName implements Comparator<String>{
    @Override
    public int compare(String aStr, String bStr) {
        int i, k;
        return aStr.compareToIgnoreCase(bStr);
    }
}
class TreeMapDemo2A {
    public static void main(String[] args) {
//использовать метод theComparing() для создания компаратора, сравнивающего сначала фамилии,
        //а затем ФИО владчиков, если фамилии ==
        CompLastNames compLN = new CompLastNames();
        Comparator<String> compLastThenFirst =
                compLN.thenComparing(new CompThenByFirstName());
        TreeMap<String, Double> tm = new TreeMap<>(compLastThenFirst);
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
