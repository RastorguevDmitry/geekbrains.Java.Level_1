package Lesson6;

import java.util.Random;

public class Cat extends Animal {

    Random random = new Random();

    protected int maxDistanseRun = random.nextInt(10) * 10 + 200;
    protected int maxDistanseSwim = 0;
    protected double maxHightJump = (double) random.nextInt(200) / 100 + 1.5;

    /*3. У каждого животного есть ограничения на действия
    (бег: кот 200 м., собака 500 м.; прыжок: кот 2 м., собака 0.5 м.;
    плавание: кот не умеет плавать, собака 10 м.).
    4. При попытке животного выполнить одно из этих действий,
    оно должно сообщить результат в консоль.
    (Например, dog1.run(150); -> результат: run: true)
    5. * Добавить животным разброс в ограничениях.
    То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.
    */

    public void run(int distanse) {
        super.run(maxDistanseRun, distanse);
    }

    public void swim() {
        System.out.println("Кошка не плавает");
    }

    public void jump(double hight) {
        super.jump(maxHightJump, hight);
      //  System.out.println(maxHightJump);

    }
}
