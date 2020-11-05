package main.java.com.Tunix70.javacore.chapter21;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ExplicitChannelWrite {
    public static void main(String[] args) {
        //получить канал к файлу в блоке оператора try  с ресурсами

        try(FileChannel fChan = (FileChannel) Files.newByteChannel(Paths.get("C:\\qwer.txt"),
                                            StandardOpenOption.WRITE, StandardOpenOption.CREATE))
        {
            //создать буфер
            ByteBuffer mBuf = ByteBuffer.allocate(26);

            //записать некоторое количество байтов в буфер
            for (int i = 0; i < 26; i++)
                mBuf.put((byte) ('A' + i));

            //подготовить буфер к записи данных
            mBuf.rewind();

            //записать данные из буфера в выходной файл
            fChan.write(mBuf);
        } catch (InvalidPathException e) {
            System.out.println("Ошибка указания пути " + e);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода " + e);
            System.exit(1);
        }
    }
}
