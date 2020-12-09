package main.java.com.Tunix70.javacore.chapter28;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarDemo {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, new BarAction());

        System.out.println("Запуск потоков");

        new MyThread1(cb, "A");
        new MyThread1(cb, "B");
        new MyThread1(cb, "C");
        new MyThread1(cb, "X");
        new MyThread1(cb, "Y");
        new MyThread1(cb, "X");
    }
}
//поток исполнения, использующий барьер типа CyclicBarrier

class MyThread1 implements Runnable{
    CyclicBarrier cbar;
    String name;

    MyThread1(CyclicBarrier c, String n){
        cbar = c;

        name = n;
        new Thread(this).start();
    }

    public void run(){
        System.out.println(name);

        try{
            cbar.await();
        }catch (BrokenBarrierException e){
            System.out.println(e);
        }catch (InterruptedException e){
            System.out.println(e);
        }
    }
}
class BarAction implements Runnable{
    public void run(){
        System.out.println("Барьер достигнут!");
    }
}
