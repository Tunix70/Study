package src.main.java.com.Tunix70.javacore.chapter15;
//сгенерировать исключение для Л-В

interface DoubleNumericArrayFunc{
    double func(double[] n) throws EmptyArrayException;
}

class EmptyArrayException extends Exception{
    EmptyArrayException() {
        super("массив пуст");
    }
}

class LambaExceptionDemo {
    public static void main(String[] args) throws EmptyArrayException {
        double [] values = {1.0, 2.0, 3.0, 4.0};
        //в этом Л-В вычисляется среднее числовых значений типа double в массиве
        DoubleNumericArrayFunc average = n -> {
            double sum = 0;

            if(n.length == 0)
                throw new EmptyArrayException();

            for (int i = 0; i <n.length ; i++)
                sum += n[i];

            return sum / n.length;
        };
        System.out.println("Среднее равно " + average.func(values));
        //эта строка приводит к генерированию исключения
        System.out.println("Среднее равно " + average.func(values));
    }
}
