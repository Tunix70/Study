package main.java.com.Tunix70.javacore.chapter28;


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class Sum extends RecursiveTask<Double>{

    //пороговое значение последовательного выполнения
    final int seqThresHold = 500;

    //обрабатываемый массив
    double[] data;

    //определить часть обрабатываемых данных
    int start, end;

    Sum(double[] vals, int s, int e){
        data = vals;
        start = s;
        end = e;
    }
    //определить сумму значений элементов в массиве типа double
    protected Double compute(){
        double sum = 0;

        //если количество элементов ниже порогового значения,
        //то выполнить далее обработку последовательно
        if((end - start) < seqThresHold) {
            //суммировать значение элементов в массиве типа double
            for (int i = start; i < end; i++)
                sum += data[i];
        }else {
            //в противном случае продолжить разджеление данных на
            //меньшие части

            //найти середину
            int middle = (start + end) / 2;

            //запустить новые подзадачи на выполнение, используя
            //разделенные на части данные
            Sum subTaskA = new Sum(data, start, middle);
            Sum subTaskB = new Sum(data, middle, end);

            //запустить каждую подзадачу по\утем разветвления
            subTaskA.fork();
            subTaskB.fork();

            //ожидать завершения подзадач и накопить результаты
            sum = subTaskA.join() + subTaskB.join();
        }
        //возвратить конечную сумму
        return sum;
    }
}
//продемонстрировать параллельное выполнение
class RecurTaskDemo {
    public static void main(String[] args) {
        //создать пул задач
        ForkJoinPool fjp = new ForkJoinPool();

        double[] nums = new double[5000];

        //инициализировать массив nums чередующимися
        //положительными и отрицательными значениями
        for (int i = 0; i < nums.length; i++)
            nums[i] = (double) (((i % 2) == 0) ? i : -i);

        Sum task = new Sum(nums, 0, nums.length);

        //Запус тить задачи типа ForkJoinTaak. Обратите
        //внимание на то, что в данном случае метод invoke( )
        //возвращает результат
        double summation = fjp.invoke(task);

        System.out.println("Суммирование " + summation);
    }
}
