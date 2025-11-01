package Lesson_7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationsTest  {

    @Test
    void testAddition() {
        assertEquals(7, ArithmeticOperations.add(3, 4));
    }

    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> ArithmeticOperations.divide(10, 0));
    }
}