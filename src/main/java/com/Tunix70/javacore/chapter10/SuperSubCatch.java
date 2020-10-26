package main.java.com.Tunix70.javacore.chapter10;

class SuperSubCatch {
    public static void main(String[] args) {
        try{
            int a = 0;
            int b = 42 / a;
        }catch (Exception e){
            System.out.println("Перехват исключений общего класса Exception");
        }//этот опрератор catch вообще не будет достигнут, т.к. подкласс ArithmeticException
        //является производняым от класса Exception
//        catch (ArithmeticException e){
//            System.out.println("Этот код вообще недостежим");
//        }
    }
}
