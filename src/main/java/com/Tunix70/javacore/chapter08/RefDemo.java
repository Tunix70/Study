package main.java.com.Tunix70.javacore.chapter08;

class RefDemo {
    public static void main(String[] args) {
        BoxWeigth weigthbox = new BoxWeigth(3, 5, 7, 8.37);
        Box plainbox = new Box();
        double vol;

        vol = weigthbox.volume();
        System.out.println("Объем weigthbox равен " + vol);
        System.out.println("Вес weigthbox равен " + weigthbox.weight);
        System.out.println();

        plainbox = weigthbox;
        vol = plainbox.volume();
        System.out.println("Объем plainbox равен " + vol);
//        System.out.println("Вес plainbox равен " + plainbox.weight);
    }
}
