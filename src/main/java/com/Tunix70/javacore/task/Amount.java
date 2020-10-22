package main.java.com.Tunix70.javacore.task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MyComp {

    static int[] amountNumber(int[]arr, int amount){
        //преобразовываем массив в ArrayList
        List<Integer> al = new ArrayList<>();
        for(int intValue : arr){
            al.add(intValue);
        }
        Collections.sort(al);

        int number1 = 0;
        int number2 = 0;
        some:
        for (int i = 0; i < al.size(); i++) {
            for (int j = 1; j < al.size(); j++) {
                if(al.get(i) < amount && al.get(j) < amount & amount - al.get(i) == al.get(j)){
                    number1 = al.get(i); 
                    number2 = al.get(j);
                    break some;
                }
            }
        }
            return new int[]{number1, number2};
    }

    public static void main(String[] args) {
        int[] arr = {26, 8, 15, 3, 21, 2};
        int amount = 23;
        amountNumber(arr, amount);
    }
}