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
        int[] arrayLengths = {10, 100, 1000, 10000};
        for (int arrayLength : arrayLengths) {
            Comparable[] random = ListGenerator.generateRandomIntegers(arrayLength);
            assertEquals(arrayLength, random.length);

            for (Comparable value : random) {
                assertThat(value, instanceOf(Integer.class));
            }
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGenerateRandomIntegersNegative() throws Exception {
        ListGenerator.generateRandomIntegers(-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGenerateRandomIntegersZero() throws Exception {
        ListGenerator.generateRandomIntegers(0);
    }

    @Test
    public void testGenerateRandomStrings() throws Exception {
        int[] arrayLengths = {10, 100, 1000, 10000};
        for (int arrayLength : arrayLengths) {
            Comparable[] random = ListGenerator.generateRandomStrings(arrayLength);
            assertEquals(arrayLength, random.length);

            for (Comparable value : random) {
                assertThat(value, instanceOf(String.class));
                assertNotSame(value, "");
                assertNotSame(value, " ");
            }
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGenerateRandomStringsNegative() throws Exception {
        ListGenerator.generateRandomStrings(-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGenerateRandomStringsZero() throws Exception {
        ListGenerator.generateRandomStrings(0);
    }

    @Test
    public void testGenerateRandomCars() throws Exception {
        int[] arrayLengths = {10, 100, 1000, 10000};
        for (int arrayLength : arrayLengths) {
            Comparable[] random = ListGenerator.generateRandomCars(arrayLength);
            assertEquals(arrayLength, random.length);

            for (Comparable value : random) {
                Car car = (Car) value;
                assertThat(value, instanceOf(Car.class));
                assertThat(car.getTopSpeed(), instanceOf(Integer.class));
            }
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGenerateRandomCarsNegative() throws Exception {
        ListGenerator.generateRandomCars(-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGenerateRandomCarsZero() throws Exception {
        ListGenerator.generateRandomCars(0);
    }

    @Test
    public void testGenerateRandomList() throws Exception {
        Class[] randomItemClasses = {String.class, Integer.class};
        int[] arrayLengths = {10, 100, 1000, 10000};
        for (Class itemClass : randomItemClasses) {
            for (int arrayLength : arrayLengths) {
                Comparable[] random = ListGenerator.generateRandomList(itemClass, arrayLength);
                assertEquals(arrayLength, random.length);

                for (Comparable value : random) {
                    assertThat(value, instanceOf(itemClass));
                }
            }
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGenerateRandomListNegative() throws Exception {
        Class[] randomItemClasses = {String.class, Integer.class};
        int[] arrayLengths = {-10};
        for (Class itemClass : randomItemClasses) {
            for (int arrayLength : arrayLengths) {
                Comparable[] random = ListGenerator.generateRandomList(itemClass, arrayLength);
                assertEquals(arrayLength, random.length);

                for (Comparable value : random) {
                    assertThat(value, instanceOf(itemClass));
                }
            }
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGenerateRandomListZero() throws Exception {
        Class[] randomItemClasses = {String.class, Integer.class};
        int[] arrayLengths = {0};
        for (Class itemClass : randomItemClasses) {
            for (int arrayLength : arrayLengths) {
                Comparable[] random = ListGenerator.generateRandomList(itemClass, arrayLength);
                assertEquals(arrayLength, random.length);

                for (Comparable value : random) {
                    assertThat(value, instanceOf(itemClass));
                }
            }
        }
    }

    @Test(expected = NoSuchMethodException.class)
    public void testGenerateRandomListNonExistingGenerator() throws Exception {
        ListGenerator.generateRandomList(Float.class, 10);
    }
}
