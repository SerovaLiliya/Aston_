package lesson3;

import java.time.LocalDate;

public class lesson3_1 {

    public static class Tovar {
        private String name;
        private LocalDate productionDate;
        private String manufacturer;
        private String countryOfOrigin;
        private double price;
        private boolean isBooked;

        public Tovar(String name, LocalDate productionDate, String manufacturer,
                     String countryOfOrigin, double price, boolean isBooked) {
            this.name = name;
            this.productionDate = productionDate;
            this.manufacturer = manufacturer;
            this.countryOfOrigin = countryOfOrigin;
            this.price = price;
            this.isBooked = isBooked;
        }

        public void printInfo() {
            System.out.println("Название: " + name);
            System.out.println("Дата производства: " + productionDate);
            System.out.println("Производитель: " + manufacturer);
            System.out.println("Страна происхождения: " + countryOfOrigin);
            System.out.println("Цена: " + price + " руб.");
            System.out.println("Забронирован покупателем: " + (isBooked ? "Да" : "Нет"));
        }
    }

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
