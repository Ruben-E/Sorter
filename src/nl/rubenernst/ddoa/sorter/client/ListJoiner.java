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

        if (threadCounter == totalLists) {
            Comparable[] mergedList = finalSort();

            setChanged();
            notifyObservers(mergedList);
        }
    }

    public void addList(int number, Comparable[] list) {
        lists[number] = list;

        threadCounter++;
    }

    public int totalItems() {
        int totalItems = 0;

        for(Comparable[] list : lists) {
            totalItems += list.length;
        }

        return totalItems;
    }

    public Comparable[] finalSort() {
        //TODO: MERGE LISTS
        Comparable[] mergedList = new Comparable[this.totalItems()];

        int i = 0;
        for(Comparable[] list : lists) {
            for(Comparable item : list) {
                mergedList[i] = item;
                i++;
            }
        }

        return mergedList;
    }
}
