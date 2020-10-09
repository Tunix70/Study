package main.java.com.Tunix70.javacore.chapter18;

import java.util.TreeSet;

class CompDemo2 {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>(
                                (aStr, bStr) -> bStr.compareTo(aStr));

        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("D");

        //вывести элемены из древовидного множества
        for(String element : ts)
            System.out.print(element + " ");
        System.out.println();
    }
}
