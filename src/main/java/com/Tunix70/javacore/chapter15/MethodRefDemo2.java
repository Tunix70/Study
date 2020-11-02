package src.main.java.com.Tunix70.javacore.chapter15;
//применение ссылки на метод экземпляра
interface StringFunc2{
    String func(String n);
}

class MyStringOps1{
    String strReverse(String str){
        String result = "";

        for (int i = str.length()-1; i >= 0 ; i--)
            result +=str.charAt(i);
        return result;
        }
}

class MethodRefDemo2 {
    /* в этом методе функциональный интерфейс указывается в качестве типа первого его параметра.
    Следовательно, ему может быть передан любой экземпляр этого интерфейса, включая и ссылку на метод
    */
    static String stringOp(StringFunc2 sf, String s){
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Лямбда выражения повышают эффективность JAVA";
        String outStr;

        //создать объект типа MyStringOps
        MyStringOps1 strOps = new MyStringOps1();
        outStr = stringOp(strOps :: strReverse, inStr);
        System.out.println("Исходная строка: " + inStr);
        System.out.println("Обращенная строка: " + outStr);
    }
}
