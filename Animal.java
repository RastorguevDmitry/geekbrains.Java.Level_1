package Lesson6;

public abstract class Animal {

    protected String name;
    protected int age;
    protected int weight;

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

    public void voic() {
        System.out.println("Зверь " + name + " издал звук");
    }
/*2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания),
или высоту (для прыжков).*/

    public void run(int maxDistanseRun, int distanse) {
        System.out.print("run: ");
        if (distanse < maxDistanseRun) System.out.println("true");
        else System.out.println("не добежал");
    }

    public void swim(int maxDistanseRun, int distanse) {
        System.out.print("swim: ");
        if (distanse < maxDistanseRun) System.out.println("true");
        else System.out.println("не доплыл");
    }

    public void jump(double maxHightJump, double hight) {
        System.out.print("jump: ");
        if (hight < maxHightJump) System.out.println("true");
        else System.out.println("не допрыгнул");
    }

    public void animalInfo() {
        System.out.println("Зверь по имени " + name);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
