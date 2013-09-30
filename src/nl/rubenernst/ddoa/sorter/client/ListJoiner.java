package nl.rubenernst.ddoa.sorter.client;

import java.util.Observable;
import java.util.Observer;

/**
 * User: rubenernst
 * Date: 9/27/13
 * Time: 12:32 PM
 */
public class ListJoiner extends Observable implements Observer {
    private int totalLists = 0;
    private Comparable[][] lists;
    private int threadCounter = 0;

    public ListJoiner(int totalLists) {
        if (totalLists <= 0) {
            throw new IllegalArgumentException();
        }

        this.totalLists = totalLists;
        this.lists = new Comparable[totalLists][];
    }

    @Override
    public void update(Observable observable, Object o) {
        ListThread listThread = (ListThread) observable;

        int number = listThread.getNumber();
        Comparable[] list = (Comparable[]) o;

        this.addList(number, list);

        if (this.threadCounter == this.totalLists) {
            Comparable[] mergedList = mergeLists();

            setChanged();
            notifyObservers(mergedList);
        }
    }

    private void addList(int number, Comparable[] list) {
        this.lists[number] = list;

        this.threadCounter++;
    }

    private Comparable[] mergeLists() {
        ListMerger listMerger = new ListMerger(this.lists);
        Comparable[] mergedList = new Comparable[0];

        try {
            mergedList = listMerger.merge();
        } catch (IllegalArgumentException e) {
            //Do nothing; can't merge.
        }

        return mergedList;
    }
}
