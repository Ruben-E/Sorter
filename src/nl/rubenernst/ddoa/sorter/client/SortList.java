package nl.rubenernst.ddoa.sorter.client;

/**
 * User: rubenernst
 * Date: 9/25/13
 * Time: 10:42 PM
 */
public class SortList {
    final int MIN = 0;
    final int MAX = 200;


    public Comparable[] generateRandomIntegers(int length) {
        Comparable[] list = {};
        for(int i = 0; i < length; i++) {
            list[i] = MIN + (int)(Math.random() * ((MAX - MIN) + 1));
        }

        return list;
    }

    public Comparable[] generateRandomStrings(int length) {
        return null;
    }
}
