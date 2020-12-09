package main.java.com.Tunix70.javacore.chapter28;

import java.util.concurrent.*;

public class PhaserDemo {
    public static void main(String[] args) {
        Phaser phsr = new Phaser(1);
        int curPhase;

        System.out.println("Запуск потоков");

        new MyThread2(phsr, "A");
        new MyThread2(phsr, "B");
        new MyThread2(phsr, "C");

        //ожидать завершения всеми потоками исполнения первой фазы
        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Фаза " + curPhase + " завершена");

        //ожидать завершения всеми потоками исполнения второй фазы
        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Фаза " + curPhase + " завершена");

        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Фаза " + curPhase + " завершена");

        //снять основной поток исполнения с регистрации
        phsr.arriveAndDeregister();

        if(phsr.isTerminated())
            System.out.println("Синхронизатор фаз завершен");
    }
}
//поток исполнения, использующий синхронизатор фаз типа Phaser
class MyThread2 implements Runnable{
    Phaser phsr;
    String name;

    MyThread2(Phaser p, String n){
        phsr = p;
        name = n;
        phsr.register();
        new Thread(this).start();
    }
    public void run(){
        System.out.println("Поток " + name + " начинает первую фазу");
        phsr.arriveAndAwaitAdvance(); //известить о достижении фазы

        /* небольшая пауза, чтобы не нарушить порядок вывода.
        Только для иллюстрации, но необязательно джля правильного
        функционирования синхронизаора фаз
         */
        try{
            Thread.sleep(10);
        }catch (InterruptedException e){
            System.out.println(e);
        }

        System.out.println("Поток " + name + " начинает вторую фазу");
        phsr.arriveAndAwaitAdvance(); //известить о достижении фазы

        /* небольшая пауза, чтобы не нарушить порядок вывода.
        Только для иллюстрации, но необязательно джля правильного
        функционирования синхронизаора фаз
         */
        try{
            Thread.sleep(10);
        }catch (InterruptedException e){
            System.out.println(e);
        }

        System.out.println("Поток " + name + " начинает третью фазу");
        phsr.arriveAndDeregister(); //известить о достижении фазы и
                                    //снять потоки с регистрации
    }
}