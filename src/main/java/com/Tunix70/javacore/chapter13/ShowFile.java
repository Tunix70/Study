package main.java.com.Tunix70.javacore.chapter13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class ShowFile {
    public static void main(String[] args) {
        int i;
        FileInputStream fin;
        //сначала убедиться, что имя файла указано
        if(args.length != 1){
            System.out.println("Использование: ShowFile имя_файла");
            return;
        }
        //попытка открыть файл
        try{
            fin = new FileInputStream(args[0]);
        }catch (FileNotFoundException e){
            System.out.println("Невозможно открыть файл");
            return;
        }
        //теперь файл открыт и готов к чтению
        //файл читается, пока не достиг конца
        try{
            do{
                i = fin.read();
                if(i != -1) System.out.print((char) i);
            }while(i != -1);
        }catch (IOException e){
            System.out.println("Ошибка чтения из файла");
        }
        //закрыть файл
        try{
            fin.close();
        }catch (IOException e){
            System.out.println("Ошибка закрытия файла");
        }
    }
}
