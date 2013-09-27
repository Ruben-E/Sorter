package nl.rubenernst.ddoa.sorter.client;

/**
 * User: rubenernst
 * Date: 9/26/13
 * Time: 5:10 PM
 */
public class ListSplicer {
    public static Comparable[][] splice(Comparable[] list, int numberOfLists) {
        if (numberOfLists <= 0) {
            throw new IllegalArgumentException();
        }
        Comparable[][] lists = new Comparable[numberOfLists][];

        int itemsEachList = (int) Math.floor(list.length / numberOfLists);
        int itemsLastList = list.length - (itemsEachList * (numberOfLists - 1));

        for (int i = 0; i < numberOfLists; i++) {
            int offset = i * itemsEachList;
            int forTo = itemsEachList;

            if ((i + 1) == numberOfLists) {
                forTo = itemsLastList;
            }

            Comparable[] tempList = new Comparable[forTo];

            for (int j = 0; j < forTo; j++) {
                int currentPos = offset + j;

                tempList[j] = list[currentPos];
            }

            lists[i] = tempList;
        }

        return lists;
    }
}
