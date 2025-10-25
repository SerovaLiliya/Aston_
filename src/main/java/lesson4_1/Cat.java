package lesson4_1;

public class Cat extends Animal {
    private static int catCount = 0;
    private static final int MAX_RUN = 200;
    private boolean isFull = false;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не смог пробежать " + distance + " м. (макс: " + MAX_RUN + ")");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public void eat(Bowl bowl, int amount) {
        if (isFull) {
            System.out.println(name + " уже сыт.");
            return;
        }
        if (bowl.getFood() >= amount) {
            bowl.decreaseFood(amount);
            isFull = true;
            System.out.println(name + " поел, сыт.");
        } else {
            System.out.println(name + " не поел — недостаточно еды.");
        }
    }

    public boolean isFull() {
        return isFull;
    }

    public String getName() {
        return name;
    }

    public static int getCatCount() {
        return catCount;
    }
}


