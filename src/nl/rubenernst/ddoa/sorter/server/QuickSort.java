package nl.rubenernst.ddoa.sorter.server;

/**
 * User: rubenernst
 * Date: 9/24/13
 * Time: 3:16 PM
 */
public class QuickSort implements ISorter {

    public QuickSort() {

    }

    /**
     * @param comparables
     * @return
     * @source http://thilinasameera.wordpress.com/2011/06/01/sorting-algorithms-sample-codes-on-java-c-and-matlab/ (2013, 24 september)
     */
    @Override
    public Comparable[] sort(Comparable[] comparables) {
        int lenD = comparables.length;
        Comparable pivot = 0;
        int ind = lenD / 2;
        int i, j = 0, k = 0;
        if (lenD < 2) {
            return comparables;
        } else {
            Comparable[] L = new Comparable[lenD];
            Comparable[] R = new Comparable[lenD];
            Comparable[] sorted = new Comparable[lenD];
            pivot = comparables[ind];
            for (i = 0; i < lenD; i++) {
                if (i != ind) {
                    if (comparables[i].compareTo(pivot) == -1) {
                        L[j] = comparables[i];
                        j++;
                    } else {
                        R[k] = comparables[i];
                        k++;
                    }
                }
            }
            Comparable[] sortedL = new Comparable[j];
            Comparable[] sortedR = new Comparable[k];
            System.arraycopy(L, 0, sortedL, 0, j);
            System.arraycopy(R, 0, sortedR, 0, k);
            sortedL = sort(sortedL);
            sortedR = sort(sortedR);
            System.arraycopy(sortedL, 0, sorted, 0, j);
            sorted[j] = pivot;
            System.arraycopy(sortedR, 0, sorted, j + 1, k);
            return sorted;
        }
    }
}
