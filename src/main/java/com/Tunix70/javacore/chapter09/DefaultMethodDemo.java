package src.main.java.com.Tunix70.javacore.chapter09;

interface MyIF{
    int getNumber();
    default String getString(){
        return "Объект типа String по умолчанию";
    }
}

class MyIFImp implements MyIF{

    @Override
    public int getNumber() {
        return 100;
    }
}

class MyIFImp2 implements MyIF{

    @Override
    public int getNumber() {
        return 100;
    }

    @Override
    public String getString() {
        return "Это другая символьная строка.";
    }
}

public class DefaultMethodDemo {
    public static void main(String[] args) {
        MyIFImp obj = new MyIFImp();

        System.out.println(obj.getNumber());
        System.out.println(obj.getString());
    }
}
