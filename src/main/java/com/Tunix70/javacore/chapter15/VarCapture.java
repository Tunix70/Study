package src.main.java.com.Tunix70.javacore.chapter15;
//пример закхвата локальной переменной из объемлющей области действия

interface MyFunc{
    int func(int n);
}

class VarCapture {
    public static void main(String[] args) {
        //локальная переменная, которая может быть закхвачена
        int num = 10;

        MyFunc myLambda = (n) -> {
            //такое применение переменной num допустимо, тк она не видоизменится
            int v = num + n;

            //код недопустим, тк принимается попытка видоизменить значение переменной num
//            num++;
            return v;
        };
        //код недопустим, тк нарушается действительно завершенное состояние переменной num
//        num = 9;
    }
}
