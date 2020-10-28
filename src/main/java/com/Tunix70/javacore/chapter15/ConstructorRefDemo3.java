package src.main.java.com.Tunix70.javacore.chapter15;

interface  MyFunc7<R, T>{
    R func(T n);
}

class MyClass5<T>{
    private T val;

    MyClass5(T v) {val = v;}

    MyClass5() {val = null;}

    T getVal() {return val; }
}

class MyClass6{
    String str;

    MyClass6(String s){str = s;}

    MyClass6() {str = "";}

    String getVal() {return str;}
}

public class ConstructorRefDemo3 {
    static <R, T> R myClassFactory(MyFunc7<R, T> cons, T v){
        return cons.func(v);
    }

    public static void main(String[] args) {
        MyFunc7<MyClass5<Double>, Double> mYclassCons = MyClass5<Double> :: new;
        MyClass5<Double> mc = myClassFactory(mYclassCons, 100.1);
        System.out.println("Значение val в объекте mc равно " + mc.getVal());

        MyFunc7<MyClass6, String> mYclassCons2 = MyClass6 :: new;
        MyClass6 mc2 = myClassFactory(mYclassCons2, "Лямбда");
        System.out.println("Значение val в объекте mc равно " + mc.getVal());

    }
}
