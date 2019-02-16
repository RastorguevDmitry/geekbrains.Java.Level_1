import java.util.Random;
import java.util.Scanner;

public class Lesson4 {

    public static char[][] map;
    public static final int SIZE = 3;
    public static final int DOT_TO_WIN = 3;
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static final char DOT_EMPTY = '*';
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Вы выиграли");
                break;
            }
            if (checkFull()) {
                System.out.println("Ничья");
                break;
            }
            compTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Комп выиграл");
                break;
            }
            if (checkFull()) {
                System.out.println("Ничья");
                break;
            }

        }

    }

    private static boolean checkFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
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
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите ваш ход Х и У");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    public static void compTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (isCellValid(x, y));
        System.out.println("Комп походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    private static boolean isCellValid(int x, int y) {
        if (x < 0 || x > SIZE - 1 || y < 0 || y > SIZE - 1) return true;
        if (map[y][x] == DOT_EMPTY) return false;
        return true;
    }

    public static boolean checkWin(char symb) {
        int volueOfWinCombination = SIZE /*выигрыш по строкам*/ +
                +SIZE /*выигрыш по столбцам*/ +
                + 2 /*по диагоналям*/ + (SIZE - DOT_TO_WIN) * 2 /*выигрыш по другим диагоналям*/;
        int[] win = new int[volueOfWinCombination];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symb) {
                    win[i] += 1;
                    win[j + SIZE] += 1;
                    if (i == j) win[SIZE + SIZE] += 1;
                    if (i == SIZE - 1 - j) win[SIZE + SIZE + 1] += 1;
                    // if ((SIZE - DOT_TO_WIN)>0)
                }
            }
        }
        for (int i = 0; i < volueOfWinCombination; i++) {
            if (win[i] == DOT_TO_WIN) return true;
        }
        return false;


    }

//        public static boolean checkWin(char symb) {
//        if (map[0][0] == symb && map[0][1] == symb && map[0][2] == symb) return true;
//        if (map[1][0] == symb && map[1][1] == symb && map[1][2] == symb) return true;
//        if (map[2][0] == symb && map[2][1] == symb && map[2][2] == symb) return true;
//        if (map[0][0] == symb && map[1][0] == symb && map[2][0] == symb) return true;
//        if (map[0][1] == symb && map[1][1] == symb && map[2][1] == symb) return true;
//        if (map[0][2] == symb && map[1][2] == symb && map[2][2] == symb) return true;
//        if (map[0][0] == symb && map[1][1] == symb && map[2][2] == symb) return true;
//        if (map[2][0] == symb && map[1][1] == symb && map[0][2] == symb) return true;
//        return false;
//    }


}
