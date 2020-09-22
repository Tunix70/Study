package main.java.com.Tunix70.javacore.chapter06;

class Box5 {
    double width;
    double height;
    double depth;

    double volume() {
        return width * height * depth;
    }

    void setDim (double w, double h, double d){
        width = w;
        height = h;
        depth = d;
    }
}

public class BoxDemo5 {  //стр 167

    public static void main(String[] args) {
	Box5 mybox1 = new Box5();
	Box5 mybox2 = new Box5();
	double vol;

	mybox1.setDim(10, 20, 15);
	mybox2.setDim(3, 6, 9);

	vol = mybox1.volume();
        System.out.println("Объем равен " + vol);

    vol = mybox2.volume();
        System.out.println("Объем равен " + vol);
    }
}
