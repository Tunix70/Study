package main.java.com.Tunix70.javacore.chapter15;
// применить обобщенный функциональный интерфейс с разнотипными Л-В
interface SomeFunc<T>{
    T func(T t);
}
class GenericFunctionalInterfaceDemo {
    public static void main(String[] args) {
        //использовать строковый вариант интерфейса SomeFunc
        SomeFunc<String> reverse = (str) -> {
            String result = "";
            for (int i = str.length()-1; i >=0 ; i--) {
                result += str.charAt(i);
            }
            return result;
        };
        System.out.println("Лямбда обращается на " + reverse.func("Лямбда"));
        System.out.println("Выражение обращается на " + reverse.func("Выражение"));

        SomeFunc<Integer> factorial = (n) -> {
            int result = 1;
            for (int i = 1; i <= n ; i++)
                result = i * result;
            return result;

        };
        System.out.println("Факториал числа 3 равен " + factorial.func(3));
        System.out.println("Факториал числа 5 равен " + factorial.func(5));

    }
}
