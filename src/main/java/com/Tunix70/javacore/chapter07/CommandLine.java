package d24;

public class CommandLine { //ввод данных в командную строку
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "]" + args[i]);
        }
    }
}
