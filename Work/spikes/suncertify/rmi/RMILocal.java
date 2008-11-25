package suncertify.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Logger;

/**
 *
 */
public class RMILocal {
    private static final Logger LOG = Logger
            .getLogger(RMILocal.class.getName());

    public static void main(String args[]) {
        try {
            String name = "RMIRemote";
            Registry registry = LocateRegistry.getRegistry(1099);
            IRemote comp = (IRemote) registry.lookup(name);

            String[] result = comp.getStringArray();
            for (int i = 0; i < result.length; i++) {
                LOG.info("Item " + i + " is " + result[i]);
            }

        } catch (Exception e) {
            LOG.severe("Whoops: " + e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
