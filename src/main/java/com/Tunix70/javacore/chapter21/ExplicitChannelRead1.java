package main.java.com.Tunix70.javacore.chapter21;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class ExplicitChannelRead1 {
    public static void main(String[] args) {
        int count;

        //канал открывается по пути, возвращаемому методом Paths.get() в виде объекта Path
        try(SeekableByteChannel fChan = Files.newByteChannel(Paths.get("C:\\qwer.txt"))) {
            //выделить память под буффер
            ByteBuffer mBuf = ByteBuffer.allocate(128);

            do {
                //читать данные из файла в буфер
                count = fChan.read(mBuf);

                //прекратить чтение по достижении конца файла
                if (count != -1) {

                    //подготовить буфер к чтению из него данных
                    mBuf.rewind();

                    //читать байты данных из буфера и выводить на экран, как символы
                    for (int i = 0; i < count; i++)
                        System.out.print((char) mBuf.get());
                }
            } while (count != -1);

            System.out.println();
        }catch (InvalidPathException e) {
            System.out.println("Ошибка указания пути: " + e);
        }catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
        }
    }
}