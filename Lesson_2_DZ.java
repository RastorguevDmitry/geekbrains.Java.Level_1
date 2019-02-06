import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] massiv = {0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0};
        int[] massiv8 = new int[8];
        massiv0To1(massiv);
        massiv8Zapolnit(massiv8);
        massivZadaniye3();
        massivZadaniye4();
        massivZadaniye5();
     //   massivZadaniye6();
    }

//1. Задать целочисленный массив, состоящий из элементов 0 и 1.
//        Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
//        С помощью цикла и условия заменить 0 на 1, 1 на 0;

    private static void massiv0To1(int massiv[]) {
        for (int i = 0; i < massiv.length; i++) {
            massiv[i] = massiv[i] == 0 ? 1 : 0;
        }
        System.out.println(Arrays.toString(massiv));
    }

    //    2. Задать пустой целочисленный массив размером 8.
//    С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    private static void massiv8Zapolnit(int massiv8[]) {
        for (int i = 0; i < massiv8.length; i++) {
            massiv8[i] = i * 3;
        }
        System.out.println(Arrays.toString(massiv8));
    }

    //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
//    пройти по нему циклом, и числа меньшие 6 умножить на 2;
    private static void massivZadaniye3() {
        int[] massiv = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < massiv.length; i++) {
            massiv[i] = massiv[i] < 6 ? massiv[i] * 2 : massiv[i];
        }
        System.out.println(Arrays.toString(massiv));
    }

    //    4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
//    и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    private static void massivZadaniye4() {
        int[][] massiv = new int[9][9];
        for (int i = 0, j = 0; i < massiv.length; i++, j++) {
            massiv[i][j] = 1;
            massiv[i][massiv.length - j - 1] = 1;
        }
        for (int[] row : massiv) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //5. ** Задать одномерный массив и найти в нем минимальный и
//    максимальный элементы (без помощи интернета);
    private static void massivZadaniye5() {
        int[] massiv = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int max, min;
        max = massiv[0];
        min = massiv[0];
        for (int i = 1; i < massiv.length; i++) {
            max = max < massiv[i] ? massiv[i] : max;
            min = min > massiv[i] ? massiv[i] : min;

        }
        System.out.println(Arrays.toString(massiv));
        System.out.println("Максимум: " + max + "\nМинимум: " + min);
    }

//    6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
//    метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой
//    части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
//    checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||,
//    эти символы в массив не входят.

//    private static boolean massivZadaniye6() {
//        int[] massiv = {2, 2, 2, 1, 2, 2, 10, 1};
//        int sumLeft = 0, sumRight = 0;
//        boolean vernut = false;
//        for (int i = 0, j = massiv.length-1; i < massiv.length; ) {
//
//            if ((sumLeft - sumRight) > 0 && (j - i)>0) {
//                sumRight += massiv[j];
//                j--;
//            } else if ((sumLeft - sumRight) < 0 && (j - i)>0 ) {
//                sumLeft += massiv[i];
//                i++;
//            } else if ((sumLeft - sumRight) == 0 && (j - i)>0 ) {
//                sumRight += massiv[j];
//                j--;
//            } else if ((sumLeft - sumRight) == 0 && (j - i)==0 ) {
//                vernut = true;
//            } else vernut = false;
//
//
//        }
//        System.out.println(vernut);
//
//
//        return vernut;
//    }


//    7. **** Написать метод, которому на вход подается одномерный массив и число n
//            (может быть положительным, или отрицательным), при этом метод должен сместить
//    все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться
//    вспомогательными массивами.



}