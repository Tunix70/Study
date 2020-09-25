package chapter08;

class Box{
    double width;
    double heigth;
    double depth;

    Box(Box ob){
        width = ob.width;
        heigth = ob.heigth;
        depth = ob.depth;
    }

    Box(double w, double h, double d) {
        width = w;
        heigth = h;
        depth = d;
    }

    Box(){
        width = -1;
        heigth = -1;
        depth = -1;
    }

    Box(double len){
        width = heigth = depth = len;
    }

    double volume(){
        return width * heigth * depth;
    }
}

class BoxWeigth extends Box{
    double weight;

    BoxWeigth(double w, double h, double d, double m){
        width = w;
        heigth = h;
        depth = d;
        weight = m;
    }
}

public class DemoBoxWeigth {
    public static void main(String[] args) {
        BoxWeigth mybox1 = new BoxWeigth(10, 20, 15, 34.3);
        BoxWeigth mybox2 = new BoxWeigth(2,3, 4, 0.076);
        double vol;

        vol = mybox1.volume();
        System.out.println("Объем mybox1 равен " + vol);
        System.out.println("Вес mybox1 равен " + mybox1.weight);
        System.out.println();

        vol = mybox2.volume();
        System.out.println("Объем mybox2 равен " + vol);
        System.out.println("Вес mybox2 равен " + mybox2.weight);
    }
}
