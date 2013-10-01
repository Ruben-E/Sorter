package nl.rubenernst.ddoa.sorter.server;

/**
 * Enum for different sorttypes
 * <p/>
 * User: rubenernst
 * Date: 9/24/13
 * Time: 3:53 PM
 */
public enum SortType {
    BUBBLESORT, QUICKSORT, MERGESORT;

    /**
     * Generate a random Enum for SortType
     *
     * @return Random generated SortType
     */
    public static SortType random() {
        return values()[(int) (Math.random() * values().length)];
    }
}
