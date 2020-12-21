package main.java.com.Tunix70.javacore.chapter28;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpExec {
    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(5);
        CountDownLatch cdl2 = new CountDownLatch(5);
        CountDownLatch cdl3 = new CountDownLatch(5);
        CountDownLatch cdl4 = new CountDownLatch(5);
        ExecutorService es = Executors.newFixedThreadPool(2);

        System.out.println("Запуск потоков");

        //запустить потоки исполнения
        es.execute(new MyThread6(cdl, "A"));
        es.execute(new MyThread6(cdl2, "B"));
        es.execute(new MyThread6(cdl3, "C"));
        es.execute(new MyThread6(cdl4, "D"));

        try{
            cdl.await();
            cdl2.await();
            cdl3.await();
            cdl4.await();
        }catch (InterruptedException e){
            System.out.println(e);
        }
        es.shutdown();
        System.out.println("Завершение потоков");
    }
}
class MyThread6 implements Runnable{
    String name;
    CountDownLatch latch;

    MyThread6(CountDownLatch c, String n){
        latch = c;
        name = n;

        new Thread(this);
    }
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println(name + ": " + i);
            latch.countDown();
        }
    }
}