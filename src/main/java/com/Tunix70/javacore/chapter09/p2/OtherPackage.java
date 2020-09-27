package main.java.com.Tunix70.javacore.chapter09.p2;

import  main.java.com.Tunix70.javacore.chapter09.p1.Protection;

class OtherPackage {
    OtherPackage(){
        Protection p = new Protection();
        System.out.println("Конструктор из другого пакета");
//        System.out.println("n = " + n);
//        System.out.println("n_pri = " + p.n_pri);
//        System.out.println("n_pro = " + n_pro);
        System.out.println("n_pub = " + p.n_pub);
    }
}
