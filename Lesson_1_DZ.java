import java.util.Random;

import static java.lang.Math.sin;

public class Lesson_1_DZ {
    byte aByte;                                                                 // задание 2
    short aShort;
    int anInt;
    long aLong;
    float aFloat;
    double aDouble;
    char aChar;
    boolean aBoolean;


    public static void main(String[] args) {                                      // задание 1
        System.out.println(calculate(1, 2, 3, 4));                       // задание 3
        System.out.println(summaOt10Do20(5, 17));                             // задание 4
        isPlusOrMinus(-5);                                                           // задание 5
        System.out.println(isMinus(5));                                               // задание 6
        privetName("Вася");                                                          // задание 7
        isYearVesokosniy(1900);
        task8(true, true);
        task9(4, 5);
        task10(5, 10);
        task11(5, 15, 7);
        task13(25, 45);
        task14();
        task15(180);
        task16(5, 20);

        task18(5, 6, 7);
        task19(0,1);


    }

    //    3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
//    где a, b, c, d – входные параметры этого метода;
    public static float calculate(int a, int b, int c, int d) {
        return a * (b + (float) c / d);
    }

    //    4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах
//    от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
    public static boolean summaOt10Do20(int a, int b) {
        return ((a + b) >= 10 && (a + b) <= 20 ? true : false);
    }

    //    5. Написать метод, которому в качестве параметра передается целое число, метод должен
//    напечатать в консоль положительное ли число передали, или отрицательное; Замечание: ноль
//    считаем положительным числом.
    public static void isPlusOrMinus(int a) {
        System.out.println((a >= 0 ? "Положительное" : "Отрицательное"));// печатается результат работы метода
    }

    //    6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть
//true, если число отрицательное;
    public static boolean isMinus(int a) {
        return (a < 0 ? true : false); // возвращает результат работы метода: если a меньше 0 - true, больше 0 -false

    }

    // задание 7
//    Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод
//    должен вывести в консоль сообщение «Привет, указанное_имя!»;
    public static void privetName(String name) {
        System.out.println("Привет, " + name + "!");// печатается результат работы метода
    }

    // задание 8
// a и b - переменные типа boolean. Напишите метод, который доказывает, выражение true.
    public static void task8(boolean a, boolean b) {
        boolean resultat;
        //выражение (!(a && b) && (a || b)) || ((a && b) || !(a || b))
        resultat = (!(a && b) && (a || b)) || ((a && b) || !(a || b));
        System.out.println("Задание 8. Результат:  " + resultat);// печатается результат работы метода
    }

    // задание 9
// Переменные a и b типа int. Упростите выражение (!(a < b) && !(a > b)).
    public static void task9(int a, int b) {
        boolean resultat;
        resultat = a == b;
        System.out.println("Задание 9. Результат a == b:  " + resultat);// печатается результат работы метода
        System.out.println("Задание 9. Результат (!(a < b) && !(a > b)):  " + (!(a < b) && !(a > b)));// печатается результат работы метода
    }

    //задание 10
    // Напишите метод, который получает на вход два положительных числа и выводит true, если одно из них нацело делится на другое.
    public static void task10(int a, int b) {
        boolean resultat;
        resultat = a >= b ? ((a % b) == 0) : ((b % a) == 0);

        System.out.println("Задание 10. одно из переданных цисел нацело делится на другое:  " + resultat);// печатается результат работы метода
    }

    //задание 11  Напишите метод, котрый получает на вход 3 положительных числа и проверяет что одно из них больше суммы других двух.
    // (Применяется для проверки, могут ли числа быть сторонами треугольника)
    public static void task11(int a, int b, int c) {
        boolean resultat;
        if (a > b + c) resultat = true;
        else if (b > a + c) resultat = true;
        else if (c > a + b) resultat = true;
        else resultat = false;
        System.out.println("Задание 11. одно из переданных чисел больше суммы других двух:  " + resultat);// печатается результат работы метода
    }

    //12. Написать метод, который определяет является ли год високосным, и выводит сообщение в
//    консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й –
//    високосный.
    public static void isYearVesokosniy(int year) {
        String isYearVesokosniy;
        if (year % 4 == 0) {
            if (year % 400 == 0) isYearVesokosniy = "Високосный";
            else if (year % 100 == 0) isYearVesokosniy = "Не високосный";
            else isYearVesokosniy = "Високосный";
        } else isYearVesokosniy = "Не високосный";
        System.out.println(isYearVesokosniy);// печатается результат работы метода
    }

    //    13. Напишите метод, который получает на вход два целых числа и выводит случайное число в этом диапазоне.
    public static void task13(int a, int b) {
        int max, min;
        if (a >= b) {
            max = a;
            min = b;
        } else {
            max = b;
            min = a;
        }
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff + 1);
        i += min;
        System.out.println("Задание 13. Два числа: " + a + ", " + b + ". Значение между ними: " + i);// печатается результат работы метода
    }

    //    14. Напишите метод, который выводит сумму двух случайных чисел от 1 до 6. (имитация броска кубиков)
    public static void task14() {
        Random random = new Random();
        int a = 1 + random.nextInt(6);
        int b = 1 + random.nextInt(6);
        int c = a + b;
        System.out.println("Задание 14. Два числа:" + a + ", " + b + ". Сумма: " + c);// печатается результат работы метода
    }

    //    15. Напишите метод, который получает на вход число t и выводит в консоль результат выражения
//    sin(2t) + sin(3t)
    public static void task15(int t) {
        double otvet = sin(2 * t) + sin(3 * t);
        System.out.printf("Задание 15. sin(2 * %d) + sin(3 * %d) = %f \n", t, t, otvet);// печатается результат работы метода
    }


    //16. Напишите метод, который получает на вход целочисленные m и d и проверяет,
// что введённые m-месяц и d-день, лежат в промежутке от 20.03 до 20.06.
    public static void task16(int m, int d) {
        boolean otvet;
        if ((m == 3 && d <= 31 && d >= 20) || (m == 4 && d <= 30 && d >= 1) || (m == 5 && d <= 31 && d >= 1) || (m == 6 && d <= 20 && d >= 1))
            otvet = true;
        else otvet = false;
        System.out.printf("Задание 16. введённые m-месяц (%d)  и d-день (%d), лежат в промежутке от 20.03 до 20.06: %s \n", m, d, otvet);// печатается результат работы метода
    }

    //            17. Напишите метод, который на вход получает информацию о цвете в формате RGB и переводит ии в формат CMYK. Результат вывести в консоль.
//---
//            18. Напишите метод, который получает на вход 3 целых числа, сравнивает их, и выводит в консоль "Все три числа равны" или "не равны".
    public static void task18(int a, int b, int c) {
        String otvet;
        if (a == b && b == c) otvet = "Все три числа равны";
            //else if (a == b || b == c || a == c) otvet = "Два числа равны";
        else otvet = "не равны";
        System.out.println("Задание 18: " + otvet);// печатается результат работы метода
    }

    //            19. Напишите метод, который проверяет, что переменные x и y типа double лежат строго в пределах от 0 до 1.
    public static void task19(double x, double y) {
        String otvet;
        if (x >= 0 && x <= 1 && y >= 0 & y <= 1) otvet = "в пределах от 0 до 1";
        else otvet = "не в пределах от 0 до 1";
        System.out.println("Задание 19: " + otvet);// печатается результат работы метода
    }

}
