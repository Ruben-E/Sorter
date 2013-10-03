package nl.rubenernst.ddoa.sorter.server;

import nl.rubenernst.ddoa.sorter.client.Car;
import nl.rubenernst.ddoa.sorter.client.ListGenerator;
import org.junit.*;

import java.rmi.RemoteException;
import java.util.HashMap;

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
        Class[] types = {Integer.class, String.class, Car.class};
        this.types = types;

        //int[] lengths = {10, 100, 1000, 10000/*, 100000*/};
        int[] lengths = {2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384};
        this.lengths = lengths;

        SortType[] sorters = {SortType.BUBBLESORT, SortType.MERGESORT, SortType.QUICKSORT};
        this.sorters = sorters;
    }

    @Test
    public void testSpeed() throws Exception {
        int avgCounter = 10;

        for (Class type : this.types) {
            System.out.println(type.getSimpleName().toUpperCase() + " TEST:");

            for (int length : this.lengths) {
                HashMap<String, Double[]> speeds = new HashMap<String, Double[]>();
                System.out.println(length + " items");

                for (int i = 0; i < avgCounter; i++) {
                    Comparable[] array = ListGenerator.generateRandomList(type, length);

                    for (SortType sortType : this.sorters) {
                        ISortFactory sortFactory = new SortFactory();
                        ISorter sorter = sortFactory.buildSorter(sortType);

                        if(!speeds.containsKey(sortType.toString())) {
                            speeds.put(sortType.toString(), new Double[avgCounter]);
                        }

                        try {
                            long startTime = System.nanoTime();
                            sorter.sort(array);
                            long endTime = System.nanoTime();

                            long duration = endTime - startTime;
                            double milliseconds = (double) duration / 1000000;

                            Double[] allTimes = speeds.get(sortType.toString());
                            allTimes[i] = milliseconds;

                        } catch (Exception e) {
                            Double[] allTimes = speeds.get(sortType.toString());
                            allTimes[i] = 0.0;

                            System.out.println(e.getMessage());
                        }
                    }
                }

                for (SortType sortType : this.sorters) {
                    Double[] allTimes = speeds.get(sortType.toString());
                    Double totalTime = 0.0;

                    for (Double time : allTimes) {
                        totalTime += time;
                    }

                    Double avg = (double)Math.round((totalTime / allTimes.length) * 100000) / 100000;

                    System.out.format("%12s%15s milliseconds", sortType, avg);
                    System.out.println();

                }




            }
        }
    }
}
