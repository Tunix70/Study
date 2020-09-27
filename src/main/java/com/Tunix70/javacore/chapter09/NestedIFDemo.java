package main.java.com.Tunix70.javacore.chapter09;

class A{
    public interface NestedIF{
        boolean isNotVegative(int x);
    }
}
class B implements A.NestedIF{

    @Override
    public boolean isNotVegative(int x) {
        return x < 0 ? false : true;
    }
}
class NestedIFDemo {
    public static void main(String[] args) {
        A.NestedIF nif = new B();
        if(nif.isNotVegative(10))
            System.out.println("Число 10 неотрицательное");
        if(nif.isNotVegative(-12))
            System.out.println("Это не будет выведено");
    }
}
