package main.java.com.Tunix70.javacore.chapter18;

import java.util.TreeSet;

class ThreeSetDemo {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>();
        ts.add("C");
        ts.add("A");
        ts.add("Gha");
        ts.add("B");
        ts.add("E");
        ts.add("1");
        ts.add("F");
        ts.add("D");

        System.out.println(ts);
    }
}
