package lesson4_1;

public class lesson4_1 {
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

