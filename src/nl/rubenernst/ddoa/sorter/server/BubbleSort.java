package nl.rubenernst.ddoa.sorter.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * User: rubenernst
 * Date: 9/24/13
 * Time: 11:35 AM
 */
public class BubbleSort extends UnicastRemoteObject implements ISorter {

    public BubbleSort() throws RemoteException {
        super();
    }

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
