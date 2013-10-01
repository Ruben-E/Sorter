package nl.rubenernst.ddoa.sorter.client;

import nl.rubenernst.ddoa.sorter.server.ISortFactory;
import nl.rubenernst.ddoa.sorter.server.ISorter;
import nl.rubenernst.ddoa.sorter.server.SortType;

import java.rmi.RemoteException;
import java.util.Observable;

/**
 * Class to sort a list in a single thread.
 * <p/>
 * User: rubenernst
 * Date: 9/27/13
 * Time: 2:24 PM
 */
public class ListThread extends Observable implements Runnable {
    private ISorter sorter;
    private Comparable[] list;
    private int number;

    /**
     * Constructor for ListThread
     *
     * @param sortFactory The SortFactory to generate a sorter
     * @param list        The list to sort
     * @param number      The number of the thread
     * @throws RemoteException
     */
    public ListThread(ISortFactory sortFactory, Comparable[] list, int number) throws RemoteException {
        SortType sortType = SortType.random();

        this.sorter = sortFactory.buildSorter(sortType);
        this.list = list;
        this.number = number;
    }

    /**
     * Start the thread
     */
    @Override
    public void run() {
        try {
            Comparable[] results = this.sorter.sort(this.list);

            setChanged();
            notifyObservers(results);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the number of the thread.
     *
     * @return the number of the thread.
     */
    public int getNumber() {
        return number;
    }
}
