package homework;

public class Homework1 {
    public static void main(String[] args) {

        // 2. Создание типов и инициализация их значений
        byte z = -13;
        short y = 32767;
        int x = 1000;
        long w = 200000L;
        float e = 12.23f;
        double f = -123.123;
        char g = '\u2242';
        boolean h = true;

        System.out.println(z);
        System.out.println(y);
        System.out.println(x);
        System.out.println(w);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);


        System.out.println(calc(3, 5,6,4));
        System.out.println(rangeSum(5, 7));
        posOrNeg(8);
        System.out.println(negative(333));
        printName("Клава");
        identifyLeap(1700);
        identifyLeapToo(2020);

    }

    // 3. Метод, вычисляющий выражение с входными параметрами.
    public static float calc (float a, float b, float c, float d) {


        return a * (b + (c / d));

    }

    //4. Метод, проверяющий, сумму входных параметров на принадлежность заданному диапазону.
    public static boolean rangeSum (int m, int n){

        return (n + m) >= 10 && (n + m) <= 20;
    }

    //5. Метод, определяющий, является число положительным или отрицательным
    public static void posOrNeg (int r){

        if (r >= 0) {
            System.out.println("Число " + r + " положительное");
        }
        else {
            System.out.println("Число " + r + " отрицательное");
        }

    }

    //6. Метод, возвращающий true, если число отрицательное
    public static boolean negative (int k){

        return k<0;
    }

    //7. Метод здоровающийся
    public static void printName (String s){

        System.out.println("Привет, " + s);
    }

    //8. Метод, определяющий, является ли год високосным
    public static void identifyLeap (int year){
        if ((year % 4 == 0 && year % 100 != 0) || (year % 100 == 0 && year % 400 == 0) ){
            System.out.println(year + " Год високосный");
        } else {
            System.out.println(year + " Год не високосный");
        }
    }

    //8.1 Еще один вариант определения високосного года, пока не понимаю, какой вариант лучше с точки зрения корректности кода

    public static void identifyLeapToo (int year){
        if ((year % 4 != 0) || ((year % 100 == 0) && (year % 400 != 0))){
            System.out.println(year + " Год не високосный");
        } else {
            System.out.println(year + " Год високосный");
        }
    }

}
