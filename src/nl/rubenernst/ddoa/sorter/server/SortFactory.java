package nl.rubenernst.ddoa.sorter.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Factory to generate a sorter class
 * <p/>
 * User: rubenernst
 * Date: 9/24/13
 * Time: 3:47 PM
 */
public class SortFactory extends UnicastRemoteObject implements ISortFactory {

    /**
     * Constructor for SortFactory
     *
     * @throws RemoteException
     */
    protected SortFactory() throws RemoteException {
        super();
    }

    /**
     * Generate a sorter class based on the type parameter
     *
     * @param type Generate sorter class of this type
     * @return The generated sorter
     * @throws RemoteException
     */
    @Override
    public ISorter buildSorter(SortType type) throws RemoteException {
        ISorter sorter = null;
        try {
            switch (type) {
                case BUBBLESORT:
                    sorter = new BubbleSort();
                    break;
                case QUICKSORT:
                    sorter = new QuickSort();
                    break;
                case MERGESORT:
                    sorter = new MergeSort();
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sorter;
    }
}
