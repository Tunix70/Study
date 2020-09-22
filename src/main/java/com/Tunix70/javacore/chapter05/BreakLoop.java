package main.java.com.Tunix70.javacore.chapter05;

public class BreakLoop {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            if(i == 10) break;

            System.out.println("i: " + i);
        }
        System.out.println("Цикл завершен.");
    }
}
