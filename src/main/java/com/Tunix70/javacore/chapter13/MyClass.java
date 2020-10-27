package Tunix70;

class MyClass {
    int a;
    int b;
    //инициализировать поля a и b по отдельности
    MyClass(int i, int j){
        a = i;
        b = j;
    }
    //инициализировать поля a и b одним и тем же значением
    MyClass(int i){
        this(i, i);//по этому ссылке вызывается конструктор MyClass(i, i)
    }
    //присвоить полям a и b нулевое значение по умолчанию
    MyClass(){
        this(0);//по этой ссылке вызывается конструктор MyClass(0)
    }

    public static void main(String[] args) {
        MyClass mc = new MyClass(0);
    }
}
