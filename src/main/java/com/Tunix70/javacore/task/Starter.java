package main.java.com.Tunix70.javacore.task;

import java.util.concurrent.Semaphore;

class Foo{
    public void printFirst(){
        System.out.print("first");
    }
    public void printSecond(){
        System.out.print("second");
    }
    public void printThird(){
        System.out.print("third");
    }
}

interface Subtask {
    void run() throws InterruptedException;
}

public class Starter {
    private final Semaphore printOne = new Semaphore(1);
    private final Semaphore printTwo = new Semaphore(1);
    private final Semaphore printThree = new Semaphore(1);

    public Starter() throws InterruptedException {
        printTwo.acquire();
        printThree.acquire();
    }

    public void printFirst() throws InterruptedException {
        printOne.acquire();
        try {
            new Foo().printFirst();
        } finally {
            printTwo.release();
        }
    }

    public void printSecond() throws InterruptedException {
        printTwo.acquire();
        try {
            new Foo().printSecond();
        } finally {
            printThree.release();
        }
    }

    public void printThird() throws InterruptedException {
        printThree.acquire();
        try {
            new Foo().printThird();
        } finally {
            printOne.release();
        }
    }

    static void thread(Subtask s){
        new Thread(() -> {
            try {
                s.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    public static void main(String[] args) throws InterruptedException {
        Starter starter = new Starter();

        thread(starter :: printThird);
        thread(starter :: printFirst);
        thread(starter :: printSecond);

    }
}
