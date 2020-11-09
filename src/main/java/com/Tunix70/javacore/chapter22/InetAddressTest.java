package main.java.com.Tunix70.javacore.chapter22;

import java.net.*;

class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress Address = InetAddress.getLocalHost();
        System.out.println(Address);

        Address = InetAddress.getByName("www.google.com");
        System.out.println(Address);

        InetAddress SW[] = InetAddress.getAllByName("www.yandex.ru");
        for (int i = 0; i <SW.length ; i++)
            System.out.println(SW[i]);
    }
}
