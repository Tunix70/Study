package main.java.com.Tunix70.javacore.chapter21;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class MappedChannelRead {
    public static void main(String[] args) {
        //получить канал к файлу в блоке оператора try с ресурсами
        try(FileChannel fChan = (FileChannel) Files.newByteChannel(Paths.get("C:\\qwer"))) {

            //получить размер файла
            long fSize = fChan.size();

            //а теперь сопоставить файл с буфером
            MappedByteBuffer mBuf = fChan.map(FileChannel.MapMode.READ_ONLY, 0, fSize);

            //читать байты из буфера и выводить их на экран
            for (int i = 0; i <fSize ; i++)
                System.out.print((char) mBuf.get());

            System.out.println();
            }catch (InvalidPathException e) {
            System.out.println("Ошибка указания пути: " + e);
        }catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
        }
    }
}
