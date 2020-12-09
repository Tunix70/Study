package main.java.com.Tunix70.javacore.chapter28;

import java.util.concurrent.CountDownLatch;

public class CDLDemo {
    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(5);

        System.out.println("Запуск потока исполнения");

        new MyThread(cdl);

        try{
            cdl.await();
        }catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.println("Завершение потока исполнения");
    }
}
class MyThread implements Runnable{
    CountDownLatch latch;

    MyThread(CountDownLatch c){
        latch = c;
        new Thread(this). start();
    }
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            latch.countDown(); //обратный отсчет
        }
    }
}
