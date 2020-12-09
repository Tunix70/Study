package main.java.com.Tunix70.javacore.chapter11;
//пример взаимной блокировки

class A{
    synchronized void foo(B b){
        String name = Thread.currentThread().getName();

        System.out.println(name + "Вошел в метод A.foo()");

        try{
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println("Класс А прерван");
        }
        System.out.println(name + " пытается вызвать метод B.last()");
        b.last();
    }

    synchronized void last(){
        System.out.println("В методе A.last()");
    }
}

class B{
    synchronized void bar(A a) {
        String name = Thread.currentThread().getName();

        System.out.println(name + "Вошел в метод B.bar()");

        try{
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println("Класс B прерван");
        }
        System.out.println(name + " пытается вызвать метод A.last()");
        a.last();
    }

    synchronized void last(){
        System.out.println("В методе B.last()");
    }
}
public class Deadlock implements Runnable {
    A a = new A();
    B b = new B();

    Deadlock(){
        Thread.currentThread().setName("Главный поток");
        Thread t = new Thread(this, "Соперничающий поток");
        t.start();

        a.foo(b); //получить блокировку для объекта a в этом потоке исполнения
        System.out.println("Назад в главный поток");
    }
    public void run(){
        b.bar(a); //получить блокировку для объекта b в этом потоке исполнения
        System.out.println("Назад в другой поток");
    }

    public static void main(String[] args) {
        new Deadlock();
    }
}
