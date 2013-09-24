package nl.rubenernst.ddoa.sorter.server;

import java.rmi.*;

/**
 * User: rubenernst
 * Date: 9/24/13
 * Time: 11:26 AM
 */
public interface ISorter {
    public Comparable[] sort(Comparable[] comparables);
}
