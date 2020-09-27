package main.java.com.Tunix70.javacore.chapter08;

class A4{
    A4(){
        System.out.println("B конструкторe A4.");
    }
}
class B4 extends A4{
    B4(){
        System.out.println("B конструкторе В4.");
    }
}

class C4 extends B4{
    C4(){
        System.out.println("B конструкторе C4.");
    }
}

public class CallingCons {
    public static void main(String[] args) {
        C4 c = new C4();
    }
}
