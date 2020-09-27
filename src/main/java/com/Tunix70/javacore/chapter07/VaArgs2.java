package main.java.com.Tunix70.javacore.chapter07;

class VarArgs2 {
    static void vaTest(String msg, int ... v) {
        System.out.print(msg + v.length + " Содержимое: ");

        for (int x : v)
            System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        vaTest("Один параментр переменной длины", 10);
        vaTest("Три параментра переменной длины",1, 2, 3);
        vaTest("Без параментров переменной длины");
    }
}
