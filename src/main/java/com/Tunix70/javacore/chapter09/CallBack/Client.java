package main.java.com.Tunix70.javacore.chapter09.CallBack;

class Client implements Callback{
    @Override
    public void callback(int p) {
        System.out.println("Метод callback(), вызываемый со значением " + p);
    }
    void nonIfaceMeth(){
        System.out.println("В классах, реализующих интерфейсы,"
                + "могут определяться и другие члены");
    }

}
