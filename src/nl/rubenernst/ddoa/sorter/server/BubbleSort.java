package nl.rubenernst.ddoa.sorter.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Implementation of bubblesort
 *
 * <p>See: <a href="http://en.wikipedia.org/wiki/Bubblesort">Wikipedia</a></p>
 *
 * User: rubenernst
 * Date: 9/24/13
 * Time: 11:35 AM
 */
public class BubbleSort extends UnicastRemoteObject implements ISorter {

    /**
     * Constructor for BubbleSort
     *
     * @throws RemoteException
     */
    public BubbleSort() throws RemoteException {
        super();
    }

    /**
     * Sort the array
     *
     * <p>Source: <a href="http://nl.wikipedia.org/wiki/Bubblesort#Implementatie_in_Java">Wikipedia</a>, 2013</p>
     *
     * @param comparables   Array of comparables to sort
     * @return              An ordered array
     * @throws RemoteException
     */
    @Override
    public Comparable[] sort(Comparable[] comparables) throws RemoteException {
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
