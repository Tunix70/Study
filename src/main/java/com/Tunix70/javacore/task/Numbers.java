package main.java.com.Tunix70.javacore.task;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class FizzBuzz {
    int n;

    private final Semaphore semFizz;
    private final Semaphore semBuzz;
    private final Semaphore semFizzBuzz;
    private final Semaphore semNumber;

    public FizzBuzz(int n) {
        this.n = n;

        semFizz = new Semaphore(0);
        semBuzz = new Semaphore(0);
        semFizzBuzz = new Semaphore(0);
        semNumber = new Semaphore(1);
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <= n ; i+= 3) {
            semFizz.acquire();
            printFizz.run();
            semNumber.release();
//            if ((i + 3) % 5 == 0) {
//                i += 3;
//            }
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n ; i += 5) {
            semBuzz.acquire();
            printBuzz.run();
            semNumber.release();
            if ((i + 5) % 3 == 0) {
                i += 5;
            }

        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 15; i <= n; i += 15) {
            semFizzBuzz.acquire();
            printFizzBuzz.run();
            semNumber.release();
        }
    }

    public void number(IntConsumer number) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            semNumber.acquire();
            if(i % 15 == 0){
                semFizzBuzz.release();
            }
            else if(i % 5 == 0){
                semBuzz.release();
            }
            else if(i % 3 == 0){
                semFizz.release();
            }
            else{
                number.accept(i);
                semNumber.release();
            }
        }
    }
}

class Number{
    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        Runnable printFizz = () -> System.out.print("fizz ");
        Runnable printBuzz = () -> System.out.print("buzz ");
        Runnable printFizzBuzz = () -> System.out.print("fizzbuzz ");
        IntConsumer printNumber = number -> System.out.print(number + " ");

        Thread threadA = new Thread(() -> {
            try {
                fizzBuzz.fizz(printFizz);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("А ЗАВЕРШЕН ");
        });

        Thread threadB = new Thread(() -> {
            try {
                fizzBuzz.buzz(printBuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("В ЗАВЕРШЕН ");
        });
        Thread threadC = new Thread(()-> {
            try {
                fizzBuzz.fizzbuzz(printFizzBuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("С ЗАВЕРШЕН ");
        });
        Thread threadD = new Thread(() -> {
            try {
                fizzBuzz.number(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("D ЗАВЕРШЕН ");
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }
}

