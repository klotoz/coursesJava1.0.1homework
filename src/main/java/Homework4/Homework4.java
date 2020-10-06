package Homework4;

import java.util.Random;
import java.util.Scanner;

public class Homework4 {
    public static int SIZE = 3;
    public static int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn(DOT_O);
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }
    public static boolean checkWin(char symb) {
    if (checkH(symb)) return true;
    if (checkV(symb)) return true;
    if (checkDA(symb)) return true;
    if (checkDB(symb)) return true;

    return false;

    }

    public static boolean checkH(char symb) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j <= SIZE-DOTS_TO_WIN; j++) {
                int count=0;
                for (int k = 0; k < DOTS_TO_WIN; k++) {
                    if(map[i][j+k] == symb){
                        count++;
                    } else count =0;
                    if (count == DOTS_TO_WIN) return true;
                }
            }
        }
        return false;
    }

    public static boolean checkV(char symb) {
        for (int i = 0; i <= SIZE-DOTS_TO_WIN; i++) {
            for (int j = 0; j < SIZE; j++) {
                int count = 0;
                for (int k = 0; k < DOTS_TO_WIN; k++) {
                     if (map[i+k][j] == symb){
                         count++;
                     } else count =0;
                     if (count == DOTS_TO_WIN) return true;
                }
            }
        }
        return false;
    }

    public static boolean checkDA(char symb) {
        for (int i = 0; i <= SIZE-DOTS_TO_WIN; i++) {
            for (int j = 0; j <= SIZE-DOTS_TO_WIN; j++) {
                int count = 0;
                for (int k = 0; k < DOTS_TO_WIN; k++) {
                    if (map[i+k][j+k] == symb){
                        count++;
                    } else count =0;
                    if (count == DOTS_TO_WIN) return true;
                }
            }
        }
        return false;
    }

    public static boolean checkDB(char symb) {
        for (int i = 0; i <= SIZE-DOTS_TO_WIN; i++) {
            for (int j = DOTS_TO_WIN-1; j < SIZE ; j++) {
                int count = 0;
                for (int k = 0; k < DOTS_TO_WIN; k++) {
                    if (map[i+k][j-k] == symb){
                        count++;
                    } else count=0;
                    if (count == DOTS_TO_WIN) return true;
                }
            }
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
    public static void aiTurn(char c) {
        int x;
        int y;
        int countH;
        int countHNull;
        int countV;
        int countVNull;
        int countDA = 0;
        int countDB = 0;
        int countDANull = 0;
        int countDBNull = 0;

        // Атакуем
        for (int i = 0; i < SIZE; i++) {
            countH = 0;
            countHNull = 0;
            countV = 0;
            countVNull = 0;
            for (int j = 0; j < SIZE; j++) {

                //проверка горизонтали
                if (map[i][j] == c) countH++;
                else if (map[i][j] == DOT_EMPTY) countHNull++;
                if ((countH == SIZE - 1) && (countHNull == 1)) {
                    for (int k = 0; k < SIZE; k++) {
                        if (map[i][k] == DOT_EMPTY) {
                            map[i][k] = c;
                            return;
                        }
                    }
                }

                // проверка вертикали
                if (map[j][i] == c) countV++;
                else if (map[j][i] == DOT_EMPTY) countVNull++;
                if ((countV == SIZE - 1) && (countVNull == 1)) {
                    for (int k = 0; k < SIZE; k++) {
                        if (map[k][i] == DOT_EMPTY) {
                            map[k][i] = c;
                            return;
                        }
                    }
                }


            }

            // проверка диагонали А
            if (map[i][i] == c) countDA++;
            else if (map[i][i] == DOT_EMPTY) countDANull++;
            if ((countDA == SIZE - 1) && (countDANull == 1)) {
                for (int j = 0; j < SIZE; j++) {
                    if (map[j][j] == DOT_EMPTY) {
                        map[j][j] = c;
                        return;
                    }
                }
            }

            // проверка диагонали Б
            if (map[i][SIZE - 1 - i] == c) countDB++;
            else if (map[i][SIZE - 1 - i] == DOT_EMPTY)  countDBNull++;
            if ((countDB == SIZE - 1) && (countDBNull == 1)) {
                for (int j = 0; j < SIZE; j++) {
                    if (map[j][SIZE - 1 - j] == DOT_EMPTY) {
                        map[j][SIZE - 1 - j] = c;
                        return;
                    }
                }
            }
        }

        countDA = 0;
        countDB = 0;
        countDANull = 0;
        countDBNull = 0;

        // Блокируем
        for (int i = 0; i < SIZE; i++) {
            countH = 0;
            countHNull = 0;
            countV = 0;
            countVNull = 0;
            for (int j = 0; j < SIZE; j++) {
                //проверка горизонтали
                if (map[i][j] == DOT_X) countH++;
                else if (map[i][j] == DOT_EMPTY) countHNull++;
                if ((countH == SIZE - 1) && (countHNull == 1)) {
                    for (int k = 0; k < SIZE; k++) {
                        if (map[i][k] == DOT_EMPTY) {
                            map[i][k] = c;
                            return;
                        }
                    }
                }
                //проверка вертикали
                if (map[j][i] == DOT_X) countV++;
                else if (map[j][i] == DOT_EMPTY) countVNull++;
                if ((countV == SIZE - 1) && (countVNull == 1)) {
                    for (int k = 0; k < SIZE; k++) {
                        if (map[k][i] == DOT_EMPTY) {
                            map[k][i] = c;
                            return;
                        }
                    }
                }
            }

            // проверка диагонали А
            if (map[i][i] == DOT_X) countDA++;
            else if (map[i][i] == DOT_EMPTY) countDANull++;
            if ((countDA == SIZE - 1) && (countDANull == 1)) {
                for (int j = 0; j < SIZE; j++) {
                    if (map[j][j] == DOT_EMPTY) {
                        map[j][j] = c;
                        return;
                    }
                }
            }

            // проверка диагонали Б
            if (map[i][SIZE - 1 - i] == DOT_X) countDB++;
            else if (map[i][SIZE - 1 - i] == DOT_EMPTY)  countDBNull++;
            if ((countDB == SIZE - 1) && (countDBNull == 1)) {
                for (int j = 0; j < SIZE; j++) {
                    if (map[j][SIZE - 1 - j] == DOT_EMPTY) {
                        map[j][SIZE - 1 - j] = c;
                        return;
                    }
                }
            }
        }

        // 3. Нужно занять центр!
        if (!(SIZE % 2 == 0)) {
            int center = (((SIZE + 1) / 2) - 1);
            if (map[center][center] == DOT_EMPTY) {
                map[center][center] = c;
                return;
            }
        }

        // 4. Нужно занять углы!
        if (map[0][0] == DOT_EMPTY) {
            map[0][0] = c;
            return;
        }
        if (map[0][map.length - 1] == DOT_EMPTY) {
            map[0][map.length - 1] = c;
            return;
        }
        if (map[map.length - 1][0] == DOT_EMPTY) {
            map[map.length - 1][0] = c;
            return;
        }
        if (map[map.length - 1][map.length - 1] == DOT_EMPTY) {
            map[map.length - 1][map.length - 1] = c;
            return;
        }

        // 5. рандомный ход, если ничего не осталось
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        map[y][x] = c;
    }


    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }
    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
