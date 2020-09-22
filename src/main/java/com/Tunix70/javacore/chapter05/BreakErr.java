package main.java.com.Tunix70.javacore.chapter05;

public class BreakErr {
    public static void main(String[] args) {
        one:
        for (int i = 0; i < 3; i++) {
            System.out.println("Проход " + i + ":");

        }
//        for (int i = 0; i < 100; i++) {
//            if(j == 10) break one; // "one" не содержит break;
//            System.out.println(j + " ");
//
//        }
    }
}
