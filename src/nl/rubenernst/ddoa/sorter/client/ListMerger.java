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
    private int lastMerged;

    public ListMerger(Comparable[][] lists) {
        this.lists = lists;
        this.list = new Comparable[this.totalItems()];
        this.lastMerged = 0;


        //this.joinLists();
    }

    public Comparable[] merge() {
        if(this.lists.length == 1) {
            return this.lists[0];
        }

        this.list = this.lists[0];

        for(Comparable[] list : this.lists) {
            this.list = this.mergeNext(this.list);
        }
        return this.list;
    }

    private Comparable[] mergeNext(Comparable[] currentList) {
        int nextArray = this.lastMerged + 1;
        if(this.lists.length > nextArray && this.lists[nextArray] != null) {
            Comparable[] merged = this.mergeTwoArrays(currentList, this.lists[nextArray]);
            this.lastMerged++;
            return merged;
        }

        return currentList;
    }

    // @source: http://stackoverflow.com/a/8949433
    private Comparable[] mergeTwoArrays(Comparable[] a, Comparable[] b) {

        Comparable[] merged = new Comparable[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (b[j].compareTo(a[i]) >= 1) {
                merged[k++] = a[i++];
            } else {
                merged[k++] = b[j++];
            }
        }

        while (i < a.length) {
            merged[k++] = a[i++];
        }


        while (j < b.length) {
            merged[k++] = b[j++];
        }

        return merged;
    }

    /*private void joinLists() {
        int totalItemNumber = 0;
        for(Comparable[] list : this.lists) {
            int itemNumber = 0;
            for(Comparable item : list) {
                this.list[totalItemNumber] = item;
                totalItemNumber++;
                itemNumber++;
            }
        }
    }*/

    /*public Comparable[] merge() throws RemoteException, NotBoundException, MalformedURLException {
        //TODO: Config file
        ISortFactory sortFactory = (ISortFactory) Naming.lookup("//localhost:1099/sortfactory");
        //TODO: Change to MergeSort;
        ISorter sorter = sortFactory.buildSorter(SortType.QUICKSORT);

        Comparable[] results = sorter.sort(this.list);

        return results;
    }*/

    private int totalItems() {
        int totalItems = 0;

        for (Comparable[] list : lists) {
            totalItems += list.length;
        }

        return totalItems;
    }
}
