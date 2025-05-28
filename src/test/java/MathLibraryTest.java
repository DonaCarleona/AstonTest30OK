import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MathLibraryTest {

    @Test
    public void testGetFactorial() {
        Assertions.assertEquals(3628800, MathLibrary.getFactorial(10));
        Assertions.assertThrows(RuntimeException.class, () -> {
            MathLibrary.getFactorial(13);
        });
    }

    @Test
    public void testGetTriangle() {
        Assertions.assertEquals(6, MathLibrary.getTriangle(3,4,5));
        Assertions.assertThrows(RuntimeException.class, () -> {
            MathLibrary.getTriangle(3,4,500);
        });
    }

    @Test
    public void testArithmetic() {
        Assertions.assertEquals(11, MathLibrary.addition(5, 6));
        Assertions.assertEquals(-1, MathLibrary.subtraction(5, 6));
        Assertions.assertEquals(30, MathLibrary.multiplication(5, 6));
        Assertions.assertEquals(1, MathLibrary.delete(5, 5));
        Assertions.assertThrows(RuntimeException.class, () -> {
            MathLibrary.delete(5, 0);
        });
    }

    @Test
    public void testComparison() {
        Assertions.assertEquals("a больше b", MathLibrary.comparison(6, 5));
        Assertions.assertEquals("b больше a", MathLibrary.comparison(4, 5));
        Assertions.assertEquals("числа равны", MathLibrary.comparison(5, 5));
    }
}