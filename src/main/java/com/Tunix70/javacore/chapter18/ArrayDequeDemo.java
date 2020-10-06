package main.java.com.Tunix70.javacore.chapter18;

import java.util.ArrayDeque;

class ArrayDequeDemo {
    public static void main(String[] args) {
        ArrayDeque<String> adq = new ArrayDeque<>();

        adq.push("A");
        adq.push("B");
        adq.push("D");
        adq.push("E");
        adq.push("F");

        System.out.print("Извлечение из стека: " );

        while(adq.peek() != null)
            System.out.print(adq.pop() + " ");
        System.out.println();
    }
}
