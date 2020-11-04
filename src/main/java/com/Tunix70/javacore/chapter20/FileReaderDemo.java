package main.java.com.Tunix70.javacore.chapter20;

import java.io.*;

class FileReaderDemo {
    public static void main(String[] args) {
        try(FileReader fr = new FileReader("FileReaderDemo.java")) {
            int c;

            //прочитать и вывести содержимое файла
            while ((c = fr.read()) != -1) System.out.println((char) c);
        }catch (IOException e){
            System.out.println("Ошибка ввода-вывода: " + e);
        }
    }
}
