package nl.rubenernst.ddoa.sorter.server;

/**
 * User: rubenernst
 * Date: 9/24/13
 * Time: 3:46 PM
 */
public interface ISortFactory {
    public ISorter buildSorter(SortType type);
}
