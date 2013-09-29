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
    public void testMerge() throws Exception {
        Comparable[][] lists = {{0, 0, 0, 1, 2, 2, 3, 4}, {0, 1, 1, 1, 2, 3, 4, 4}, {1, 2, 2, 2, 3, 3, 4, 5}};
        Comparable[] ordered = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5};
        ListMerger listMerger = new ListMerger(lists);

        Comparable[] list = listMerger.merge();

        assertArrayEquals(ordered, list);
    }
}
