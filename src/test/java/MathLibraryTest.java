import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class MathLibraryTest {

    @Test
    public void testGetFactorial() {
        assertEquals(MathLibrary.getFactorial(10), 3628800);
        assertThrows(RuntimeException.class, () -> {
            MathLibrary.getFactorial(13);
        });
    }

    @Test
    public void testGetTriangle() {
        assertEquals(MathLibrary.getTriangle(3,4,5), 6);
        assertThrows(RuntimeException.class, () -> {
            MathLibrary.getTriangle(3,4,500);
        });
    }

    @Test
    public void testArithmetic() {
        assertEquals(MathLibrary.addition(5, 6), 11);
        assertEquals(MathLibrary.subtraction(5, 6), -1);
        assertEquals(MathLibrary.multiplication(5, 6), 30);
        assertEquals(MathLibrary.delete(5, 5), 1);
        assertThrows(RuntimeException.class, () -> {
            MathLibrary.delete(5, 0);
        });
    }

    @Test
    public void testComparison() {
        assertEquals(MathLibrary.comparison(6, 5), "a больше b");
        assertEquals(MathLibrary.comparison(4, 5), "b больше a");
        assertEquals(MathLibrary.comparison(5, 5), "числа равны");
    }
}