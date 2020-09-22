package main.java.com.Tunix70.javacore.chapter06;

class Box7 {
    double wigth;
    double heigth;
    double depth;

    Box7(double w, double h, double d){

        wigth = w;
        heigth = h;
        depth = d;
    }
    double volume(){
        return wigth * heigth * depth;
    }
}

class BoxDemo7{
    public static void main(String[] args) {
        Box7 mybox1 = new Box7(10, 20, 15);
        Box7 mybox2 = new Box7(3, 6, 9);

        double vol;

        vol = mybox1.volume();
        System.out.println("Объем равен " + vol);

        vol = mybox2.volume();
        System.out.println("Объем равен " + vol);
    }
}
