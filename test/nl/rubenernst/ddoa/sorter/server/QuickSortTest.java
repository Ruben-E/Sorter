package nl.rubenernst.ddoa.sorter.server;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * User: rubenernst
 * Date: 9/24/13
 * Time: 3:17 PM
 */
public class QuickSortTest {
    @Test
    public void testSort() throws Exception {
        ISorter sorter = new QuickSort();

        Comparable[] toSort = {6, 45, 7, 456, 5, 3, 67, 5, 65, 0};
        Comparable[] expected = {0, 3, 5, 5, 6, 7, 45, 65, 67, 456};
        Comparable[] results = sorter.sort(toSort);

        assertArrayEquals(expected, results);
    }

    @Test
    public void testSortEmpty() throws Exception {
        ISorter sorter = new QuickSort();

        Comparable[] toSort = {};
        Comparable[] expected = {};
        Comparable[] results = sorter.sort(toSort);

        assertArrayEquals(expected, results);
    }

    @Test
    public void testSortSorted() throws Exception {
        ISorter sorter = new QuickSort();

        Comparable[] toSort = {0, 1, 2, 3, 4, 5};
        Comparable[] expected = {0, 1, 2, 3, 4, 5};
        Comparable[] results = sorter.sort(toSort);

        assertArrayEquals(expected, results);
    }

    @Test
    public void testSortNegative() throws Exception {
        ISorter sorter = new QuickSort();

        Comparable[] toSort = {6, 45, 7, 456, 5, 3, 67, 5, 65, 0, -10, -11, -5};
        Comparable[] expected = {-11, -10, -5, 0, 3, 5, 5, 6, 7, 45, 65, 67, 456};
        Comparable[] results = sorter.sort(toSort);

        assertArrayEquals(expected, results);
    }

    @Test
    public void testSortAllNegative() throws Exception {
        ISorter sorter = new QuickSort();

        Comparable[] toSort = {-10, -11, -5, -1, -100};
        Comparable[] expected = {-100, -11, -10, -5, -1};
        Comparable[] results = sorter.sort(toSort);

        assertArrayEquals(expected, results);
    }

    @Test
    public void testSortOneItem() throws Exception {
        ISorter sorter = new QuickSort();

        Comparable[] toSort = {6};
        Comparable[] expected = {6};
        Comparable[] results = sorter.sort(toSort);

        assertArrayEquals(expected, results);
    }
}
