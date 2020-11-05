package main.java.com.Tunix70.javacore.chapter21;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.InvalidPathException;

public class ExplicitChannelRead2 {
    public static void main(String[] args) {
        FileInputStream fIn = null;
        FileChannel fChan = null;
        ByteBuffer mBuf;
        int count;

        try{
            //сначала открыть файл для ввода
            fIn = new FileInputStream("C:\\qwer.txt");

            //затем получить канал к этому файлу
            fChan = fIn.getChannel();

            //выделить оперативную память под буфер
            mBuf = ByteBuffer.allocate(128);

            do{
                //читать данные в буфер
                count = fChan.read(mBuf);

                //прекратить чтение по достижению конца файла
                if(count != -1) {

                    //подготовить буфер к чтению из него файлов
                    (mBuf).rewind();

                    //читать байты данныз из буфера и выводить их на экран как символы
                    for (int i = 0; i < count; i++)
                        System.out.print((char) (mBuf).get());
                }
                }while(count != -1);
                System.out.println();
        }catch (InvalidPathException e) {
            System.out.println("Ошибка указания пути: " + e);
        }catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
        }
    }
}
