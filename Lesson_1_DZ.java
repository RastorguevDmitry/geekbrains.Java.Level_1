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
    }


    public static float calculate(int a, int b, int c, int d) {                   // задание 3
        return a * (b + (float) c / d);
    }

    public static boolean summaOt10Do20(int a, int b) {                             // задание 4
        return ((a + b) >= 10 && (a + b) <= 20 ? true : false);
    }

    public static void isPlusOrMinus(int a) {                             // задание 5
        System.out.println((a >= 0 ? "Положительное" : "Отрицательное"));// печатается результат работы метода
    }

    public static boolean isMinus(int a) {                             // задание 6
        return (a < 0 ? true : false); // возвращает результат работы метода: если a меньше 0 - true, больше 0 -false

    }

    public static void privetName(String name) {                             // задание 7
        System.out.println("Привет, " + name + "!");// печатается результат работы метода

    }


//*Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
//    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.

    public static void isYearVesokosniy(int year) {
        String isYearVesokosniy;
        if (year % 4 == 0) {
            if (year % 400 == 0) isYearVesokosniy = "Високосный";
            else if (year % 100 == 0) isYearVesokosniy = "Не високосный";
            else isYearVesokosniy = "Високосный";
        } else isYearVesokosniy = "Не високосный";


        System.out.println(isYearVesokosniy);// печатается результат работы метода

    }


}
