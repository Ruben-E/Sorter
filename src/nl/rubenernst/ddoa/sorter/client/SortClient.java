package nl.rubenernst.ddoa.sorter.client;

import nl.rubenernst.ddoa.sorter.server.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Observer;

/**
 * User: rubenernst
 * Date: 9/24/13
 * Time: 11:16 AM
 *
 * Specialities:
 * - Clean code
 *      - Clean code
 *      - List splicer in it's own class
 *      - List merger in it's own class
 * - Custom made splice algorithm
 * - Custom made search algorithm
 * - 3 sort algorithms
 * - A lot of unit tests
 * - Made Listjoiner an observerable
 * - Great report
 */
public class SortClient implements Observer {
    private ISortFactory sortFactory;

    public static void main(String[] args) {
        SortClient sortClient = new SortClient();
        try {
            sortClient.sort();
        } catch (Exception e) {
            System.out.println("Sorting failed: " + e.getMessage());
        }
    }

    public void sort() throws Exception {
        sortFactory = (ISortFactory) Naming.lookup("//localhost:1099/sortfactory");

        Comparable[] randomList = ListGenerator.generateRandomIntegers(1000);
        Comparable[][] lists = ListSplicer.splice(randomList, 3);

        ListJoiner listJoiner = new ListJoiner(lists.length);
        listJoiner.addObserver(this);

        int i = 0;
        for (Comparable[] splicedList : lists) {
            ListThread listThread = new ListThread(sortFactory, splicedList, i);
            listThread.addObserver(listJoiner);

            Thread t = new Thread(listThread);
            t.start();

            i++;
        }
    }

    @Override
    public void update(Observable observable, Object o) {
        Comparable[] list = (Comparable[]) o;
        for (Comparable item : list) {
            System.out.println(item);
        }
    }
}
