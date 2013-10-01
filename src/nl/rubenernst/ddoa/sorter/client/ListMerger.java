package nl.rubenernst.ddoa.sorter.client;

/**
 * Class to merge multiple ordered lists into one ordered list
 *
 * User: rubenernst
 * Date: 9/28/13
 * Time: 8:47 AM
 */
public class ListMerger {
    private Comparable[][] lists;
    private Comparable[] list;
    private int lastMerged;

    /**
     * The constructor for ListMerger
     *
     * @param lists the collection of single ordered lists, this list will be merged
     */
    public ListMerger(Comparable[][] lists) {
        if (lists.length == 0) {
            throw new IllegalArgumentException();
        }

        this.lists = lists;
        this.list = new Comparable[this.totalItems()];
        this.lastMerged = 0;
    }

    /**
     * Merge the collection of single ordered lists
     *
     * @return the merged ordered list
     */
    public Comparable[] merge() {
        if (this.lists.length == 1) {
            return this.lists[0];
        }

        this.list = this.lists[0];

        for (Comparable[] list : this.lists) {
            this.list = this.mergeNext(this.list);
        }
        return this.list;
    }

    /**
     * Merge the next ordered list from the collection into the single merged ordered list
     *
     * @param currentList   The single merged list
     * @return              The single merged list with the next ordered single list into it
     */
    private Comparable[] mergeNext(Comparable[] currentList) {
        int nextArray = this.lastMerged + 1;
        if (this.lists.length > nextArray && this.lists[nextArray] != null) {
            Comparable[] merged = this.mergeTwoArrays(currentList, this.lists[nextArray]);
            this.lastMerged++;
            return merged;
        }

        return currentList;
    }

    // @source: http://stackoverflow.com/a/8949433

    /**
     * Method to merge two ordered lists into one single ordered list.
     *
     * <p>Source: <a href="http://stackoverflow.com/a/8949433">Mike Saull (Stackoverflow)</a>, 2013</p>
     *
     * @param a One ordered list to merge
     * @param b The other ordered list to merge
     * @return  The merged list
     */
    private Comparable[] mergeTwoArrays(Comparable[] a, Comparable[] b) {

        Comparable[] merged = new Comparable[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (b[j].compareTo(a[i]) >= 1) {
                merged[k++] = a[i++];
            } else {
                merged[k++] = b[j++];
            }
        }

        while (i < a.length) {
            merged[k++] = a[i++];
        }


        while (j < b.length) {
            merged[k++] = b[j++];
        }

        return merged;
    }

    /**
     * Count total items from all the single ordered lists
     *
     * @return number of items
     */
    private int totalItems() {
        int totalItems = 0;

        for (Comparable[] list : lists) {
            totalItems += list.length;
        }

        return totalItems;
    }
}
