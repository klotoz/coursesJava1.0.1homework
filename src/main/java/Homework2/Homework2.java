package Homework2;

import java.util.Arrays;

public class Homework2 {
    public static void main(String[] args) {

    int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
    int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
    int[] arr6 = new int[10];
    int[] arr7 = {2, 2, 2, 1, 2, 2, 10, 1};

        for (int i = 0; i < arr6.length; i++) {
            arr6[i] = (int) Math.round((Math.random() * 100) - 50);
        }

    printReplaceNumbers(arr);
    printSeqStepThree(8, 3);
    printMultiplyLessThanSix(arr3, 6, 2);
    printDiagonals(11);

    System.out.print(Arrays.toString(arr6));
    System.out.println();
    minNumber(arr6);
    maxNumber(arr6);
    System.out.println(checkBalance(arr7));
    bias(arr6, 2);


    }

    /**
     * Метод меняет в массиве нули на единицы и выводит результат на экран
     * @param arr входящий массив
     * */

    public static void printReplaceNumbers (int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1){
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    /**
     * Метод создает и выводит на экран массив из n чисел, каждое последующее число больше предыдущего на m.
     * @param n длина массива
     * @param m на сколько нужно увеличить числа
     * */

    public static void printSeqStepThree (int n, int m){
        int[] arr2 = new int[n];
        for (int i = 1; i <n; i++) {
                arr2[i] = arr2[i-1]+m;
        }
        System.out.println(Arrays.toString(arr2));
    }

    /**
     * Метод увеличивет на a все числа массива, которые меньше b.
     * @param arr массив
     * */

    public static void printMultiplyLessThanSix (int[] arr, int a, int b){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < a){
                arr[i] *= b;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    /**
     * Создает и выводит на экран квадратный двумерный массив, диагонали которого заполнены единицами
     * @param n размер массива
     * */

    public static void printDiagonals (int n){
        int[][] arr4 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    arr4[i][j] = 1;
                }
                else if (j+i == n-1){
                    arr4[i][j] = 1;
                }

                System.out.print(arr4[i][j] + " ");

            }
            System.out.println();
        }

    }
    /**
     * Находит элемент в массиве с минимальным значением
     * @param arr6 массив в котором искать
     * */

    public static void minNumber(int[] arr6) {


        int min = arr6[0];

        for (int j : arr6) {
            if (j < min) {
                min = j;
            }

        }

        System.out.println("Min is " + min);

    }

    /**
     * Находит элемент в массиве с максимальным значением
     * @param arr6 массив в котором искать
     * */

    public static void maxNumber(int[] arr6) {

        int max = arr6[0];
        for (int j : arr6) {

            if (j > max) {
                max = j;
            }
        }

        System.out.println("Max is " + max);

    }

    /**
     * Ищет, есть ли место в массиве, где сумма чисел слева равна сумме чисел справа
     * @param arr7 массив
     * */

    public static boolean checkBalance(int[] arr7) {
        for (int i = 0; i < arr7.length; i++) {
            int left = 0;
            int right = 0;
            for (int j = 0; j < i; j++) {
                left += arr7[j];
            }
            for (int k = i; k < arr7.length; k++) {
                right += arr7[k];
            }
            if (left == right) {
                return true;
            }

        }
        return false;
    }
    /**
     * Перемещает в массиве числа по кругу на заданное количество позиций.
     * @param a если число больше 0, то сдвиг направо, если меньше - сдвиг налево
     * */

    public static void bias (int[] arr8, int a){
        System.out.println("Массив " + Arrays.toString(arr8));
        if (a>0) {
            for (int i = 0; i < a; i++) {
                int buf = arr8[arr8.length - 1];
                for (int j = arr8.length - 1; j > 0; j--) {
                    arr8[j] = arr8[j - 1];
                }
                arr8[0] = buf;
            }
        } else {

            for (int i = 0; i < a*(-1); i++) {
                int buf = arr8[0];
                for (int j = 0; j < arr8.length - 1; j++) {
                    arr8[j] = arr8[j + 1];
                }
                arr8[arr8.length - 1] = buf;
            }
        }

        System.out.println("смещен на " + a + "\n" + Arrays.toString(arr8));

    }

}
