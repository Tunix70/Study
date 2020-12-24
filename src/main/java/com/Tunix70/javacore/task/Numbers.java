package main.java.com.Tunix70.javacore.task;

class FizzBuzz{
    int n;

    public FizzBuzz(int n){
        this.n = n;
    }

    public int getNum() {
        return n;
    }

    public void fizz(){
        System.out.print("Fizz");
    }

    public void buzz(){
        System.out.print("Buzz");
    }

    public void fizzbuzz(){
        System.out.print("FizzBuzz");
    }

    public void number(int i){
        System.out.print(i);
    }
}

public class Numbers {
    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        for (int i = 1; i <= fizzBuzz.getNum(); i++) {
            if (((i % 3) == 0) && ((i % 5) == 0)){
                fizzBuzz.fizzbuzz();
                System.out.print(" ");
                continue;
            }
            if ((i % 3) == 0){
                fizzBuzz.fizz();
                System.out.print(" ");
                continue;
            }
            if ((i % 5) == 0){
                fizzBuzz.buzz();
                System.out.print(" ");
                continue;
            }
            else fizzBuzz.number(i);
            System.out.print(" ");
            continue;
        }
    }
}

