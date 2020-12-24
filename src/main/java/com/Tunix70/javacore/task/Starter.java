package main.java.com.Tunix70.javacore.task;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Semaphore;

class Foo{
    private final Semaphore printOne = new Semaphore(1);
    private final Semaphore printTwo = new Semaphore(1);
    private final Semaphore printThree = new Semaphore(1);

    public Foo() {
        try {
            printTwo.acquire();
            printThree.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
        Foo foo = new Foo();
        new Thread(new Thread2(foo)).start();
        new Thread(new Thread3(foo)).start();
        new Thread(new Thread1(foo)).start();
//        CompletableFuture.runAsync
    }
}
class Thread1 implements Runnable{
        private Foo foo;
        public Thread1(Foo foo){
            this.foo = foo;
        }
         @Override
         public void run() {
             try {
                 foo.printFirst();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
        }
}
class Thread2 implements Runnable{
        private Foo foo;
        public Thread2(Foo foo){
            this.foo = foo;
        }
         @Override
         public void run() {
             try {
                 foo.printSecond();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
}
class Thread3 implements Runnable{
        private Foo foo;
        public Thread3(Foo foo){
            this.foo = foo;
        }
        @Override
        public void run() {
            try {
                foo.printThird();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}


