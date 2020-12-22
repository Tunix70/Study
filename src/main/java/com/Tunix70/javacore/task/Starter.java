package main.java.com.Tunix70.javacore.task;

import java.util.concurrent.Semaphore;

class Foo{
    private static final Semaphore printOne = new Semaphore(1);
    private static final Semaphore printTwo = new Semaphore(1);
    private static final Semaphore printThree = new Semaphore(1);

    public Foo() throws InterruptedException {
        printTwo.acquire();
        printThree.acquire();
    }

    public void printFirst() throws InterruptedException {
        printOne.acquire();
        System.out.print("first");
        printTwo.release();
    }
    public void printSecond() throws InterruptedException {
        printTwo.acquire();
        System.out.print("second");
        printThree.release();
    }
    public void printThird() throws InterruptedException {
        printThree.acquire();
        System.out.print("third");
        printOne.release();
    }

}

public class Starter {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Thread1()).start();
        new Thread(new Thread2()).start();
        new Thread(new Thread3()).start();
    }
}
class Thread1 implements Runnable{

         @Override
         public void run() {
             try {
                 new Foo().printFirst();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
}
class Thread2 implements Runnable{

         @Override
         public void run() {
             try {
                 new Foo().printSecond();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
}
class Thread3 implements Runnable{

        @Override
        public void run() {
            try {
                new Foo().printThird();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}


