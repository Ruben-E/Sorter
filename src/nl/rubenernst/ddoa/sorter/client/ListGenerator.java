package nl.rubenernst.ddoa.sorter.client;

/**
 * User: rubenernst
 * Date: 9/25/13
 * Time: 10:42 PM
 */
public class ListGenerator {
    final static int MIN_INT = 0;
    final static int MAX_INT = 200;


    public static Comparable[] generateRandomIntegers(int length) {
        if(length <= 0 || length > Integer.MAX_VALUE) {
            throw new IllegalArgumentException();
        }

        Comparable[] list = new Comparable[length];
        for(int i = 0; i < length; i++) {
            list[i] = MIN_INT + (int)(Math.random() * ((MAX_INT - MIN_INT) + 1));
        }

        return list;
    }

    public static Comparable[] generateRandomStrings(int length) {
        return null;
    }
}
