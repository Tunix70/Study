package main.java.com.Tunix70.javacore.chapter10;

class ThrowsDemo {
    static void throwOne() throws IllegalAccessException{
        System.out.println("В теле метода throwOne()");
        throw new IllegalAccessException("Demonstration");
    }

    public static void main(String[] args) {
        try {
            throwOne();
        } catch (IllegalAccessException e) {
            System.out.println("Перехвачено исключение: " + e);
        }
    }
}
