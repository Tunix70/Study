package Tunix70;

import java.io.*;

class FileWriterDemo {
    public static void main(String[] args) {
        String source = "Now is the time for all good men\n" +
                        " to come to the aid of their country\n " +
                        " and pay their due taxes.";
        char[] buffer = new char[source.length()];
        source.getChars(0, source.length(), buffer, 0);

        try{
            FileWriter f0 = new FileWriter("file1.txt");
            FileWriter f1 = new FileWriter("file2.txt");
            FileWriter f2 = new FileWriter("file3.txt");

            //ввести символы в первый файл
            for (int i = 0; i < buffer.length; i+=2) {
                f0.write(buffer[i]);
            }
            //ввести символы со второго потока
            f1.write(buffer);

            //ввести символы с третьего файла
            f2.write(buffer, buffer.length/4, buffer.length/4);
        }catch (IOException e){
            System.out.println("Произошла ошибка ввода-вывода");
        }
    }
}
