package main.java.com.Tunix70.javacore.chapter03;

class ScopeErr {
    public static void main(String[] args) {
        int bar = 1;
//        {
//            int bar = 2;// создается новая область действия
//        }               //Ошибка во время компиляции - переменая bar уже определена!
    }
}
