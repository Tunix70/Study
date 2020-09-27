package main.java.com.Tunix70.javacore.chapter09.CallBack;

class TestIface {
    public static void main(String[] args) {
        Callback c = new Client();
        c.callback(42);
    }
}
