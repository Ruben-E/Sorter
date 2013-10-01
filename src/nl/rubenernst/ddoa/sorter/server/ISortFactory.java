package nl.rubenernst.ddoa.sorter.server;

import java.rmi.*;

/**
 * ISortFactory interface
 *
 * User: rubenernst
 * Date: 9/24/13
 * Time: 3:46 PM
 */
public interface ISortFactory extends Remote {
    /**
     * Method to build a sorter based on the type
     *
     * @param type  Generate sorter class of this type
     * @return      Sorter class
     * @throws RemoteException
     */
    public ISorter buildSorter(SortType type) throws RemoteException;
}
