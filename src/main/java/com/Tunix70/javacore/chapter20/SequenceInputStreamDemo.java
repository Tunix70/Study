package main.java.com.Tunix70.javacore.chapter20;

import java.io.*;
import java.util.*;

class InputStreamEnumerator implements Enumeration<FileInputStream>{
    private Enumeration<String> files;

    public InputStreamEnumerator(Vector<String> files){
        this.files = files.elements();
    }

    @Override
    public boolean hasMoreElements() {
        return files.hasMoreElements();
    }

    @Override
    public FileInputStream nextElement() {
        try {
            return new FileInputStream(files.nextElement().toString());
        } catch (IOException e) {
            return null;
        }
    }
}

class SequenceInputStreamDemo {
    public static void main(String[] args) {
        int c;
        Vector<String> files = new Vector<>();

        files.addElement("copy.txt");
        files.addElement("file2.txt");
        files.addElement("file3.txt");
        InputStreamEnumerator ise = new InputStreamEnumerator(files);
        InputStream input = new SequenceInputStream(ise);

        try{
            while((c = input.read()) != -1)
                System.out.print((char) c);
        }catch (NullPointerException e) {
            System.out.println("Ошибка открытия файла");
        }catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
    } finally {
            try {
                input.close();
            }catch (IOException e){
                System.out.println("Ошибка закрытия потока ввода SequenseInputStream");
            }
        }
        }
}
