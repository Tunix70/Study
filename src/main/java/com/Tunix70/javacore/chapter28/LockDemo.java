package main.java.com.Tunix70.javacore.chapter28;

import java.util.concurrent.locks.ReentrantLock;

class LockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        new LockThread(lock, "A");
        new LockThread(lock, "B");
    }
}
//общий ресурс
class Shared1{
    static int count = 0;
}
//поток исполнения, инкрементирующий значение счетчика
class LockThread implements Runnable{
    String name;
    ReentrantLock lock;
    LockThread(ReentrantLock lk, String n){
        lock = lk;
        name = n;
        new Thread(this).start();
    }
    public void run(){
        System.out.println("Запуск потока " + name);

        try{
            //сначала заблокировать счетчик
            System.out.println("Поток " + name + " ожидает блокировки счетчика");
            lock.lock();
            System.out.println("Поток " + name + " блокирует счетчик");
            Shared1.count++;
            System.out.println("Поток " + name + ": " + Shared1.count);
            //а теперь переключение контекста, если это возможно
            System.out.println("Поток " + name + " ожидает");
            Thread.sleep(1000);
        }catch(InterruptedException e){
            System.out.println(e);
        }finally {
            //снять блокировку
            System.out.println("Поток " + name + " разблокирует счетчик");
            lock.unlock();
        }
    }
}