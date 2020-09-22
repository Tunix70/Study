package main.java.com.Tunix70.javacore.chapter06;

class Box6 {
    double wigth;
    double heigth;
    double depth;

    Box6(){
        System.out.println("Конструирование объекта Box");
        wigth = 10;
        heigth = 10;
        depth = 10;
    }
    double volume(){
        return wigth * heigth * depth;
    }
}

class BoxDemo6{
    public static void main(String[] args) {
        Box6 mybox1 = new Box6();
        Box6 mybox2 = new Box6();

        double vol;

        vol = mybox1.volume();
        System.out.println("Объем равен " + vol);

        vol = mybox2.volume();
        System.out.println("Объем равен " + vol);
    }
}
