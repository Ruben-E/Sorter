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

            Comparable[] list = ListGenerator.generateRandomIntegers(1000);
            Comparable[][] lists = ListSplicer.splice(list, 2);
            for (Comparable[] lst : lists) {
                ISorter sorter = sortFactory.buildSorter(SortType.random());
                Comparable[] results = sorter.sort(lst);
                System.out.println("RESULTS FOR SORTER");
                for(Comparable result : results) {
                    System.out.println(result);
                }
            }
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
