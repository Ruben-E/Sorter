package nl.rubenernst.ddoa.sorter.server;

/**
 * User: rubenernst
 * Date: 9/24/13
 * Time: 11:35 AM
 */
public class BubbleSort implements ISorter {

    public BubbleSort() {

    }

    @Override
    public Comparable[] sort(Comparable[] comparables) {
        int i, j;
        Comparable temp;

        for (j = 0; j < comparables.length; j++) {
            for (i = 1; i < comparables.length - j; i++) {
                if (comparables[i - 1].compareTo(comparables[i]) >= 1) {
                    temp = comparables[i];
                    comparables[i] = comparables[i - 1];
                    comparables[i - 1] = temp;
                }
            }
        }

        return comparables;
    }
}
