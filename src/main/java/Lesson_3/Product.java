package Lesson_3;

public class Product {
    String name;
    String productionDate;
    String manufacturer;
    String country;
    double price;
    boolean isReserved;

    public Product(String name, String productionDate, String manufacturer,
                   String country, double price, boolean isReserved) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.isReserved = isReserved;
    }

    public void printInfo() {
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + country);
        System.out.println("Цена: " + price);
        System.out.println("Забронировано: " + (isReserved ? "Да" : "Нет"));
        System.out.println("-----------------------------");
    }
}

