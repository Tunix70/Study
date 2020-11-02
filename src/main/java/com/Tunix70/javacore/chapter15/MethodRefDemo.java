package src.main.java.com.Tunix70.javacore.chapter15;
//ссылка на статистический метод

interface StringFunc1{
    String func(String n);
}
//в этом классе определяется стат метод strReverse()
class MyStringOps{
    static String strReverse(String str){
        String result = "";
        int i;

        for (i = str.length()-1; i >= 0 ; i--)
            result += str.charAt(i);
        return result;
    }
}
//в этом методе функциональный интерфейс указывается в качестве типа первого его
//параметра. Те ему может быть передан любой экземпляр этого интерфейса, вкл и ссылку на метод

class MethodRefDemo {
    static String stringOp(StringFunc1 sf, String s){
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Лямбда-выражение повышает эффективность JAVA";
        String outStr;
        //здесь ссылка на метод strReverce() передается методу stringOp()
        outStr = stringOp(MyStringOps :: strReverse, inStr);
        System.out.println("Исходная строка: " + inStr);
        System.out.println("Обращенная строка: " + outStr);
    }
}
