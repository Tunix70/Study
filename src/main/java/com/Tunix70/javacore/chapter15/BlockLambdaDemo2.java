package main.java.com.Tunix70.javacore.chapter15;

interface StringFunc{
    String func(String n);
}

class BlockLambdaDemo2 {
    public static void main(String[] args) {
        //изменяет порядок следования символов на обратный
        StringFunc reverse = (str) -> {
            String result = "";
            for (int i = str.length()-1; i >=0 ; i--) {
                result +=str.charAt(i);
            }
            return result;
        };
        System.out.println("Лямбда обращается на " + reverse.func("Лямбда"));
        System.out.println("Выражение обращается на " + reverse.func("Выражение"));
    }
}
