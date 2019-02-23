package Lesson6;

import java.util.Random;

public class Dog extends Animal {

    Random random = new Random();
    protected int maxDistanseRun = random.nextInt(10) * 10 + 400;
    protected int maxDistanseSwim = random.nextInt(10) * +5;
    protected double maxHightJump = (double) random.nextInt(200) / 100 + 0.5;


    /*3. У каждого животного есть ограничения на действия
    (бег: кот 200 м., собака 500 м.; прыжок: кот 2 м., собака 0.5 м.;
    плавание: кот не умеет плавать, собака 10 м.).
    4. При попытке животного выполнить одно из этих действий,
    оно должно сообщить результат в консоль.
    (Например, dog1.run(150); -> результат: run: true)
    */

    public void run(int distanse) {
        super.run(maxDistanseRun, distanse);
    }

    public void swim(int distanse) {
        super.run(maxDistanseRun, distanse);
    }

    public void jump(double hight) {
        super.jump(maxHightJump, hight);
    }
}
