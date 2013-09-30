package nl.rubenernst.ddoa.sorter.client;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * User: rubenernst
 * Date: 9/28/13
 * Time: 8:48 AM
 */
public class ListMergerTest {
    @Test
    public void testMerge1list() throws Exception {
        Comparable[][] lists = {{0, 0, 0, 1, 2, 2, 3, 4}};
        Comparable[] ordered = {0, 0, 0, 1, 2, 2, 3, 4};
        ListMerger listMerger = new ListMerger(lists);

        Comparable[] list = listMerger.merge();

        assertArrayEquals(ordered, list);
    }

    @Test
    public void testMerge2lists() throws Exception {
        Comparable[][] lists = {{0, 0, 0, 1, 2, 2, 3, 4}, {0, 1, 1, 1, 2, 3, 4, 4}};
        Comparable[] ordered = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 4};
        ListMerger listMerger = new ListMerger(lists);

        Comparable[] list = listMerger.merge();

        assertArrayEquals(ordered, list);
    }

    @Test
    public void testMerge3lists() throws Exception {
        Comparable[][] lists = {{0, 0, 0, 1, 2, 2, 3, 4}, {0, 1, 1, 1, 2, 3, 4, 4}, {1, 2, 2, 2, 3, 3, 4, 5}};
        Comparable[] ordered = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5};
        ListMerger listMerger = new ListMerger(lists);

        Comparable[] list = listMerger.merge();

        assertArrayEquals(ordered, list);
    }

    @Test
    public void testMerge4lists() throws Exception {
        Comparable[][] lists = {{0, 0, 0, 1, 2, 2, 3, 4}, {0, 1, 1, 1, 2, 3, 4, 4}, {1, 2, 2, 2, 3, 3, 4, 5}, {0, 0, 2, 3, 3, 5}};
        Comparable[] ordered = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5};
        ListMerger listMerger = new ListMerger(lists);

        Comparable[] list = listMerger.merge();

        assertArrayEquals(ordered, list);
    }

    @Test
    public void testMerge5lists() throws Exception {
        Comparable[][] lists = {{0, 0, 0, 1, 2, 2, 3, 4}, {0, 1, 1, 1, 2, 3, 4, 4}, {1, 2, 2, 2, 3, 3, 4, 5}, {0, 0, 2, 3, 3, 5}, {1, 2, 2, 2, 4}};
        Comparable[] ordered = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5};
        ListMerger listMerger = new ListMerger(lists);

        Comparable[] list = listMerger.merge();

        assertArrayEquals(ordered, list);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMergeZero() throws Exception {
        Comparable[][] lists = {};
        new ListMerger(lists);
    }
}
