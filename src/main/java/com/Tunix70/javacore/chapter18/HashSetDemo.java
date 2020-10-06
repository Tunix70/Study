package main.java.com.Tunix70.javacore.chapter18;

import java.util.HashSet;

class HashSetDemo {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();

        hs.add("Бета");
        hs.add("Альфа");
        hs.add("Эта");
        hs.add("Гамма");
        hs.add("Эпсилон");
        hs.add("ОМега");

        System.out.println(hs);
    }
}
