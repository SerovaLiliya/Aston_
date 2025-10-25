package lesson4_2;

public class lesson4_2 {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(5, "Серый", "Бурый"),
                new Rectangle(4, 7, "Малиновый", "Цвет морской волны"),
                new Triangle(3, 4, 5, "Цвет блошиного брюшка", "Цвет Розовый фламинго")
        };
        for (Shape shape : shapes) {
            System.out.println("Фигура: " + shape.getClass().getSimpleName());
            System.out.println("Цвет заливки: " + shape.getFillColor());
            System.out.println("Цвет границы: " + shape.getBorderColor());
            System.out.printf("Периметр: %.2f%n", shape.getPerimeter());
            System.out.printf("Площадь: %.2f%n", shape.getArea());
            System.out.println();
        }
    }
}

