package main.java.com.Tunix70.javacore.task;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Semaphore;

class FizzBuzz {
    int n;

    private final Semaphore semFizz;
    private final Semaphore semBuzz;
    private final Semaphore semFizzBuzz;
    private final Semaphore semNumber;

    public FizzBuzz(int n) throws InterruptedException {
        this.n = n;

        semFizz = new Semaphore(0);
        semBuzz = new Semaphore(0);
        semFizzBuzz = new Semaphore(0);
        semNumber = new Semaphore(1);
    }

//        public void fizz() throws InterruptedException {
//            for (int i = 3; i <= n; i += 3) {
//                semFizz.acquire();
//                System.out.print("Fizz ");
//                semNumber.release();
//            }
//        }
//
//        public void buzz () throws InterruptedException {
//            for (int i = 5; i <= n; i += 5) {
//                semBuzz.acquire();
//                System.out.print("Buzz ");
//                semNumber.release();
//            }
//        }
//
//        public void fizzbuzz () throws InterruptedException {
//            for (int i = 15; i <= n; i += 15) {
//                semFizzBuzz.acquire();
//                System.out.print("FizzBuzz ");
//                semNumber.release();
//            }
//        }

        public void number() throws InterruptedException {
                semNumber.acquire();
            for (int i = 1; i <= n; i++) {
//                if (((i % 3) == 0) && ((i % 5) == 0)){
//                    semFizzBuzz.release();
//                }
//                else if ((i % 3) == 0){
//                    semFizz.release();
//                }
//                else if ((i % 5) == 0){
//                    semBuzz.release();
//                }else
                    System.out.print(i);
//            }
        }
}

public class Numbers {
        public static void main(String[] args) throws InterruptedException {
        FizzBuzz fb = new FizzBuzz(25);
        new Thread(new Thread1(fb)).start();
//        CompletableFuture.runAsync(() -> {
//            try {
//                fb.fizz();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//            CompletableFuture.runAsync(() -> {
//                try {
//                    fb.buzz();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//            CompletableFuture.runAsync(() -> {
//                try {
//                    fb.fizzbuzz();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//            CompletableFuture.runAsync(() -> {
//                try {
//                    fb.number();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
    }
}
class Thread1 implements Runnable{
    FizzBuzz fb;
    public Thread1(FizzBuzz fb){
        this.fb = fb;
    }
    @Override
    public void run() {
        try {
            fb.number();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

