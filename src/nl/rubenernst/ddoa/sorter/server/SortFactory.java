package nl.rubenernst.ddoa.sorter.server;

/**
 * User: rubenernst
 * Date: 9/24/13
 * Time: 3:47 PM
 */
public class SortFactory implements ISortFactory {

    @Override
    public ISorter buildSorter(SortType type) {
        ISorter sorter = null;
        switch (type) {
            case BUBBLESORT:
                sorter = new BubbleSort();
                break;
            case QUICKSORT:
                sorter = new QuickSort();
                break;
            default:
                break;
        }

        return sorter;
    }
}
