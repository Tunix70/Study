package src.main.java.com.Tunix70.javacore.chapter15;

interface  MyFunc6<T>{
    MyClass2<T> func(T n);
}

class MyClass2<T>{
    private T val;

    MyClass2(T v) {val = v;}

    MyClass2() {val = null;}

    T getVal() {return val;}
}

public class ConstructorRefDemo2 {
    public static void main(String[] args) {
        MyFunc6<Integer> myClassCons = MyClass2<Integer>::new;

        MyClass2 mc = myClassCons.func(100);
        System.out.println("Значение val в объекте mc равно " + mc.getVal());

    }
}
