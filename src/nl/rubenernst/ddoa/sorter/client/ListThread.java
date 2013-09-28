package nl.rubenernst.ddoa.sorter.client;

import nl.rubenernst.ddoa.sorter.server.ISortFactory;
import nl.rubenernst.ddoa.sorter.server.ISorter;
import nl.rubenernst.ddoa.sorter.server.SortType;

import java.rmi.RemoteException;
import java.util.Observable;

/**
 * User: rubenernst
 * Date: 9/27/13
 * Time: 2:24 PM
 */
public class ListThread extends Observable implements Runnable {
    private ISorter sorter;
    private Comparable[] list;
    private int number;

    public ListThread(ISortFactory sortFactory, Comparable[] list, int number) throws RemoteException {
        SortType sortType = SortType.random();

        this.sorter = sortFactory.buildSorter(sortType);
        this.list = list;
        this.number = number;
    }

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

    public int getNumber() {
        return number;
    }
}
