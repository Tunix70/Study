package main.java.com.Tunix70.javacore.chapter03;

class Scope {
    public static void main(String[] args) {
        int x;

        x = 10;
        if(x == 10) {
            int y = 20;
            System.out.println("x и y: " + x + " " + y);

            x = y * 2;}

        System.out.println("x равно " + x);
    }
}

