package main.java.com.Tunix70.javacore.chapter08;

class A1{
    int i;
    private int j;

    void setij(int x, int y){
        i = x;
        j = y;
    }
}

class B1 extends A1{
    int total;

    void sum(){
//        total = i + j; ОШИБКА
    }
}

public class Access {
    public static void main(String[] args) {
        B1 supOb = new B1();

        supOb.setij(10, 12);

        supOb.sum();
        System.out.println("Сумма равна " + supOb.total);
    }
}
