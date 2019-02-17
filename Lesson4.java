import java.util.Random;
import java.util.Scanner;

public class Lesson4 {

    public static char[][] map;
    public static final int SIZE = 5;
    public static final int DOT_TO_WIN = 4;
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static final char DOT_EMPTY = '*';
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static int volueOfWinCombination = SIZE /*выигрыш по строкам*/ +
            +SIZE /*выигрыш по столбцам*/ +
            +2 /*по диагоналям*/ + (SIZE - DOT_TO_WIN) * 2 + 2 /*выигрыш по другим диагоналям*/;
    public static int[] win = new int[volueOfWinCombination];

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
        int x = 0, y = 0;
        int maxZnachenieVeroyatnosty = 0;
        int pozichiyaMaxZnachenieVeroyatnosty = 0;
        for (int i = 0; i < volueOfWinCombination; i++) {
            if (win[i] > maxZnachenieVeroyatnosty) {
                maxZnachenieVeroyatnosty = win[i];
                pozichiyaMaxZnachenieVeroyatnosty = i + 1;
            }
        }
        do {
            // находим по какому выигрышу максимальная вероятноть
            switch (pozichiyaMaxZnachenieVeroyatnosty) {
//блокировка по строкам
                case 1:
                    y = pozichiyaMaxZnachenieVeroyatnosty - 1;
                    x = rand.nextInt(SIZE);
                    break;
                case 2:
                    y = pozichiyaMaxZnachenieVeroyatnosty - 1;
                    x = rand.nextInt(SIZE);
                    break;
                case 3:
                    y = pozichiyaMaxZnachenieVeroyatnosty - 1;
                    x = rand.nextInt(SIZE);
                    break;
                case 4:
                    y = pozichiyaMaxZnachenieVeroyatnosty - 1;
                    x = rand.nextInt(SIZE);
                    break;
                case 5:
                    y = pozichiyaMaxZnachenieVeroyatnosty - 1;
                    x = rand.nextInt(SIZE);
                    break;
                // блокировка по столбцам
                case 6:
                    x = pozichiyaMaxZnachenieVeroyatnosty - 1 - SIZE;
                    y = rand.nextInt(SIZE);
                    break;
                case 7:
                    x = pozichiyaMaxZnachenieVeroyatnosty - 1 - SIZE;
                    y = rand.nextInt(SIZE);
                    break;
                case 8:
                    x = pozichiyaMaxZnachenieVeroyatnosty - 1 - SIZE;
                    y = rand.nextInt(SIZE);
                    break;
                case 9:
                    x = pozichiyaMaxZnachenieVeroyatnosty - 1 - SIZE;
                    y = rand.nextInt(SIZE);
                    break;
                case 10:
                    x = pozichiyaMaxZnachenieVeroyatnosty - 1 - SIZE;
                    y = rand.nextInt(SIZE);
                    break;
//блокировка по диагонали
                case 11:
                    x = y = rand.nextInt(SIZE);
                    break;
                case 12:
                    y = rand.nextInt(SIZE);
                    x = SIZE - y - 1;
                    break;
//блокировка по другим диагоналям
// по паралельным главной диагонали
                case 13:
                    x = rand.nextInt(SIZE);
                    y = x - 1;
                    break;
                case 14:
                    y = rand.nextInt(SIZE - 1);
                    x = y - 1;
                    break;
// по паралельным другой диагонали
                case 15:
                    y = rand.nextInt(SIZE - 1);
                    x = SIZE - y - 2;
                    break;
                case 16:
                    x = rand.nextInt(SIZE) + 1;
                    y = SIZE - x;
                    break;
            }
        } while (isCellValid(x, y));
        System.out.println("Комп походил в точку " + (x + 1) + " " + (y + 1) /*+
                +maxZnachenieVeroyatnosty + "  " + pozichiyaMaxZnachenieVeroyatnosty*/);
        map[y][x] = DOT_O;
    }

    private static boolean isCellValid(int x, int y) {
        if (x < 0 || x > SIZE - 1 || y < 0 || y > SIZE - 1) return true;
        if (map[y][x] == DOT_EMPTY) return false;
        return true;
    }

    public static boolean checkWin(char symb) { //проверка выигрыша и расчет вероятности
        for (int i = 0; i < volueOfWinCombination; i++) {
            win[i] = 0;
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symb) {

                    //"вероятность" победы по строке
                    win[i] += (j == 0 || j == SIZE - 1) ? 9 : 10;

                    //"вероятность" победы по столбцу
                    win[j + SIZE] += (i == 0 || i == SIZE - 1) ? 9 : 10;

                    //"вероятность" победы по диагонали
                    if ((i == j) && (i == 0 || i == SIZE - 1)) win[SIZE + SIZE] += 9;
                    else if (i == j) win[SIZE + SIZE] += 10;

                    //"вероятность" победы по диагонали справа вниз
                    if (i == (SIZE - 1 - j) && (i == 0 || i == SIZE - 1)) win[SIZE + SIZE + 1] += 9;
                    else if (i == (SIZE - 1 - j)) win[SIZE + SIZE + 1] += 10;

                    /*выигрыш по другим диагоналям*/
                    if ((SIZE - DOT_TO_WIN) > 0) {
                        //над диагональю
                        if (i == (j - 1)) win[SIZE + SIZE + 2] += 10;
                        //над диагональю
                        if ((i - 1) == j) win[SIZE + SIZE + 3] += 10;

                        //над диагональю справа вниз
                        if (i == (SIZE - 2 - j)) win[SIZE + SIZE + 4] += 10;
                        //под диагональю справа вниз
                        if (i == (SIZE - j)) win[SIZE + SIZE + 5] += 10;
                    }


                } else if (map[i][j] == DOT_EMPTY) {
                } //если ячейка пустая, то ничего

//если ячейка занята не нашей фишкой вычитаем вероятность выигрыша
                //если ячейки заняты не нашей фишкой, и это сказывается на возможности выигрыша (к примеру 0.0 не кретично
                else {

                    //"вероятность" победы по строке
                    win[i] -= (j == 0 || j == SIZE - 1) ? 0 : 50;
                    win[i] -= ((j == 0 || j == SIZE - 1) && win[i] > 30) ? 50 : 0;

                    //"вероятность" победы по столбцу
                    win[j + SIZE] -= (i == 0 || i == SIZE - 1) ? 0 : 50;
                    win[j + SIZE] -= ((i == 0 || i == SIZE - 1) && win[j + SIZE] > 30) ? 50 : 0;

                    //"вероятность" победы по диагонали

                    if ((i == j) && !(i == 0 || i == SIZE - 1)) win[SIZE + SIZE] -= 50;
                    else if ((i == j) && (i == 0 || i == SIZE - 1) && win[SIZE + SIZE] > 30) win[SIZE + SIZE] -= 50;

                    //"вероятность" победы по диагонали справа вниз
                    if (i == (SIZE - 1 - j) && !(i == 0 || i == SIZE - 1)) win[SIZE + SIZE + 1] -= 50;
                    else if ((i == (SIZE - 1 - j)) && (i == 0 || i == SIZE - 1) && win[SIZE + SIZE + 1] > 30)
                        win[SIZE + SIZE + 1] -= 50;

                    if ((SIZE - DOT_TO_WIN) > 0) {
                        //над диагональю
                        if (i == (j - 1)) win[SIZE + SIZE + 2] -= 50;
                        //под диагональю
                        if ((i - 1) == j) win[SIZE + SIZE + 3] -= 50;
                        //над диагональю справа вниз
                        if (i == (SIZE - 2 - j)) win[SIZE + SIZE + 4] -= 50;
                        //под диагональю справа вниз
                        if (i == (SIZE - j)) win[SIZE + SIZE + 5] -= 50;
                    }
                }

            }
        }
        for (int i = 0; i < volueOfWinCombination; i++) {
            System.out.print(win[i] + " ");
        }
        for (int i = 0; i < volueOfWinCombination; i++) {
            if (win[i] >= DOT_TO_WIN * 10 - 1) return true;
        }
        return false;
    }
}
