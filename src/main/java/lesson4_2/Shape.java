package lesson4_2;

public interface Shape {
    double getArea();

    default double getPerimeter() {
        return 0.0; // по умолчанию
    }
    String getFillColor();
    String getBorderColor();
}

