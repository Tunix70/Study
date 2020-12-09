package main.java.com.Tunix70.javacore.chapter11;

class Callme1{
    void call1(String msg){
        System.out.print("[" + msg);
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("Прервано");
        }
        System.out.println("]");
    }
}
class Caller1 implements Runnable {
    String msg;
    Callme1 target;
    Thread t;

    public Caller1(Callme1 targ, String s) {
        target = targ;
        msg = s;
        t = new Thread(this);
        t.start();
    }

    //синхронизированные вызовы метода call1()
    public void run() {
        synchronized (target) {//синхронизированный блок
            target.call1(msg);
        }
    }
}

public class Synch1 {
    public static void main(String[] args) {
        Callme1 target = new Callme1();
        Caller1 ob1 = new Caller1(target, "Добро пожаловать");
        Caller1 ob2 = new Caller1(target, "в синхронизированный");
        Caller1 ob3 = new Caller1(target, "мир!");

        //ожидать завершения потока исполения
        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Прервано");
        }
    }
}


