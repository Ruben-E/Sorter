package nl.rubenernst.ddoa.sorter.server;

/**
 * User: rubenernst
 * Date: 9/24/13
 * Time: 3:53 PM
 */
public enum SortType {
    BUBBLESORT, QUICKSORT;

    public static SortType random() {
        return values()[(int) (Math.random() * values().length)];
    }
}
