package nl.rubenernst.ddoa.sorter.server;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * User: rubenernst
 * Date: 9/24/13
 * Time: 4:02 PM
 */
public class SortFactoryTest {
    @Test
    public void testBuildSorterBubbleSort() throws Exception {
        SortType type = SortType.BUBBLESORT;

        SortFactory sortFactory = new SortFactory();
        ISorter sorter = sortFactory.buildSorter(type);

        assertEquals(sorter.getClass(), BubbleSort.class);
    }

    @Test
    public void testBuildSorterQuickSort() throws Exception {
        SortType type = SortType.QUICKSORT;

        SortFactory sortFactory = new SortFactory();
        ISorter sorter = sortFactory.buildSorter(type);

        assertEquals(sorter.getClass(), QuickSort.class);
    }

    @Test
    public void testBuildSorterMErgeSort() throws Exception {
        SortType type = SortType.MERGESORT;

        SortFactory sortFactory = new SortFactory();
        ISorter sorter = sortFactory.buildSorter(type);

        assertEquals(sorter.getClass(), MergeSort.class);
    }
}
