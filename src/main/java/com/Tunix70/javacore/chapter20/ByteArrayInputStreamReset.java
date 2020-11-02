package main.java.com.Tunix70.javacore.chapter20;

import java.io.*;

class ByteArrayInputStreamReset {
    public static void main(String[] args) {
        String tmp = "abc";
        byte b [] = tmp.getBytes();
        ByteArrayInputStream in = new ByteArrayInputStream(b);

        for (int i = 0; i < 2; i++) {
            int t;
            while((t = in.read()) != -1){
                if(i == 0) {
                    System.out.print((char) t);
                } else {
                    System.out.print(Character.toUpperCase((char) t));
                }
            }
            System.out.println();
            in.reset();
        }
    }
}
