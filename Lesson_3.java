import java.text.MessageFormat;
import java.util.Random;
import java.util.Scanner;

//2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
//        При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
//        сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь.
//        Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
//        apple – загаданное
//        apricot - ответ игрока
//        ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
//        Для сравнения двух слов посимвольно, можно пользоваться:
//        String str = "apple";
//        str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
//        Играем до тех пор, пока игрок не отгадает слово
//        Используем только маленькие буквы
public class Lesson {
    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int random, d;
        String str, string;
        Scanner scanner = new Scanner(System.in);
//        int  randomChar1, randomChar2;
//        String strWithBlank ="";

        do {
            random = (new Random()).nextInt(25);
            str = words[random]; //выбор случайного слова из массива

            // вариант с рандомным расположением отображаемых букв
//            randomChar1 = (new Random()).nextInt(str.length() - 1);
//            randomChar2 = (new Random()).nextInt(str.length() - 1);
//            for (int i = 0; i < 14; i++) {
//                if (i == randomChar1) strWithBlank = strWithBlank + str.charAt(randomChar1);
//            else if (i == randomChar2) strWithBlank = strWithBlank + str.charAt(randomChar2);
//            else strWithBlank = strWithBlank + "#";
//        }
//        System.out.println(MessageFormat.format(
//                "Угадайте слово:  {0}" , strWithBlank
//        ));

            System.out.println(MessageFormat.format(
                    "Угадайте слово:  {0}{1}#############"
                    , str.charAt(0), str.charAt(1)
            ));
            System.out.println("Введите слово:");
            string = scanner.nextLine(); //считываем строку, введенную пользователем
            d = str.compareTo(string); //сравниваем введенное с загаданным
            System.out.println(d == 0 ? "Вы угадали" : "Вы не угадали, загаданное слово: " + str);
        } while (d != 0);
    }
}