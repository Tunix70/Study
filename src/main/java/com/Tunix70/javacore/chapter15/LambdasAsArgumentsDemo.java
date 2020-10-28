package src.main.java.com.Tunix70.javacore.chapter15;

interface StringFunc{
    String func(String n);
}
//передать Л-В в качестве аргумента методу
class LambdasAsArgumentsDemo {
        static String stringOp(StringFunc sf, String s){
           return sf.func(s);
        }

    public static void main(String[] args) {
        String inStr = "Лямбда-выражения повышают эффективность JAVA";
        String outStr;

        System.out.println("Это исходная строка: " + inStr);
        //ниже приведено простое Л-В, преобразующее в верхний регистр букв все
        //символы исходной строки, передаваемой оператору stringOp()
        outStr = stringOp((str) -> str.toUpperCase(), inStr);
        System.out.println("Это строка в верхнем регистре: " + outStr);

        outStr = stringOp((str) -> {
            String result = "";
            int i;
            for(i = 0; i < str.length(); i++)
                if(str.charAt(i) != ' ')
                    result += str.charAt(i);
                return result;
        }, inStr);
        System.out.println("Это строка с удаленными пробелами: " + outStr);

        //конечно, можно передать и экземпляр интерфейса StringFunc, созданный в предыдущем Л-В
        //например после следующего объявления ссылка reverse делается на экз интерфейса StringFunc
        StringFunc reserve = (str) -> {
            String result = "";
            int i;

            for(i = str.length()-1; i >= 0; i--)
                result +=str.charAt(i);
            return result;
        };
        //а теперь ссылку reverse можно передать в качестве первого параметра методу stringOp()
        System.out.println("Это обращенная строка: " + stringOp(reserve, inStr));
    }

}
