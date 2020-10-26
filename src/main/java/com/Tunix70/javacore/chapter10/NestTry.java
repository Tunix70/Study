package main.java.com.Tunix70.javacore.chapter10;

class NestTry {
    public static void main(String[] args) {
        try {
            int a = args.length;
            /* если не указаны аргументы командной строки, в следующем
            операторе будет сгенерировано исключение в связи с делением на нуль
             */
            int b = 42 / a;
            System.out.println("a =" + a);
            try {//вложенный блок try
                /* если указан один аргумент командной строки, в следующем
            коде будет сгенерировано исключение в связи с делением на нуль*/
                if (a == 1) a = a / (a - a);
                /* если указаны два аргумента командной строки, то генерируется
                исключение в связи с выходом за пределы массива*/
                if (a == 2) {
                    int c[] = {1};
                    c[42] = 99;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Индекс за пределами массива: " + e);
            }
        } catch (ArithmeticException e) {
            System.out.println("Деление на нуль: " + e);
        }
    }
}

