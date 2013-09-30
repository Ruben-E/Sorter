package nl.rubenernst.ddoa.sorter.server;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * User: rubenernst
 * Date: 9/29/13
 * Time: 8:08 PM
 */
public class MergeSortTest {
    @Test
    public void testSort() throws Exception {
        ISorter sorter = new MergeSort();

        Comparable[] toSort = {6, 45, 7, 456, 5, 3, 67, 5, 65, 0};
        Comparable[] expected = {0, 3, 5, 5, 6, 7, 45, 65, 67, 456};
        Comparable[] results = sorter.sort(toSort);

        assertArrayEquals(expected, results);
    }

    @Test
    public void testSortEmpty() throws Exception {
        ISorter sorter = new MergeSort();

        Comparable[] toSort = {};
        Comparable[] expected = {};
        Comparable[] results = sorter.sort(toSort);

        assertArrayEquals(expected, results);
    }

    @Test
    public void testSortSorted() throws Exception {
        ISorter sorter = new MergeSort();

        Comparable[] toSort = {0, 1, 2, 3, 4, 5};
        Comparable[] expected = {0, 1, 2, 3, 4, 5};
        Comparable[] results = sorter.sort(toSort);

        assertArrayEquals(expected, results);
    }

    @Test
    public void testSortNegative() throws Exception {
        ISorter sorter = new MergeSort();

        Comparable[] toSort = {6, 45, 7, 456, 5, 3, 67, 5, 65, 0, -10, -11, -5};
        Comparable[] expected = {-11, -10, -5, 0, 3, 5, 5, 6, 7, 45, 65, 67, 456};
        Comparable[] results = sorter.sort(toSort);

        assertArrayEquals(expected, results);
    }
}
