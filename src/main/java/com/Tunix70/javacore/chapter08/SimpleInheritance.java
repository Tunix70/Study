package chapter08;

class A{
    int i, j;

    void showij(){
        System.out.println("i и j: " + i + " " + j);
    }
}
class B extends A{
    int k;
    void showk(){
        System.out.println("k: " + k);
    }
    void sum(){
        System.out.println("i+j+k: " + (i+j+k));
    }
}
public class SimpleInheritance {
    public static void main(String[] args) {
        A superOb = new A();
        B supOb = new B();

        superOb.i = 10;
        superOb.j = 20;
        System.out.println("Содержимое объекта superOb: ");
        superOb.showij();
        System.out.println();

        supOb.i = 7;
        supOb.j = 8;
        supOb.k = 9;
        System.out.println("Содержимое объекта supOb: ");
        supOb.showij();
        supOb.showk();

        System.out.println();
        System.out.println("Сумма i, j, k в Объекте subOb:");
        supOb.sum();

    }
}
