package Lesson7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationsTest  {

    @Test
    void testAddition() {
        assertEquals(7, Lesson7.ArithmeticOperations.add(3, 4));
    }

    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> Lesson7.ArithmeticOperations.divide(10, 0));
    }
}