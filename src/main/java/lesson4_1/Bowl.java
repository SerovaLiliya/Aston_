package lesson4_1;

public class Bowl {
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

