package main.java.com.Tunix70.javacore.chapter21;

import java.io.IOException;
import java.nio.file.*;

public class NIOCopy {
    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.println("Применение: откуда и куда копировать");
            return;
        }
        try {
            Path source = Paths.get(args[0]);
            Path target = Paths.get(args[1]);

            //скопировать файл
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        }catch (InvalidPathException e){
            System.out.println("Ошибки указания пути: " + e);
        }catch (IOException e){
            System.out.println("Ошибка ввода-вывода " + e);
        }
    }
}
