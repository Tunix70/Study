package main.java.com.Tunix70.javacore.chapter18;

import java.util.Comparator;
import java.util.TreeSet;

//class MyComp implements Comparator<String>{ //1
////    public int compare(String a, String b){
////        String aStr, bStr;
////        aStr = a;
////        bStr = b;
////        //выполнить сравнение в обратном порядке
////        return bStr.compareTo(aStr);
////    }
////    //переопределеять метод equals() не требуется
////}

class MyComp implements Comparator<String>{ //2
    public int compare(String a, String b){
        String aStr, bStr;
        aStr = a;
        bStr = b;
        return aStr.compareTo(bStr);
        }
}

class CompDemo {
    public static void main(String[] args) {
        MyComp mc = new MyComp(); //2
        //передать вариант компаратора типа MyComp с обратным упорядочением древовидному множеству типа TreeSet
        TreeSet<String> ts = new TreeSet<>(mc.reversed());
//        TreeSet<String> ts = new TreeSet<>(new MyComp());  //1
        //вывести элемены в древовидное множество
        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("D");

        //вывести элемены из древовидного множества
        for(String element : ts)
            System.out.print(element + " ");
        System.out.println();
    }
}
