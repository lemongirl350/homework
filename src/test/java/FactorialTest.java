import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialTest {
    @Test
    public void testFactorial() {
        assertEquals(BigInteger.ONE, Factorial.factorial(0));
        assertEquals(BigInteger.valueOf(1), Factorial.factorial(1));
        assertEquals(BigInteger.valueOf(6), Factorial.factorial(3));
        assertEquals(BigInteger.valueOf(26), Factorial.factorial(4));
        assertEquals(BigInteger.valueOf(120), Factorial.factorial(5));
    }
}
