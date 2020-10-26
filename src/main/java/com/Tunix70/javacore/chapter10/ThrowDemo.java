package main.java.com.Tunix70.javacore.chapter10;

class ThrowDemo {
    static void demoroc(){
        try{
            throw new NullPointerException("Демонстрация");
        }catch (NullPointerException e){
            System.out.println("Исключение перехвачено в теле метода demoroc");
            throw e; //повторно сгенерировать исключение
        }
    }

    public static void main(String[] args) {
        try{
            demoroc();
        }catch (NullPointerException e){
            System.out.println("Повторный перехват: " + e);
        }
    }
}
