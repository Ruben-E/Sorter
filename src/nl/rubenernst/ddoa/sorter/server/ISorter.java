package nl.rubenernst.ddoa.sorter.server;

import java.rmi.*;

/**
 * ISorter interface
 *
 * User: rubenernst
 * Date: 9/24/13
 * Time: 11:26 AM
 */
public interface ISorter extends Remote {
    /**
     * Sort method that will be called to sort the array
     *
     * @param comparables   Array of comparables to sort
     * @return              Sorted comparables array
     * @throws RemoteException
     */
    public Comparable[] sort(Comparable[] comparables) throws RemoteException;
}
