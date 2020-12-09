package main.java.com.Tunix70.javacore.chapter28;

import java.util.concurrent.Phaser;

//Расширить класс MyPhaser3, чтобы выполнить только
// определенное количество фаз
class MyPhaser1 extends Phaser {
    int numPhases;

    MyPhaser1(int parties, int phaseCount){
        super(parties);
        numPhases = phaseCount - 1;
    }

    //переопределить метод onAdvance, чтобы выполнять определенное количество фаз
    protected boolean onAdvance(int p, int regParties){
        //следующий опрератор println() требуется только для
        //целей иллюстрации. Как правильно метода onAdvace()
        //не отображает вводимые данные
        System.out.println("Фаза " + p + " завершена.\n");

        //возвратить логичесткое значение true,
        //если все фазы завершены
        if(p == numPhases || regParties == 0) return true;
        else
            return false;
    }
}

class PhaserDemo2{
    public static void main(String[] args) {
        MyPhaser1 phsr = new MyPhaser1(1, 4);
        System.out.println("Запуск потоков.\n");

        new MyThread3(phsr, "A");
        new MyThread3(phsr, "B");
        new MyThread3(phsr, "C");

        //ожидать завершения определенного количества фаз
        while(!phsr.isTerminated()){
            phsr.arriveAndAwaitAdvance();
        }
        System.out.println("Синхронизаторр фаз завершен.");
    }
}

class MyThread3 implements Runnable{
    Phaser phsr;
    String name;

    MyThread3(Phaser p, String n){
        phsr = p;
        name = n;
        phsr.register();
        new Thread(this).start();
    }
    public void run(){
        while(!phsr.isTerminated()){
            System.out.println(
                    "Поток " + name + " начинает фразу " + phsr.getPhase());
            phsr.arriveAndAwaitAdvance();
            /* Небольшая пауза, чтобы не нарушить порядок вывода.
            Только для иллюстраций, но необязатально для правильного
            функционирования синхронизатора фаз
             */
            try {
                Thread.sleep(10);
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
