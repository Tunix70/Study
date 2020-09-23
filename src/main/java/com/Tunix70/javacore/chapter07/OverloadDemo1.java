package main.java.com.Tunix70.javacore.chapter07;

public class OverloadDemo1 {
    void test(){
        System.out.println("Параметры отсутствуют.");
    }

    void test(int a, int b){
        System.out.println("a и b: " + a + " " + b);
    }
    void test(double a){
        System.out.println("Внутреннее преобразование при вызове test(double) a: " + a);
    }
}

class Overload1{
    public static void main(String[] args) {
        OverloadDemo1 ob = new OverloadDemo1();
        int i = 88;

        ob.test();
        ob.test(10, 20);

        ob.test(i);
        ob.test(123.2);
    }
}
