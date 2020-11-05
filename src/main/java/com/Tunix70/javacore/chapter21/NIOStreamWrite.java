package main.java.com.Tunix70.javacore.chapter21;

import java.io.*;
import java.nio.file.*;

class NIOStreamWrite {
    public static void main(String[] args) {
        //открыть файл и получить связанный с ним поток вывода
        try(OutputStream fout = new BufferedOutputStream(Files.newOutputStream(Paths.get("C:\\qwer")))){

            //вывести в поток заданное количество байтов
            for(int i = 0; i < 26; i++)
                fout.write((byte) ('A' + i));
        }catch (InvalidPathException e){
            System.out.println("Ошибки указания пути: " + e);
        }catch (IOException e){
            System.out.println("Ошибка ввода-вывода " + e);
        }
    }
}
