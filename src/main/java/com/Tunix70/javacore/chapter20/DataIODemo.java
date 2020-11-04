package main.java.com.Tunix70.javacore.chapter20;

import java.io.*;

class DataIODemo {
    public static void main(String[] args) {
        try(DataOutputStream dout = new DataOutputStream(new FileOutputStream("Test.dat")))
        {
            dout.writeDouble(98.6);
            dout.writeInt(1000);
            dout.writeBoolean(true);
        }catch (FileNotFoundException e){
            System.out.println("Нельзя открыть файл вывода");
            return;
        }catch (IOException e){
            System.out.println("Ошибка ввода-вывода: " + e);
        }

        //ввести данные из файла
        try(DataInputStream din = new DataInputStream(new FileInputStream("Test.dat"))) {
            double d = din.readDouble();
            int i = din.readInt();
            boolean b = din.readBoolean();

            System.out.println("Получаемые значения: " + d + " " + i + " " + b);
        }catch (FileNotFoundException e){
            System.out.println("Нельзя открыть файл вывода");
            return;
        }catch (IOException e){
            System.out.println("Ошибка ввода-вывода: " + e);
        }

    }
}
