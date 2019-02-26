package Lesson7;

import java.io.UnsupportedEncodingException;
import java.util.Random;

public class Cat {

    private static int catsWantToEat;
    private static String hungry = "";
    private static int amountOfNeedFood = 0;


    private String name;
    private int appetite;
    private boolean full;
    private long whenCatEat;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.full = false;
    }

    public Cat() {
        Random random = new Random();
        this.name = randomName();
        this.appetite = random.nextInt(100) + 100;
        this.full = false;
    }

    public Cat(int appetite) {
        this.name = randomName();
        this.appetite = appetite;
        this.full = false;
    }


    private String randomName() {
        Random random = new Random();
        String catName = "";
        for (int j = 0; j < 5; j++) {
            try {
                catName += new String(
                        new byte[]{
                                (byte) (random.nextInt(25) + 65) //new String(bytes, "UTF-8"); 176-207 маленькие 65-90 большие
                        }, "UTF-8"
                );
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return catName;

    }


    public String eat(Plate plate) {
        Random random = new Random();
        if (this.full == false || (System.currentTimeMillis() - whenCatEat) > (10000/appetite)) {
            if ("Еды достаточно".equals(plate.decreasefood(appetite))) {
                System.out.println("Кот " + name + " поел. У него аппетит " + appetite);
                this.full = true;
                whenCatEat = System.currentTimeMillis();
                return "Кот поел";
            } else {
                System.out.println("В миске не достаточно еды. Кот " + name + " не поел. У него аппетит " + appetite);
                catsWantToEat += 1;
                amountOfNeedFood += appetite;
                hungry += " " + name;
                if (catsWantToEat >= 2) {
                    System.out.println("Уже два кота (" + hungry + ") просят есть. ");
                    plate.addFood(amountOfNeedFood);
                    hungry = "";
                    amountOfNeedFood = catsWantToEat = 0;
                }
                return "Коту недостаточно еды";
            }
        } else {
            System.out.println("Кот " + name + " не хочет есть");
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Кот не голодный";
        }

    }
}
