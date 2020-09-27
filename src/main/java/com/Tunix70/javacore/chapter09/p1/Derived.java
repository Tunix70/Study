package main.java.com.Tunix70.javacore.chapter09.p1;

class Derived extends Protection {
    Derived(){
        System.out.println("Конструктор подласса");
        System.out.println("n = " + n);

//        System.out.println("n_pri = " + n_pri);
        System.out.println("n_pro = " + n_pro);
        System.out.println("n_pub = " + n_pub);
    }
}
