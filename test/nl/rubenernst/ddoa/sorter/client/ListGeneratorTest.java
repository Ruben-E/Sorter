package nl.rubenernst.ddoa.sorter.client;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

/**
 * User: rubenernst
 * Date: 9/26/13
 * Time: 2:08 PM
 */
public class ListGeneratorTest {
    @Test
    public void testGenerateRandomIntegers() throws Exception {
        Comparable[] random = ListGenerator.generateRandomIntegers(10);
        assertEquals(10, random.length);

        for(int i = 0; i < random.length; i++) {
            Comparable value = random[i];
            assertThat(value, instanceOf(Integer.class));
        }

        Comparable[] random2 = ListGenerator.generateRandomIntegers(100);
        assertEquals(100, random2.length);

        for(int i = 0; i < random2.length; i++) {
            Comparable value = random2[i];
            assertThat(value, instanceOf(Integer.class));
        }

        Comparable[] random3 = ListGenerator.generateRandomIntegers(1000);
        assertEquals(1000, random3.length);

        for(int i = 0; i < random3.length; i++) {
            Comparable value = random3[i];
            assertThat(value, instanceOf(Integer.class));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGenerateRandomIntegersNegative() throws Exception {
        Comparable[] random = ListGenerator.generateRandomIntegers(-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGenerateRandomIntegersZero() throws Exception {
        Comparable[] random = ListGenerator.generateRandomIntegers(0);
    }

    @Test
    public void testGenerateRandomStrings() throws Exception {

    }
}
