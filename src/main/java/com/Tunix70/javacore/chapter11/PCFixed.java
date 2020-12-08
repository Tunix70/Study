package main.java.com.Tunix70.javacore.chapter11;

//правильная реализация поставщика и потребителя
class Q1 {
    int n;
    boolean valueSet = false;

    synchronized int get(){
        while(!valueSet)
            try{
                wait();
            }catch (InterruptedException e){
                System.out.println("Исключение типа InterruptedException перехвачено");
            }
        System.out.println("Получено: " + n);
            valueSet = false;
            notify();
        return n;
    }

    synchronized void put(int n) {
        while(valueSet)
            try{
                wait();
            }catch (InterruptedException e){
                System.out.println("Исключение типа InterruptedException перехвачено");
            }
        this.n = n;
            valueSet = true;
        System.out.println("Отправлено: " + n);
        notify();
    }
}
class Producer1 implements Runnable{
    Q1 q;
    Producer1(Q1 q){
        this.q = q;
        new Thread(this, "Поставщик").start();
    }
    public void run(){
        int i = 0;
        while (true) {
            q.put(i++);
        }
    }
}
class Consumer1 implements Runnable{
    Q1 q;

    Consumer1(Q1 q){
        this.q = q;
        new Thread(this, "Потребитель").start();
    }
    public void run(){
        while(true){
            q.get();
        }
    }
}

public class PCFixed {
    public static void main(String[] args) {
        Q1 q = new Q1();
        new Producer1(q);
        new Consumer1(q);

        System.out.println("Для остановки нажмите Ctrl-C");

    }
}