package main.java.com.Tunix70.javacore.chapter21;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class DirList {
    public static void main(String[] args) {
        String dirname = "C:\\JR";

        //получить о обработать поток ввода каталога в блоке оператора try
        try(DirectoryStream<Path> distrm = Files.newDirectoryStream(Paths.get(dirname)))
        {
            System.out.println("Каталог: " + dirname);

            //класс DirectoryStream реализует интерфейс Iterable, поэтому пользуемся for each
            for(Path entry : distrm) {
                BasicFileAttributes attribs = Files.readAttributes(entry, BasicFileAttributes.class);

                if (attribs.isDirectory())
                    System.out.println("<DIR> ");
                else
                    System.out.println("      ");

                System.out.println(entry.getName(1));
            }
        }catch(InvalidPathException e){
            System.out.println("Ошибка указания пути: " + e);
        }catch (NotDirectoryException e){
            System.out.println(dirname + " не является каталогом");
        }catch (IOException e){
            System.out.println("Ошибка ввода-вывода: " + e);
        }
    }
}
