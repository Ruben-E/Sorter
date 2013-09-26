package nl.rubenernst.ddoa.sorter.server;

import java.net.MalformedURLException;
import java.rmi.*;

/**
 * User: rubenernst
 * Date: 9/24/13
 * Time: 11:24 AM
 *
 * Start server:
 * $ cd Documents/workspace/praktijktoets3/out/production/praktijktoets3/
 * $ rmiregistry 1099

 */
public class SortServer {
    public static void main(String[] args) {
        try {
            ISortFactory sortFactory = new SortFactory();
            try {
                Naming.rebind("//127.0.0.1:1099/sortfactory", sortFactory);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
