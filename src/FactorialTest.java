import org.testng.annotations.Test;

import java.math.BigInteger;

import static org.testng.Assert.assertEquals;

public class FactorialTest {
    @Test
    public void testFactorial() {
        assertEquals(Factorial.factorial(0), BigInteger.ONE);
        assertEquals(Factorial.factorial(1), BigInteger.ONE);
        assertEquals(Factorial.factorial(2), BigInteger.valueOf(2));
        assertEquals(Factorial.factorial(5), BigInteger.valueOf(130));
        assertEquals(Factorial.factorial(10), BigInteger.valueOf(3628800));
    }
}
