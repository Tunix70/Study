package main.java.com.Tunix70.javacore.chapter18;

import java.util.LinkedList;

class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();

        ll.add("F");
        ll.add("B");
        ll.add("D");
        ll.add("E");
        ll.add("C");
        ll.addLast("Z");
        ll.addFirst("A");
        ll.add(1, "A2");

        System.out.println("Исходное содержимое связного списка ll: " + ll);

        ll.remove("F");
        ll.remove(2);
        System.out.println("Содержимое списка ll " +
                        "после удаления элементов: " + ll);

        ll.removeFirst();
        ll.removeLast();
        System.out.println("Содержимое списка ll " +
                "после удаления первого и последнего элементов: " + ll);

        String val = ll.get(2);
        ll.set(2, val + " изменено");

        System.out.println("Содержимое связного списка после изменения ll: " + ll);
    }
}
