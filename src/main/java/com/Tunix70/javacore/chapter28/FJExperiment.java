package main.java.com.Tunix70.javacore.chapter28;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class Transform extends RecursiveAction{
    //Порог последовательного исполнения,
    //устанавливаемый конструктором
    int seqThreshold;

    //обрабатываемый массив
    double[] data;

    //определить часть обрабатываемых данных
    int start, end;

    Transform(double[] vals, int s, int e, int t){
        data = vals;
        start = s;
        end = e;
        seqThreshold = t;
    }

    //этот метод выполняет параллельное вычисление
    protected void compute(){
        //выполнить далее обработку последовательно,
        //если количество элементов ниже порогового значения
        if((end - start) < seqThreshold) {
            //В следующем фрагменте кода элементу по четному
            //индексу присваивает с я квадратный корень его
            //первоначаль ного значения ,а элементу по нечетному
            //индексу - кубический корень его первоначального значения .
            //Этот код предназначен только для потребления времени ЦП ,
            //чтобы сделать нагляднее эффект от параллельного выполнения
            for (int i = start; i < end; i++) {
                if((data[i] % 2) == 0)
                    data[i] = Math.sqrt(data[i]);
                else data[i] = Math.cbrt(data[i]);
            }
        }else{
            //в противном случае продолжить разделение данных на
            //меньшие части

            //найти середину
            int middle = (start + end) / 2;

            //запустить новые подзадачи на выполнение,
            //используя разделенные на части данные
            invokeAll(new Transform(data, start, middle, seqThreshold),
                    new Transform(data, middle, end, seqThreshold));
        }
    }
}

//продемонстрировать параллельное выполнение
class FJExperiment{
    public static void main(String[] args) {
        int pLevel;
        int threshold;

        if(args.length != 2){
            System.out.println("Использование: FJExperiment параллелизм порог");
            return;
        }
        pLevel = Integer.parseInt(args[0]);
        threshold = Integer.parseInt(args[1]);

        //эти переменные используютс для измерения
        //времени выполнения задачи
        long beginT, endT;

        //создание пул задач
        //обратите внимание на установку уровня параллелизма
        ForkJoinPool fjp = new ForkJoinPool(pLevel);

        double[] nums = new double[1000000];

        for (int i = 0; i < nums.length; i++)
            nums[i] = (double) i;

        Transform task = new Transform(nums, 0, nums.length, threshold);

        //начать измерение времени выполнения задачи
        beginT = System.nanoTime();

        //запустить главную задачу типа ForkJoinTask
        fjp.invoke(task);

        //завершить измерение времени выполнения задачи
        endT = System.nanoTime();

        System.out.println("Уровень параллелизма: " + pLevel);
        System.out.println("Порог последовательности обработки: " + threshold);
        System.out.println("Истекшее время: " + (endT - beginT) + " нс");
        System.out.println();
    }
}
