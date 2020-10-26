package main.java.com.Tunix70.javacore.chapter10;

class FinallyDemo {
    //сгенерировать исключение в методе
    static void procA(){
        try {
            System.out.println("В теле метода procA()");
            throw new RuntimeException("Demonstration");
        }finally {
            System.out.println("Блок оператора finally в методе procA()");
        }
    }
    //возвратить управление из блока оператора try
    static void procB(){
        try {
            System.out.println("В теле метода procB()");
            return;
        }finally {
            System.out.println("Блок оператора finally в методе procB()");
        }
    }
    static void procC(){
        try {
            System.out.println("В теле метода procC()");
        }finally {
            System.out.println("Блок оператора finally в методе procC()");
        }
    }

    public static void main(String[] args) {
        try{
            procA();
        }catch (Exception e){
            System.out.println("Исключение перехвачено");
        }
        procB();
        procC();
    }
}
