package nl.rubenernst.ddoa.sorter.client;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * User: rubenernst
 * Date: 9/27/13
 * Time: 11:17 AM
 */
public class ListSplicerTest {
    @Test
    public void testSplice() throws Exception {
        Comparable[] list;
        Comparable[][] spliced;

        list = ListGenerator.generateRandomIntegers(100);
        spliced = ListSplicer.splice(list, 2);

        assertEquals(50, spliced[0].length);
        assertEquals(50, spliced[1].length);

        list = ListGenerator.generateRandomIntegers(100);
        spliced = ListSplicer.splice(list, 3);

        assertEquals(33, spliced[0].length);
        assertEquals(33, spliced[1].length);
        assertEquals(34, spliced[2].length);

        list = ListGenerator.generateRandomIntegers(101);
        spliced = ListSplicer.splice(list, 3);

        assertEquals(33, spliced[0].length);
        assertEquals(33, spliced[1].length);
        assertEquals(35, spliced[2].length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSpliceNegative() throws Exception {
        ListGenerator.generateRandomIntegers(-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSpliceZero() throws Exception {
        ListGenerator.generateRandomIntegers(0);
    }
}
