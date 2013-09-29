package nl.rubenernst.ddoa.sorter.client;

import nl.rubenernst.ddoa.sorter.server.ISortFactory;
import nl.rubenernst.ddoa.sorter.server.ISorter;
import nl.rubenernst.ddoa.sorter.server.SortType;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * User: rubenernst
 * Date: 9/28/13
 * Time: 8:47 AM
 */
public class ListMerger {
    private Comparable[][] lists;
    private Comparable[] list;

    public ListMerger(Comparable[][] lists) {
        this.lists = lists;
        this.list = new Comparable[this.totalItems()];

        this.joinLists();
    }

    private void joinLists() {
        int totalItemNumber = 0;
        for(Comparable[] list : this.lists) {
            int itemNumber = 0;
            for(Comparable item : list) {
                this.list[totalItemNumber] = item;
                totalItemNumber++;
                itemNumber++;
            }
        }
    }

    public Comparable[] merge() throws RemoteException, NotBoundException, MalformedURLException {
        //TODO: Config file
        ISortFactory sortFactory = (ISortFactory) Naming.lookup("//localhost:1099/sortfactory");
        //TODO: Change to MergeSort;
        ISorter sorter = sortFactory.buildSorter(SortType.QUICKSORT);

        Comparable[] results = sorter.sort(this.list);

        return results;
    }

    private int totalItems() {
        int totalItems = 0;

        for (Comparable[] list : lists) {
            totalItems += list.length;
        }

        return totalItems;
    }
}
