package main.java.com.Tunix70.javacore.chapter07;


class Stack1 {
    private int stck[] = new int[10];
    private int tos;

    Stack1(){
        tos = -1;
    }
    void push (int item){
        if(tos==9)
            System.out.println("Стек заполнен.");
        else
            stck[++tos] = item;
    }
    int pop(){
        if(tos < 0){
            System.out.println("Стек не загружен");
            return 0;
        }
        else
            return stck[tos--];
    }
}


public class TestStack2 {
    public static void main(String[] args) {
        Stack1 mystack1 = new Stack1();
        Stack1 mystack2 = new Stack1();

        for (int i = 0; i < 10; i++) {
            mystack1.push(i);
        }
        for (int i = 10; i < 20; i++) {
            mystack2.push(i);
        }

        System.out.println("Стек в mystack1:");
        for (int i = 0; i < 10; i++) {
            System.out.println(mystack1.pop());
        }
        System.out.println("Стек в mystack2:");
        for (int i = 0; i < 10; i++) {
            System.out.println(mystack2.pop());

//            mystack1.tos = -2;
//            mystack2.stck[3] = 100;
        }
    }
}

