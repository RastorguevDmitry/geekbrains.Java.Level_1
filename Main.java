package Lesson6;

public class Main {


    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.run(550);
        cat.swim();
        cat.jump(1);
        System.out.println();

        Dog dog = new Dog();
        dog.run(550);
        dog.swim(5);
        dog.jump(0.2);
        System.out.println();

        Cat cat2 = new Cat();
        cat2.run(550);
        cat2.swim();
        cat2.jump(1);
        System.out.println();


    }

}
