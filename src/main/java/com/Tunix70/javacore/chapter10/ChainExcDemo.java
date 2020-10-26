package main.java.com.Tunix70.javacore.chapter10;

public class ChainExcDemo {
    static void demoproc(){
        //создание исключения
        NullPointerException e = new NullPointerException("Верхний уровень");

        //добавить причину исключения
        e.initCause(new ArithmeticException("Причина"));
        throw  e;
    }

    public static void main(String[] args) {
        try {
            demoproc();
        }catch (NullPointerException e){
            System.out.println("Перехвачено исключение: " + e);
            System.out.println("Первопричина: " + e.getCause());
        }
    }
}
