package main.java.com.Tunix70.javacore.chapter21;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.InvalidPathException;

public class MappedChannalRead1 {
    public static void main(String[] args) {
        FileInputStream fIn = null;
        FileChannel fChan = null;
        long fSize;
        MappedByteBuffer mBuf;

        try {
            //сначала открыть файл для ввода
            fIn = new FileInputStream("C:\\qwer.txt");

            //затем получить канал к этому файлу
            fChan = fIn.getChannel();

            //получить размер файла
            fSize = fChan.size();

            //а теперь сопоставить файл с буфером
            mBuf = fChan.map(FileChannel.MapMode.READ_ONLY, 0, fSize);

            //читать байты из буфера и выводить их на экран
            for (int i = 0; i < fSize; i++)
                System.out.print((char) mBuf.get());

        } catch (InvalidPathException e) {
            System.out.println("Ошибка указания пути: " + e);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
        }
    }
}
