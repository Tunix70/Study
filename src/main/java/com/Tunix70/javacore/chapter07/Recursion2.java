package main.java.com.Tunix70.javacore.chapter07;

class RecTest {
    int values[];
    RecTest(int i){
        values = new int[i];
    }

    //вывести рекурсивно элементы массива
    void printArray(int i){
        if(i == 0)return;
            else printArray(i - 1);
        System.out.println("[" + (i - 1) + "]" + values[i-1]);
    }
}

public class Recursion2 {
    public static void main(String[] args) {
        RecTest ob = new RecTest(10);
        int i;
        for (i = 0; i < 10; i++)
            ob.values[i] = i;
            ob.printArray(10);

    }
}
