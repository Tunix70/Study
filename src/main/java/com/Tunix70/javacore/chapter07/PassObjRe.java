package main.java.com.Tunix70.javacore.chapter07;

class Test2{
    int a, b;

    Test2(int i, int j){
        a= i;
        b = j;
    }
    void meth(Test2 o){
        o.a *= 2;
        o.b /= 2;
    }
}
public class PassObjRe {
    public static void main(String[] args) {
        Test2 ob = new Test2(15, 20);
        System.out.println("ob.a и ob.b до вызова: " + ob.a + " " + ob.b);

        ob.meth(ob);
        System.out.println("ob.a и ob.b после вызова: " + ob.a + " " + ob.b);
    }
}
