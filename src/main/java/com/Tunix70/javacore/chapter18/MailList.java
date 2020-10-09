package main.java.com.Tunix70.javacore.chapter18;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.ListIterator;

class Address {
    private String name;
    private String street;
    private String city;
    private String state;
    private String code;
    Address(String n, String s, String c, String st, String cd){
        name = n;
        street = s;
        city = c;
        state = st;
        code = cd;
    }

    public String toString(){
        return name + "\n" + street + "\n" + city + " " + state + " " + code;
    }
}

class MailList {
    public static void main(String[] args) {
        LinkedList<Address> ml = new LinkedList<>();
        ml.add(new Address("J.W. West", "11 Oak Ave", "Urbana", "IL", "61801"));
        ml.add(new Address("Ralph Baker", "1142 Maple Lane", "Mahomet", "IL", "61853"));
        ml.add(new Address("Tom Charlton", "867 Elm St", "Champaign", "IL", "61820"));

        for (Address element : ml)
            System.out.println(element + "\n");
        System.out.println();
    }
}
