package main.java.com.Tunix70.javacore.chapter11;

//создать несколько потоков исполнения
class NewThread2 implements Runnable{
    String name; //имя потока исполнения
    Thread t;

    NewThread2(String threadname){
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

public class MultiThreadDemo {
    public static void main(String[] args) {
        new NewThread2("Один"); //запустить потоки на исполение
        new NewThread2("Два");
        new NewThread2("Три");

            try{
                //ожидать завершения других потоков исполения
                    Thread.sleep(10000);
            }catch (InterruptedException e){
                System.out.println("Главный поток прерван");
            }
            System.out.println("Главный поток завершен");
    }
}
