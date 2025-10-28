package Lesson_3;

import java.time.LocalDate;

public class Lesson3_1 {
    public static void main(String[] args) {
        Tovar product = new Tovar(
                "Смартфон",
                LocalDate.of(2025, 10, 17),
                "SmartTech",
                "Корея",
                59999.99,
                false
        );
        product.printInfo();
    }
}
