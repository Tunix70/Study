package main.java.com.Tunix70.javacore.chapter10;

class MultiCatch {
    public static void main(String[] args) {
        int a = 10, b = 0;
        int cals[] = {1, 2, 3};
        try{
            int result = a / b;
       }catch (ArithmeticException | ArrayIndexOutOfBoundsException e){
            System.out.println("Исключение перехвачено: " + e);
        }
        System.out.println("После многократного перхвата");
    }
}
