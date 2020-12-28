package main.java.com.Tunix70.javacore.task;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Semaphore;

class FizzBuzz {
    int n;

    private final Semaphore semFizz = new Semaphore(1);
    private final Semaphore semBuzz = new Semaphore(1);
    private final Semaphore semFizzBuzz = new Semaphore(1);
    private final Semaphore semNumber = new Semaphore(1);

    public FizzBuzz(int n) throws InterruptedException {
        this.n = n;

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
                continue;
                }
                if ((i % 3) == 0){
                    semFizz.release();
                    continue;
                }
                if ((i % 5) == 0){
                    semBuzz.release();
                    continue;
                }else
                System.out.print(i);
                continue;
            }
        }
}

public class Numbers {
        public static void main(String[] args) throws InterruptedException {
        FizzBuzz fb = new FizzBuzz(15);

    }
}

