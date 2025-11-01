package Lesson_7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialCalculatorTest  {

    @Test
    void testFactorialOf5() {
        assertEquals(120, FactorialCalculator.factorial(5));
    }

    @Test
    void testFactorialOf0() {
        assertEquals(1, FactorialCalculator.factorial(0));
    }

    @Test
    void testNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> FactorialCalculator.factorial(-1));
    }
}
