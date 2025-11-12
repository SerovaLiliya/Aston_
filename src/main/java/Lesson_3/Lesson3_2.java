package Lesson_3;

public class Lesson3_2 {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",
                "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("iPhone 17 Pro", "15.03.2025",
                "Apple Inc.", "USA", 6399, false);
        productsArray[2] = new Product("Xiaomi Mix 6", "20.01.2025",
                "Xiaomi Ltd.", "China", 3299, true);
        productsArray[3] = new Product("Sony Xperia XZ", "10.04.2025",
                "Sony Corp.", "Japan", 4599, false);
        productsArray[4] = new Product("Nokia G22", "05.02.2025",
                "HMD Global", "Finland", 1999, false);

        for (Product product : productsArray) {
            product.printInfo();
        }
    }
}
