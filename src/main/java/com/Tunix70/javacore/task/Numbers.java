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

        semFizz = new Semaphore(1);
        semBuzz = new Semaphore(1);
        semFizzBuzz = new Semaphore(1);
        semNumber = new Semaphore(1);

        semFizz.acquire();
        semBuzz.acquire();
        semFizzBuzz.acquire();
    }

        public void fizz() throws InterruptedException {
            for (int i = 3; i < n; i += 3) {
            System.out.print("Fizz ");
            semFizz.acquire();
            semNumber.release();
            }
        }
        public void buzz () throws InterruptedException {
            for (int i = 5; i < n; i += 5) {
                System.out.print("Buzz ");
                semBuzz.acquire();
                semNumber.release();
            }
        }

        public void fizzbuzz () throws InterruptedException {
            for (int i = 15; i < n; i += 15) {
                System.out.print("FizzBuzz ");
                semFizzBuzz.acquire();
                semNumber.release();
            }
        }

        public void number() {
            for (int i = 1; i < n; i++) {
                if (((i % 3) == 0) && ((i % 5) == 0)){
                semFizzBuzz.release();
                }
                else if ((i % 3) == 0){
                    semFizz.release();
                }
                else if ((i % 5) == 0){
                    semBuzz.release();
                }else
                System.out.print(i);
                continue;
            }
        }
}

public class Numbers {
        public static void main(String[] args) throws InterruptedException {
        FizzBuzz fb = new FizzBuzz(25);

        CompletableFuture.runAsync(() -> {
            try {
                fb.fizz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
            CompletableFuture.runAsync(() -> {
                try {
                    fb.buzz();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            CompletableFuture.runAsync(() -> {
                try {
                    fb.fizzbuzz();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            CompletableFuture.runAsync(() -> fb.number());
    }
}

