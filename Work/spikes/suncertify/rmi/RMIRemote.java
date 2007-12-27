package suncertify.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Logger;

/**
 *
 */
public class RMIRemote implements IRemote {
    private static final Logger LOG = Logger.getLogger(RMIRemote.class
            .getName());

    public String[] getStringArray() {
        return new String[] { "tony", "matthew", "mark", "leanne" };

    }

    public static void main(String[] args) {

        try {
            String name = "RMIRemote";
            IRemote engine = new RMIRemote();
            IRemote stub = (IRemote) UnicastRemoteObject
                    .exportObject(engine, 0);

            Registry registry = LocateRegistry.createRegistry(1099);

            registry.rebind(name, stub);
            LOG.info("RMIRemote bound");
        } catch (Exception e) {
            LOG.severe("RMIRemote exception: " + e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
