package main.java.com.Tunix70.javacore.chapter06;

class Stack {
    int stck [] = new int[10];
    int tos;

    Stack() { //инициализировать вершину стека
        tos = -1;
    }
    // разместить элемент в стеке
        void push (int item){
            if(tos==9)
                System.out.println("Стек заполнен.");
            else
                stck[++tos] = item;
        }
     // извлечь элемент из стека
    int pop(){
        if(tos < 0){
            System.out.println("Стек не загружен.");
            return 0;
        }
        else
            return stck [tos--];

    }
}

