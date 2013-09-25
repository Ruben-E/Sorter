package nl.rubenernst.ddoa.sorter.server;

import java.rmi.*;

/**
 * User: rubenernst
 * Date: 9/24/13
 * Time: 3:46 PM
 */
public interface ISortFactory extends Remote {
    public ISorter buildSorter(SortType type) throws RemoteException;
}
