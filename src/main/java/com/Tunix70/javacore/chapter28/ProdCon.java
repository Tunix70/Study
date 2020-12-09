package main.java.com.Tunix70.javacore.chapter28;

import java.util.concurrent.Semaphore;
import java.util.function.Consumer;

// реализация поставщика и потребителя, использующая семафоры для управления синхронизацией
class Q{
    int n;

    //начать с недоступного семафора потребителя
    static Semaphore semCon = new Semaphore(0);
    static Semaphore semProd = new Semaphore(1);

    void get(){
        try{
            semCon.acquire();
        }catch (InterruptedException e){
            System.out.println("Перехвачено исключение типа InterruptedException");
        }
        System.out.println("Получено: " + n);
        semProd.release();
    }
    void put(int n){
        try{
            semProd.acquire();
        }catch (InterruptedException e){
            System.out.println("Перехвачено исключение типа InterruptedException");
        }
        this.n = n;
        System.out.println("Отправлено: " + n);
        semCon.release();
    }
}

class Producer implements Runnable{
    Q q;
    Producer(Q q){
        this.q = q;
        new Thread(this, "Producer").start();
    }
    public void run(){
        for (int i = 0; i < 20; i++) q.put(i);
    }
}

class Consumer1 implements Runnable{
    Q q;
    Consumer1(Q q){
        this.q = q;
        new Thread(this, "Consumer").start();
    }
    public void run(){
        for (int i = 0; i < 20; i++) q.get();
    }
}

public class ProdCon {
    public static void main(String[] args) {

        Q q = new Q();
        new Consumer1(q);
        new Producer(q);
    }
}
