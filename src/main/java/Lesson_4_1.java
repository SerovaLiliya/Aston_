public class Lesson_4_1 {
    public static void main(String[] args) {
        Dog dogBobik = new Dog("Бобик");
        Cat catMurka = new Cat("Черныш");

        dogBobik.run(400);
        dogBobik.swim(10);
        dogBobik.swim(15);
        catMurka.run(150);
        catMurka.run(250);
        catMurka.swim(5);


        System.out.println("\nВсего животных: " + Animal.getAnimalCount());
        System.out.println("Собак: " + Dog.getDogCount());
        System.out.println("Котов: " + Cat.getCatCount());

        System.out.println("\n--- Кормление котов ---");
        Cat[] cats = {
                new Cat("Барсик"),
                new Cat("Мурзик"),
                new Cat("Снежок")
        };

        Bowl bowl = new Bowl(25);
        int portion = 10;

        for (Cat cat : cats) {
            cat.eat(bowl, portion);
        }

        System.out.println("\nСытость котов:");
        for (Cat cat : cats) {
            System.out.println(cat.getName() + " — " + (cat.isFull() ? "сыт" : "голоден"));
        }

        System.out.println("\nДобавляем еды в миску:");
        bowl.addFood(10);

    }
}

class Animal {
    protected String name;
    private static int animalCount = 0;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + " м.");
    }

    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " м.");
    }

    public static int getAnimalCount() {
        return animalCount;
    }
}

class Dog extends Animal {
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

class Cat extends Animal {
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

class Bowl {
    private int food;

    public Bowl(int food) {
        this.food = Math.max(food, 0);
    }

    public int getFood() {
        return food;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            food += amount;
            System.out.println("Добавлено " + amount + " ед. еды. Теперь в миске: " + food);
        } else {
            System.out.println("Нельзя добавить отрицательное количество еды.");
        }
    }

    public void decreaseFood(int amount) {
        if (food >= amount) {
            food -= amount;
        }
    }


}
