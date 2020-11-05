package main.java.com.Tunix70.javacore.chapter21;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class ExplicitChannelWrite1 {
    public static void main(String[] args) {
        FileOutputStream fOut = null;
        FileChannel fChan = null;
        ByteBuffer mBuf;

        try{
            //открыть файл для вывода данных
            fOut = new FileOutputStream("C:\\qwer.txt");

            //затем получить канал к файлу для вывода данных
            fChan = fOut.getChannel();

            //создать буфер
            mBuf = ByteBuffer.allocate(26);

            //записать некоторое количество байтов в буфер
            for (int i = 0; i < 26; i++)
                mBuf.put((byte) ('A' + i));

            //подготовить буфер к записи данных
            mBuf.rewind();

            //записать данные из буфера в выходной файл
            fChan.write(mBuf);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода " + e);
        } finally {
            try {
                if(fChan != null) fChan.close();
            }catch (IOException e){
                System.out.println("Ошибка закрытия канала");
            }
            try {
                if (fOut != null) fOut.close();
            }catch (IOException e){
                System.out.println("Ошибка закрытия файла");
            }
        }
    }
}
