package nl.rubenernst.ddoa.sorter.client;

import nl.rubenernst.ddoa.sorter.server.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * User: rubenernst
 * Date: 9/24/13
 * Time: 11:16 AM
 */
public class SortClient {
    private ISortFactory sortFactory;

    public static void main(String[] args) {
        SortClient sortClient = new SortClient();
        try {
            sortClient.sort();
        } catch (Exception e) {
            System.out.println("Sorting failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void sort() throws Exception {
        sortFactory = (ISortFactory) Naming.lookup("//localhost:1099/sortfactory");

        Comparable[] randomList = ListGenerator.generateRandomStrings(1000);
        Comparable[][] lists = ListSplicer.splice(randomList, 2);
        for (Comparable[] splicedList : lists) {
            SortType sortType = SortType.random();
            ISorter sorter = sortFactory.buildSorter(sortType);

            Comparable[] results = sorter.sort(splicedList);
            System.out.println("RESULTS FOR SORTER: " + sortType.toString());
            for (Comparable result : results) {
                System.out.println(result);
            }
        }
    }
}
