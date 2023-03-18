package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(13, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("169 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }
    @Test
    public void testSquarePrimestwo() {
        IntList lst = IntList.of(3, 5, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("9 -> 25 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }
    @Test
    public void testSquarePrimesthree() {
        IntList lst = IntList.of(1, 0, 16, 3, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("1 -> 0 -> 16 -> 9 -> 18", lst.toString());
        assertTrue(changed);
    }
}
