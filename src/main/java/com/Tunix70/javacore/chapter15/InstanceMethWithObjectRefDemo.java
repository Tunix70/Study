package src.main.java.com.Tunix70.javacore.chapter15;
//использовать ссылку на метод экземпляра вместе с разными объектами
// 458

interface MyFunc3<T>{
    boolean func(T v1, T v2);
}

class HigtTemp{
    private int hTemp;
    HigtTemp(int ht) {hTemp = ht; }

/* возвратить логическое значение true, если вызываюший объект типа HighTemp
имеет такую же температуру, как и у объекта ht2
 */
    boolean sameTemp(HigtTemp ht2) {
        return hTemp == ht2.hTemp;
    }
/* возвратить логическое значение true, если вызываюший объект типа HighTemp
имеет температуру ниже, чем у объекта ht2  */
    boolean lessThanTemp(HigtTemp ht2) {
        return hTemp < ht2.hTemp;
    }
}

class InstanceMethWithObjectRefDemo {
    /* метод. возвращающий количество экземпляров объекта, найденных по критериям, задаваемым
    параметром фунц интерфейса MyFunc
     */
    static <T> int counter(T[] vals, MyFunc3<T> f, T v){
        int count = 0;

        for (int i = 0; i < vals.length; i++)
            if(f.func(vals[i], v)) count++;

            return count;
    }

    public static void main(String[] args) {
        int count;
       HigtTemp[] weekDayHighs = {new HigtTemp(89), new HigtTemp(82),
                                  new HigtTemp(90), new HigtTemp(89),
                                  new HigtTemp(89), new HigtTemp(91),
                                  new HigtTemp(84), new HigtTemp(83)};
       count = counter(weekDayHighs, HigtTemp :: sameTemp, new HigtTemp(89));
        System.out.println("Дней, максимальная температура была 89: " + count);

        HigtTemp[] weekDayHighs2 = {new HigtTemp(89), new HigtTemp(82),
                                   new HigtTemp(90), new HigtTemp(89),
                                   new HigtTemp(89), new HigtTemp(91),
                                   new HigtTemp(84), new HigtTemp(83)};
        count = counter(weekDayHighs2, HigtTemp :: sameTemp, new HigtTemp(12));
        System.out.println("Дней, максимальная температура была 12: " + count);

//    а теперь воспользоваться методом lessThanTemp(), чтобы выяснить, сколько дней
//    температура была меньше заданной
        count = counter(weekDayHighs, HigtTemp::lessThanTemp, new HigtTemp(89));
        System.out.println("Дней, максимальная температура была меньше 89: " + count);

        count = counter(weekDayHighs2, HigtTemp::lessThanTemp, new HigtTemp(19));
        System.out.println("Дней, максимальная температура была меньше 19: " + count);
       }
}
