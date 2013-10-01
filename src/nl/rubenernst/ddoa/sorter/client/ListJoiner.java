package nl.rubenernst.ddoa.sorter.client;

import java.util.Observable;
import java.util.Observer;

/**
 * Class to join the lists (threads)
 * <p/>
 * User: rubenernst
 * Date: 9/27/13
 * Time: 12:32 PM
 */
public class ListJoiner extends Observable implements Observer {
    private int totalLists = 0;
    private Comparable[][] lists;
    private int threadCounter = 0;

    /**
     * Constructor for ListJoiner
     *
     * @param totalLists The number of lists (threads) are beeing generated
     */
    public ListJoiner(int totalLists) {
        if (totalLists <= 0) {
            throw new IllegalArgumentException();
        }

        this.totalLists = totalLists;
        this.lists = new Comparable[totalLists][];
    }

    /**
     * Observer for ListThread
     *
     * @param observable ListThread instance that called the observer
     * @param o          Object send to the observer from the observable
     */
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

    /**
     * Add a single sorted list to the collection of all sorted lists
     *
     * @param number Number of the threads
     * @param list   The sorted Comparable list to add to the collection
     */
    private void addList(int number, Comparable[] list) {
        this.lists[number] = list;

        this.threadCounter++;
    }

    /**
     * Merge the collection of single lists to one merged ordered list
     *
     * @return The merged ordered Comparable list
     */
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
