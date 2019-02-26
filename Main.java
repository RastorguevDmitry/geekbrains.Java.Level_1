package Lesson7;


public class Main {

    public static void main(String[] args) {

        int countOfHungryCat = 0;
        Plate plate = new Plate(2000);
        Cat[] cat = new Cat[5];
        for (int i = 0; i < 5; i++) {
            cat[i] = new Cat();
        }

        for (int i = 0, j = 0; i < 24; i++) {
            for (Cat cats : cat) {
                plate.info();
                switch (cats.eat(plate)) {
                    case "Коту недостаточно еды": countOfHungryCat++;
                    case "Кот не голодный":
                    case "Кот поел":
                }

            }

        }

    }
}
