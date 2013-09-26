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
        sortClient.sort();
    }

    public void sort() {
        Comparable[] unsorted = {45, 3, 456, 1, 55, 12, 21, 85, 5, 3, 8, 27, 96, 123, 54, 6, 7, 53, 467, 4};
        try {
            sortFactory = (ISortFactory) Naming.lookup("//localhost:1099/sortfactory");
            ISorter sorter = sortFactory.buildSorter(SortType.BUBBLESORT);
            Comparable[] sorted = sorter.sort(unsorted);
            for(int i = 0; i< sorted.length; i++) {
                System.out.println(sorted[i]);
            }
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
