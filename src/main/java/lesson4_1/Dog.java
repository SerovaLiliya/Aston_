package lesson4_1;

public class Dog extends Animal {
    private static int dogCount = 0;
    private static final int MAX_RUN = 500;
    private static final int MAX_SWIM = 10;

    public Dog(String name) {
        super(name);
        dogCount++;
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
        if (distance <= MAX_SWIM) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не смог проплыть " + distance + " м. (макс: " + MAX_SWIM + ")");
        }
    }

    public static int getDogCount() {
        return dogCount;
    }
}
