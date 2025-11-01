package Lesson_7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumberComparatorTest  {

    @Test
    void testCompareEqual() {
        assertEquals(0, NumberComparator.compare(5, 5));
    }

    @Test
    void testCompareGreater() {
        assertTrue(NumberComparator.compare(10, 5) > 0);
    }
}