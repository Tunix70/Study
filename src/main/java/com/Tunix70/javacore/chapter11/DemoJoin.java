package main.java.com.Tunix70.javacore.chapter11;

class NewThread3 implements Runnable{
    String name; //имя потока исполнения
    Thread t;

    NewThread3(String threadname){
        name = threadname;
        t = new Thread(this, name);
        System.out.println("Новый поток: " + t);
        t.start(); //запустить поток на исполнение
    }

    //точка входа потока исполения
    public void run(){
        try{
            for (int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println(name + " прерван");
        }
        System.out.println(name + " завершен");
    }
}
public class DemoJoin {
    public static void main(String[] args) {
        NewThread3 ob1 = new NewThread3("One");
        NewThread3 ob2 = new NewThread3("Two");
        NewThread3 ob3 = new NewThread3("Three");

        System.out.println("Поток One запущен: " + ob1.t.isAlive());
        System.out.println("Поток Two запущен: " + ob2.t.isAlive());
        System.out.println("Поток Three запущен: " + ob3.t.isAlive());

        //ожидать завершения потоков исполения
        try{
            System.out.println("Ожидание завершения потоков.");
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        }catch (InterruptedException e){
            System.out.println("Главный поток прерван");
        }
        System.out.println("Поток One запущен: " + ob1.t.isAlive());
        System.out.println("Поток Two запущен: " + ob2.t.isAlive());
        System.out.println("Поток Three запущен: " + ob3.t.isAlive());

        System.out.println("Главный поток завершен");
    }
}
