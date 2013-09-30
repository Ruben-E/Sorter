package nl.rubenernst.ddoa.sorter.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * User: rubenernst
 * Date: 9/29/13
 * Time: 8:01 PM
 *
 * @source: http://www.cs.cmu.edu/~adamchik/15-121/lectures/Sorting%20Algorithms/code/MergeSort.java
 */
public class MergeSort extends UnicastRemoteObject implements ISorter {

    protected MergeSort() throws RemoteException {
        super();
    }

    @Override
    public Comparable[] sort(Comparable[] comparables) throws RemoteException {
        Comparable[] tmp = new Comparable[comparables.length];
        mergeSort(comparables, tmp, 0, comparables.length - 1);

        return comparables;
    }


    private static void mergeSort(Comparable[] a, Comparable[] tmp, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmp, left, center);
            mergeSort(a, tmp, center + 1, right);
            merge(a, tmp, left, center + 1, right);
        }
    }


    private static void merge(Comparable[] a, Comparable[] tmp, int left, int right, int rightEnd) {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while (left <= leftEnd && right <= rightEnd)
            if (a[left].compareTo(a[right]) <= 0)
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];

        while (left <= leftEnd)    // Copy rest of first half
            tmp[k++] = a[left++];

        while (right <= rightEnd)  // Copy rest of right half
            tmp[k++] = a[right++];

        // Copy tmp back
        for (int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }
}
