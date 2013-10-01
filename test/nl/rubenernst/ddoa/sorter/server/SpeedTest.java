package nl.rubenernst.ddoa.sorter.server;

import nl.rubenernst.ddoa.sorter.client.Car;
import nl.rubenernst.ddoa.sorter.client.ListGenerator;
import org.junit.*;

import java.rmi.RemoteException;

/**
 * User: rubenernst
 * Date: 10/1/13
 * Time: 10:20 AM
 */
public class SpeedTest {
    private Class[] types;
    private int[] lengths;
    private SortType[] sorters;

    @Before
    public void initObjects() {
        Class[] types = {/*Integer.class,*/ String.class, Car.class};
        this.types = types;

        int[] lengths = {10, 100, 1000, 10000/*, 100000*/};
        this.lengths = lengths;

        SortType[] sorters = {SortType.BUBBLESORT, SortType.MERGESORT, SortType.QUICKSORT};
        this.sorters = sorters;
    }

    @Test
    public void testSpeed() throws Exception {
        for (Class type : this.types) {
            System.out.println(type.getSimpleName().toUpperCase() + " TEST:");

            for (int length : this.lengths) {
                Comparable[] array = ListGenerator.generateRandomList(type, length);

                System.out.println(length + " items");

                for (SortType sortType : this.sorters) {
                    ISortFactory sortFactory = new SortFactory();
                    ISorter sorter = sortFactory.buildSorter(sortType);

                    try {
                        long startTime = System.nanoTime();
                        sorter.sort(array);
                        long endTime = System.nanoTime();

                        long duration = endTime - startTime;
                        double milliseconds = (double)duration / 1000000;
                        System.out.format("%10s%15s milliseconds", sortType, milliseconds);

                    } catch (Exception e) {
                        System.out.format("%15s%15s milliseconds", sortType, "FAIL");
                        System.out.println(e.getMessage());
                    }

                    System.out.println();
                }
            }
        }
    }
}
