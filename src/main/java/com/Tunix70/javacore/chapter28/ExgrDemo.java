package main.java.com.Tunix70.javacore.chapter28;

import java.util.concurrent.Exchanger;

public class ExgrDemo {
    public static void main(String[] args) {
        Exchanger<String> exgr = new Exchanger<>();
        new UseString(exgr);
        new MakeString(exgr);
    }
}
//потомок типа Thread, формирующий символьную строку
class MakeString implements Runnable{
    Exchanger<String> ex;
    String str;
    MakeString(Exchanger<String>c){
        ex = c;
        str = new String();
        new Thread(this).start();
    }
    public void run(){
        char ch = 'A';
        for (int i = 0; i < 3; i++) {
            //заполнить буфер
            for (int j = 0; j < 5; j++)
                str += (char) ch++;
            try{
                //обменять заполненный буфер на пустой
                str = ex.exchange(str);
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
//поток типа Thread, использующий символьную строку
class UseString implements Runnable{
    Exchanger<String> ex;
    String str;
    UseString(Exchanger<String>c){
        ex = c;
        new Thread(this).start();
    }
    public void run(){
        for (int i = 0; i < 3; i++) {
            try{
                //обменять пустой буфер на заполненный
                str = ex.exchange(new String());
                System.out.println("Получено: " + str);
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
