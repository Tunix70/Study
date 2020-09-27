package main.java.com.Tunix70.javacore.chapter08;

class Box3{
    private double width;
    private double heigth;
    private double depth;

    Box3(Box3 ob){
        width = ob.width;
        heigth = ob.heigth;
        depth = ob.depth;
    }

    Box3(double w, double h, double d) {
        width = w;
        heigth = h;
        depth = d;
    }

    Box3(){
        width = -1;
        heigth = -1;
        depth = -1;
    }

    Box3(double len){
        width = heigth = depth = len;
    }

    double volume(){
        return width * heigth * depth;
    }
}

class BoxWeigth3 extends Box3{
    double weight;

    BoxWeigth3(BoxWeigth3 ob){
        super(ob);
        weight = ob.weight;
    }

    BoxWeigth3(double w, double h, double d, double m){
        super(w,h,d);
        weight = m;
    }
    BoxWeigth3(){
        super();
        weight = -1;
    }
    BoxWeigth3(double len, double m){
        super(len);
        weight = m;
    }
}
class Shipment extends BoxWeigth3{
    double cost;

    Shipment(Shipment ob){
        super(ob);
        cost = ob.cost;
    }
    Shipment(double w, double h, double d, double m, double c){
        super(w,h,d, m);
        cost = c;
    }
    Shipment(){
    super();
    cost = -1;
    }
    Shipment(double len, double m, double c){
        super(len, m);
        cost = c;
    }
}

class DemoShipment {
    public static void main(String[] args) {
        Shipment shipment1 = new Shipment(10, 20, 15, 10, 3.41);
        Shipment shipment2 = new Shipment(2, 3, 4, 0.76, 1.28);
        double vol;

        vol = shipment1.volume();
        System.out.println("Объем shipment1 равен " + vol);
        System.out.println("Вес shipment1 равен " + shipment1.weight);
        System.out.println("Стоимость доставки: $ " + shipment1.cost);
        System.out.println();

        vol = shipment2.volume();
        System.out.println("Объем shipment2 равен " + vol);
        System.out.println("Вес shipment2 равен " + shipment2.weight);
        System.out.println("Стоимость доставки: $ " + shipment2.cost);
        System.out.println();
    }
}