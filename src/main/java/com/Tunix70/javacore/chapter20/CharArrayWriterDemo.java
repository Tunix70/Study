package main.java.com.Tunix70.javacore.chapter20;

import java.io.*;

class CharArrayWriterDemo {
    public static void main(String[] args) throws IOException {
        CharArrayWriter f = new CharArrayWriter();
        String s = "Эти данные должны ыть введены в массив";
        char buf[] = new char[s.length()];

        s.getChars(0, s.length(), buf, 0);

        try{
            f.write(buf);
        }catch (IOException e){
            System.out.println("Ошибка записи в буфер");
            return;
        }

        System.out.println("Буфер в виде символьной строки");
        System.out.println(f.toString());
        System.out.println("В массив");

        char c[] = f.toCharArray();
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }
        System.out.println("\nВ поток вывода типа FileWriter()");

        try(FileWriter f2 = new FileWriter("text.txt"))
        {
            f.writeTo(f2);
        }catch (IOException e){
            System.out.println("Ошибка ввода-вывода: " + e);
        }
        System.out.println("Установка в исходное состояние");
        f.reset();

        for (int i = 0; i < 3; i++) f.write('X');
        System.out.println(f.toString());
    }
}
