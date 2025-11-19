package Lesson7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriangleAreaCalculatorTest  {

    @Test
    void testValidTriangle() {
        assertEquals(6.0, Lesson7.TriangleAreaCalculator.area(3, 4, 5), 0.0001);
    }

    @Test
    void testInvalidSides() {
        assertThrows(IllegalArgumentException.class, () -> Lesson7.TriangleAreaCalculator.area(1, 2, 10));
    }
}
