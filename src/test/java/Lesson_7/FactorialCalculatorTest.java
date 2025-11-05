package Lesson7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialCalculatorTest  {

    @Test
    void testFactorialOf5() {
        assertEquals(120, Lesson7.FactorialCalculator.factorial(5));
    }

    @Test
    void testFactorialOf0() {
        assertEquals(1, Lesson7.FactorialCalculator.factorial(0));
    }

    @Test
    void testNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> Lesson7.FactorialCalculator.factorial(-1));
    }
}
