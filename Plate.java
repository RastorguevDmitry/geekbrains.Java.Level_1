package Lesson7;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("В миске " + food + " еды");
    }

    public String decreasefood(int appetite) {
        if (food - appetite >= 0) {
            food -= appetite;
            return "Еды достаточно";
        } else {
            return "Не достаточно еды";
        }
    }

    public void addFood(int amountOfNeedFood) {
        food += amountOfNeedFood;
        System.out.println("В миску добавили " + amountOfNeedFood + " еды");

    }
}
